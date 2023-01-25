package com.example.pawtiserie1.repository;

import com.example.pawtiserie1.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
}
