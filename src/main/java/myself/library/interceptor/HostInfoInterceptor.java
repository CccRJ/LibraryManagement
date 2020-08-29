package myself.library.interceptor;

import freemarker.template.utility.StringUtil;
import myself.library.model.entities.Ticket;
import myself.library.model.entities.User;
import myself.library.service.TicketService;
import myself.library.service.UserService;
import myself.library.utils.ConcurrentUtils;
import myself.library.utils.CookieUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * @program: library
 * @description: 总是返回true可以访问初始网页，通过请求中的Cookie找ticket，放行用户
 * 找到ticket从数据库找到用户放入ConcurrentUtils
 * 登陆一次之后的操作和登陆都不需要密码
 *
 * 解决问题：注册之后注入ThreadLocal，读取时线程不同导致读取不到user
 * 访问网页前的拦截器和controller 是相同线程，可以保证用户显示登录正常
 * @author: ChaiRJ
 * @create: 2020-08-29 10:29
 **/

@Component
public class HostInfoInterceptor implements HandlerInterceptor {
    @Autowired
    private TicketService ticketService;

    @Autowired
    private UserService userService;

    /**
     * 注入host信息
     *
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //从cookie中获取ticket信息
        String ticketInfo = CookieUtils.getCookie("ticket", request);
        if (!StringUtils.isEmpty(ticketInfo)) {
            //查找ticket对象
            Ticket ticket = ticketService.getTicket(ticketInfo);
            //如果可以找到，并且没有过期
            if (ticket != null && ticket.getExpiredAt().after(new Date())) {
                //找到用户并且注入ThreadLocal
                User user = userService.getUser(ticket.getUserId());
                //System.out.println("Host拦截器"+Thread.currentThread());
                ConcurrentUtils.setHost(user);
            }
        }
        return true;
    }
}
