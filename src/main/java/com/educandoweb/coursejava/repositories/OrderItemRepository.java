package com.educandoweb.coursejava.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.coursejava.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
