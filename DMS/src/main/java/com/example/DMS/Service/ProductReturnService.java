package com.example.DMS.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.example.DMS.Models.ProductReturn;
import com.example.DMS.Models.Warehouse;
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
    private KafkaTemplate<String, ProductReturn> kafkaTemplate;

    private static final String RETURN_TOPIC = "return-events";

    // Other methods...

    public ProductReturn processReturn(String orderId, String productName, String reason, int quantity, int warehouseId) {
        Warehouse warehouse = warehouseRepository.findById(warehouseId)
                .orElseThrow(() -> new RuntimeException("Warehouse not found"));

        Warehouse inventory = inventoryRepository.findByProductNameAndWarehouse(productName, warehouse)
                .orElseThrow(() -> new RuntimeException("Product not found in the specified warehouse"));

        // Update inventory with the returned quantity
        inventory.setStockLevel(inventory.getStockLevel() + quantity);
        inventoryRepository.save(inventory);

        // Save the return details
        ProductReturn productReturn = new ProductReturn();
        productReturn.setOrderId(orderId);
        productReturn.setProductName(productName);
        productReturn.setReason(reason);
        productReturn.setQuantity(quantity);
        productReturn.setWarehouse(warehouse);
        productReturn.setInventory(inventory);

        // Send return data to Kafka
        kafkaTemplate.send(RETURN_TOPIC, productReturn);

        return productReturnRepository.save(productReturn);
    }



	public List<ProductReturn> getAllReturns() {
		// TODO Auto-generated method stub
		return productReturnRepository.findAll();
	}
	 @KafkaListener(topics = "return-events", groupId = "dms_group", containerFactory = "kafkaListenerContainerFactory")
	    public void consumeReturnEvent(Orders order) {
	        // Assuming the order includes information about returns
	        System.out.println("Received return event for order: " + order);
	        processReturn(order.getOrderId(), order.getProductName(), "Customer Return", order.getQuantity(), order.getWarehouseId());
	    }

	private void processReturn(Long orderId, Object productName, String reason, int quantity, int warehouseId) {
		// TODO Auto-generated method stub
		
	}

}
