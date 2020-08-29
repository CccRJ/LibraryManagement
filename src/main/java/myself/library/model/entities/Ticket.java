package myself.library.model.entities;

import java.util.Date;

/**
 * @program: library
 * @description: 用户凭证
 * @author: ChaiRJ
 * @create: 2020-08-28 11:20
 **/
public class Ticket {

    private int ticketId;
    //绑定userId
    private int userId;
    //票本身信息
    private String ticket;
    //过期时间
    private Date expiredAt;

    public Ticket(int userId, String ticket, Date expiredAt) {
        this.userId = userId;
        this.ticket = ticket;
        this.expiredAt = expiredAt;
    }

    public Ticket() {
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public Date getExpiredAt() {
        return expiredAt;
    }

    public void setExpiredAt(Date expiredAt) {
        this.expiredAt = expiredAt;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketId=" + ticketId +
                ", userId=" + userId +
                ", ticket='" + ticket + '\'' +
                ", expiredAt=" + expiredAt +
                '}';
    }
}
