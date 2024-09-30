package com.example.TMS.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TMS.Models.Shipment;
import com.example.TMS.Repositories.ShipmentRepository;

@Service
public class ShipmentService {
	 @Autowired
	    private ShipmentRepository shipmentRepository;
	

	public Shipment createShipments(Shipment shipment) {
		// TODO Auto-generated method stub
		return shipmentRepository.save(shipment);
	}

}
