package chasing.service;

import chasing.pojo.Book;
import chasing.pojo.Page;

import java.util.List;

/**
 * @author 柴柴快乐每一天
 * @create 2021-05-09  11:01 上午
 * <p>
 * 『Stay hungry, stay foolish. 』
 */
public interface BookService {
    public void addBook(Book book);

    public void deleteBookById(Integer id);

    public void updateBook(Book book);

    public Book queryBookById(Integer id);

    public List<Book> queryBooks();

    Page<Book> page(int pageNo, int pageSize);

    Page<Book> pageByPrice(int min, int max, int pageNo, int pageSize);
}
