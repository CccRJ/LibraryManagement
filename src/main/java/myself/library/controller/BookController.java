package myself.library.controller;

import myself.library.model.entities.Book;
import myself.library.model.entities.User;
import myself.library.service.BookService;
import myself.library.service.HostHolder;
import myself.library.utils.ConcurrentUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @program: library
 * @description: BookController
 * @author: ChaiRJ
 * @create: 2020-08-27 13:46
 **/
@Controller
public class BookController {
    @Autowired
    private BookService bookService;

    @Autowired
    private HostHolder hostHolder;

    /**
     * 为model加载所有的book
     * @param model
     */
    private void loadAllBooksView(Model model){
        model.addAttribute("books",bookService.getAllBooks());
    }

    /**
     * 登陆前 初始页面
     * @param model
     * @return 初始页面
     */
    @RequestMapping(path = {"/index",""}, method = {RequestMethod.GET})
    public String bookList(Model model){
        //线程同步
        //System.out.println("BookController-"+Thread.currentThread());
        User host = hostHolder.getUser();
        if (host != null){
            model.addAttribute("host",host);
        }
        loadAllBooksView(model);

        return "book/books";
    }

    /**
     * 跳转到addbook.html页面
     * @return 加书页面
     */
    @RequestMapping(path = "/books/add",method = RequestMethod.GET)
    public String addBook(){
        //添加书籍页面
        return "book/addbook";
    }

    /**
     * 添加书籍，重定向返回初始页面
     * @param book
     * @return 重定向初始页面
     */
    @RequestMapping(path = "/books/add/do",method = RequestMethod.POST)
    public String doAddBook(Book book){
        System.out.println(book);
        bookService.addBook(book);
        return "redirect:/index";
    }

    /**
     * 借书，修改书的状态为删除状态
     *
     * @param bookId
     * @return 重定向初始页面
     */
    @RequestMapping(path = "/books/{bookId:[0-9]+}/delete",method = RequestMethod.GET)
    public String deleteBook(@PathVariable("bookId") int bookId){
        bookService.deleteBook(bookId);
        return "redirect:/index";
    }

    /**
     * 还书，书修改为存在状态
     * @param bookId
     * @return 重定向初始页面
     */
    @RequestMapping(path = "/books/{bookId:[0-9]+}/recover",method = RequestMethod.GET)
    public String recoverBook(@PathVariable("bookId") int bookId){
        bookService.recoverBook(bookId);
        return "redirect:/index";
    }
}
