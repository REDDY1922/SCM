package com.example.OMS.Models;

import com.example.OMS.Enums.OrderStatus;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String product;
	private int Quantity;
	private String CustomerName;
	@Enumerated(EnumType.STRING)
	private OrderStatus status;
	private String pickupLocation;
	private String deliveryLocation;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProduct() {
		return product;
	}
	public void setProduct(String product) {
		this.product = product;
	}
	public int getQuantity() {
		return Quantity;
	}
	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
	public String getCustomerName() {
		return CustomerName;
	}
	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}
	public OrderStatus getStatus() {
		return status;
	}
	public void setStatus(OrderStatus status) {
		this.status = status;
	}
	public String getPickupLocation() {
		return pickupLocation;
	}
	public void setPickupLocation(String pickupLocation) {
		this.pickupLocation = pickupLocation;
	}
	public String getDeliveryLocation() {
		return deliveryLocation;
	}
	public void setDeliveryLocation(String deliveryLocation) {
		this.deliveryLocation = deliveryLocation;
	}
	@Override
	public String toString() {
		return "Orders [id=" + id + ", product=" + product + ", Quantity=" + Quantity + ", CustomerName=" + CustomerName
				+ ", status=" + status + ", pickupLocation=" + pickupLocation + ", deliveryLocation=" + deliveryLocation
				+ "]";
	}
	public Object getProductName() {
		// TODO Auto-generated method stub
		return product;
	}
	public Long getOrderId() {
		// TODO Auto-generated method stub
		return id;
	}
	public int getWarehouseId() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
	
	
}
