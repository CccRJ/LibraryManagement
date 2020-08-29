package myself.library.dao;

import myself.library.model.entities.Ticket;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * @program: library
 * @description: 凭证接口
 * @author: ChaiRJ
 * @create: 2020-08-28 14:29
 **/
@Repository
@Mapper
public interface TicketDao {

    String tableName = "ticket";
    String insertField = "userId,ticket,expiredAt";
    String selectField = "ticketId," + insertField;

    @Select({"select", selectField, "from", tableName, "where userId = #{userId}"})
    Ticket selectByUserId(int userId);

    @Select({"select", selectField, "from", tableName, "where ticket = #{ticket}"})
    Ticket selectByTicket(String ticket);

//    @Insert({"insert into", tableName, "(", insertField,
//            ") values(#{userId},#{ticket},#{expiredAt})"})
    @Insert("insert into ticket values(#{ticketId},#{userId},#{ticket},#{expiredAt})")
    int addTicket(Ticket ticket);

    @Delete({"delete from", tableName, "where userId = #{userId}"})
    int deleteTicketByUserId(int userId);

    @Delete({"delete from", tableName, "where ticketId = #{ticketId}"})
    int deleteTicketByTicketId(int ticketId);

    @Delete({"delete from", tableName, "where ticket = #{ticket}"})
    int deleteTicket(String ticket);
}
