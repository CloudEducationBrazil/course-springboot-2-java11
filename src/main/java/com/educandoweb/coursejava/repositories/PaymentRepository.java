package com.educandoweb.coursejava.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.coursejava.entities.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {

}
