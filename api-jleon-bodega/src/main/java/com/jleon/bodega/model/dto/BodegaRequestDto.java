package com.jleon.bodega.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BodegaRequestDto {
	
	private Integer idBodegaRequest;
	private String nombreRequest;
	private String direccionRequest;

}
