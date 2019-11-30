package com.lf.sino.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.lf.sino.model.Denuncia;
import com.lf.sino.model.Municipio;
import com.lf.sino.repository.DenunciaRepository;
import com.lf.sino.repository.MunicipioRepository;
import com.lf.sino.service.FileStorageService;

@RestController
@RequestMapping("rest/denuncias")
public class DenunciaRestController {

	@Autowired
	private MunicipioRepository municipioRepository;

	@Autowired
	private FileStorageService fileStorageService;

	@Autowired
	DenunciaRepository denunciaRepository;

	@GetMapping("/listarMunicipios")
	public List<Municipio> listarMunicipios() {
		return municipioRepository.findAll();
	}

	@GetMapping("/listarDenuncias")
	public List<Denuncia> listarDenuncias() {
		return denunciaRepository.findAll();
	}

	@PostMapping(value = "/enviarDenuncia", consumes = { "multipart/form-data" })
	public void upload(@RequestPart("denuncia") Denuncia denuncia, @RequestPart("file") MultipartFile file) {

		String fileName = fileStorageService.storeFile(file);

		denuncia.setFoto(fileName);
		denunciaRepository.save(denuncia);
	}

}
