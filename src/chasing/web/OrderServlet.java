package chasing.web;

import chasing.pojo.Cart;
import chasing.pojo.Order;
import chasing.pojo.OrderItem;
import chasing.pojo.User;
import chasing.service.OrderService;
import chasing.service.impl.OrderServiceImpl;
import chasing.utils.WebUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @author 柴柴快乐每一天
 * @create 2021-05-15  11:11 上午
 * <p>
 * 『Stay hungry, stay foolish. 』
 */
public class OrderServlet extends BaseServlet{

    private OrderService orderService = new OrderServiceImpl();

    /**\
     * 生成订单
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void createOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取cart购物车对象
        Cart cart = (Cart) req.getSession().getAttribute("cart");
        //获取userId
        User loginUser = (User) req.getSession().getAttribute("user");

        if (loginUser == null) {
            req.getRequestDispatcher("/pages/user/login.jsp").forward(req,resp);
            return;
        }

        Integer userId = loginUser.getId();
        String orderId = orderService.createOrder(cart, userId);

        //重定向到订单完成界面，为避免表单重复提交，不能用请求转发
        req.getSession().setAttribute("orderId", orderId);
        resp.sendRedirect(req.getContextPath()+"/pages/cart/checkout.jsp");
    }

    /**
     * 我的订单列表
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void myOrders(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int userId = WebUtils.parseInt(req.getParameter("userId"), 0);
        List<Order> orders = orderService.myOrders(userId);
        req.setAttribute("myOrders", orders);

        //不要忘了写forward
        req.getRequestDispatcher("/pages/order/order.jsp").forward(req,resp);
    }

    /**
     * 订单明细
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void orderDetails(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String orderId = req.getParameter("orderId");

        List<OrderItem> orderItems = orderService.orderDetails(orderId);

        req.setAttribute("orderDetails", orderItems);
        req.getRequestDispatcher("/pages/order/orderDetails.jsp").forward(req,resp);
    }

    /**
     * 查看所有订单（管理员）
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void allOrders(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Order> orders = orderService.allOrders();
        req.setAttribute("allOrders", orders);
        req.getRequestDispatcher("/pages/manager/order_manager.jsp").forward(req,resp);
    }

    /**
     * 发货（管理员）
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void sendOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String orderId = req.getParameter("orderId");
        orderService.sendOrder(orderId);
        //因为要刷新操作后的页面，所以应该再次请求
        req.getRequestDispatcher("orderServlet?action=allOrders").forward(req,resp);
    }

    /**
     * 收货（用户）
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    protected void receiveOrder(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int userId = WebUtils.parseInt(req.getParameter("userId"), 0);
        String orderId = req.getParameter("orderId");
        orderService.receiveOrder(orderId);
        //因为要刷新操作后的页面，所以应该再次请求,,,,servlet程序不是jsp页面，不能用EL表达式
        req.getRequestDispatcher("orderServlet?action=myOrders&userId="+userId).forward(req,resp);

    }
}
