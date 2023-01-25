package com.example.pawtiserie1.controller;

import com.example.pawtiserie1.model.Cake;
import com.example.pawtiserie1.service.CakeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cake")
public class CakeController {
    private final CakeService cakeService;


    public CakeController(CakeService cakeService) {
        this.cakeService = cakeService;
    }

    @GetMapping
    public ResponseEntity<List<Cake>> retrieveCakes(){
        return ResponseEntity.ok().body(cakeService.retrieveCakes());
    }

    @PostMapping("/add")
    private ResponseEntity<Cake> addCake(@RequestBody Cake cake) {
        return ResponseEntity.ok().body(cakeService.addCake(cake));
    }
}
