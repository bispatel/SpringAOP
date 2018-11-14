package com.springaop.learn.aspect.transaction;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface OrderService {

    void persistOrders(List<OrderItem> orderItems);

    List<OrderItem> getAllOrders();
    
    void persistOrdersWithRollBack(List<OrderItem> orderItems)  throws InvalidOrderItemException;
    void persistOrdersWithOutRollBack(List<OrderItem> orderItems)  throws InvalidOrderItemException;
    
}