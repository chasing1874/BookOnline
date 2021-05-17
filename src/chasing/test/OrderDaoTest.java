package chasing.test;

import chasing.dao.OrderDao;
import chasing.dao.impl.OrderDaoImpl;
import chasing.pojo.Order;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author 柴柴快乐每一天
 * @create 2021-05-15  10:33 上午
 * <p>
 * 『Stay hungry, stay foolish. 』
 */
public class OrderDaoTest {

    OrderDao orderDao = new OrderDaoImpl();
    @Test
    public void saveOrder() {

        orderDao.saveOrder(new Order("123333333", new Date(), new BigDecimal(100), 0, 1));

    }

    @Test
    public void queryMyOrder() {
        List<Order> orders = orderDao.queryMyOrder(2);
        for (Order order : orders) {
            System.out.println(order);
        }

    }

    @Test
    public void queryAllOrders() {
        List<Order> orders = orderDao.queryAllOrders();
        for (Order order : orders) {
            System.out.println(order);
        }
    }

    @Test
    public void changeOrderStatus() {
        int i = orderDao.changeOrderStatus("16210479082711", 1);
    }
}