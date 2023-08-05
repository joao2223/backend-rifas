package com.sitederifas.rifas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sitederifas.rifas.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{

}
