package br.com.magicApi.externo.rest.conexao;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import br.com.magicApi.config.Propriedades;
import br.com.magicApi.dto.externo.HouseRequestDTO;
import br.com.magicApi.dto.externo.HouseResponseDTO;
import br.com.magicApi.externo.rest.RestClientTemplate;
import br.com.twsoftware.alfred.object.Objeto;

/**
 * Classe que representa a conexão com a API da PotterApi.
 * @author Yallamy Nascimento (yallamy@gmail.com)
 * @since 5 de set de 2020
 */
@Component
public class PotterApiConexao {

	private final String SERVICE_CONSULTAR_CASAS = "/houses/{houseId}?key={key}";

	private String url;

	private String key;

	@Autowired
	private Propriedades propriedades;

	@PostConstruct
	public void init() {

		this.url = propriedades.getMagicApiConfig().potterApi.url;
		this.key = propriedades.getMagicApiConfig().potterApi.key;
	}

	/**
	 * Método que retorna uma conexão com o serviço consultar casa da PotterApi.
	 * @param requestEntity - DTO com os dados da requisição
	 * @return RestClientTemplate
	 * @author Yallamy Nascimento (yallamy@gmail.com)
	 * @since 5 de set de 2020
	 */
	public RestClientTemplate getHouse(HouseRequestDTO requestEntity) {

		if(Objeto.isBlank(requestEntity) || Objeto.isBlank(requestEntity.getHouseId())) {
			return RestClientTemplate.builder().build();
		}
		
		Map<String, String> params = new HashMap<String, String>();
	    params.put("houseId", requestEntity.getHouseId());
	    params.put("key", this.key);
	    
	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.APPLICATION_JSON);
	    headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        headers.add("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) "
        		+ "AppleWebKit/537.36 (KHTML, like Gecko) Chrome/54.0.2840.99 Safari/537.36");
		
		@SuppressWarnings({ "rawtypes", "unchecked" })
		HttpEntity requestHttpEntity = new HttpEntity(headers);

		RestClientTemplate restTemplate = 
				RestClientTemplate.builder()
				.url(this.url + this.SERVICE_CONSULTAR_CASAS)
				.params(params)
				.httpMethod(HttpMethod.GET)
				.requestHttpEntity(requestHttpEntity)
				.responseType(HouseResponseDTO.class)
				.build();

		return restTemplate;
	}
}
