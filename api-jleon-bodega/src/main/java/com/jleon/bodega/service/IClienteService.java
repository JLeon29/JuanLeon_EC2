package com.jleon.bodega.service;

import java.util.List;

import com.jleon.bodega.model.dto.ClienteRequestDto;
import com.jleon.bodega.model.dto.ClienteResponseDto;

public interface IClienteService {
	
	void guardarCliente(ClienteRequestDto clienteDto);
	void eliminarCliente(Integer id);
	void editarCliente(ClienteRequestDto clienteDto);
	List<ClienteResponseDto> listarCliente();
	ClienteResponseDto clienteById(Integer id);
	

}
