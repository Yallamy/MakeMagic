package br.com.magicApi.externo.rest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import br.com.magicApi.exception.CustomException;

/**
 * Classe de teste que representa os cenários de testes da classe {@link ApiClient}
 * @author Yallamy Nascimento (yallamy@gmail.com)
 * @since 9 de set de 2020
 */
@SpringBootTest
public class ApiClientTest {
	
	@InjectMocks
	private ApiClient apiClient;

	@Test
	public void failure() throws CustomException {

		ResponseEntity<?> response = this.apiClient.failure();
		
		assertNotNull(response);
		assertEquals(HttpStatus.BAD_GATEWAY, response.getStatusCode());
	}
}
