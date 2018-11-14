package com.springaop.learn.aspect.transaction;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private Dao<OrderItem> dao;

    @Override
    public void persistOrders(List<OrderItem> orderItems) {
        for (OrderItem orderItem : orderItems) {
            long id = dao.save(orderItem);
            System.out.println("id generated: " + id);
        }
    }

    @Override
    @Transactional(rollbackFor = InvalidOrderItemException.class)
    public void persistOrdersWithRollBack(List<OrderItem> orderItems) throws InvalidOrderItemException {
        for (OrderItem orderItem : orderItems) {
            if (orderItem.getQty() > 100) {
                throw new InvalidOrderItemException(
                        "Order quantity cannot be more than 100, found: "
                                + orderItem.getQty());
            }
            long id = dao.save(orderItem);
            System.out.println("id generated: " + id);
        }
    }
    
    @Override
    @Transactional
    public void persistOrdersWithOutRollBack(List<OrderItem> orderItems) throws InvalidOrderItemException {
        for (OrderItem orderItem : orderItems) {
            if (orderItem.getQty() > 100) {
                throw new InvalidOrderItemException(
                        "Order quantity cannot be more than 100, found: "
                                + orderItem.getQty());
            }
            long id = dao.save(orderItem);
            System.out.println("id generated: " + id);
        }
    }
    
    @Override
    public List<OrderItem> getAllOrders() {
        return dao.loadAll();
    }
}