package com.campospadilhaa.client.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

	@Transactional(readOnly = true) // configuração para lock de somente leitura, a transanção fica mais rápida
	public Page<ClientDTO> findAll(Pageable pageable) {

		// objeto Page que retorna paginação
		Page<Client> listaClient = clientRepository.findAll(pageable);

		return listaClient.map(item -> new ClientDTO(item));
	}

	@Transactional(readOnly = true) // configuração para lock de somente leitura, a transanção fica mais rápida
	public ClientDTO findById(Long id) {

		Optional<Client> optionalClient = clientRepository.findById(id);

		Client client = optionalClient.get();

		ClientDTO productDTO = new ClientDTO(client);

		return productDTO;
	}
}