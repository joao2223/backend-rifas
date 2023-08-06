package com.sitederifas.rifas.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sitederifas.rifas.dto.OrderItemDTO;
import com.sitederifas.rifas.entities.Order;
import com.sitederifas.rifas.entities.OrderItem;
import com.sitederifas.rifas.entities.Raffle;
import com.sitederifas.rifas.services.OrderItemService;
import com.sitederifas.rifas.services.OrderService;
import com.sitederifas.rifas.services.RaffleService;

@RestController
@RequestMapping(value = "/order-items")
public class OrderItemResource {

	@Autowired
    private OrderService orderService;

    @Autowired
    private RaffleService raffleService;

    @Autowired
    private OrderItemService orderItemService;

    @GetMapping
    public ResponseEntity<List<OrderItem>> findAll() {
        List<OrderItem> orderItems = orderItemService.findAll();
        return ResponseEntity.ok().body(orderItems);
    }

    @PostMapping("/create")
    public ResponseEntity<OrderItem> createOrderItem(@RequestBody OrderItemDTO dto) {
        Order order = orderService.findById(dto.getOrderId());
        Raffle raffle = raffleService.findById(dto.getRaffleId());

        OrderItem newOrderItem = new OrderItem(order, raffle, dto.getQuantity(), raffle.getPrice());
        orderItemService.createOrderItem(newOrderItem);

        return ResponseEntity.ok().body(newOrderItem);
    }
}