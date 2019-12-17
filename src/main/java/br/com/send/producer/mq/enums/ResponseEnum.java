package br.com.send.producer.mq.enums;

public enum ResponseEnum {

	OK(0 , "Dados enviado para fila com sucesso"),
	DADOS_INVALIDOS(1,"Dados inválidos"),
	ERRO_PROCESSAMENTO(2,"Erro no processamento");
	
	private ResponseEnum(int codigo, String msg) {
		this.codigo = codigo;
		this.msg = msg;
	}
	private int codigo;
	private String msg;
	
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
