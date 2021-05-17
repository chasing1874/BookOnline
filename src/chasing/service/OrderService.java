package chasing.service;

import chasing.pojo.Cart;
import chasing.pojo.Order;
import chasing.pojo.OrderItem;

import java.util.List;

/**
 * @author 柴柴快乐每一天
 * @create 2021-05-15  10:47 上午
 * <p>
 * 『Stay hungry, stay foolish. 』
 */
public interface OrderService {
    /**
     * 生成订单
     * @param cart  购物车信息
     * @param userId    用户信息
     * @return  返回订单编号
     */
    public String createOrder(Cart cart, Integer userId);

    /**
     * 查询我的订单
     * @param userId    传入该用户Id
     * @return  返回该用户所有订单信息
     */
    public List<Order> myOrders(int userId);

    /**
     * 查询订单明细
     * @param orderId   传入订单Id
     * @return  返回该订单下的所有订单项
     */
    public List<OrderItem> orderDetails(String orderId);

    /**
     * 查询所有人订单（管理员使用）
     * @return  返回所有订单信息
     */
    public List<Order> allOrders();

    /**
     * 确认发货（管理员）
     * @param orderId   传入该订单Id
     */
    public void sendOrder(String orderId);

    /**
     * 用户确认收货（用户使用）
     * @param orderId   传入该订单ID
     */
    public void receiveOrder(String orderId);
}
