package com.web.multiclient.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.web.multiclient.entity.Orders;


public interface OrderRepo extends JpaRepository<Orders,Long> {
	
	Orders findByOrderId(long orderId);

}
