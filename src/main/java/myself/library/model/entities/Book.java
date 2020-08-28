package myself.library.model;

import java.io.Serializable;

/**
 * @program: library
 * @description: 书
 * @author: ChaiRJ
 * @create: 2020-08-27 13:02
 **/
public class Book implements Serializable {
    private int bookId;
    private String bookName;
    private String bookAuthor;
    private String bookPrice;

    public Book(int bookId, String bookName, String bookAuthor, String bookPrice, Integer bookStatus) {
        this.bookId = bookId;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookPrice = bookPrice;
        this.bookStatus = bookStatus;
    }

    private Integer bookStatus;

    public Book() {
    }


    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookPrice() {
        return bookPrice;
    }

    public void setBookPrice(String bookPrice) {
        this.bookPrice = bookPrice;
    }

    public Integer getBookStatus() {
        return bookStatus;
    }

    public void setBookStatus(Integer bookStatus) {
        this.bookStatus = bookStatus;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", bookAuthor='" + bookAuthor + '\'' +
                ", bookPrice='" + bookPrice + '\'' +
                ", bookStatus=" + bookStatus +
                '}';
    }
}
