package com.sitederifas.rifas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sitederifas.rifas.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long>{

}
