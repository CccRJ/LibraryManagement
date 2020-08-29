package myself.library.service;

import myself.library.dao.TicketDao;
import myself.library.model.entities.Ticket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: library
 * @description: 凭证功能
 * @author: ChaiRJ
 * @create: 2020-08-28 15:07
 **/
@Service
public class TicketService {

    @Autowired
    TicketDao ticketDao;

    public Ticket getTicket(int uerId){
        return ticketDao.selectByUserId(uerId);
    }

    public Ticket getTicket(String ticket){
        return ticketDao.selectByTicket(ticket);
    }

    public void addTicket(Ticket t){
        ticketDao.addTicket(t);
    }

    public void deleteTicket(int ticketId){
        ticketDao.deleteTicketByTicketId(ticketId);
    }

    public void deleteTicket(String ticket){
        ticketDao.deleteTicket(ticket);
    }

    public void deleteTicketByUserId(int userId){
        ticketDao.deleteTicketByUserId(userId);
    }
}
