package com.lf.sino.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/")
	public String home() {
		return "index2";
	}

	@GetMapping("/login")
	public String logar(@AuthenticationPrincipal User user) {

		if (user != null) {
			System.out.println("usuario não é nulo: "+ user.getUsername());
			return "redirect:/denuncia/listar";
		}

		return "login";
	}

	@GetMapping("/acesso-nao-autorizado")
	public String accessDenied() {
		return "/erro/acesso-nao-autorizado";
	}

}
