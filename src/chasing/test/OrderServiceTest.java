package chasing.test;

import chasing.pojo.Cart;
import chasing.pojo.CartItem;
import chasing.pojo.Order;
import chasing.pojo.OrderItem;
import chasing.service.OrderService;
import chasing.service.impl.OrderServiceImpl;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.*;

/**
 * @author 柴柴快乐每一天
 * @create 2021-05-15  10:59 上午
 * <p>
 * 『Stay hungry, stay foolish. 』
 */
public class OrderServiceTest {
    OrderService orderService = new OrderServiceImpl();


    @Test
    public void createOrder() {
        Cart cart = new Cart();

        cart.addItem(new CartItem(1, "java1", 1, new BigDecimal(1000), new BigDecimal(1000)));
        cart.addItem(new CartItem(1, "java1", 1, new BigDecimal(1000), new BigDecimal(1000)));
        cart.addItem(new CartItem(2, "java2", 1, new BigDecimal(100), new BigDecimal(100)));


        System.out.println("订单编号：" + orderService.createOrder(cart, 1));
    }

    @Test
    public void myOrders() {
        List<Order> orders = orderService.myOrders(2);
        for (Order order : orders) {
            System.out.println(order);
        }
    }

    @Test
    public void orderDetails() {
        List<OrderItem> orderItems = orderService.orderDetails("16210488906582");
        for (OrderItem orderItem : orderItems) {
            System.out.println(orderItem);
        }
    }

    @Test
    public void allOrders() {
        List<Order> orders = orderService.allOrders();
        for (Order order : orders) {
            System.out.println(order);
        }
    }

    @Test
    public void sendOrder() {
        orderService.sendOrder("16210488906582");
    }

    @Test
    public void receiveOrder() {
        orderService.receiveOrder("16210488906582");
    }
}