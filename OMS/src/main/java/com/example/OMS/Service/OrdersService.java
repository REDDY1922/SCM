package com.example.OMS.Service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.OMS.Enums.OrderStatus;
import com.example.OMS.Models.Orders;
import com.example.OMS.Repository.OrdersRepository;
@Service
public class OrdersService {

	@Autowired
	private OrdersRepository ordersRepository;
	@Autowired
	private KafkaTemplate<String, Orders> kafkaTemplate;
	 // Declare a logger instance for the OrdersService class
    private static final Logger logger = LoggerFactory.getLogger(OrdersService.class);
    // Kafka topic name
    private static final String ORDER_TOPIC = "order-events";
	public Orders placeOrder(Orders orders) {
		orders.setStatus(OrderStatus.PENDING);
		Orders savedOrder=ordersRepository.save(orders);
		//send the orders details to kafka
		logger.info("sending order {} to kafka topic {}",savedOrder,ORDER_TOPIC);
		kafkaTemplate.send(ORDER_TOPIC,savedOrder);
		return savedOrder;
	}

}
