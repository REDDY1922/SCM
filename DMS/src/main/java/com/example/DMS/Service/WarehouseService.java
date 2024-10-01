package com.example.DMS.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.DMS.Models.Warehouse;
import com.example.DMS.Repositories.WarehouseRepository;

@Service
public class WarehouseService {
	@Autowired
    private WarehouseRepository warehouseRepository;

    // Add a new warehouse
    public Warehouse addWarehouse(Warehouse warehouse) {
        return warehouseRepository.save(warehouse);
    }

    // Get all warehouses
    public List<Warehouse> getAllWarehouses() {
        return warehouseRepository.findAll();
    }

    // Get warehouse by ID
    public Warehouse getWarehouseById(int id) {
        return warehouseRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Warehouse not found"));
    }

    // Delete warehouse
    public void deleteWarehouse(int id) {
        warehouseRepository.deleteById(id);
    }

	
}
