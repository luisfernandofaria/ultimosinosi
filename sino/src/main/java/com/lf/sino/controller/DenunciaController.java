package com.lf.sino.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lf.sino.model.Denuncia;
import com.lf.sino.model.LocalAcidente;
import com.lf.sino.model.Municipio;
import com.lf.sino.repository.DenunciaRepository;
import com.lf.sino.repository.LocalAcidenteRepository;

@Controller
@RequestMapping("/denuncia")
public class DenunciaController {

	@Autowired
	DenunciaRepository denunciaRepository;

	@Autowired
	LocalAcidenteRepository localAcidenteRepository;

	// mapear página de cadastro da denúncia
	@GetMapping("/cadastrar")
	public String cadastrarDenuncia(Denuncia denuncia) {
		return "denuncia/cadastro";
	}

	// salvar denúncia
	@PostMapping("/salvar")
	public String salvarDenuncia(@Valid Denuncia denuncia) {
		denunciaRepository.save(denuncia);
		return "redirect:/";
	}

	
	
//	// salvar denúncia
//	@PostMapping("/denuncia/salvar")
//	public String salvarDenuncia(@RequestParam("id") Integer id, ModelMap model, @Valid Denuncia denuncia,
//			LocalAcidente localAcidente) {
//		model.addAttribute(localAcidenteRepository.findById(id));
//
//		System.out.println("TESTAAAAAAAAAAAAAAAAAANO   " + localAcidente);
//
//		System.out.println();
//		System.out.println("DENÚNCIA dentro do método SALVAR(): " + denuncia);
//		System.out.println();
//		denunciaRepository.save(denuncia);
//
//		return "redirect:/";
//	}

}