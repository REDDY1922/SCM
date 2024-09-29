package com.example.OMS.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.OMS.Models.Orders;

public interface OrdersRepository extends JpaRepository<Orders, Long>{

}
