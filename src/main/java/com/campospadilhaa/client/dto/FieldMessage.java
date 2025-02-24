package com.campospadilhaa.client.dto;

/*
 * classes: ValidationError e FieldMessage, criadas para formatar as mensagens emitidas pelas validações
 */

public class FieldMessage {

	private String fieldName;
	private String message;

	public FieldMessage(String fieldName, String message) {

		this.fieldName = fieldName;
		this.message = message;
	}

	public String getFieldName() {
		return fieldName;
	}

	public String getMessage() {
		return message;
	}
}