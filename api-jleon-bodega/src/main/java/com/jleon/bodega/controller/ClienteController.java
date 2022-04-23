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
import com.jleon.bodega.repository.ClienteRepository;
import com.jleon.bodega.service.IClienteService;

@RestController
@RequestMapping("/api/cliente")
public class ClienteController {
	
	@Autowired
	private IClienteService iClienteService;
	
	@GetMapping("/listar")
	public ResponseEntity<List<ClienteResponseDto>> listar(){
		
		return new ResponseEntity<List<ClienteResponseDto>>(iClienteService.listarCliente(),HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Void> guardar(@RequestBody ClienteRequestDto clienteRequestDto){
		
		iClienteService.guardarCliente(clienteRequestDto);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public @ResponseBody ResponseEntity<ClienteResponseDto> cursoPorId(@PathVariable Integer id){
		
		ClienteResponseDto curso = iClienteService.clienteById(id);
		if(curso != null) {
			return new ResponseEntity<ClienteResponseDto>(curso, HttpStatus.OK);
			
		}
		
		return new ResponseEntity<ClienteResponseDto>(HttpStatus.NOT_FOUND);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		
		ClienteResponseDto clienteResponseDto = iClienteService.clienteById(id);
		if(clienteResponseDto != null) {
			iClienteService.eliminarCliente(id);
			
			return new ResponseEntity<Void>(HttpStatus.OK);
			
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		
	}
	
	@PutMapping
	public ResponseEntity<Void> editar (@RequestBody ClienteRequestDto clienteRequestDto){
		
		ClienteResponseDto clienteResponseDto = iClienteService.clienteById(clienteRequestDto.getIdCliente());
		if(clienteResponseDto != null) {
			iClienteService.editarCliente(clienteRequestDto);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}

}
