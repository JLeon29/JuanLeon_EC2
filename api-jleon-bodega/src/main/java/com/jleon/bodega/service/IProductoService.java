package com.jleon.bodega.service;

import java.util.List;

import com.jleon.bodega.model.dto.ClienteRequestDto;
import com.jleon.bodega.model.dto.ClienteResponseDto;
import com.jleon.bodega.model.dto.ProductoRequestDto;
import com.jleon.bodega.model.dto.ProductoResponseDto;

public interface IProductoService {
	
	void guardarProducto(ProductoRequestDto productoDto);
	void eliminarProducto(Integer id);
	void editarProducto(ProductoRequestDto productoDto);
	List<ProductoResponseDto> listarProducto();
	ProductoResponseDto productoById(Integer id);
	

}
