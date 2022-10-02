package com.web.multiclient.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.web.multiclient.entity.Orders;
import com.web.multiclient.exceptions.OrderNotFoundException;
import com.web.multiclient.repo.OrderRepo;
import com.web.multiclient.service.OrderService;


@Service //These class files are used to write business logic in a different layer, separated from @RestController class file.

public class OrderServiceImpl implements OrderService {
	
private static final Logger log =LoggerFactory.getLogger(OrderService.class);
	
	//@Autowired annotation is used for dependency injection.In spring boot application, all loaded beans are eligible for auto wiring to another bean
	@Autowired
	OrderRepo orderRepo;
	

	
	@Override
	public Orders addOrder(Orders order) {
		log.info("Inside addOrder Service");
		orderRepo.save(order);
		return order;
	}

	@Override
	public Orders deleteOrder(long orderId) {
		log.info("Inside removeOrder Service");
		Orders o=orderRepo.findByOrderId(orderId);
		if(o==null) {
			throw new OrderNotFoundException("Order with Id "+orderId+" does not exist.");
		}
		orderRepo.delete(o);
		return o;
	}

	@Override
	public Orders updateOrder(long orderId,Orders order) {

		
        Optional<Orders> order2 = Optional.ofNullable(orderRepo.findByOrderId(orderId));
        if(order2.isPresent()) {
        	System.out.println(orderId);
        	Orders o=order2.get();
        	o.setProductName(order.getProductName());
        	o.setAmount(order.getAmount());
        	o.setBillDate(order.getBillDate());
        	o.setPaymentMethod(order.getPaymentMethod());
        	System.out.println(o);
        	orderRepo.save(o);
        }
               // .orElseThrow(() -> new ProductNotFoundException("Product with this id is not found"));
        
        return order;
	}

	@Override
	public Orders getOrderDetails(long orderId) {
		log.info("Inside getOrderDetails Service");
		Orders o1=orderRepo.findByOrderId(orderId);
		if(o1==null) {
			throw new OrderNotFoundException("Order with Id "+orderId+" does not exist.");
		}
		return o1;
	}

	@Override
	public List<Orders> getAllOrders() {
		//Log.info("Inside get detail");
		return orderRepo.findAll();
	}

}



