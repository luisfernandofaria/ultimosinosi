package com.lf.sino.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.lf.sino.service.UsuarioService;

@EnableWebSecurity
public class SecurityConfigurations extends WebSecurityConfigurerAdapter {

	@Autowired
	private UsuarioService usuarioService;
	
//	@Autowired
//	private UserDetailsService userDetailsService;
//	

	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider auth = new DaoAuthenticationProvider();
		auth.setUserDetailsService(usuarioService); 
		auth.setPasswordEncoder(new BCryptPasswordEncoder());
		return auth;
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring()
		.antMatchers("/", "/materialize/**", "/js/**", "/css/**", "/img/**", "/webjars/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()

				.antMatchers(HttpMethod.GET, "/denuncia/cadastro").permitAll()
				.antMatchers(HttpMethod.GET, "/home").permitAll()
				.antMatchers("/login").permitAll()
				.antMatchers(HttpMethod.GET, "/rest/denuncias/listarMunicipios").permitAll()
				.antMatchers(HttpMethod.POST, "/rest/denuncias/enviarDenuncia").permitAll()

				.anyRequest().authenticated().and().formLogin().loginPage("/login").and().csrf().disable();

	}

}
