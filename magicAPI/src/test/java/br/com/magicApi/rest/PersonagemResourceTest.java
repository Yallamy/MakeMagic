package br.com.magicApi.rest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.magicApi.EntityGenericUtil;
import br.com.magicApi.dto.externo.HouseRequestDTO;
import junit.framework.TestCase;

/**
 * Classe de teste que representa os cenários de testes da classe {@link PersonagemResource}
 * @author Yallamy Nascimento (yallamy@gmail.com)
 * @since 6 de set de 2020
 */
@RunWith(SpringRunner.class)
public class PersonagemResourceTest {
	
	private String houseId;

	@Before
	public void setup() {

		this.houseId = EntityGenericUtil.getString();
	}

	@Test
	public void getInstanceTest() {

		HouseRequestDTO request = new HouseRequestDTO(this.houseId);

		TestCase.assertNotNull(request);
		TestCase.assertEquals(this.houseId, request.getHouseId());
	}

}
