package br.com.send.producer.mq.vo;

import br.com.send.producer.mq.enums.ResponseEnum;

public class ResponseVo {
	
	public ResponseVo(ResponseEnum responseEnum) {
		super();
		this.msg = responseEnum.getMsg();
		this.codigo = responseEnum.getCodigo();
	}

	private String msg;
	
	private int codigo;

	
	
	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
}
