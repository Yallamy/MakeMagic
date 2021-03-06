package br.com.magicApi.exception;

import org.springframework.http.HttpStatus;

/**
 * Interface que representa as validações genericas do sistema.
 * @author Yallamy Nascimento (yallamy@gmail.com)
 * @since 5 de set de 2020
 */
public interface GenericValidacao {
	
	/**
	 * Método que retorna o código de erro referente a exception.
	 * @return String
	 * @author Yallamy Nascimento (yallamy@gmail.com)
	 * @since 5 de set de 2020
	 */
	public String getCodigoErro();
	
	/**
	 * Método que retorna o HttpStatus referente a Exception
	 * @return HttpStatus
	 * @author Yallamy Nascimento (yallamy@gmail.com)
	 * @since 7 de set de 2020
	 */
	public HttpStatus getHttpStatus();

}
