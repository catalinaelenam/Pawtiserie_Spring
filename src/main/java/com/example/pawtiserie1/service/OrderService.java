package com.example.pawtiserie1.service;

import com.example.pawtiserie1.model.Order;
import com.example.pawtiserie1.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    private OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Order saveNewOrder(Order order) {
        return orderRepository.save(order);
    }

    public List<Order> retrieveOrders(){
        return orderRepository.findAll();
    }

    public void deleteById(int id) {
        orderRepository.deleteById(id);
    }
}
