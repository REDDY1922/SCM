package com.example.TMS.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.TMS.Models.Carrier;

public interface CarrierRepository extends JpaRepository<Carrier,Integer>{

	Carrier findByName(String name);

}
