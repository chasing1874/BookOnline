package chasing.service.impl;

import chasing.dao.BookDao;
import chasing.dao.impl.BookDaoImpl;
import chasing.pojo.Book;
import chasing.pojo.Page;
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

    @Override
    public Page<Book> page(int pageNo, int pageSize) {
        Page<Book> page = new Page<>();


        //每页显示的数量
        page.setPage_size(pageSize);
        //求总记录数
        Integer pageTotalCount = bookDao.queryForPageTotalCount();
        page.setPageTotal(pageTotalCount);
        //求总页码
        Integer pageTotal = pageTotalCount / pageSize;
        if (pageTotalCount % pageSize > 0) {
            pageTotal += 1;
        }
        page.setPageTotal(pageTotal);

        //设置当前页码，在求得总页码之后，因为有一个边界检验
        page.setPageNo(pageNo);

        //求当前页的数据
        Integer begin = (page.getPageNo()-1) * pageSize;
        List<Book> items = bookDao.queryForPageItems(begin, pageSize);
        page.setItems(items);

        return page;
    }

    @Override
    public Page<Book> pageByPrice(int min, int max, int pageNo, int pageSize) {
        Page<Book> page = new Page<>();

        //每页显示的数量
        page.setPage_size(pageSize);
        //求总记录数
        Integer pageTotalCount = bookDao.queryForPageTotalCountByPrice(min, max);
        page.setPageTotal(pageTotalCount);
        //求总页码
        Integer pageTotal = pageTotalCount / pageSize;
        if (pageTotalCount % pageSize > 0) {
            pageTotal += 1;
        }
        page.setPageTotal(pageTotal);

        //设置当前页码，在求得总页码之后，因为有一个边界检验
        page.setPageNo(pageNo);

        //求当前页的数据
        Integer begin = (page.getPageNo()-1) * pageSize;
        List<Book> items = bookDao.queryForPageItemsByPrice(min, max, begin, pageSize);
        page.setItems(items);

        return page;
    }
}
