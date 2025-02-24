package com.campospadilhaa.client.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.campospadilhaa.client.dto.ClientDTO;
import com.campospadilhaa.client.entities.Client;
import com.campospadilhaa.client.repository.ClientRepository;

@Service
public class ClientService {

	@Autowired
	private ClientRepository clientRepository;

	@Transactional(readOnly = true) // configuração para lock de somente leitura, a transanção fica mais rápida
	public List<ClientDTO> findAll() {

		// objeto Page que retorna paginação
		List<Client> listaClient = clientRepository.findAll();

		return listaClient.stream().map(item -> new ClientDTO(item)).toList();
	}
}