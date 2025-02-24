package com.campospadilhaa.client.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

/*
 * classes: ValidationError e FieldMessage, criadas para formatar as mensagens emitidas pelas validações
 */

public class ValidationError extends CustomError {

	private List<FieldMessage> listaErros = new ArrayList<>();

	public ValidationError(Instant timestamp, Integer status, String error, String path) {
		super(timestamp, status, error, path);
	}

	public List<FieldMessage> getListaErros() {
		return listaErros;
	}

	public void addError(String fieldName, String message) {

		listaErros.add(new FieldMessage(fieldName, message));
	}
}