package com.example.DMS.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.DMS.Models.Inventory;
import com.example.DMS.Models.Warehouse;

public interface InventoryRepository extends JpaRepository<Inventory, Integer>{

	List<Inventory> findByWarehouseId(int warehouseId);

	Inventory findByProductName(String product);

	

	
	
	
	
	

	
	

	

}
