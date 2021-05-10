package chasing.test;

import chasing.dao.BookDao;
import chasing.dao.impl.BookDaoImpl;
import chasing.pojo.Book;
import org.junit.Test;

import java.math.BigDecimal;

import static org.junit.Assert.*;

/**
 * @author 柴柴快乐每一天
 * @create 2021-05-09  10:53 上午
 * <p>
 * 『Stay hungry, stay foolish. 』
 */
public class BookDaoTest {

    private BookDao bookDao = new BookDaoImpl();
    @Test
    public void addBook() {
        bookDao.addBook(new Book(null, "龙族", "江南", new BigDecimal(9999), 110000, 0, null));
    }

    @Test
    public void deleteBookById() {
        bookDao.deleteBookById(23);
    }

    @Test
    public void updateBook() {
        bookDao.updateBook(new Book(22, "龙族全集", "江南老贼", new BigDecimal(6666), 1100000, 0, null));
    }

    @Test
    public void queryBookById() {
        System.out.println(bookDao.queryBookById(22));
    }

    @Test
    public void queryBooks() {
        for (Book book :
                bookDao.queryBooks()) {
            System.out.println(book);
        }
    }
}