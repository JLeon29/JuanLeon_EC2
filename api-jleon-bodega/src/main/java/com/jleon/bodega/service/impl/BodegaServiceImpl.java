package com.jleon.bodega.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jleon.bodega.model.Bodega;
import com.jleon.bodega.model.Cliente;
import com.jleon.bodega.model.dto.BodegaRequestDto;
import com.jleon.bodega.model.dto.BodegaResponseDto;
import com.jleon.bodega.model.dto.ClienteResponseDto;
import com.jleon.bodega.repository.BodegaRepository;
import com.jleon.bodega.service.IBodegaService;

@Service
public class BodegaServiceImpl implements IBodegaService{
	
	
	@Autowired
	private BodegaRepository bodegaRepository;

	@Override
	public void guardarBodega(BodegaRequestDto bodegaRequestDto) {
		
		Bodega bodega = new Bodega();

		bodega.setIdBodega(bodegaRequestDto.getIdBodegaRequest());
		bodega.setNombre(bodegaRequestDto.getNombreRequest());
		bodega.setDireccion(bodegaRequestDto.getDireccionRequest());


		bodegaRepository.save(bodega);
		
	}

	@Override
	public void eliminarBodega(Integer id) {
		bodegaRepository.deleteById(id);		
	}

	@Override
	public void editarBodega(BodegaRequestDto bodegaRequestDto) {

		Bodega bodega = new Bodega();

		bodega.setIdBodega(bodegaRequestDto.getIdBodegaRequest());
		bodega.setNombre(bodegaRequestDto.getNombreRequest());
		bodega.setDireccion(bodegaRequestDto.getDireccionRequest());

		bodegaRepository.saveAndFlush(bodega);
	}

	@Override
	public List<BodegaResponseDto> listarBodega() {
		
		List<Bodega> listBodega = bodegaRepository.findAll();
		List<BodegaResponseDto> listBodegaDto = new ArrayList<>();
		BodegaResponseDto bodegaResponseDto = new BodegaResponseDto();
		
		for( Bodega variable : listBodega ) {
			
			bodegaResponseDto.setIdBodegaResponse(variable.getIdBodega());
			bodegaResponseDto.setNombreResponse(variable.getNombre());
			bodegaResponseDto.setDireccionResponse(variable.getDireccion());

			
			listBodegaDto.add(bodegaResponseDto);
			
			
			
		}
		return listBodegaDto;
	}

	@Override
	public BodegaResponseDto bodegaById(Integer id) {
		Bodega Bodega = bodegaRepository.findById(id).orElse(null);
		BodegaResponseDto bodegaResponseDto =new BodegaResponseDto();
		
		bodegaResponseDto.setIdBodegaResponse(Bodega.getIdBodega());
		bodegaResponseDto.setNombreResponse(Bodega.getNombre());
		bodegaResponseDto.setDireccionResponse(Bodega.getDireccion());
		
		
		return bodegaResponseDto;
	}
	
	

}
