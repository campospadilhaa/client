package com.campospadilhaa.client.dto;

import java.time.LocalDate;

import com.campospadilhaa.client.entities.Client;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;

public class ClientDTO {

	private Long id;

	@NotBlank(message = "Campo requerido")
	private String name;

	private String cpf;

	@Positive(message = "O preço deve ser positivo")
	private Double income;

	@PastOrPresent
	private LocalDate birthDate;

	private Integer children;

	public ClientDTO() {

	}

	public ClientDTO(Client client) {

		this.id = client.getId();
		this.name = client.getName();
		this.cpf = client.getCpf();
		this.income = client.getIncome();
		this.birthDate = client.getBirthDate();
		this.children = client.getChildren();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getCpf() {
		return cpf;
	}

	public Double getIncome() {
		return income;
	}

	public LocalDate getBirthDate() {
		return birthDate;
	}

	public Integer getChildren() {
		return children;
	}
}