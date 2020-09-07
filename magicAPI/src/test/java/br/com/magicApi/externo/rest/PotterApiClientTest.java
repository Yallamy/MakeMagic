package br.com.magicApi.externo.rest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

import br.com.magicApi.EntityGenericUtil;
import br.com.magicApi.dto.externo.HouseRequestDTO;
import br.com.magicApi.dto.externo.HouseResponseDTO;
import br.com.magicApi.exception.CustomException;
import br.com.magicApi.externo.rest.conexao.PotterApiConexao;
import junit.framework.TestCase;

/**
 * Classe de teste que representa os cenários de testes da classe {@link PotterApiClient}
 * @author Yallamy Nascimento (yallamy@gmail.com)
 * @since 6 de set de 2020
 */
@RunWith(SpringRunner.class)
public class PotterApiClientTest {

	@InjectMocks
	private PotterApiClient potterApiClient;

	@Mock
	private PotterApiConexao potterApiConexao;

	@Mock
	private RestTemplate restTemplate;
	
	private ResponseEntity<?> response;

	private HouseRequestDTO request;
	
	private Gson gson;

	private RestClientTemplate restClientTemplate;

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Before
	public void setup() {

		this.request = HouseRequestDTO.builder().houseId(EntityGenericUtil.getString()).build();
		this.gson = new Gson();
		
		potterApiClient.setGson(this.gson);
		
		this.response = new ResponseEntity<String>("[\r\n" + 
				"    {\r\n" + 
				"        \"_id\": \"5a05e2b252f721a3cf2ea33f\",\r\n" + 
				"        \"name\": \"Gryffindor\",\r\n" + 
				"        \"mascot\": \"lion\",\r\n" + 
				"        \"headOfHouse\": \"Minerva McGonagall\",\r\n" + 
				"        \"houseGhost\": \"Nearly Headless Nick\",\r\n" + 
				"        \"founder\": \"Goderic Gryffindor\",\r\n" + 
				"        \"__v\": 0,\r\n" + 
				"        \"school\": \"Hogwarts School of Witchcraft and Wizardry\"\r\n" + 
				"    }\r\n" + 
				"]", HttpStatus.OK);

		Map<String, String> params = new HashMap<String, String>();
	    params.put("houseId", EntityGenericUtil.getString());
	    params.put("key", EntityGenericUtil.getString());
	    
	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("user-agent", EntityGenericUtil.getString());
		
		HttpEntity requestHttpEntity = new HttpEntity(headers);

		this.restClientTemplate = 
				RestClientTemplate.builder()
				.url("https://www.potterapi.com/v2/houses/{houseId}?key={key}")
				.params(params)
				.httpMethod(HttpMethod.GET)
				.requestHttpEntity(requestHttpEntity)
				.responseType(HouseResponseDTO.class)
				.build();

		Mockito.when(this.potterApiConexao.getHouse(
				Mockito.any(HouseRequestDTO.class))).thenReturn(restClientTemplate);
		Mockito.when(this.restTemplate.exchange(
				Mockito.any(String.class), Mockito.any(HttpMethod.class), 
				Mockito.any(HttpEntity.class), Mockito.eq(String.class), 
				Mockito.any(Map.class))).thenReturn(this.response);
	}

	@Test
	public void getHouseSucessoTest() throws CustomException {

		HouseResponseDTO response = this.potterApiClient.getHouse(this.request);
		
		TestCase.assertNotNull(response);
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	@Test(expected = CustomException.class)
	public void getHouseErroConsumirServicoTest() throws CustomException {
		
		Map<String, String> params = new HashMap<String, String>();
	    params.put("houseId", EntityGenericUtil.getString());
	    params.put("key", EntityGenericUtil.getString());
	    
	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("user-agent", EntityGenericUtil.getString());
	    
		HttpEntity requestHttpEntity = new HttpEntity(headers);
		
		RestClientTemplate restClientTemplate2 = 
				RestClientTemplate.builder()
				.url("https://algumSite/v2/houses/{houseId}?key={key}")
				.params(params)
				.httpMethod(HttpMethod.GET)
				.requestHttpEntity(requestHttpEntity)
				.responseType(HouseResponseDTO.class)
				.build();

		Mockito.when(this.potterApiConexao.getHouse(
				Mockito.any(HouseRequestDTO.class))).thenReturn(restClientTemplate2);
		Mockito.when(this.restTemplate.exchange(
				Mockito.any(String.class), Mockito.any(HttpMethod.class), 
				Mockito.any(HttpEntity.class), Mockito.eq(String.class), 
				Mockito.any(Map.class))).thenThrow(IllegalStateException.class);
		
		this.potterApiClient.getHouse(this.request);
	}
	
	@SuppressWarnings("unchecked")
	@Test(expected = CustomException.class)
	public void getHouseErroStatusDiferente200Test() throws CustomException {

		this.response = new ResponseEntity<String>("{\r\n" + 
				"    \"message\": \"Cast to ObjectId failed for value \\\"5a05e2b252f721a3cf2ea33g\\\" at path \\\"_id\\\" for model \\\"Houses\\\"\",\r\n" + 
				"    \"name\": \"CastError\",\r\n" + 
				"    \"stringValue\": \"\\\"5a05e2b252f721a3cf2ea33g\\\"\",\r\n" + 
				"    \"kind\": \"ObjectId\",\r\n" + 
				"    \"value\": \"5a05e2b252f721a3cf2ea33g\",\r\n" + 
				"    \"path\": \"_id\"\r\n" + 
				"}", HttpStatus.CONFLICT);
		
		Mockito.when(this.restTemplate.exchange(
				Mockito.any(String.class), Mockito.any(HttpMethod.class), 
				Mockito.any(HttpEntity.class), Mockito.eq(String.class), 
				Mockito.any(Map.class))).thenReturn(this.response);
		
		this.potterApiClient.getHouse(this.request);
	}
	
	@SuppressWarnings("unchecked")
	@Test(expected = CustomException.class)
	public void getHouseNotFoundTest() throws CustomException {

		this.response = new ResponseEntity<String>("{\r\n" + 
				"    \"message\": \"Cast to ObjectId failed for value \\\"5a05e2b252f721a3cf2ea33g\\\" at path \\\"_id\\\" for model \\\"Houses\\\"\",\r\n" + 
				"    \"name\": \"CastError\",\r\n" + 
				"    \"stringValue\": \"\\\"5a05e2b252f721a3cf2ea33g\\\"\",\r\n" + 
				"    \"kind\": \"ObjectId\",\r\n" + 
				"    \"value\": \"5a05e2b252f721a3cf2ea33g\",\r\n" + 
				"    \"path\": \"_id\"\r\n" + 
				"}", HttpStatus.OK);
		
		Mockito.when(this.restTemplate.exchange(
				Mockito.any(String.class), Mockito.any(HttpMethod.class), 
				Mockito.any(HttpEntity.class), Mockito.eq(String.class), 
				Mockito.any(Map.class))).thenReturn(this.response);
		
		this.potterApiClient.getHouse(this.request);
	}

	@Test
	public void getHouseRequestNullTest() throws CustomException {

		HouseResponseDTO resultado = potterApiClient.getHouse(null);

		TestCase.assertNull(resultado);
	}
	
	@Test
	public void getHouseRequestHouseIdNullTest() throws CustomException {
		
		HouseResponseDTO resultado = potterApiClient.getHouse(HouseRequestDTO.builder().build());

		TestCase.assertNull(resultado);
	}

}
