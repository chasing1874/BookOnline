package chasing.web;

import chasing.pojo.Book;
import chasing.service.BookService;
import chasing.service.impl.BookServiceImpl;
import chasing.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author 柴柴快乐每一天
 * @create 2021-05-09  11:16 上午
 * <p>
 * 『Stay hungry, stay foolish. 』
 */
public class BookServlet extends BaseServlet{
    private BookService bookService = new BookServiceImpl();

    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1 通过 BookService 查询全部图书
        List<Book> books = bookService.queryBooks();
        //2 把全部图书保存到 Request 域中
        req.setAttribute("books", books);
        //3、请求转发到/pages/manager/book_manager.jsp 页面,域对象一次请求用请求转发保存数据
        req.getRequestDispatcher("/pages/manager/book_manager.jsp").forward(req,resp);
    }

    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       // 1、获取请求的参数==封装成为 Book 对象
        Book book = WebUtils.copyParamToBean(req.getParameterMap(), new Book());
        //2、调用 BookService.addBook()保存图书
        bookService.addBook(book);
        System.out.println("invoke already");
        //3、跳到图书列表页面
        // /manager/bookServlet?action=list
        // req.getRequestDispatcher("/manager/bookServlet?action=list").forward(req, resp);
        resp.sendRedirect(req.getContextPath()+"/manager/bookServlet?action=list");
    }

    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = WebUtils.parseInt(req.getParameter("id"), 0);

        bookService.deleteBookById(id);

        resp.sendRedirect(req.getContextPath()+"/manager/bookServlet?action=list");
    }

    protected void getBook(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. 获取请求的图书参数
        int id = WebUtils.parseInt(req.getParameter("id"), 0);
        //2. 调用bookService查询图书
        Book book = bookService.queryBookById(id);
        //3. 将查询结果保存到域对象
        req.setAttribute("book", book);
        //4、 将请求转发，把域对象book带到book_edit页面
        req.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(req, resp);
    }

    protected void update(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //1. 获取请求的参数，封装称为对象
        Book book = WebUtils.copyParamToBean(req.getParameterMap(), new Book());
        //2. 调用bookService更新图书信息
        //之所以更新失败，是因为更新还需要获取id参数，必须获取！
        bookService.updateBook(book);
        //3. 重定向回列表管理页面
        //地址：/工程名/manager/bookServlet?action=list
        resp.sendRedirect(req.getContextPath()+"/manager/bookServlet?action=list");

    }

}
