package br.com.magicApi.exception;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.server.ResponseStatusException;


/**
 * Classe que representa a customização das exceptions do sistema.
 * @author Yallamy Nascimento (yallamy@gmail.com)
 * @since 5 de set de 2020
 */
public class CustomException extends ResponseStatusException {

	private static final long serialVersionUID = 5101008253945611515L;
	
	private GenericValidacao erro;
	private List<String> parametros = new ArrayList<String>();

	/**
	 * Construtor da classe.
	 * @param erro
	 * @author Yallamy Nascimento (yallamy@gmail.com)
	 * @since 5 de set de 2020
	 */
	public CustomException(GenericValidacao erro) {
		
		super(erro.getHttpStatus(), erro.getCodigoErro());
		
		this.erro = erro;
		this.parametros = new ArrayList<String>();
	}

	/**
	 * Construtor da classe.
	 * @param erro
	 * @param ex
	 * @author Yallamy Nascimento (yallamy@gmail.com)
	 * @since 5 de set de 2020
	 */
	public CustomException(GenericValidacao erro, Exception ex) {
		
		super(erro.getHttpStatus(), erro.getCodigoErro(), ex);
		this.erro = erro;
		this.parametros = new ArrayList<String>();
	}

	/**
	 * Construtor da classe.
	 * @param erro
	 * @param params
	 * @author Yallamy Nascimento (yallamy@gmail.com)
	 * @since 5 de set de 2020
	 */
	public CustomException(GenericValidacao erro, String... params) {
		
		super(erro.getHttpStatus(), erro.getCodigoErro());
		this.erro = erro;
		this.parametros = Arrays.asList(params);
	}

	/**
	 * Construtor da classe.
	 * @param erro
	 * @param ex
	 * @param params
	 * @author Yallamy Nascimento (yallamy@gmail.com)
	 * @since 5 de set de 2020  
	 */
	public CustomException(GenericValidacao erro, Exception ex, String... params) {
		
		super(erro.getHttpStatus(), erro.getCodigoErro(), ex);
		this.erro = erro;
		this.parametros = Arrays.asList(params);
	}

	/**
	 * Método que retorna a pilha de erros da excecução.
	 * @param t
	 * @return String - Uma String com a pilha de erros.
	 * @author Yallamy Nascimento (yallamy@gmail.com)
	 * @since 5 de set de 2020
	 */
	public static final String getPilhaErro(Throwable t) {
		
		StringWriter writer = new StringWriter();
		PrintWriter printWriter = new PrintWriter(writer);
		t.printStackTrace(printWriter);
		
		return writer.toString();
	}

	/**
	 * Método que retorna a validação genérica.
	 * @return GenericValidacoes
	 * @author Yallamy Nascimento (yallamy@gmail.com)
	 * @since 5 de set de 2020
	 */
	public GenericValidacao getErro() {
		return erro;
	}

	/**
	 * Método que insere uma GenericValidacao.
	 * @param erro - Uma GenericValidacao
	 * @author Yallamy Nascimento (yallamy@gmail.com)
	 * @since 5 de set de 2020
	 */
	public void setErro(GenericValidacao erro) {
		this.erro = erro;
	}

	/**
	 * Método que retorna a a lista de parâmetros da validação genérica.
	 * @return List<String>
	 * @author Yallamy Nascimento (yallamy@gmail.com)
	 * @since 5 de set de 2020
	 */
	public List<String> getParametros() {
		return parametros;
	}

	/**
	 * Método que insere os parâmetros na validação genérica.
	 * @param parametros
	 * @author Yallamy Nascimento (yallamy@gmail.com)
	 * @since 5 de set de 2020
	 */
	public void setParametros(List<String> parametros) {
		this.parametros = parametros;
	}

	/**
	 * Sobrescrevendo o Método toString.
	 * @author Yallamy Nascimento (yallamy@gmail.com)
	 * @since 5 de set de 2020
	 */
	@Override
	public String toString() {
		return "CustomException ["
				+ (erro != null ? "erro=" + erro + ", " : "")
				+ (parametros != null ? "parametros=" + parametros : "") + "]";
	}

}
