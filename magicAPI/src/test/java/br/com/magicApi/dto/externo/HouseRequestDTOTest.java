package br.com.magicApi.dto.externo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.magicApi.EntityGenericUtil;
import junit.framework.TestCase;

/**
 * Classe de teste que representa os cenários de testes da classe {@link HouseRequestDTO}
 * @author Yallamy Nascimento (yallamy@gmail.com)
 * @since 6 de set de 2020
 */
@RunWith(SpringRunner.class)
public class HouseRequestDTOTest {

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

	@Test
	public void getInstanceVaziaTest() {

		HouseRequestDTO request = new HouseRequestDTO();

		TestCase.assertNotNull(request);
		TestCase.assertEquals(null, request.getHouseId());
	}

	@Test
	public void getInstanceComBuilderTest() {

		HouseRequestDTO request = HouseRequestDTO
				.builder()
				.houseId(this.houseId)
				.build();

		TestCase.assertNotNull(request);
		TestCase.assertEquals(this.houseId, request.getHouseId());
	}

	@Test
	public void setAndGetAllFieldsTest() {

		HouseRequestDTO request = new HouseRequestDTO();
		request.setHouseId(this.houseId);

		TestCase.assertEquals(this.houseId, request.getHouseId());
	}
	
	@Test
	public void getEqualsTest() {

		HouseRequestDTO request = new HouseRequestDTO(this.houseId);
		
		HouseRequestDTO request2 = new HouseRequestDTO(this.houseId);

		TestCase.assertNotNull(request);
		TestCase.assertNotNull(request2);
		TestCase.assertEquals(request, request2);
	}
	
	@Test
	public void getHashCodeTest() {

		HouseRequestDTO request = new HouseRequestDTO(this.houseId);
		
		HouseRequestDTO request2 = new HouseRequestDTO(this.houseId);

		TestCase.assertNotNull(request);
		TestCase.assertNotNull(request2);
		TestCase.assertEquals(request.hashCode(), request2.hashCode());
	}
	
	@Test
	public void getToStringTest() {

		HouseRequestDTO request = new HouseRequestDTO(this.houseId);

		TestCase.assertNotNull(request);
		TestCase.assertNotNull(request.toString());
	}

}
