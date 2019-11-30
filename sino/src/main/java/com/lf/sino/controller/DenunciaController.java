package com.lf.sino.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lf.sino.model.Denuncia;
import com.lf.sino.model.LocalAcidente;
import com.lf.sino.repository.DenunciaRepository;
import com.lf.sino.repository.MunicipioRepository;

@Controller
@RequestMapping("/denuncia")
public class DenunciaController {

	private static final Logger logger = LoggerFactory.getLogger(LocalAcidenteController.class);

	@Autowired
	DenunciaRepository denunciaRepository;

	@Autowired
	MunicipioRepository municipioRepository;

	@GetMapping("/cadastro")
	public ModelAndView novo(Denuncia denuncia) {
		ModelAndView mv = new ModelAndView("denuncia/cadastro");
		mv.addObject("municipios", municipioRepository.findAll());
		mv.addObject("localAcidente", new LocalAcidente());
		return mv;
	}

	@PostMapping("/cadastro")
	public ModelAndView salvar(@Valid Denuncia denuncia, BindingResult brDenuncia, @Valid LocalAcidente localAcidente,
			BindingResult brLocalAcidente) {

		ModelAndView mv = new ModelAndView("redirect:/denuncia/cadastro");

		if (brDenuncia.hasErrors() || brLocalAcidente.hasErrors()) {
			return novo(denuncia);
		}
		denuncia.setLocalAcidente(localAcidente);
		denunciaRepository.save(denuncia);
		return mv;
	}

	@GetMapping("/listar")
	public ModelAndView listarDenuncias(Denuncia denuncia) {
		ModelAndView mv = new ModelAndView("denuncia/listar");
		mv.addObject("denuncias", denunciaRepository.findAll());
		return mv;
	}

}