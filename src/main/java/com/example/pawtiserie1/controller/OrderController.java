package com.example.pawtiserie1.controller;

import com.example.pawtiserie1.model.Order;
import com.example.pawtiserie1.service.OrderService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comanda")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public ResponseEntity<List<Order>> retrieveStones(){
        return ResponseEntity.ok().body(orderService.retrieveOrders());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable int id){
        orderService.deleteById(id);
        return ResponseEntity.ok().body("Order with id " + id + " was deleted successfully :D");
    }
}
