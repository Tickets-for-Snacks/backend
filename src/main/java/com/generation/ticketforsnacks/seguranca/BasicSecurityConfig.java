package com.generation.ticketforsnacks.seguranca;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Classe BasicSecurityConfig
 * 
 * Esta classe é responsável por habilitar a segurança básica da aplicação e o login
 * na aplicação.
 * 
 * Para habilitar a segurança HTTP no Spring, precisamos extender (herdar) 
 * a Classe WebSecurityConfigurerAdapter para fornecer uma configuração padrão 
 * no método configure (HttpSecurity http)
 * 
 * A configuração padrão garante que qualquer requisição enviada para a API 
 * seja autenticada com login baseado em formulário ou autenticação via Browser.
 * 
 * Para personalizar a autenticação utilizaremos a sobrecarga dos métodos da
 * Classe WebSecurityConfigurerAdapter
 * 
 */

/**
 *  A annotation @EnableWebSecurity: habilita a configuração de segurança padrão 
 *  do Spring Security na nossa api.
 */

@SuppressWarnings("deprecation")
@EnableWebSecurity
public class BasicSecurityConfig extends WebSecurityConfigurerAdapter {



	@Autowired
	private UserDetailsService userDetailsService;



	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		

		
		 auth.userDetailsService(userDetailsService);

		 auth.inMemoryAuthentication()
			.withUser("root")
			.password(passwordEncoder().encode("root"))
			.authorities("ROLE_USER");

	}


	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}


	 @Override
	protected void configure(HttpSecurity http) throws Exception {
		
	

		http.authorizeRequests()
        .antMatchers("/usuarios/logar").permitAll()
        .antMatchers("/usuarios/cadastrar").permitAll()
        .antMatchers(HttpMethod.PUT, "/usuarios/atualizar").permitAll()
        .antMatchers(HttpMethod.GET, "/categorias").permitAll()
        .antMatchers(HttpMethod.GET, "/produtos").permitAll()
        .antMatchers(HttpMethod.GET, "/usuarios/*").permitAll()
        .antMatchers(HttpMethod.OPTIONS).permitAll()
        .anyRequest().authenticated()
        .and().httpBasic()
        .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        .and().cors()
        .and().csrf().disable();
			
	}
}
