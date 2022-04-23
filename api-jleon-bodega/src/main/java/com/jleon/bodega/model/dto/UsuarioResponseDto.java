package com.jleon.bodega.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class UsuarioResponseDto {
	
	private String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public UsuarioResponseDto(String token) {
		super();
		this.token = token;
	}

	public UsuarioResponseDto() {
		super();
	}
	
	

}
