package com.campospadilhaa.client.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.campospadilhaa.client.entities.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

}