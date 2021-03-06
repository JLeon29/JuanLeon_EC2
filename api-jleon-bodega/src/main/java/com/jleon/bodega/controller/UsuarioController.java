package com.jleon.bodega.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jleon.bodega.model.dto.UsuarioRequestDto;
import com.jleon.bodega.model.dto.UsuarioResponseDto;
import com.jleon.bodega.security.JWTTokenUtil;
import com.jleon.bodega.security.JWTUserDetailsService;

@RestController
public class UsuarioController {
	
	@Autowired
	private JWTTokenUtil jwtTokenUtil;
	
	@Autowired
	private JWTUserDetailsService jWTUserDetailService;
	
	@RequestMapping(method = RequestMethod.POST, path = "/crearToken")
	public ResponseEntity<?> crearToken(@RequestBody UsuarioRequestDto request){
		
		UserDetails userDetail = jWTUserDetailService.loadUserByUsername(request.getUsuario());
		
		return ResponseEntity.ok(new UsuarioResponseDto(jwtTokenUtil.generateToken(userDetail.getUsername())));
	}

}
