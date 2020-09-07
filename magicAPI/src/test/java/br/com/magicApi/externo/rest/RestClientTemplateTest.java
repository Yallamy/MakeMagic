package br.com.magicApi.externo.rest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.magicApi.EntityGenericUtil;
import br.com.magicApi.dto.PersonagemRequestDTO;
import junit.framework.TestCase;

/**
 * Classe de teste que representa os cenários de testes da classe {@link RestClientTemplate}
 * @author Yallamy Nascimento (yallamy@gmail.com)
 * @since 6 de set de 2020
 */
@RunWith(SpringRunner.class)
public class RestClientTemplateTest {

	private RequestEntity<?> requestEntity;

	@SuppressWarnings("rawtypes")
	private Class responseType;

	private String url;
	
	private Map<String, String> params;
	
	@SuppressWarnings("rawtypes")
	private HttpEntity requestHttpEntity;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Before
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

		TestCase.assertNotNull(request);
		TestCase.assertEquals(this.requestEntity, request.getRequestEntity());
		TestCase.assertEquals(this.responseType, request.getResponseType());
		TestCase.assertEquals(this.url, request.getUrl());
		TestCase.assertEquals(this.params, request.getParams());
		TestCase.assertEquals(this.requestHttpEntity, request.getRequestHttpEntity());
	}

	@Test
	public void getInstanceVaziaTest() {

		RestClientTemplate request = RestClientTemplate.builder().build();

		TestCase.assertNotNull(request);
		TestCase.assertEquals(null, request.getRequestEntity());
		TestCase.assertEquals(null, request.getResponseType());
		TestCase.assertEquals(null, request.getUrl());
		TestCase.assertEquals(null, request.getParams());
		TestCase.assertEquals(null, request.getRequestHttpEntity());
	}
	

	@Test
	public void setAndGetAllFieldsTest() {

		RestClientTemplate request = RestClientTemplate.builder().build();

		request.setRequestEntity(this.requestEntity);
		request.setResponseType(this.responseType);
		request.setUrl(this.url);
		request.setParams(this.params);
		request.setRequestHttpEntity(this.requestHttpEntity);

		TestCase.assertEquals(this.requestEntity, request.getRequestEntity());
		TestCase.assertEquals(this.responseType, request.getResponseType());
		TestCase.assertEquals(this.url, request.getUrl());
		TestCase.assertEquals(this.params, request.getParams());
		TestCase.assertEquals(this.requestHttpEntity, request.getRequestHttpEntity());
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

		TestCase.assertNotNull(experado);
		TestCase.assertNotNull(request);
		TestCase.assertTrue(experado.equals(request));
		TestCase.assertEquals(experado.hashCode(), request.hashCode());
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

		TestCase.assertNotNull(request);
		TestCase.assertNotNull(request.toString());
	}
}
