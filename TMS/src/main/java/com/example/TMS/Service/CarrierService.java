package com.example.TMS.Service;

import java.util.List;
import java.util.Optional;

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

		    public List<Carrier> getAllCarriers() {
		        return carrierRepository.findAll();
		    
}

			public Carrier findCarrierByName(String name) {
				// TODO Auto-generated method stub
				return carrierRepository.findByName(name);
			}

}