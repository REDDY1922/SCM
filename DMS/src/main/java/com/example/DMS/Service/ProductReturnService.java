package com.example.DMS.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.DMS.Models.Inventory;
import com.example.DMS.Models.ProductReturn;
import com.example.DMS.Repositories.InventoryRepository;
import com.example.DMS.Repositories.ProductReturnRepository;
import com.example.DMS.Repositories.WarehouseRepository;
import com.example.OMS.Models.Orders;

@Service
public class ProductReturnService {
	@Autowired
	private ProductReturnRepository productReturnRepository;
	@Autowired
	private WarehouseRepository warehouseRepository;
	@Autowired
	private InventoryRepository inventoryRepository;
	@Autowired
	private final KafkaTemplate<String, ProductReturn> kafkaTemplate;

    private static final String RETURN_TOPIC = "return-events";

    @Autowired
    private InventoryService inventoryService;

    ProductReturnService(KafkaTemplate kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }	

	public ProductReturn processProductReturn(String orderId, String product, String reason, int quantity) {
		// TODO Auto-generated method stub
		// Step 1: Update inventory to add back the returned products
        inventoryService.updateStockLevel(product,quantity);

        // Step 2: Create a ProductReturnEvent
        ProductReturn returnEvent = new ProductReturn();

        // Step 3: Send the return event to Kafka
        kafkaTemplate.send(RETURN_TOPIC, returnEvent);

        // Step 4: Return the event for further processing or confirmation
        return returnEvent;
	}
	public List<ProductReturn> getAllReturns() {
		// TODO Auto-generated method stub
		return productReturnRepository.findAll();
	}

}
