package br.com.magicApi.exception;

/**
 * Classe que implementa as validações genéricas do sistema.
 * @author Yallamy Nascimento (yallamy@gmail.com)
 * @since 5 de set de 2020
 */
public enum ServiceWsValidacao implements GenericValidacao{

	PERSONAGEM_NAO_ENCONTRADO("Personagem não encontrado"),
	BAD_REQUEST("Campos obrigatórios não informados"),
	CASA_NAO_ENCONTRADA("A casa informada não foi encontrada"),
	CASA_INVALIDA("A casa informada não é uma opção válida"),
	ERRO_CONSUMO_SERVICO("Ocorreu um erro ao consumir um serviço externo"),
	XXX("XXX");
	
	public String codigoErro;

	/**
	 * Construtor privado da classe.
	 * @param codigoErro
	 * @author Yallamy Nascimento (yallamy@gmail.com)
	 * @since 5 de set de 2020
	 */
	private ServiceWsValidacao(String codigoErro) {
		this.codigoErro = codigoErro;
	}

	/**
	 * Método que retorna o código de erro referente a exception.
	 * @return String
	 * @author Yallamy Nascimento (yallamy@gmail.com)
	 * @since 5 de set de 2020
	 */
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
}
