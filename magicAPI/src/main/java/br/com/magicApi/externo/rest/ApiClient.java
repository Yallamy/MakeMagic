package br.com.magicApi.externo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * Classe que apresenta os métodos comuns para todos os clientes de API externos.
 * @author Yallamy Nascimento (yallamy@gmail.com)
 * @since 9 de set de 2020
 */
public class ApiClient {
	
	/**
	 * Método que retorna um ResponseEntity<?> em caso de falha no consumo do serviço externo.
	 * @return ResponseEntity<?>
	 * @author Yallamy Nascimento (yallamy@gmail.com)
	 * @since 9 de set de 2020
	 */
	public ResponseEntity<?> failure() {
		return new ResponseEntity<String>("{\"message\": \"Não foi possível comunicar com o sistema externo\"}",
				HttpStatus.BAD_GATEWAY) ;
	}

}
