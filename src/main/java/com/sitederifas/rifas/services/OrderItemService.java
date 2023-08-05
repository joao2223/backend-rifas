package com.sitederifas.rifas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sitederifas.rifas.entities.OrderItem;
import com.sitederifas.rifas.repositories.OrderItemRepository;

@Service
public class OrderItemService {

	@Autowired
	private OrderItemRepository repository;

	public List<OrderItem> findAll(){
		return repository.findAll();
	} 

	public OrderItem findById(Long id) {
		Optional<OrderItem> obj = repository.findById(id);
		return obj.get();
	}
	
	public OrderItem insert(OrderItem obj) {
		return repository.save(obj);
	}
	
	public OrderItem updateQuantity(Long itemId, Integer newQuantity) {
        OrderItem item = repository.findById(itemId).orElseThrow(() -> new RuntimeException("OrderItem not found"));

        item.setQuantity(newQuantity);
        // Você pode adicionar aqui a lógica para regenerar os números aleatórios se necessário

        return repository.save(item);
    }
	
	 public OrderItem save(OrderItem orderItem) {
	        return repository.save(orderItem);
	    }
	 
	 public OrderItem createOrderItem(OrderItem orderItem) {
	        // Adicione as lógicas necessárias, como validações, antes de salvar
	        return repository.save(orderItem);
	    }
}
