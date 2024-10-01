package com.example.DMS.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class ProductReturn {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String orderId;
	private String productName;
	private String reason;
	private int quantity;
	@ManyToOne
	private Inventory inventory;
	@ManyToOne
	private Warehouse warehouse;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}

	public Inventory getInventory() {
		return inventory;
	}
	public void setInventory(Inventory inventory) {
		this.inventory = inventory;
	}
	
	public Warehouse getWarehouse() {
		return warehouse;
	}
	public void setWarehouse(Warehouse warehouse) {
		this.warehouse = warehouse;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "ProductReturn [id=" + id + ", orderId=" + orderId + ", productName=" + productName + ", reason="
				+ reason + ", quantity=" + quantity + ", inventory=" + inventory + ", warehouse=" + warehouse + "]";
	}
	public void setInventory(Warehouse inventory2) {
		// TODO Auto-generated method stub
		
	}
	
	
	
	
}
