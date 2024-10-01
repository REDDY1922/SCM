package com.example.DMS.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.DMS.Models.Warehouse;
import com.example.DMS.Service.WarehouseService;

@RestController
@RequestMapping("/warehouse")
public class WarehouseController {
	@Autowired
	private WarehouseService warehouseService;
	
	@PostMapping("/add")
	public Warehouse createWarehouse(@RequestBody Warehouse warehouse) {
		return warehouseService.addWarehouse(warehouse);
	}
	@GetMapping("/all")
    public List<Warehouse> getAllWarehouses() {
        return warehouseService.getAllWarehouses();
    }

    @GetMapping("/{id}")
    public Warehouse getWarehouseById(@PathVariable int id) {
        return warehouseService.getWarehouseById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteWarehouse(@PathVariable int id) {
        warehouseService.deleteWarehouse(id);
    }
	
}
