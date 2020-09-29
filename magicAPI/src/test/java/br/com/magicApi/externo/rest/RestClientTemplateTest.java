package br.com.magicApi.externo.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.magicApi.EntityGenericUtil;
import br.com.magicApi.dto.PersonagemRequestDTO;

/**
 * Classe de teste que representa os cenários de testes da classe {@link RestClientTemplate}
 * @author Yallamy Nascimento (yallamy@gmail.com)
 * @since 6 de set de 2020
 */
public class RestClientTemplateTest {

	private RequestEntity<?> requestEntity;

	@SuppressWarnings("rawtypes")
	private Class responseType;

	private String url;
	
	private Map<String, String> params;
	
	@SuppressWarnings("rawtypes")
	private HttpEntity requestHttpEntity;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@BeforeEach
	public void setup() {
		
		this.params = new HashMap<String, String>();
	    params.put("houseId", EntityGenericUtil.getString());
	    params.put("key", EntityGenericUtil.getString());
	    
	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) "
        		+ "AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
		
		this.requestHttpEntity = new HttpEntity(headers);

		UriComponentsBuilder uriComponentsBuilder = UriComponentsBuilder
				.fromHttpUrl("https://www.potterapi.com/v2/houses/{houseId}?key={key}");

		this.requestEntity = RequestEntity.post(uriComponentsBuilder.build().encode().toUri())
				.header("Content-Type", "application/json")
				.body(EntityGenericUtil.getString());

		this.responseType = PersonagemRequestDTO.class;
		this.url = uriComponentsBuilder.toUriString();
	}

	@Test
	public void getInstanceTest() {

		RestClientTemplate request = RestClientTemplate
				.builder()
				.requestEntity(this.requestEntity)
				.responseType(this.responseType)
				.url(this.url)
				.params(this.params)
				.requestHttpEntity(this.requestHttpEntity)
				.build();

		assertNotNull(request);
		assertEquals(this.requestEntity, request.getRequestEntity());
		assertEquals(this.responseType, request.getResponseType());
		assertEquals(this.url, request.getUrl());
		assertEquals(this.params, request.getParams());
		assertEquals(this.requestHttpEntity, request.getRequestHttpEntity());
	}

	@Test
	public void getInstanceVaziaTest() {

		RestClientTemplate request = RestClientTemplate.builder().build();

		assertNotNull(request);
		assertEquals(null, request.getRequestEntity());
		assertEquals(null, request.getResponseType());
		assertEquals(null, request.getUrl());
		assertEquals(null, request.getParams());
		assertEquals(null, request.getRequestHttpEntity());
	}
	

	@Test
	public void setAndGetAllFieldsTest() {

		RestClientTemplate request = RestClientTemplate.builder().build();

		request.setRequestEntity(this.requestEntity);
		request.setResponseType(this.responseType);
		request.setUrl(this.url);
		request.setParams(this.params);
		request.setRequestHttpEntity(this.requestHttpEntity);

		assertEquals(this.requestEntity, request.getRequestEntity());
		assertEquals(this.responseType, request.getResponseType());
		assertEquals(this.url, request.getUrl());
		assertEquals(this.params, request.getParams());
		assertEquals(this.requestHttpEntity, request.getRequestHttpEntity());
	}

	@Test
	public void testEqualsAndHashCodeTest() {

		RestClientTemplate experado = RestClientTemplate
				.builder()
				.requestEntity(this.requestEntity)
				.responseType(this.responseType)
				.url(this.url)
				.params(this.params)
				.requestHttpEntity(this.requestHttpEntity)
				.build();

		RestClientTemplate request = RestClientTemplate
				.builder()
				.requestEntity(this.requestEntity)
				.responseType(this.responseType)
				.url(this.url)
				.params(this.params)
				.requestHttpEntity(this.requestHttpEntity)
				.build();

		assertNotNull(experado);
		assertNotNull(request);
		assertTrue(experado.equals(request));
		assertEquals(experado.hashCode(), request.hashCode());
	}

	@Test
	public void toStringTest() {

		RestClientTemplate request = RestClientTemplate
				.builder()
				.requestEntity(this.requestEntity)
				.responseType(this.responseType)
				.url(this.url)
				.params(this.params)
				.requestHttpEntity(this.requestHttpEntity)
				.build();

		assertNotNull(request);
		assertNotNull(request.toString());
	}
}
