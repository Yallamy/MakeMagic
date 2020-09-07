package br.com.magicApi.exception;

import org.springframework.http.HttpStatus;

/**
 * Classe que implementa as validações genéricas do sistema.
 * @author Yallamy Nascimento (yallamy@gmail.com)
 * @since 5 de set de 2020
 */
public enum ServiceWsValidacao implements GenericValidacao{

	PERSONAGEM_NAO_ENCONTRADO("Personagem não encontrado", HttpStatus.NOT_FOUND),
	BAD_REQUEST("Campos obrigatórios não informados", HttpStatus.BAD_REQUEST),
	CASA_NAO_ENCONTRADA("A casa informada não foi encontrada", HttpStatus.NOT_FOUND),
	CASA_INVALIDA("A casa informada não é uma opção válida", HttpStatus.BAD_REQUEST),
	ERRO_CONSUMO_SERVICO("Ocorreu um erro ao consumir um serviço externo", HttpStatus.REQUEST_TIMEOUT);
	
	private String codigoErro;
	
	private HttpStatus httpStatus;

	/**
	 * Construtor privado da classe.
	 * @param codigoErro
	 * @author Yallamy Nascimento (yallamy@gmail.com)
	 * @since 5 de set de 2020
	 */
	private ServiceWsValidacao(String codigoErro, HttpStatus httpStatus) {
		this.codigoErro = codigoErro;
		this.httpStatus = httpStatus;
	}

	/**
	 * Método que retorna o código de erro referente a exception.
	 * @return String
	 * @author Yallamy Nascimento (yallamy@gmail.com)
	 * @since 5 de set de 2020
	 */
	@Override
	public String getCodigoErro() {
		return codigoErro;
	}

	/**
	 * Método que insere o código de erro referente a exception.
	 * @param codigoErro
	 * @author Yallamy Nascimento (yallamy@gmail.com)
	 * @since 5 de set de 2020
	 */
	public void setCodigoErro(String codigoErro) {
		this.codigoErro = codigoErro;
	}

	@Override
	public HttpStatus getHttpStatus() {
		return this.httpStatus;
	}
	
	public void setHttpStatus(HttpStatus httpStatus) {
		this.httpStatus = httpStatus;
	}
}
