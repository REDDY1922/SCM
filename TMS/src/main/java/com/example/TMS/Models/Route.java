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
	private double distance;
	private String startLocation;
    private String endLocation;
	@ManyToOne
	private Shipment shipments;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public double getDistance() {
		return distance;
	}
	public void setDistance(double distance) {
		this.distance = distance;
	}
	public String getStartLocation() {
		return startLocation;
	}
	public void setStartLocation(String startLocation) {
		this.startLocation = startLocation;
	}
	public String getEndLocation() {
		return endLocation;
	}
	public void setEndLocation(String endLocation) {
		this.endLocation = endLocation;
	}

	public Shipment getShipments() {
		return shipments;
	}
	public void setShipments(Shipment shipments) {
		this.shipments = shipments;
	}
	@Override
	public String toString() {
		return "Route [id=" + id + ", distance=" + distance + ", startLocation=" + startLocation + ", endLocation="
				+ endLocation + ", shipments=" + shipments + "]";
	}
	
}