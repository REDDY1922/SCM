package com.example.OMS.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.OMS.Models.Orders;
import com.example.OMS.Service.OrdersService;

@RestController
@RequestMapping("/api/orders")
public class OrdersController {
	@Autowired
	private OrdersService ordersService;
	@PostMapping
	public ResponseEntity<Orders> placeOrder(@RequestBody Orders orders) 
	{
		Orders createdOrder=ordersService.placeOrder(orders);
		return new ResponseEntity<>(createdOrder,HttpStatus.CREATED);
	}
}
