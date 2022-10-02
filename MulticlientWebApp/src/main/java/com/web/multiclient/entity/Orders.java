package com.web.multiclient.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Orders {
	@Id//@Id annotation specifies the primary key of an entity
	//The @GeneratedValue annotation is to configure the way of increment of the specified column(field).
	
	@Column
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long orderId;
	
	@Column
	private String productName;
	
	@Column 
	private double amount;
	
	@Column
	private LocalDate billDate;
	

	@Column
	private String paymentMethod;

	


    public Orders() {
    	
    }


	public Orders(long i, String string, double d, String string1, String string2) {
		
	}





	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public long getOrderId() {
		return orderId;
	}


	public void setOrderId(long orderId) {
		this.orderId = orderId;
	}


	public double getAmount() {
		return amount;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	public LocalDate getBillDate() {
		return billDate;
	}


	public void setBillDate(LocalDate billDate) {
		this.billDate = billDate;
	}


	


	public String getPaymentMethod() {
		return paymentMethod;
	}


	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	
	





	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ",productName=" + productName + " amount=" + amount + ", billDate=" + billDate + ", paymentMethod="
				+ paymentMethod +  "]";
	}



	
    
	
	
	                                                                    
}


	


