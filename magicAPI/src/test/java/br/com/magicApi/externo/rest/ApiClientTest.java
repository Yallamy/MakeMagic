package br.com.magicApi.externo.rest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.magicApi.exception.CustomException;
import junit.framework.TestCase;

/**
 * Classe de teste que representa os cenários de testes da classe {@link ApiClient}
 * @author Yallamy Nascimento (yallamy@gmail.com)
 * @since 9 de set de 2020
 */
@RunWith(SpringRunner.class)
public class ApiClientTest {
	
	@InjectMocks
	private ApiClient apiClient;

	@Test
	public void failure() throws CustomException {

		ResponseEntity<?> response = this.apiClient.failure();
		
		TestCase.assertNotNull(response);
		TestCase.assertEquals(HttpStatus.BAD_GATEWAY, response.getStatusCode());
	}
}
