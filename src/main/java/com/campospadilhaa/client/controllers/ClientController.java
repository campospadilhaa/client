package com.campospadilhaa.client.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.campospadilhaa.client.dto.ClientDTO;
import com.campospadilhaa.client.services.ClientService;

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
}