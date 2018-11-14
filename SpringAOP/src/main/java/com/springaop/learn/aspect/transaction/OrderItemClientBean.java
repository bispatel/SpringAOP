package com.springaop.learn.aspect.transaction;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderItemClientBean {
    @Autowired
    private OrderService orderService;

    public void persistOrderItems() {
        List<OrderItem> orders = Arrays.asList(
                new OrderItem("BWell Ethernet Cable", 5),
                new OrderItem("EDrive SSD", 2000)
        );
        try {
            orderService.persistOrdersWithOutRollBack(orders);
        } catch (InvalidOrderItemException e) {
            logException(e);
        }
        List<OrderItem> allOrders = orderService.getAllOrders();
        System.out.println("loaded orders: " + allOrders);

        System.out.println("-- second attempt --");
        List<OrderItem> orders2 = Arrays.asList(
                new OrderItem("BWell Ethernet Cable", 5),
                new OrderItem("EDrive SSD", 20)
        );
        try {
            orderService.persistOrdersWithOutRollBack(orders2);
        } catch (InvalidOrderItemException e) {
            logException(e);
        }
        List<OrderItem> allOrders2 = orderService.getAllOrders();
        System.out.println("loaded orders: " + allOrders2);
    }

    private static void logException(Exception e) {
        System.out.println("-- exception --");
        System.err.println("Exception: "+e.getClass().getName());
        System.err.println("Message: "+ e.getMessage());
        System.out.println("---------");
    }
}