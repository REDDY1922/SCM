package com.example.TMS.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.OMS.Models.Orders;
import com.example.TMS.Models.Carrier;
import com.example.TMS.Models.Route;
import com.example.TMS.Models.Shipment;
import com.example.TMS.Service.BillingService;
import com.example.TMS.Service.CarrierService;
import com.example.TMS.Service.RouteService;
import com.example.TMS.Service.ShipmentService;
import com.example.TMS.dto.ShipmentRequest;

@RestController
@RequestMapping("/tms")
public class TMSController {
	@Autowired
	private ShipmentService shipmentService;
	@Autowired
	private RouteService routeService;
	@Autowired
	private CarrierService carrierService;
	@Autowired
	private BillingService billingService;
//	@Autowired
//	private KafkaTemplate<String, Shipment> kafkaTemplate;
//
//	private static final String SHIPMENT_TOPIC = "shipment-events";

//	@PostMapping("/shipments")
//	public Shipment createShipment(@RequestParam(required = false) String pickUpLocation, @RequestParam(required = false) String deliveryLocation,
//			@RequestParam(required = false) String name) {
//		// optimizing the route
//		Route optimizedRoute = routeService.optimizeRoute(pickUpLocation, deliveryLocation);
//		// Assign Carrier
//		Carrier carrier = carrierService.findCarrierByName(name);
//		if (carrier == null) {
//			throw new RuntimeException("carrier Not Found");
//		}
//		// billing calculation
//		double freightCost = billingService.calculateFreightCost(optimizedRoute.getDistance());
//		// process payment
//		billingService.processPayment(freightCost);
//		// create shipment
//		Shipment shipment = new Shipment();
//		shipment.setPickUpLocation(pickUpLocation);
//		shipment.setDeliveryLocation(deliveryLocation);
//		shipment.setCarrier(carrier);
//		shipment.setDistance(optimizedRoute.getDistance());
//		shipment.setRoute(optimizedRoute);
//		// save shipment to database
//		Shipment savedShipment = shipmentService.createShipments(shipment);
//		// send shipment data to kafkaTopic
//		kafkaTemplate.send(SHIPMENT_TOPIC, savedShipment);
//
//		return savedShipment;
//	}
//	@PostMapping("/shipments")
//	public Shipment createShipment(
//	        @RequestParam(required = false) String pickUpLocation,
//	        @RequestParam(required = false) String deliveryLocation,
//	        @RequestParam(required = false) String name) {
//	    
//	    // Log the received parameters
//	    System.out.println("Received pickUpLocation: " + pickUpLocation);
//	    System.out.println("Received deliveryLocation: " + deliveryLocation);
//	    System.out.println("Received carrierName: " + name);
//
//	    // Validate parameters
//	    if (pickUpLocation == null || deliveryLocation == null || name == null) {
//	        throw new IllegalArgumentException("Missing required parameters");
//	    }
//
//	    // Optimizing the route
//	    Route optimizedRoute = routeService.optimizeRoute(pickUpLocation, deliveryLocation);
//
//	    // Assign Carrier
//	    Carrier carrier = carrierService.findCarrierByName(name);
//	    if (carrier == null) {
//	        throw new RuntimeException("Carrier Not Found");
//	    }
//
//	    // Billing calculation
//	    double freightCost = billingService.calculateFreightCost(optimizedRoute.getDistance());
//
//	    // Process payment
//	    billingService.processPayment(freightCost);
//
//	    // Create shipment
//	    Shipment shipment = new Shipment();
//	    shipment.setPickUpLocation(pickUpLocation);
//	    shipment.setDeliveryLocation(deliveryLocation);
//	    shipment.setCarrier(carrier);
//	    shipment.setDistance(optimizedRoute.getDistance());
//	    shipment.setRoute(optimizedRoute);
//
//	    // Save shipment to database
//	    Shipment savedShipment = shipmentService.createShipments(shipment);
//
//	    // Send shipment data to Kafka
//	    kafkaTemplate.send(SHIPMENT_TOPIC, savedShipment);
//
//	    return savedShipment;
//	}
//
	
	    @PostMapping("/shipments")
	    public Shipment createShipment(@RequestBody ShipmentRequest shipmentRequest) {
	        
	        // Log the received parameters
	        System.out.println("Received pickUpLocation: " + shipmentRequest.getPickUpLocation());
	        System.out.println("Received deliveryLocation: " + shipmentRequest.getDeliveryLocation());
	        System.out.println("Received carrierName: " + shipmentRequest.getName());

	        // Optimizing the route
	        Route optimizedRoute = routeService.optimizeRoute(shipmentRequest.getPickUpLocation(), shipmentRequest.getDeliveryLocation());
	        Route savedRoute = routeService.saveRoute(optimizedRoute);

	        // Assign Carrier
	        Carrier carrier = carrierService.findCarrierByName(shipmentRequest.getName());
	        if (carrier == null) {
	            throw new RuntimeException("Carrier Not Found");
	        }

	        // Billing calculation
	        double freightCost = billingService.calculateFreightCost(optimizedRoute.getDistance());

	        // Process payment
	        billingService.processPayment(freightCost);

	        // Create shipment
	        Shipment shipment = new Shipment();
	        shipment.setPickUpLocation(shipmentRequest.getPickUpLocation());
	        shipment.setDeliveryLocation(shipmentRequest.getDeliveryLocation());
	        shipment.setCarrier(carrier);
	        shipment.setDistance(optimizedRoute.getDistance());
	        shipment.setRoute(optimizedRoute);

	        // Save shipment to database
	        Shipment savedShipment = shipmentService.createShipments(shipment);

//	        // Send shipment data to Kafka
//	        kafkaTemplate.send(SHIPMENT_TOPIC, savedShipment);

	        return savedShipment;
	    }
	

	// Listen to orders received from OMS
	@KafkaListener(topics = "order-events", groupId = "tms_group")
	public void listenToOmsOrders(Orders orders) {
		System.out.println("orders receivedd from OMS:" + orders.getId());
	}

	@PostMapping("/carriers")
	public Carrier createCarrier(@RequestBody Carrier carrier) {
		return carrierService.createCarrier(carrier); // Create a new carrier
	}

	@GetMapping("/carriers")
	public List<Carrier> getAllCarriers() {
		return carrierService.getAllCarriers(); // Get all carriers
	}

}
