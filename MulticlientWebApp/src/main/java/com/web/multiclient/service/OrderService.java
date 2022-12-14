package com.web.multiclient.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.web.multiclient.entity.Orders;

@Service
public interface OrderService {
	
    public Orders addOrder(Orders order);
	
	public Orders deleteOrder(long orderId);

	public Orders updateOrder(long orderId,Orders order);
	
	public Orders getOrderDetails(long orderId);
	
	public List<Orders> getAllOrders();

}
