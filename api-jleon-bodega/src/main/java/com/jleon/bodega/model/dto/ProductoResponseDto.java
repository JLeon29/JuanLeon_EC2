package com.jleon.bodega.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductoResponseDto {
	
	private Integer idProductoResponse;
	private String productoResponse;
	private String descripcionResponse;
	private Double precioResponse;
	private Integer stockResponse;

}
