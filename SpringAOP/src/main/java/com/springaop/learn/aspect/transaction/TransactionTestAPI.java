package com.springaop.learn.aspect.transaction;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.springaop.learn.aspect.AppConfig;

public class TransactionTestAPI {
	 public static void main(String[] args) {
	        AnnotationConfigApplicationContext context =
	                new AnnotationConfigApplicationContext(AppConfig.class);
	        OrderItemClientBean orderItemClientBean = context.getBean(OrderItemClientBean.class);
	        orderItemClientBean.persistOrderItems();
	        context.close();
	    }
}
