package com.lf.sino.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lf.sino.model.Denuncia;
import com.lf.sino.repository.DenunciaRepository;

@RestController
@RequestMapping("rest/denuncia")
public class DenunciaRestController {

	@Autowired
	DenunciaRepository denunciaRepository;

	@GetMapping("/listar")
	public List<Denuncia> listar() {
		return denunciaRepository.findAll();
	}

	@PostMapping("/")
	public Denuncia criarDenuncia(@RequestBody Denuncia denuncia) {
		return denunciaRepository.save(denuncia);
	}
}
