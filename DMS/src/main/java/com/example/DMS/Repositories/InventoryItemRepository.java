package com.example.DMS.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.DMS.Models.InventoryItem;

public interface InventoryItemRepository extends JpaRepository<InventoryItem, Integer>{

}
