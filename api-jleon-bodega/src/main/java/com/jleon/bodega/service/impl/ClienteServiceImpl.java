package com.jleon.bodega.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jleon.bodega.model.Cliente;
import com.jleon.bodega.model.dto.ClienteRequestDto;
import com.jleon.bodega.model.dto.ClienteResponseDto;
import com.jleon.bodega.repository.ClienteRepository;
import com.jleon.bodega.service.IClienteService;

@Service
public class ClienteServiceImpl implements IClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public void guardarCliente(ClienteRequestDto clienteDto) {

		Cliente cliente = new Cliente();

		cliente.setIdCliente(clienteDto.getIdCliente());
		cliente.setNombre(clienteDto.getNombre());
		cliente.setDni(clienteDto.getDni());
		cliente.setDirección(clienteDto.getDirección());

		clienteRepository.save(cliente);
	}

	@Override
	public void eliminarCliente(Integer id) {
		clienteRepository.deleteById(id);
	}

	@Override
	public void editarCliente(ClienteRequestDto clienteDto) {

		Cliente cliente = new Cliente();

		cliente.setIdCliente(clienteDto.getIdCliente());
		cliente.setNombre(clienteDto.getNombre());
		cliente.setDni(clienteDto.getDni());
		cliente.setDirección(clienteDto.getDirección());

		clienteRepository.saveAndFlush(cliente);
	}

	@Override
	public List<ClienteResponseDto> listarCliente() {
		
		List<Cliente> listClientes = clienteRepository.findAll();
		List<ClienteResponseDto> listClientesDto = new ArrayList<>();
		ClienteResponseDto clienteResponseDto = new ClienteResponseDto();
		
		for( Cliente variable : listClientes ) {
			
			clienteResponseDto.setIdCliente(variable.getIdCliente());
			clienteResponseDto.setNombre(variable.getNombre());
			clienteResponseDto.setDni(variable.getDni());
			clienteResponseDto.setDirección(variable.getDirección());
			
			listClientesDto.add(clienteResponseDto);
			
			
			
		}
		return listClientesDto;
	}

	@Override
	public ClienteResponseDto clienteById(Integer id) {
		
		Cliente cliente = clienteRepository.findById(id).orElse(null);
		ClienteResponseDto clienteResponseDto =new ClienteResponseDto();
		
		clienteResponseDto.setIdCliente(cliente.getIdCliente());
		clienteResponseDto.setNombre(cliente.getNombre());
		clienteResponseDto.setDni(cliente.getDni());
		clienteResponseDto.setDirección(cliente.getDirección());
			
		
		return clienteResponseDto;
	}

}
