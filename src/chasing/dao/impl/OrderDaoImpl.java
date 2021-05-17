package chasing.dao.impl;

import chasing.dao.OrderDao;
import chasing.pojo.Order;
import chasing.pojo.User;

import java.util.List;

/**
 * @author 柴柴快乐每一天
 * @create 2021-05-15  10:23 上午
 * <p>
 * 『Stay hungry, stay foolish. 』
 */
public class OrderDaoImpl extends BaseDao implements OrderDao {
    @Override
    public int saveOrder(Order order) {
        //不用起别名，查询才起
        String sql = "insert into t_order(order_id, create_time, price, status, user_id) value(?, ?, ?, ?, ?)";
        return update(sql, order.getOrderId(), order.getCreateTime(), order.getPrice(), order.getStatus(), order.getUserId());
    }

    @Override
    public List<Order> queryMyOrder(int userId) {
        String sql = "select order_id orderId, create_time createTime, price, status, user_id userId from t_order where user_id = ?";
        return queryForList(Order.class, sql, userId);
    }

    @Override
    public List<Order> queryAllOrders() {
        String sql = "select order_id orderId, create_time createTime, price, status, user_id userId from t_order";
        return queryForList(Order.class, sql);
    }

    @Override
    public int changeOrderStatus(String orderId, int status) {
        String sql = "update t_order set status = ? where order_id = ?";
        return update(sql, status, orderId);
    }
}
