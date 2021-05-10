package chasing.dao;

import chasing.pojo.Book;

import java.util.List;

/**
 * @author 柴柴快乐每一天
 * @create 2021-05-09  10:36 上午
 * <p>
 * 『Stay hungry, stay foolish. 』
 */
public interface BookDao {
    public int addBook(Book book);

    public int deleteBookById(Integer id);

    public int updateBook(Book book);

    public Book queryBookById(Integer id);

    public List<Book> queryBooks();

    Integer queryForPageTotalCount();

    List<Book> queryForPageItems(Integer begin, int pageSize);

    Integer queryForPageTotalCountByPrice(int min, int max);

    List<Book> queryForPageItemsByPrice(int min, int max, Integer begin, int pageSize);
}
