package com.lf.sino.controller.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.lf.sino.model.Denuncia;
import com.lf.sino.repository.DenunciaRepository;
import com.lf.sino.service.FileStorageService;
import com.lf.sino.upload.UploadFileResponse;

@RestController
@RequestMapping("rest/denuncias")
public class DenunciaRestController {

	@Autowired
	private FileStorageService fileStorageService;

	@Autowired
	DenunciaRepository denunciaRepository;

	@GetMapping("/listar")
	public List<Denuncia> listar() {
		return denunciaRepository.findAll();
	}

	@PostMapping("/denuncia")
	public Denuncia criarDenuncia(@RequestBody Denuncia denuncia) {
		return denunciaRepository.save(denuncia);
	}

//	@RequestMapping(value = "/executesampleservice", method = RequestMethod.POST,
//		    consumes = {"multipart/form-data"})
//		@ResponseBody
//		public boolean executeSampleService(
//		        @RequestPart("properties") @Valid ConnectionProperties properties,
//		        @RequestPart("file") @Valid @NotNull @NotBlank MultipartFile file) {
//		    return projectService.executeSampleService(properties, file);
//		}

//	@PostMapping("/uploadFile")
//	public UploadFileResponse gravar(MultipartFile file, @Valid Denuncia denuncia) {
//		
//		String fileName = fileStorageService.storeFile(file);
//
//		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/downloadFile/")
//				.path(fileName).toUriString();
//		denuncia.setCaminhoFoto(fileDownloadUri);
//		denunciaRepository.save(denuncia);
//		System.out.println(" camihhoda::: " +denuncia.getCaminhoFoto());
//		
//		
//		return new UploadFileResponse(fileName, fileDownloadUri, file.getContentType(), file.getSize());
//	}

	@PostMapping("/uploadFile")
	@ResponseBody
	public UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file,
			@RequestParam("denuncia") Denuncia denuncia) {

		String fileName = fileStorageService.storeFile(file);

		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/downloadFile/")
				.path(fileName).toUriString();

		denuncia.setCaminhoFoto(fileName);
		denunciaRepository.save(denuncia);
		System.out.println(" camihhoda::: " + denuncia.getCaminhoFoto());

		return new UploadFileResponse(fileName, fileDownloadUri, file.getContentType(), file.getSize());
	}

//	@PostMapping("/uploadFile")
//	@ResponseBody
//	public UploadFileResponse uploadFile(@RequestPart("denuncia") @Valid Denuncia denuncia,
//	        @RequestPart("file") @Valid @NotNull @NotBlank MultipartFile file) {
//
//		String fileName = fileStorageService.storeFile(file);
//
//		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/downloadFile/")
//				.path(fileName).toUriString();
//		denuncia.setCaminhoFoto(fileName);
//		denunciaRepository.save(denuncia);
//		System.out.println(" camihhoda::: " +denuncia.getCaminhoFoto());
//
//		return new UploadFileResponse(fileName, fileDownloadUri, file.getContentType(), file.getSize());
//	}

}
