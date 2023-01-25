package com.example.pawtiserie1.service;

import com.example.pawtiserie1.model.Cake;
import com.example.pawtiserie1.repository.CakeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CakeService {
    private CakeRepository cakeRepository;

    public CakeService(CakeRepository cakeRepository) {
        this.cakeRepository = cakeRepository;
    }

    public List<Cake> retrieveCakes() {
        return cakeRepository.findAll();
    }

    public Cake addProduct(Cake cake) {
        return cakeRepository.save(cake);
    }

    public Cake addCake(Cake cake) {
        return cakeRepository.save(cake);
    }
}
