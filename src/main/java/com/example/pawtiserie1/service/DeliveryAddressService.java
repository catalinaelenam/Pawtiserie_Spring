package com.example.pawtiserie1.service;

import com.example.pawtiserie1.model.DeliveryAddress;
import com.example.pawtiserie1.repository.DeliveryAddressRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeliveryAddressService {
    private DeliveryAddressRepository deliveryAddressRepository;

    public DeliveryAddressService(DeliveryAddressRepository deliveryAddressRepository) {
        this.deliveryAddressRepository = deliveryAddressRepository;
    }
    public List<DeliveryAddress> retrieveDeliveries(){
        return deliveryAddressRepository.findAll();
    }
}
