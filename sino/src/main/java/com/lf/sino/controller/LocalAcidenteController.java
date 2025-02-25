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

import com.lf.sino.model.LocalAcidente;
import com.lf.sino.repository.LocalAcidenteRepository;
import com.lf.sino.repository.MunicipioRepository;

@Controller
@RequestMapping("/localacidente")
public class LocalAcidenteController {

	private static final Logger logger = LoggerFactory.getLogger(LocalAcidenteController.class);

	@Autowired
	LocalAcidenteRepository localAcidenteRepository;

	@Autowired
	MunicipioRepository municipioRepository;

	@GetMapping("/cadastro")
	public ModelAndView novo(LocalAcidente localAcidente) {
		ModelAndView mv = new ModelAndView("localacidente/cadastro");
		mv.addObject("municipios", municipioRepository.findAll());
		return mv;
	}

	@PostMapping("/cadastro")
	public ModelAndView salvar(@Valid LocalAcidente localAcidente, BindingResult result) {

		if (result.hasErrors()) {
			return novo(localAcidente);
		}

		return new ModelAndView("redirect:/localacidente/cadastro");
	}

	// salvar local do acidente
	@PostMapping("/salvar")
	public ModelAndView salvarLocalAcidente(LocalAcidente localAcidente) {
		localAcidenteRepository.save(localAcidente);
		return new ModelAndView("redirect:/denuncia/cadastrar");
	}

}
