package com.example.pawtiserie1.service;

import com.example.pawtiserie1.repository.DeliveryAddressRepository;
import com.example.pawtiserie1.model.History;

import com.example.pawtiserie1.repository.HistoryRepository;
import org.springframework.stereotype.Service;
import com.example.pawtiserie1.model.DeliveryAddress;

import java.util.List;

@Service
public class HistoryService {

    private  HistoryRepository historyRepository;
    private DeliveryAddressRepository deliveryRepository;


    public HistoryService(HistoryRepository historyRepository) {
        this.historyRepository = historyRepository;
    }

    public List<History> retrieveHistory() {
        return historyRepository.findAll();
    }

    public History saveNewHistory(History history, int deliveryId){
        DeliveryAddress delivery = deliveryRepository.findById(deliveryId)
                .orElseThrow(() -> new RuntimeException("Delivery not found!"));
        history.setDelivery(delivery);
        return historyRepository.save(history);
    }
    public void deleteHistoryById(int id) {
        historyRepository.deleteById(id);
    }
}