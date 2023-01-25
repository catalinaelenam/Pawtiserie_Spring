package com.example.pawtiserie1.repository;

import com.example.pawtiserie1.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
