package chasing.dao.impl;

import chasing.dao.OrderItemDao;
import chasing.pojo.Order;
import chasing.pojo.OrderItem;

import java.util.List;

/**
 * @author 柴柴快乐每一天
 * @create 2021-05-15  10:30 上午
 * <p>
 * 『Stay hungry, stay foolish. 』
 */
public class OrderItemDaoImpl extends BaseDao implements OrderItemDao {
    @Override
    public int saveOrderItem(OrderItem orderItem) {
        //id 自增，不用传入
        String sql = "insert into t_order_item(name, count, price, total_price, order_id) value(?, ?, ?, ?, ?)";
        return update(sql, orderItem.getName(), orderItem.getCount(), orderItem.getPrice(), orderItem.getTotalPrice(), orderItem.getOrderId());
    }

    @Override
    public List<OrderItem> queryOrderDetailByOrderId(String orderId) {
        String sql = "select id, name, count, price, total_price totalPrice, order_id orderId from t_order_item where order_id = ?";
        return queryForList(OrderItem.class, sql, orderId);
    }
}
