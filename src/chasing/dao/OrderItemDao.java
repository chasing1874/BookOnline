package chasing.dao;

import chasing.pojo.Order;
import chasing.pojo.OrderItem;

import java.util.List;

/**
 * @author 柴柴快乐每一天
 * @create 2021-05-15  10:27 上午
 * <p>
 * 『Stay hungry, stay foolish. 』
 */
public interface OrderItemDao {
    /**
     * 保存订单项
     * @param orderItem 订单项信息
     * @return  保存是否成功
     */
    public int saveOrderItem(OrderItem orderItem);

    /**
     * 查询某个订单的明细
     * @param orderId    传入该订单ID
     * @return  返回该订单的所有订单项
     */
    public List<OrderItem> queryOrderDetailByOrderId(String orderId);
}
