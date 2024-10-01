package com.example.DMS.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.DMS.Models.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Integer>{

}
