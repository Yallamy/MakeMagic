package br.com.magicApi.externo.rest.conexao;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.magicApi.EntityGenericUtil;
import br.com.magicApi.config.Propriedades;
import br.com.magicApi.config.Propriedades.MagicApiConfig;
import br.com.magicApi.config.Propriedades.MagicApiConfig.PotterApi;
import br.com.magicApi.dto.externo.HouseRequestDTO;
import br.com.magicApi.externo.rest.RestClientTemplate;
import junit.framework.TestCase;


/**
 * Classe de teste que representa os cenários de testes da classe {@link PotterApiConexao}
 * @author Yallamy Nascimento (yallamy@gmail.com)
 * @since 6 de set de 2020
 */
@RunWith(SpringRunner.class)
public class PotterApiConexaoTest {

	@InjectMocks
	private PotterApiConexao potterApiConexao;

	@Mock
	private Propriedades propriedades;
	
	@Mock
	private MagicApiConfig magicApiConfig;
	
	@Mock
	private PotterApi potterApi;
	
	private HouseRequestDTO request;
	
	private String url;
	
	private String key;

	@Before
	public void setup() {

		this.request = HouseRequestDTO
				.builder()
				.houseId(EntityGenericUtil.getString())
				.build();

		this.url = "https://www.potterapi.com/v2";
		this.key = EntityGenericUtil.getString();

		Mockito.when(this.propriedades.getMagicApiConfig()).thenReturn(this.magicApiConfig);
		Mockito.when(this.magicApiConfig.getPotterApi()).thenReturn(this.potterApi);
		Mockito.when(this.potterApi.getUrl()).thenReturn(this.url);
		Mockito.when(this.potterApi.getKey()).thenReturn(this.key);
	}
	
	@Test
	public void getHouseConexaoTest() {
		
		potterApiConexao.init();
		RestClientTemplate response = potterApiConexao.getHouse(this.request);
		
		TestCase.assertNotNull(response);
		TestCase.assertNotNull(response.getUrl());
	}
	
	@Test
	public void getHouseConexaoRequestNullTest() {
		
		potterApiConexao.init();
		RestClientTemplate response = potterApiConexao.getHouse(null);
		
		TestCase.assertNotNull(response);
		TestCase.assertNull(response.getUrl());
	}
	
	@Test
	public void getHouseConexaoHouseIdNullTest() {
		
		potterApiConexao.init();
		RestClientTemplate response = potterApiConexao.getHouse(HouseRequestDTO
				.builder()
				.build());
		
		TestCase.assertNotNull(response);
		TestCase.assertNull(response.getUrl());
	}

}
