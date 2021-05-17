package chasing.test;

import chasing.dao.OrderItemDao;
import chasing.dao.impl.OrderItemDaoImpl;
import chasing.pojo.OrderItem;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author 柴柴快乐每一天
 * @create 2021-05-15  10:33 上午
 * <p>
 * 『Stay hungry, stay foolish. 』
 */
public class OrderItemDaoTest {

    OrderItemDao orderItemDao = new OrderItemDaoImpl();

    @Test
    public void saveOrderItem() {
        orderItemDao.saveOrderItem(new OrderItem(null, "java", 1, new BigDecimal(100), new BigDecimal(100), "123333333"));
        orderItemDao.saveOrderItem(new OrderItem(null, "java1", 1, new BigDecimal(100), new BigDecimal(100), "123333333"));
        orderItemDao.saveOrderItem(new OrderItem(null, "java2", 1, new BigDecimal(100), new BigDecimal(100), "123333333"));
    }

    @Test
    public void queryOrderDetailByOrderId() {
        List<OrderItem> orderItems = orderItemDao.queryOrderDetailByOrderId("16212110978692");
        for (OrderItem orderItem : orderItems) {
            System.out.println(orderItem);
        }
    }
}