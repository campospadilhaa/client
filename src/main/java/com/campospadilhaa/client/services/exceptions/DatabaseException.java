package com.campospadilhaa.client.services.exceptions;

// classe criada para controlar as exceções do sistema
public class DatabaseException extends RuntimeException {

	public DatabaseException(String mensagem) {

		super(mensagem);
	}
}