package com.example.pawtiserie1.controller;


import com.example.pawtiserie1.model.Client;
import com.example.pawtiserie1.service.ClientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {
    private final ClientService clientService;

    public ClientController(ClientService clientService){

        this.clientService = clientService;
    }

    @PostMapping("/register")
    public ResponseEntity<Client> saveClient(@RequestBody Client client){
        return ResponseEntity.ok().body(clientService.saveNewClient(client));
    }
    @GetMapping
    public ResponseEntity<List<Client>> retrieveClients(){
        return ResponseEntity.ok().body(clientService.retrieveClients());
    }
}
