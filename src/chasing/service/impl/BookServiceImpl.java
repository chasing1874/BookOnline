package chasing.service.impl;

import chasing.dao.BookDao;
import chasing.dao.impl.BookDaoImpl;
import chasing.pojo.Book;
import chasing.service.BookService;

import java.util.List;

/**
 * @author 柴柴快乐每一天
 * @create 2021-05-09  11:03 上午
 * <p>
 * 『Stay hungry, stay foolish. 』
 */
public class BookServiceImpl implements BookService {

    private BookDao bookDao = new BookDaoImpl();

    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    @Override
    public void deleteBookById(Integer id) {
        bookDao.deleteBookById(id);
    }

    @Override
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    @Override
    public Book queryBookById(Integer id) {
        return bookDao.queryBookById(id);
    }

    @Override
    public List<Book> queryBooks() {
        return bookDao.queryBooks();
    }
}
