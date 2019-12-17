package br.com.send.producer.mq.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import br.com.send.producer.mq.enums.ResponseEnum;
import br.com.send.producer.mq.vo.ResponseVo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.amqp.core.Queue;

@Component
public class SendService {

	private static final Logger logger = LogManager.getLogger(SendService.class);
	
	@Autowired
    private RabbitTemplate rabbitTemplate;
 
	@Value("${rabbitmq.queue}")
	private String nomeFila;
    
    @Autowired
    private ValidaService validaService;
 
    public ResponseVo send(String msg){
    	
    	try {
    		if(validaService.isValido(msg)) {
	    		rabbitTemplate.convertAndSend(nomeFila, msg);
	    		return new ResponseVo(ResponseEnum.OK);
    		}else {
    			return new ResponseVo(ResponseEnum.DADOS_INVALIDOS);
    		}
    	}catch (Exception e) {
			 logger.error("{}", e);
			 return new ResponseVo(ResponseEnum.ERRO_PROCESSAMENTO);
		}
    }
}
