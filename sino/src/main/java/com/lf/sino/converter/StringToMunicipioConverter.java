package com.lf.sino.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import com.lf.sino.model.Municipio;
import com.lf.sino.repository.MunicipioRepository;

@Component
public class StringToMunicipioConverter implements Converter<String, Municipio> {

	@Autowired
	private MunicipioRepository municipioRepository;
	
	@Override
	public Municipio convert(String text) {
		if(text.isEmpty()) {
			return null;
		}
		Integer id = Integer.valueOf(text);
		return municipioRepository.findById(id).get();
	}
}
