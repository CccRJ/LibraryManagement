package myself.library;

import myself.library.dao.BookDao;
import myself.library.dao.UserDao;
import myself.library.model.entities.Book;
import myself.library.model.entities.User;
import myself.library.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class LibraryApplicationTests {

	@Test
	void contextLoads() {
	}

	@Autowired
	BookService bookService;

	@Autowired
	UserDao userDao;

	@Test
	public void testSelectAll(){
		List<Book> allBooks = bookService.getAllBooks();
		System.out.println(allBooks);
	}

	@Test
	public void testAddUser(){
		User user = new User("chai","123@123.com","123");
		userDao.insertUser(user);
		User user1 = userDao.selectById(1);
		System.out.println(user1);
	}

}
