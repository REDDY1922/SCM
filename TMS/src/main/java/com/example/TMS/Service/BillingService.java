package com.example.TMS.Service;

import org.springframework.stereotype.Service;

@Service
public class BillingService {

	public double calculateFreightCost(double distance) {
		// TODO Auto-generated method stub
		return distance * 1.5;
	}

	public void processPayment(double freightCost) {
		// TODO Auto-generated method stub
		 System.out.println("Payment of $" + freightCost + " processed successfully.");
	}

}
