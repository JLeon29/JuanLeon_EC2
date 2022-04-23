package com.jleon.bodega.model.dto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter

public class ClienteRequestDto {
	
	
	private Integer idCliente;
	private String nombre;
	private String dirección;
	private String dni;

}
