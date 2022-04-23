package com.jleon.bodega.service;

import java.util.List;

import com.jleon.bodega.model.dto.BodegaRequestDto;
import com.jleon.bodega.model.dto.BodegaResponseDto;

public interface IBodegaService {
	
	void guardarBodega(BodegaRequestDto bodegaRequestDto);
	void eliminarBodega(Integer id);
	void editarBodega(BodegaRequestDto bodegaRequestDto);
	List<BodegaResponseDto> listarBodega();
	BodegaResponseDto bodegaById(Integer id);

}
