package com.example.TMS.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.TMS.Models.Shipment;

public interface ShipmentRepository extends JpaRepository<Shipment, Integer>{

}
