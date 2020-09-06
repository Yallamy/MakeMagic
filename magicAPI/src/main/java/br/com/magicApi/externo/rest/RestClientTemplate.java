package br.com.magicApi.externo.rest;

import java.util.Map;

import org.junit.Ignore;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Classe que representa uma requisição REST.
 * @author Yallamy Nascimento (yallamy@gmail.com)
 * @since 5 de set de 2020
 */
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@Ignore
@Data
public class RestClientTemplate {

	private RequestEntity<?> requestEntity;

	@SuppressWarnings("rawtypes")
	private Class responseType;

	private String url;
	
	private Map<String, String> params;
	
	@SuppressWarnings("rawtypes")
	private HttpEntity requestHttpEntity;
	
	private HttpMethod httpMethod;
}
