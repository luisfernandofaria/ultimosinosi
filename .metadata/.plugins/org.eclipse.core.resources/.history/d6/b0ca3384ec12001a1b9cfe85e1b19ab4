package com.lf.sino.controller.upload;

import org.springframework.web.context.request.async.DeferredResult;
import org.springframework.web.multipart.MultipartFile;

import com.lf.sino.controller.dto.FotoDTO;

public class FotoStorageRunnable implements Runnable {

	private MultipartFile[] files;
	private DeferredResult<FotoDTO> resultado;

	public FotoStorageRunnable(MultipartFile[] files, DeferredResult<FotoDTO> resultado) {
		this.files = files;
		this.resultado = resultado;
	}

	@Override
	public void run() {

		String nomeFoto = (files[0].getOriginalFilename());
		String contentType = (files[0].getContentType());

		resultado.setResult(new FotoDTO(nomeFoto, contentType));
	}

}
