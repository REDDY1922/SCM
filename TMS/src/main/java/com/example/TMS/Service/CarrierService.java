package com.example.TMS.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TMS.Models.Carrier;
import com.example.TMS.Repositories.CarrierRepository;

@Service
public class CarrierService {
	 @Autowired
	    private CarrierRepository carrierRepository;

	    public Carrier createCarrier(Carrier carrier) {
	        return carrierRepository.save(carrier);
	    }

	public Carrier findCarrierByName(String carrierName) {
		// Logic to find carrier by name
        return carrierRepository.findAll().stream()
                .filter(carrier -> carrier.getName().equalsIgnoreCase(carrierName))
                .findFirst()
                .orElse(null);

	}

	public List<Carrier> getAllCarriers() {
		// TODO Auto-generated method stub
		return carrierRepository.findAll();
	}

}
