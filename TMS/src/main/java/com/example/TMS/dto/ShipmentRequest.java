package com.example.TMS.dto;

public class ShipmentRequest {
	private String pickUpLocation;
    private String deliveryLocation;
    private String name;

    
    public String getPickUpLocation() { return pickUpLocation; }
    public void setPickUpLocation(String pickUpLocation) { this.pickUpLocation = pickUpLocation; }

    public String getDeliveryLocation() { return deliveryLocation; }
    public void setDeliveryLocation(String deliveryLocation) { this.deliveryLocation = deliveryLocation; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
}
