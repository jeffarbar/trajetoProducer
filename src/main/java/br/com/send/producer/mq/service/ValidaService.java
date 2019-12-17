package br.com.send.producer.mq.service;

import java.util.Arrays;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class ValidaService {

	private static final Logger logger = LogManager.getLogger(ValidaService.class);
	
	@Value("${tags.obrigatorios}")
	private String tagsObrigatorios;
	
	public boolean isValido(String msg) {
		
		try {
			
			if( tagsObrigatorios == null || "".equals(tagsObrigatorios) ) {
				return true;
			}
			
			return Arrays.asList(tagsObrigatorios.split(";")).stream().allMatch( tag -> msg.contains( tag ) );
			
		}catch (Exception e) {
			logger.error("{ Erro de validação }", e);
		}
		return false;
	}
}
