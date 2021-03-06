package com.jleon.bodega.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jleon.bodega.model.Cliente;
import com.jleon.bodega.model.Producto;
import com.jleon.bodega.model.dto.ClienteResponseDto;
import com.jleon.bodega.model.dto.ProductoRequestDto;
import com.jleon.bodega.model.dto.ProductoResponseDto;
import com.jleon.bodega.repository.ProductoRepository;
import com.jleon.bodega.service.IProductoService;

@Service
public class ProductoServiceImpl implements IProductoService{
	
	@Autowired
	private ProductoRepository productoRepository;

	@Override
	public void guardarProducto(ProductoRequestDto productoDto) {
		
		Producto producto = new Producto();

		producto.setIdProducto(productoDto.getIdProductoRequest());
		producto.setProducto(productoDto.getProductoRequest());
		producto.setPrecio(productoDto.getPrecioRequest());
		producto.setStock(productoDto.getStockRequest());
		producto.setDescripcion(productoDto.getDescripcionRequest());

		productoRepository.save(producto);
		
	}

	@Override
	public void eliminarProducto(Integer id) {
		productoRepository.deleteById(id);
	}

	@Override
	public void editarProducto(ProductoRequestDto productoDto) {

		Producto producto = new Producto();
		producto.setIdProducto(productoDto.getIdProductoRequest());
		producto.setProducto(productoDto.getProductoRequest());
		producto.setPrecio(productoDto.getPrecioRequest());
		producto.setStock(productoDto.getStockRequest());
		producto.setDescripcion(productoDto.getDescripcionRequest());
		
		productoRepository.saveAndFlush(producto);
		
		
	}

	@Override
	public List<ProductoResponseDto> listarProducto() {
		
		List<Producto> listProductos = productoRepository.findAll();
		List<ProductoResponseDto> lisProductosDto = new ArrayList<>();
		ProductoResponseDto productoResponseDto = new ProductoResponseDto();
		
		for( Producto variable : listProductos ) {
			
			productoResponseDto.setIdProductoResponse(variable.getIdProducto());
			productoResponseDto.setProductoResponse(variable.getProducto());
			productoResponseDto.setPrecioResponse(variable.getPrecio());
			productoResponseDto.setStockResponse(variable.getStock());
			productoResponseDto.setDescripcionResponse(variable.getDescripcion());
			
			lisProductosDto.add(productoResponseDto);
			
			
			
		}
		return lisProductosDto;
	}

	@Override
	public ProductoResponseDto productoById(Integer id) {
		
		Producto producto = productoRepository.findById(id).orElse(null);
		ProductoResponseDto productoResponseDto =new ProductoResponseDto();
		
		productoResponseDto.setIdProductoResponse(producto.getIdProducto());
		productoResponseDto.setProductoResponse(producto.getProducto());
		productoResponseDto.setPrecioResponse(producto.getPrecio());
		productoResponseDto.setStockResponse(producto.getStock());
		productoResponseDto.setDescripcionResponse(producto.getDescripcion());
			
		
		return productoResponseDto;
	}
	


}
