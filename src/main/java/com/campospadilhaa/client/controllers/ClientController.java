package com.campospadilhaa.client.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

	@GetMapping
	public List<ClientDTO> findAll() {

		List<ClientDTO> listaClientDTO = clientService.findAll();

		return listaClientDTO;
	}
}