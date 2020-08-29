package myself.library.utils;

import myself.library.model.entities.Ticket;
import org.joda.time.DateTime;

/**
 * @program: library
 * @description: 凭证工具
 * @author: ChaiRJ
 * @create: 2020-08-28 15:58
 **/
public class TicketUtils {

    /**
     * 为用户 userId 生成ticket工具
     *
     * @param userId
     * @return 返回ticket
     */
    public static Ticket generateTicket(int userId) {
        Ticket ticket = new Ticket();
        ticket.setTicket(UUIDUtils.generateUUID());
        ticket.setUserId(userId);
        //设置过期时间，初始化当前时间
        DateTime expiredTime = new DateTime();
        //增加三个月的 month
        expiredTime = expiredTime.plusMinutes(1);
        ticket.setExpiredAt(expiredTime.toDate());

        return ticket;
    }
}
