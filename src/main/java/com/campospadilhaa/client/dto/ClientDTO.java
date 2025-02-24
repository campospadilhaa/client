package com.campospadilhaa.client.dto;

import java.time.LocalDate;

import com.campospadilhaa.client.entities.Client;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.PositiveOrZero;

public class ClientDTO {

	private Long id;

	@NotBlank(message = "Campo requerido")
	private String name;

	private String cpf;

	@PositiveOrZero(message = "O valor da renda deve ser positivo")
	private Double income;

	@PastOrPresent(message = "A Data de nascimento não pode ser uma data futura")
	private LocalDate birthDate;

	@PositiveOrZero(message = "O número de filhos deve ser maior ou igual a zero")
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