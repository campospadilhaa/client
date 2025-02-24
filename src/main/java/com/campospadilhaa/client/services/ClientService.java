package com.campospadilhaa.client.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.campospadilhaa.client.dto.ClientDTO;
import com.campospadilhaa.client.entities.Client;
import com.campospadilhaa.client.repository.ClientRepository;
import com.campospadilhaa.client.services.exceptions.DatabaseException;
import com.campospadilhaa.client.services.exceptions.ResourceNotFoundException;

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

		// get( substituído pelo orElseThrow() para controlar exceção. Interceptando a exceção do Optional e lançando a minha exceção 'Client não encontrado'
		//Client client = optionalClient.get();
		Client client = optionalClient.orElseThrow(
				() -> new ResourceNotFoundException("Cliente inexistente"));

		ClientDTO clientDTO = new ClientDTO(client);

		return clientDTO;
	}

	@Transactional
	public ClientDTO insert(ClientDTO clientDTO) {

		try {

			Client client = new Client();

			client.setName(clientDTO.getName());
			client.setCpf(clientDTO.getCpf());
			client.setIncome(clientDTO.getIncome());
			client.setBirthDate(clientDTO.getBirthDate());
			client.setChildren(clientDTO.getChildren());

			client = clientRepository.save(client);

			return new ClientDTO(client);

		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Já existe um cliente com o CPF informado");
		}
	}
}