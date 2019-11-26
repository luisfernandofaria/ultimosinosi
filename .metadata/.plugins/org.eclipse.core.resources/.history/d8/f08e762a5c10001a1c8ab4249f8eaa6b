package com.lf.sino.controller.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.lf.sino.model.Denuncia;
import com.lf.sino.repository.DenunciaRepository;
import com.lf.sino.service.FileStorageService;
import com.lf.sino.upload.FileSaver;
import com.lf.sino.upload.UploadFileResponse;

@RestController
@RequestMapping("rest/denuncias")
public class DenunciaRestController {

	@Autowired
	private FileStorageService fileStorageService;

	@Autowired
	private FileSaver fileSaver;

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

//	@RequestMapping(value = "/upload", method = RequestMethod.POST, consumes = {   "multipart/form-data" })
//	@ResponseBody
//	public boolean uploadImage(@RequestPart("obj") YourDTO dto, @RequestPart("file") MultipartFile file) {
//	    // your logic
//	    return true;
//	}

	@RequestMapping(value = "/singleSave", method = RequestMethod.POST, consumes = { "multipart/form-data" })
	public void upload(@RequestPart("denuncia") Denuncia denuncia, @RequestPart("file") MultipartFile file) {
		
		System.out.println(denuncia.getCategoria());
		
		
		String fileName = fileStorageService.storeFile(file);

		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/downloadFile/")
				.path(fileName).toUriString();

		denuncia.setCaminhoFoto(fileName);
		denunciaRepository.save(denuncia);

	}
	
	
//	@RequestMapping(value = "/singleSave", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//	public ResponseEntity<Denuncia> singleSave(@RequestParam("file") MultipartFile file,
//			@RequestParam("denuncia") Denuncia denuncia) {
//		
//		
//		System.out.println(denuncia.getCategoria());
//		
//		
//		String fileName = fileStorageService.storeFile(file);
//
//		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/downloadFile/")
//				.path(fileName).toUriString();
//
////		denuncia.setCaminhoFoto(fileName);
////		denunciaRepository.save(denuncia);
//				
//		return singleSave(file, denuncia);
//	}

	@PostMapping(value = "/uploadFile", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
	public @ResponseBody UploadFileResponse uploadFile(@RequestParam("file") MultipartFile file,
			@RequestParam("denuncia") Denuncia denuncia) {

		String fileName = fileStorageService.storeFile(file);

		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/downloadFile/")
				.path(fileName).toUriString();

		denuncia.setCaminhoFoto(fileName);
		denunciaRepository.save(denuncia);
		System.out.println(" camihhoda::: " + denuncia.getCaminhoFoto());

		return new UploadFileResponse(fileName, fileDownloadUri, file.getContentType(), file.getSize());
	}

//	
//
//	@PostMapping("/mais")
//	public void uploadFile(@RequestParam("denuncia") Denuncia denuncia, @RequestParam("file") MultipartFile file) {
//		System.out.println(denuncia);
//
//		String caminho = fileSaver.write("", file);
//		denuncia.setCaminhoFoto(caminho);
//		denunciaRepository.save(denuncia);
//
//		System.out.println(" camihhoda::: " + denuncia.getCaminhoFoto());
//	
//	}

//	@PostMapping("/novo")
//	public ResponseEntity<String> receiveData(@RequestParam("file") MultipartFile file,
//			@RequestParam("denuncia") Denuncia denuncia) {
//
//		System.out.println(denuncia);
//
//		String caminho = fileSaver.write("", file);
//		denuncia.setCaminhoFoto(caminho);
//		denunciaRepository.save(denuncia);
//
//		System.out.println(" camihhoda::: " + denuncia.getCaminhoFoto());
//
//		return ResponseEntity.ok("Deu certo!");
//	}

	@PostMapping("/send")
	public ResponseEntity<String> receiveData(MultipartFile foto, @Valid Denuncia denuncia) {

		System.out.println(denuncia);
		System.out.println(foto.getOriginalFilename());

		String fileName = fileStorageService.storeFile(foto);

		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/downloadFile/")
				.path(fileName).toUriString();

		denuncia.setCaminhoFoto(fileName);
		denunciaRepository.save(denuncia);

		System.out.println(" camihhoda::: " + denuncia.getCaminhoFoto());

		return ResponseEntity.ok("Deu certo!");
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
