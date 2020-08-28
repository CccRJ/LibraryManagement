package myself.library.service;

import myself.library.dao.BookDao;
import myself.library.model.entities.Book;
import myself.library.model.enums.BookStatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: library
 * @description: BookService
 * @author: ChaiRJ
 * @create: 2020-08-27 13:31
 **/
@Service
public class BookService {
    @Autowired
    private BookDao bookDao;

    public List<Book> getAllBooks() {
        return bookDao.selectAllBook();
    }

    public Book getBook(int id) {
        return bookDao.selectBookById(id);
    }

    public int addBook(Book book) {
        return bookDao.insertBook(book);
    }

    public int deleteBook(int id) {
        return bookDao.updateBookStatus(id, BookStatusEnum.DELETE.getValue());
    }

    public int recoverBook(int id) {
        return bookDao.updateBookStatus(id, BookStatusEnum.NORMAL.getValue());
    }

}
