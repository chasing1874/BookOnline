package chasing.web;

import chasing.pojo.Eb;
import chasing.service.EbService;
import chasing.service.impl.EbServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

/**
 * @author 柴柴快乐每一天
 * @create 2021-05-14  7:18 下午
 * <p>
 * 『Stay hungry, stay foolish. 』
 */
public class EbServlet extends BaseServlet{

    EbService ebService = new EbServiceImpl();

    protected void search(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        java.util.Date  utilDate = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

        List<Eb> ebList = ebService.search(sqlDate);
        req.setAttribute("ebList", ebList);
        System.out.println(ebList);
        req.getRequestDispatcher("/pages/client/ebbinghaus.jsp").forward(req,resp);
    }

    protected void addEb(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        java.util.Date  utilDate = new java.util.Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

        String ebInfo = req.getParameter("ebInfo");
        String ebHref = req.getParameter("ebHref");

        Eb eb = new Eb(null, sqlDate, ebInfo, ebHref, null, null, null, null, null, null, null, null);
        ebService.addEb(eb);
        

        resp.sendRedirect(req.getContextPath()+"/pages/client/ebbinghaus.jsp");

    }
}
