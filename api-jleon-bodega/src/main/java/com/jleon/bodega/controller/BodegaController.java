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

import com.jleon.bodega.model.dto.BodegaRequestDto;
import com.jleon.bodega.model.dto.BodegaResponseDto;
import com.jleon.bodega.model.dto.ClienteRequestDto;
import com.jleon.bodega.model.dto.ClienteResponseDto;
import com.jleon.bodega.service.IBodegaService;

@RestController
@RequestMapping("/api/bodega")
public class BodegaController {
	
	
	@Autowired
	private IBodegaService iBodegaService;
	
	@GetMapping("/listar")
	public ResponseEntity<List<BodegaResponseDto>> listar(){
		
		return new ResponseEntity<List<BodegaResponseDto>>(iBodegaService.listarBodega(),HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<Void> guardar(@RequestBody BodegaRequestDto bodegaRequestDto){
		
		iBodegaService.guardarBodega(bodegaRequestDto);
		return new ResponseEntity<Void>(HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public @ResponseBody ResponseEntity<BodegaResponseDto> cursoPorId(@PathVariable Integer id){
		
		BodegaResponseDto bodegaResponseDto = iBodegaService.bodegaById(id);
		if(bodegaResponseDto != null) {
			return new ResponseEntity<BodegaResponseDto>(bodegaResponseDto, HttpStatus.OK);
			
		}
		
		return new ResponseEntity<BodegaResponseDto>(HttpStatus.NOT_FOUND);
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> eliminar(@PathVariable Integer id){
		
		BodegaResponseDto bodegaResponseDto = iBodegaService.bodegaById(id);
		if(bodegaResponseDto != null) {
			iBodegaService.eliminarBodega(id);
			
			return new ResponseEntity<Void>(HttpStatus.OK);
			
		}
		
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		
	}
	
	@PutMapping
	public ResponseEntity<Void> editar (@RequestBody BodegaRequestDto bodegaRequestDto){
		
		BodegaResponseDto bodegaResponseDto = iBodegaService.bodegaById(bodegaRequestDto.getIdBodegaRequest());
		if(bodegaResponseDto != null) {
			iBodegaService.editarBodega(bodegaRequestDto);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
		return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
	}

}
