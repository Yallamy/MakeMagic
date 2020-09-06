package br.com.magicApi.exception;

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

}
