package myself.library.service;

import myself.library.model.entities.Ticket;
import myself.library.model.entities.User;
import myself.library.model.exceptions.LoginRegisterException;
import myself.library.utils.ConcurrentUtils;
import myself.library.utils.MD5;
import myself.library.utils.TicketUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @program: library
 * @description: 登陆检查
 * @author: ChaiRJ
 * @create: 2020-08-27 21:28
 **/
@Service
public class LoginService {

    @Autowired
    private UserService userService;

    @Autowired
    private TicketService ticketService;

    /**
     * 登陆，先检查邮箱和密码，然后更新ticket
     *
     * @param userName 用户名
     * @param password 密码
     * @return 返回最新的ticket信息
     * @throws Exception 账号密码错误
     */
    public String login(String userName, String password) throws Exception {
        User user = userService.getUser(userName);

        if (user == null) {
            throw new LoginRegisterException("用户不存在");
        }
        //检查密码
        if (!StringUtils.equals(MD5.encrypt(password), user.getUserPassword()))
            throw new LoginRegisterException("密码错误");

        //检查ticket
        Ticket ticket = ticketService.getTicket(user.getUserId());

        //没有ticket，生成一个
        if (ticket == null) {
            ticket = TicketUtils.generateTicket(user.getUserId());
            ticketService.addTicket(ticket);
            return ticket.getTicket();
        }
        //是否过期
        if (ticket.getExpiredAt().before(new Date())) {
            //删除
            ticketService.deleteTicket(ticket.getTicketId());

            //生成新票
            ticket = TicketUtils.generateTicket(user.getUserId());
            ticketService.addTicket(ticket);
        }

        //System.out.println("LoginService-"+Thread.currentThread());
        //设置当前user
        ConcurrentUtils.setHost(user);

        return ticket.getTicket();
    }

    /**
     * 用户退出登录，从数据库中删除用户的ticket
     *
     * @param ticket
     */
    public void logout(String ticket) {
        ticketService.deleteTicket(ticket);
    }

    /**
     * 注册用户
     *
     * @param user
     * @return 返回Ticket的ticket信息
     * @throws Exception 用户名存在错误
     */
    public String register(User user) throws Exception {
        //信息检查
        if (userService.getUser(user.getUserName()) != null) {
            throw new LoginRegisterException("用户名已存在！");
        }

        //密码加密
        String plain = user.getUserPassword();
        String encrypt = MD5.encrypt(plain);
        user.setUserPassword(encrypt);
        //数据库添加
        userService.register(user);
        //userId为0，加入数据库自增主键
        user = userService.getUser(user.getUserName());
        //用户的票
        Ticket ticket = TicketUtils.generateTicket(user.getUserId());
        //数据库
        ticketService.addTicket(ticket);

        ConcurrentUtils.setHost(user);

        return ticket.getTicket();
    }
}
