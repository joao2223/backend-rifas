package com.sitederifas.rifas.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.sitederifas.rifas.dto.OrderDTO;
import com.sitederifas.rifas.entities.Order;
import com.sitederifas.rifas.entities.OrderItem;
import com.sitederifas.rifas.entities.Raffle;
import com.sitederifas.rifas.services.OrderService;

@RestController
@RequestMapping(value = "/orders")
public class OrderResource {

	@Autowired
	private OrderService service;

	@GetMapping
	public ResponseEntity<List<Order>> findAll(){
		List<Order> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Order> findById(@PathVariable Long id) {
		 Order obj = service.findById(id);

		    for (OrderItem item : obj.getItems()) {
		        Raffle raffle = item.getRaffle(); // Obtém a instância de Raffle associada ao OrderItem
		        Integer quantity = item.getQuantity();
		        raffle.generateRandomNumbers(quantity); // Gera os números aleatórios para o Raffle associado ao OrderItem
		    }

		    return ResponseEntity.ok().body(obj);
	}
	
	 @PostMapping
	    public ResponseEntity<Order> createOrder(@RequestBody OrderDTO orderDTO) {
	        Order newOrder = service.createOrder(orderDTO);

	        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
	                .buildAndExpand(newOrder.getId()).toUri();

	        return ResponseEntity.created(uri).body(newOrder);
	    }
}
