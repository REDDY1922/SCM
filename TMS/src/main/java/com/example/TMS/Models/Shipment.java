package com.example.TMS.Models;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;


@Entity
public class Shipment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String orderId;
	private String pickUpLocation;
	private String deliveryLocation;
	private String status;//used for tracking delivery status
	private double distance;//for billing purpose
	@ManyToOne
	private Route route;
	@ManyToOne
	private Carrier carrier;
	
	
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
	
	public String getPickUpLocation() {
		return pickUpLocation;
	}
	public void setPickUpLocation(String pickUpLocation) {
		this.pickUpLocation = pickUpLocation;
	}
	public String getDeliveryLocation() {
		return deliveryLocation;
	}
	public void setDeliveryLocation(String deliveryLocation) {
		this.deliveryLocation = deliveryLocation;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Route getRoute() {
		return route;
	}
	public void setRoute(Route route) {
		this.route = route;
	}
	public Carrier getCarrier() {
		return carrier;
	}
	public void setCarrier(Carrier carrier) {
		this.carrier = carrier;
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	@Override
	public String toString() {
		return "Shipment [id=" + id + ", orderId=" + orderId + ", pickUpLocation=" + pickUpLocation
				+ ", deliveryLocation=" + deliveryLocation + ", status=" + status + ", distance=" + distance
				+ ", route=" + route + ", carrier=" + carrier + "]";
	}
	
	

}
