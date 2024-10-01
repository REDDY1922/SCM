package com.example.DMS.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.DMS.Models.Inventory;
import com.example.DMS.Service.InventoryService;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
	@Autowired
    private InventoryService inventoryService;

    @PostMapping("/warehouse/{warehouseId}")
    public Inventory addInventory(@PathVariable int warehouseId, @RequestBody Inventory inventory) {
        return inventoryService.addInventoryToWarehouse(warehouseId, inventory);
    }

    @PutMapping("/{inventoryId}")
    public Inventory updateStockLevel(@PathVariable int inventoryId, @RequestParam int stockLevel) {
        return inventoryService.updateStockLevel(inventoryId, stockLevel);
    }

    @GetMapping("/warehouse/{warehouseId}")
    public List<Inventory> getInventoryByWarehouse(@PathVariable int warehouseId) {
        return inventoryService.getInventoryByWarehouse(warehouseId);
    }

    @GetMapping
    public List<Inventory> getAllInventory() {
        return inventoryService.getAllInventory();
    }
}
