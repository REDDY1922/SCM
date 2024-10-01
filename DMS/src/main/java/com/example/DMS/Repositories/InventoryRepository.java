package com.example.DMS.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.DMS.Models.Inventory;
import com.example.DMS.Models.Warehouse;

public interface InventoryRepository extends JpaRepository<Inventory, Integer>{

	List<Inventory> findByWarehouseId(int warehouseId);

	Inventory findByProductName(Object productName);

	
	void save(Warehouse inventory);

	Optional<Warehouse> findByProductNameAndWarehouse(String productName, Warehouse warehouse);

	

	

}
