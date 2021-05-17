package chasing.service.impl;

import chasing.dao.BookDao;
import chasing.dao.OrderDao;
import chasing.dao.OrderItemDao;
import chasing.dao.impl.BookDaoImpl;
import chasing.dao.impl.OrderDaoImpl;
import chasing.dao.impl.OrderItemDaoImpl;
import chasing.pojo.*;
import chasing.service.OrderService;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @author 柴柴快乐每一天
 * @create 2021-05-15  10:49 上午
 * <p>
 * 『Stay hungry, stay foolish. 』
 */
public class OrderServiceImpl implements OrderService {

    private OrderDao orderDao = new OrderDaoImpl();
    private OrderItemDao orderItemDao = new OrderItemDaoImpl();
    private BookDao bookDao = new BookDaoImpl();

    @Override
    public String createOrder(Cart cart, Integer userId) {
        //生成订单号，唯一
        String orderId = System.currentTimeMillis()+""+userId;
        //创建一个订单对象
        Order order = new Order(orderId, new Date(), cart.getTotalPrice(), 0, userId);
        //保存订单
        orderDao.saveOrder(order);

        //遍历购物车中每一个商品项转换为订单项添加到数据库
        for (Map.Entry<Integer, CartItem>entry : cart.getItems().entrySet()) {
            //获取每一个购物车中的商品项
            CartItem cartItem = entry.getValue();
            //商品项转换为订单项,订单编号为上面生成的订单编号
            OrderItem orderItem = new OrderItem(null, cartItem.getName(), cartItem.getCount(), cartItem.getPrice(), cartItem.getTotalPrice(), orderId);
            //订单项保存到数据库
            orderItemDao.saveOrderItem(orderItem);

            //更新库存和销量
            Book book = bookDao.queryBookById(cartItem.getId());
            book.setSales(book.getSales()+cartItem.getCount());
            book.setStock(book.getStock()- cartItem.getCount());
            bookDao.updateBook(book);

        }
        //情况购物车
        cart.clear();
        return orderId;
    }

    @Override
    public List<Order> myOrders(int userId) {
        List<Order> orders = orderDao.queryMyOrder(userId);
        return orders;
    }

    @Override
    public List<OrderItem> orderDetails(String orderId) {
        List<OrderItem> orderItems = orderItemDao.queryOrderDetailByOrderId(orderId);
        return orderItems;
    }

    @Override
    public List<Order> allOrders() {
        List<Order> orders = orderDao.queryAllOrders();
        return orders;
    }

    @Override
    public void sendOrder(String orderId) {
        orderDao.changeOrderStatus(orderId, 1);
    }

    @Override
    public void receiveOrder(String orderId) {
        orderDao.changeOrderStatus(orderId, 2);
    }
}
