package com.jleon.bodega.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jleon.bodega.model.dto.ClienteRequestDto;
import com.jleon.bodega.model.dto.ClienteResponseDto;
import com.jleon.bodega.model.dto.ProductoRequestDto;
import com.jleon.bodega.model.dto.ProductoResponseDto;
import com.jleon.bodega.service.IProductoService;

@RestController
@RequestMapping("/api/producto")
public class ProductoController {
	
	@Autowired
	private IProductoService iProductoService;
	
	@GetMapping("/listar")
	public ResponseEntity<List<ProductoResponseDto>> listar(){
		
		return new ResponseEntity<List<ProductoResponseDto>>(iProductoService.listarProducto(),HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Void> guardar(@RequestBody ProductoRequestDto clienteRequestDto){
		
		iProductoService.guardarProducto(clienteRequestDto);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public @ResponseBody ResponseEntity<ProductoResponseDto> cursoPorId(@PathVariable Integer id){
		
		ProductoResponseDto productoResponseDto = iProductoService.productoById(id);
		if(productoResponseDto != null) {
			return new ResponseEntity<ProductoResponseDto>(productoResponseDto, HttpStatus.OK);
			
		}
		
		return new ResponseEntity<ProductoResponseDto>(HttpStatus.NOT_FOUND);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		
		ProductoResponseDto productoResponseDto = iProductoService.productoById(id);
		if(productoResponseDto != null) {
			iProductoService.eliminarProducto(id);
			
			return new ResponseEntity<Void>(HttpStatus.OK);
			
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		
	}
	
	@PutMapping
	public ResponseEntity<Void> editar (@RequestBody ProductoRequestDto productoRequestDto){
		
		ProductoResponseDto productoResponseDto = iProductoService.productoById(productoRequestDto.getIdProductoRequest());
		if(productoResponseDto != null) {
			iProductoService.editarProducto(productoRequestDto);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}

}
