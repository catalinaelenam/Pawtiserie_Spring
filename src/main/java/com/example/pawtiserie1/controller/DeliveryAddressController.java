package com.example.pawtiserie1.controller;


import com.example.pawtiserie1.model.DeliveryAddress;
import com.example.pawtiserie1.service.DeliveryAddressService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/deliveryaddress")
public class DeliveryAddressController {
    private final DeliveryAddressService deliveryAddressService;

    public DeliveryAddressController(DeliveryAddressService deliveryAddressService) {
        this.deliveryAddressService = deliveryAddressService;
    }
    @GetMapping
    public ResponseEntity<List<DeliveryAddress>> retrieveDeliveries(){
        return ResponseEntity.ok().body(deliveryAddressService.retrieveDeliveries());
    }
}
