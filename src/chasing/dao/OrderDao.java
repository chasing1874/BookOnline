package chasing.dao;

import chasing.pojo.Order;
import chasing.pojo.User;

import java.util.List;

/**
 * @author 柴柴快乐每一天
 * @create 2021-05-15  10:22 上午
 * <p>
 * 『Stay hungry, stay foolish. 』
 */
public interface OrderDao {
    /**
     * 保存订单
     * @param order 订单信息
     * @return  返回保存是否成功
     */
    public int saveOrder(Order order);

    /**
     * 查询我的订单
     * @param userId    传入该用户Id
     * @return  返回我的订单列表
     */
    public List<Order> queryMyOrder(int userId);

    /**
     * 查询所有订单（管理员使用）
     * @return  返回所有订单列表
     */
    public List<Order> queryAllOrders();

    /**
     * 修改订单状态
     * @param orderId   该订单id
     * @param status    欲修改的状态，0未发货，1已发货，2已签收
     * @return
     */
    public int changeOrderStatus(String orderId, int status);

}
