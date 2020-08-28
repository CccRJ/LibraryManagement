package myself.library.dao;

import myself.library.model.entities.Book;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: library
 * @description: BookDAO
 * @author: ChaiRJ
 * @create: 2020-08-27 13:05
 **/
@Mapper
@Repository
public interface BookDao {

    @Select("select * from book")
    List<Book> selectAllBook();

    @Select("select * from book " +
            "where bookId = #{bookId}")
    Book selectBookById(Integer bookId);

    @Insert("insert into book " +
            "values(#{bookId},#{bookName},#{bookAuthor},#{bookPrice},#{bookStatus})")
    int insertBook(Book book);

    @Delete("delete from book " +
            "where bookId = #{bookId}")
    int deleteById(Integer bookId);

    @Update("update book set bookStatus = #{bookStatus} " +
            "where bookId = #{bookId}")
    int updateBookStatus(Integer bookId,int bookStatus);

}
