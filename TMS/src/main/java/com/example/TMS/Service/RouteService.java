package com.example.TMS.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TMS.Models.Route;
import com.example.TMS.Repositories.RouteRepository;

@Service
public class RouteService {
	@Autowired
	private RouteRepository routeRepository;

	public Route optimizeRoute(String pickupLocation, String deliveryLocation) {
		// TODO Auto-generated method stub
		 Route route = new Route();
	        route.setStartLocation(pickupLocation);
	        route.setEndLocation(deliveryLocation);
	        route.setDistance(10.0); // Placeholder for actual distance calculation
	        return route;
	}

}
