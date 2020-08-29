package myself.library.interceptor;

import myself.library.model.entities.Ticket;
import myself.library.service.TicketService;
import myself.library.utils.ConcurrentUtils;
import myself.library.utils.CookieUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

/**
 * @program: library
 * @description: ticket认证拦截器，没次对书进行操作时都进行检查，查看ticket是否有效
 * @author: ChaiRJ
 * @create: 2020-08-29 11:23
 **/
@Component
public class LoginInterceptor implements HandlerInterceptor {
    @Autowired
    private TicketService ticketService;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //cookie中没有ticket信息
        String ticketInfo = CookieUtils.getCookie("ticket", request);
        if (StringUtils.isEmpty(ticketInfo)){
            response.sendRedirect("/users/login");
            return false;
        }

        //无效票或者票过期
        Ticket ticket = ticketService.getTicket(ticketInfo);
        if (ticket == null || ticket.getExpiredAt().before(new Date())){
            response.sendRedirect("/users/login");
            //删除host
            //ConcurrentUtils.setHost(null);
            return false;
        }
        return true;
    }
}
