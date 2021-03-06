package com.jleon.bodega.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	
	

	@Autowired
	private JWTUserDetailsService jWTUserDetailService;
	
	@Autowired
	private JWTTokenFilter jWTTokenFilter;
	
	@Autowired
	private JWTEntryPoint jWTEntryPoint;
	

	//SOURCE - OVERRIDE IMPLEMENT METHODS ( para implementar los metodos siempre y cuando se extiende de una clase )
	
	//Metodo permite conectarme con usuarios
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		//CREAMOS LOS USUARIOS EN MEMORIA
		
		/*
		auth.inMemoryAuthentication().withUser("JUAN").password(encoder().encode("juan123")).roles("ADMIN");
		auth.inMemoryAuthentication().withUser("JOSE").password(encoder().encode("jose123")).roles("USER");
		auth.inMemoryAuthentication().withUser("LEON").password(encoder().encode("leon123")).roles("LOCAL");*/
		
		auth.userDetailsService(jWTUserDetailService).passwordEncoder(encoder()); // userDetailsService para conectarse a BD
		
	}

	
	//Metodo permite configurar los usuarios HTTP
	@Override
	protected void configure(HttpSecurity http) throws Exception {
	
		
		http.authorizeRequests()
			.antMatchers("/crearToken").permitAll()
			.antMatchers("/api/cliente/*").access("hasRole('ADMIN')")
			.antMatchers("/api/producto/*").access("hasRole('ADMIN')")
			.antMatchers("/api/bodega/listar").access("hasRole('USER')")
			.anyRequest()
			.authenticated()
			.and()
			.exceptionHandling()
			.authenticationEntryPoint(jWTEntryPoint)
			.and()
			.sessionManagement()
			.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
			.and()
			.addFilterBefore(jWTTokenFilter, UsernamePasswordAuthenticationFilter.class)
			.csrf().disable();
		
	}
	
	@Bean
	public PasswordEncoder encoder() {
		
		return new BCryptPasswordEncoder();
	}
	
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		
		return super.authenticationManagerBean();
	}

}
