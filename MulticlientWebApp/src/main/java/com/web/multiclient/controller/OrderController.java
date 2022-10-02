package com.web.multiclient.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.web.multiclient.entity.Orders;
import com.web.multiclient.service.OrderService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value="/api")
public class OrderController {
	
	
	private static final Logger log =LoggerFactory.getLogger(OrderService.class);
	
	@Autowired
	private OrderService orderService;
	
	
	@PostMapping("/add")
	public ResponseEntity<?> add(@Valid @RequestBody Orders order) {
		log.info("Order Service Impl addOrder :{}");
		Orders or1=orderService.addOrder(order);
		return new ResponseEntity<Orders>(or1 , HttpStatus.CREATED);
		
	}
	
	@GetMapping("/{orderId}")
	public ResponseEntity<?> getOrderById(@PathVariable("orderId") long orderId){
		Orders or2=	orderService.getOrderDetails(orderId);
		return new ResponseEntity<Orders>(or2,HttpStatus.OK);
	}
	
	@GetMapping("/get")
	public List<Orders> getDetails(){
		log.info("Entering into OrderService");
		return orderService.getAllOrders();
	}
	
	@PutMapping("/{orderId}")
	public ResponseEntity<?> update(@PathVariable("orderId") long orderId ,@RequestBody Orders order) {
		Orders or2=orderService.updateOrder(orderId, order);
		System.out.println(order+","+orderId);
		return new ResponseEntity<Orders>(or2,HttpStatus.CREATED);
		
	}
	
	@DeleteMapping("/{orderId}")
	public ResponseEntity<?> delete(@PathVariable("orderId") long orderId) {
		log.info("User service impl deleteOrder : {}",orderId);
		orderService.deleteOrder(orderId);
		return new ResponseEntity<String>("Order with ID: "+orderId+" deleted successfully",HttpStatus.OK);
	}
	

	
	
}


