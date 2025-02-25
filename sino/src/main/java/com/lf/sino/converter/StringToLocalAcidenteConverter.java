package com.lf.sino.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.lf.sino.model.LocalAcidente;
import com.lf.sino.repository.LocalAcidenteRepository;

@Component
public class StringToLocalAcidenteConverter implements Converter<String, LocalAcidente> {

	@Autowired
	private LocalAcidenteRepository localAcidenteRepository;
	
	@Override
	public LocalAcidente convert(String text) {
		if(text.isEmpty()) {
			return null;
		}
		Integer id = Integer.valueOf(text);
		return localAcidenteRepository.findById(id).get();
	}
}
