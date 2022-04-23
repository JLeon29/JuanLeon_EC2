package com.jleon.bodega.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductoRequestDto {
		
	private Integer idProductoRequest;
	private String productoRequest;
	private String descripcionRequest;
	private Double precioRequest;
	private Integer stockRequest;

}
