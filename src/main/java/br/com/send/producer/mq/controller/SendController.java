package br.com.send.producer.mq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.send.producer.mq.service.SendService;
import br.com.send.producer.mq.vo.ResponseVo;

@RestController
@RequestMapping(path = "/send")
public class SendController extends Controller {

	@Autowired
	private SendService sendService;
	
	@PostMapping(path="/", produces = {MediaType.APPLICATION_JSON_VALUE} , consumes = {MediaType.TEXT_PLAIN_VALUE})
	public ResponseEntity<ResponseVo> salva(@RequestBody String trajeto) {

		return ResponseEntity.ok().body(sendService.send(trajeto)); 
	}
}
