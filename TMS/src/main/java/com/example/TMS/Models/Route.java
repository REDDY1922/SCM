package com.example.TMS.Models;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Route {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int distance;
	private int duration;
	private String trafficCondition;
	private String estimatedArrivalTime;
	@ManyToOne
	private List<Shipment> shipments;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDistance() {
		return distance;
	}
	public void setDistance(int distance) {
		this.distance = distance;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public String getTrafficCondition() {
		return trafficCondition;
	}
	public void setTrafficCondition(String trafficCondition) {
		this.trafficCondition = trafficCondition;
	}
	public String getEstimatedArrivalTime() {
		return estimatedArrivalTime;
	}
	public void setEstimatedArrivalTime(String estimatedArrivalTime) {
		this.estimatedArrivalTime = estimatedArrivalTime;
	}
	public List<Shipment> getShipments() {
		return shipments;
	}
	public void setShipments(List<Shipment> shipments) {
		this.shipments = shipments;
	}
	@Override
	public String toString() {
		return "Route [id=" + id + ", distance=" + distance + ", duration=" + duration + ", trafficCondition="
				+ trafficCondition + ", estimatedArrivalTime=" + estimatedArrivalTime + ", shipments=" + shipments
				+ "]";
	}
	
	
}
