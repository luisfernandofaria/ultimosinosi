package com.lf.sino.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lf.sino.model.LocalAcidente;
import com.lf.sino.model.Municipio;
import com.lf.sino.repository.LocalAcidenteRepository;
import com.lf.sino.repository.MunicipioRepository;

@Controller
@RequestMapping("/localacidente")
public class LocalAcidenteController {


	@Autowired
	MunicipioRepository municipioRepository;
	
	@Autowired
	LocalAcidenteRepository localAcidenteRepository;

	// buscar a lista de municípios no banco de dados
	@ModelAttribute("municipios")
	public List<Municipio> listarMunicipios() {
		return municipioRepository.findAll();
	}
	
	// mapear página de cadastro do local do acidente
	@GetMapping("/cadastrar")
	public String cadastrarLocalAcidente(LocalAcidente localAcidente) {
		return "localacidente/cadastro";
	}

	// salvar local do acidente
//	@PostMapping("/salvar")
//	public String salvarLocalAcidente(@Valid LocalAcidente localAcidente, RedirectAttributes attr) {
//		localAcidenteRepository.save(localAcidente);
//		attr.addAttribute(localAcidente);
//		return "redirect:/denuncia/cadastrar";
//	}
	
	@PostMapping("/salvar")
	public ModelAndView salvarLocalAcidente(@Valid LocalAcidente localAcidente) {
		localAcidenteRepository.save(localAcidente);
		return new ModelAndView("redirect:/denuncia/cadastrar");
	}
	
}
