package com.example.TMS.Models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Carrier {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String ServieType;
	@ManyToOne
	private Shipment shipments;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getServieType() {
		return ServieType;
	}
	public void setServieType(String servieType) {
		ServieType = servieType;
	}
	
	public void setShipments(Shipment shipments) {
		this.shipments = shipments;
	}
	@Override
	public String toString() {
		return "Carrier [id=" + id + ", name=" + name + ", ServieType=" + ServieType + ", shipments=" + shipments + "]";
	}
	
}