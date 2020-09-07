package br.com.magicApi.externo.rest;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.google.gson.Gson;

import br.com.magicApi.dto.externo.HouseRequestDTO;
import br.com.magicApi.dto.externo.HouseResponseDTO;
import br.com.magicApi.exception.CustomException;
import br.com.magicApi.exception.ServiceWsValidacao;
import br.com.magicApi.externo.rest.conexao.PotterApiConexao;
import br.com.magicApi.util.Constantes;
import br.com.twsoftware.alfred.object.Objeto;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * Classe que representa o cliente da API REST da PotterApi.
 * @author Yallamy Nascimento (yallamy@gmail.com)
 * @since 5 de set de 2020
 */
@Slf4j
@Component
public class PotterApiClient {

	//@Getter
	//@Autowired
	//private CircuitBreakerManager circuitBreaker;

	@Getter
	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private PotterApiConexao potterApiConexao;
	
	@Setter
	@Autowired
	private Gson gson;

	/**
	 * Consome o serviço de consultar casa da PotterApi.
	 * @param requestEntity - DTO com os dados da requisição
	 * @return HouseResponseDTO - DTO com os dados da response
	 * @throws CustomException 
	 * @author Yallamy Nascimento (yallamy@gmail.com)
	 * @since 5 de set de 2020
	 */
	public HouseResponseDTO getHouse(HouseRequestDTO requestEntity) throws CustomException {

		HouseResponseDTO houseResponseDTO = null;
		ResponseEntity<?> response = null;

		if(Objeto.isBlank(requestEntity) || Objeto.isBlank(requestEntity.getHouseId())) {
			return houseResponseDTO;
		}

		//montando o template com os dados da conexão
		RestClientTemplate restClientTemplate = potterApiConexao.getHouse(requestEntity);

		try {

			//consumindo o serviço
			//response = circuitBreaker.failsafe(() -> restTemplate.exchange(restClientTemplate.getUrl(), restClientTemplate.getHttpMethod(), 
			//		restClientTemplate.getRequestHttpEntity(), String.class, restClientTemplate.getParams()), restClientTemplate.getUrl());
			
			response = restTemplate.exchange(restClientTemplate.getUrl(), restClientTemplate.getHttpMethod(), 
					restClientTemplate.getRequestHttpEntity(), String.class, restClientTemplate.getParams());
		
		} catch (Exception ex) {
			log.error("Erro na requisicao GET " + restClientTemplate.getUrl() + ". Mensagem: {}", ex.getMessage());
			throw new CustomException(ServiceWsValidacao.ERRO_CONSUMO_SERVICO);
		}

		//validando o response
		if(Objeto.notBlank(response) && HttpStatus.OK == response.getStatusCode()) {
			
			String json = (String) response.getBody();
			validarHouseNotFound(json, requestEntity.getHouseId());

			HouseResponseDTO[] casas = gson.fromJson(json, HouseResponseDTO[].class);
			houseResponseDTO = casas != null ? casas[BigDecimal.ZERO.intValue()] : null;

		} else {
			log.error("Erro no consumo do serviço para a API Potter");
			throw new CustomException(ServiceWsValidacao.CASA_INVALIDA);
		}

		return houseResponseDTO;
	}
	
	/**
	 * Método que valida o retorno do serviço de recuperar a house. Como o serviço da PotterApi 
	 * retorna o status 200 para casas que não existe, então tem que validar o conteúdo do json.
	 * @param json - retorno do serviço
	 * @param houseId - id da casa
	 * @throws CustomException
	 * @author Yallamy Nascimento (yallamy@gmail.com)
	 * @since 6 de set de 2020
	 */
	private void validarHouseNotFound(String json, String houseId) throws CustomException {
		
		if(json.contains(Constantes.TAG_ERRO)) {
			log.error("Casa não encontrada na API Potter para o id: " + houseId);
			log.error("Causa: " + houseId);
			throw new CustomException(ServiceWsValidacao.CASA_NAO_ENCONTRADA);
		}
	}
}
