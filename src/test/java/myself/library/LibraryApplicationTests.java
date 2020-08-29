package myself.library;

import myself.library.dao.BookDao;
import myself.library.dao.UserDao;
import myself.library.model.entities.Book;
import myself.library.model.entities.Ticket;
import myself.library.model.entities.User;
import myself.library.service.BookService;
import myself.library.service.TicketService;
import myself.library.utils.ConcurrentUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@SpringBootTest
class LibraryApplicationTests {

	@Test
	void contextLoads() {
		System.out.println(UUID.randomUUID().toString());
	}

	@Autowired
	BookService bookService;

	@Autowired
	UserDao userDao;

	@Autowired
	TicketService ticketService;

	@Test
	public void testSelectAll(){
		List<Book> allBooks = bookService.getAllBooks();
		System.out.println(allBooks);
	}

	//测试添加用户
	@Test
	public void testAddUser(){
		User user = new User("chai","123@123.com","123");
		userDao.insertUser(user);
		User user1 = userDao.selectById(1);
		System.out.println(user1);
	}

	//测试添加ticket
	@Test
	public void testAddTicket(){
		ticketService.addTicket(new Ticket(1,"1",new Date()));
	}
	//查询ticket
	@Test
	public void testSelectTicket(){
		Ticket ticket = ticketService.getTicket(10);
		System.out.println(ticket);
	}
	@Test
	public void testThread(){
		Thread thread1 = new Thread(new Runnable() {
			@Override
			public void run() {
				ConcurrentUtils.setHost(new User("chai","abc","123"));
			}
		});
		thread1.start();
		Thread thread2 = new Thread(new Runnable() {
			@Override
			public void run() {
				User host = ConcurrentUtils.getHost();
				System.out.println(host);
			}
		});
		thread2.start();
	}
}
