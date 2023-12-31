package com.sitederifas.rifas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sitederifas.rifas.dto.OrderDTO;
import com.sitederifas.rifas.entities.Order;
import com.sitederifas.rifas.entities.User;
import com.sitederifas.rifas.repositories.OrderRepository;
import com.sitederifas.rifas.repositories.UserRepository;
import com.sitederifas.rifas.services.exceptions.ResourceNotFoundException;

@Service
public class OrderService {

	@Autowired
	private OrderRepository repository;
	
	 @Autowired
	private UserRepository userRepository;

	public List<Order> findAll(){
		return repository.findAll();
	} 

	public Order findById(Long id) {
		Optional<Order> obj = repository.findById(id);
		return obj.get();
	}

	public Order createOrder(OrderDTO orderDTO) {
        User client = userRepository.findById(orderDTO.getClientId())
                .orElseThrow(() -> new ResourceNotFoundException(orderDTO.getClientId()));

        Order newOrder = new Order();
        newOrder.setClient(client);

        return repository.save(newOrder);
    }
}
