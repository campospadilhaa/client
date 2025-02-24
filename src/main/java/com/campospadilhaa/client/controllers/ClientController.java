package com.campospadilhaa.client.controllers;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.campospadilhaa.client.dto.ClientDTO;
import com.campospadilhaa.client.services.ClientService;

import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/clients")
public class ClientController {

	@Autowired
	private ClientService clientService;

	/* substituído pelo método abaixo mais completo, com a possibilidade de aplicar paginação
	@GetMapping
	public List<ClientDTO> findAll() {

		List<ClientDTO> listaClientDTO = clientService.findAll();

		return listaClientDTO;
	}/**/

	// http://localhost:8080/clients?size=5&page=0&sort=name,asc
	// size: quantidade de itens retornados por página
	// page: o número da página que deverá ser exibida
	// sort: ordenação + asc/desc
	@GetMapping
	public ResponseEntity<Page<ClientDTO>> findAll(Pageable pageable) { // parametro para gerar paginação

		Page<ClientDTO> listaClientDTO = clientService.findAll(pageable);

		return ResponseEntity.ok( listaClientDTO ); // ResponseEntity retorna o status 200
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<ClientDTO> findById(@PathVariable Long id) {

		ClientDTO clientDTO = clientService.findById(id);

		return ResponseEntity.ok( clientDTO ); // ResponseEntity retorna o status 200
	}

	@PostMapping
	public ResponseEntity<ClientDTO> insert(@Valid @RequestBody ClientDTO clientDTO) { // anotation '@Valid' considera as validações definidas no DTO

		clientDTO = clientService.insert(clientDTO);

		// a criação de uma URI faz com que no header do response conste a URL para a busca do Client
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(clientDTO.getId()).toUri();

		// ResponseEntity com 'created' retorna o status 201 (created)
		return ResponseEntity.created(uri).body(clientDTO);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<ClientDTO> update(@PathVariable Long id, @Valid @RequestBody ClientDTO clientDTO) {

		clientDTO = clientService.update(id, clientDTO);

		return ResponseEntity.ok( clientDTO ); // ResponseEntity retorna o status 200
	}
}