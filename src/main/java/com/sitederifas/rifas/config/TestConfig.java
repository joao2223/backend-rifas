package com.sitederifas.rifas.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.sitederifas.rifas.entities.Order;
import com.sitederifas.rifas.entities.OrderItem;
import com.sitederifas.rifas.entities.Raffle;
import com.sitederifas.rifas.entities.User;
import com.sitederifas.rifas.entities.enums.RaffleStatus;
import com.sitederifas.rifas.repositories.OrderItemRepository;
import com.sitederifas.rifas.repositories.OrderRepository;
import com.sitederifas.rifas.repositories.RaffleRepository;
import com.sitederifas.rifas.repositories.UserRepository;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner{

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private RaffleRepository raffleRepository;
	
	@Autowired
	private OrderItemRepository orderItemRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		Raffle r1 = new Raffle(null, 100000, "raffle1", "raffle", 10.50, "", RaffleStatus.OPEN);
		Raffle r2 = new Raffle(null, 100, "raffle2", "raffle", 10.50, "", RaffleStatus.OPEN);
		Raffle r3 = new Raffle(null, 100, "raffle3", "raffle", 10.50, "", RaffleStatus.OPEN);
		Raffle r4 = new Raffle(null, 50, "raffle4", "raffle", 10.50, "", RaffleStatus.OPEN);
		
		raffleRepository.saveAll(Arrays.asList(r1, r2, r3, r4));
		
		User u1 = new User(null, "Maria", "999999", "");
		User u2 = new User(null, "Jerry", "888888", "");
		
		Order o1 = new Order(null, u1);
		Order o2 = new Order(null, u2);
		Order o3 = new Order(null, u1);
		
		userRepository.saveAll(Arrays.asList(u1,u2));
		orderRepository.saveAll(Arrays.asList(o1, o2, o3));
		
		OrderItem oi1 = new OrderItem(o1, r1, 2, r1.getPrice());
		OrderItem oi2 = new OrderItem(o1, r2, 1, r3.getPrice());
		OrderItem oi3 = new OrderItem(o2, r2, 2, r1.getPrice());
		OrderItem oi4 = new OrderItem(o2, r4, 1, r3.getPrice());

		orderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));
	}

	
}
