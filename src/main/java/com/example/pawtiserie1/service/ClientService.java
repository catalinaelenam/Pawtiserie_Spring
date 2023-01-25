package com.example.pawtiserie1.service;

import com.example.pawtiserie1.model.Client;
import com.example.pawtiserie1.repository.ClientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    private ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }

    public Client saveNewClient(Client client) {
        return clientRepository.save(client);
    }

    public List<Client> retrieveClients(){
        return clientRepository.findAll();
    }

}
