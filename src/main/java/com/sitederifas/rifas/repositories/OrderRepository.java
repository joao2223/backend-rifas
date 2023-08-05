package com.sitederifas.rifas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sitederifas.rifas.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{

}
