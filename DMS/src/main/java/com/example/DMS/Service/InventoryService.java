package com.example.DMS.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.example.DMS.Models.Inventory;
import com.example.DMS.Models.Warehouse;
import com.example.DMS.Repositories.InventoryRepository;
import com.example.DMS.Repositories.WarehouseRepository;
import com.example.OMS.Models.Orders;

@Service
public class InventoryService {

	 @Autowired
	    private InventoryRepository inventoryRepository;
	    @Autowired
	    private WarehouseRepository warehouseRepository;

	   
	    // Add inventory to a specific warehouse
	    public Inventory addInventoryToWarehouse(int warehouseId, Inventory inventory) {
	        Warehouse warehouse = warehouseRepository.findById(warehouseId)
	            .orElseThrow(() -> new RuntimeException("Warehouse not found"));
	        inventory.setWarehouse(warehouse);
	        return inventoryRepository.save(inventory);
	    }

	    // Update stock level
	    public Inventory updateStockLevel1(String product, int stockLevel) {
	        Inventory inventory = inventoryRepository.findById(stockLevel)
	            .orElseThrow(() -> new RuntimeException("Inventory not found"));
	        inventory.setStockLevel(stockLevel);
	        return inventoryRepository.save(inventory);
	    }

	    // Get inventory by warehouse
	    public List<Inventory> getInventoryByWarehouse(int warehouseId) {
	        return inventoryRepository.findByWarehouseId(warehouseId);
	    }

	    // Get all inventory items
	    public List<Inventory> getAllInventory() {
	        return inventoryRepository.findAll();
	    }
	    
	    @KafkaListener(topics = "order-events", groupId = "dms_group", containerFactory = "kafkaListenerContainerFactory")
	    public void consumeOrderEvent(Orders order) {
	        System.out.println("Received Order: " + order);
	        Inventory inventory = inventoryRepository.findByProductName(order.getProduct());
	        if (inventory != null && inventory.getStockLevel() > 0) {
	            inventory.setStockLevel(inventory.getStockLevel() - order.getQuantity());
	            inventoryRepository.save(inventory);
	        }
	    }
		
		public void updateStockLevel(String product, int quantity) {
			// TODO Auto-generated method stub
			
		}
		public Inventory updateStockLevel(int inventoryId, int stockLevel) {
			// TODO Auto-generated method stubS
			return null;
		}
		

}
