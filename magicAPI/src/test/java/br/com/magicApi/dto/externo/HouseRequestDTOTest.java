package br.com.magicApi.dto.externo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.magicApi.EntityGenericUtil;

/**
 * Classe de teste que representa os cenários de testes da classe {@link HouseRequestDTO}
 * @author Yallamy Nascimento (yallamy@gmail.com)
 * @since 6 de set de 2020
 */
public class HouseRequestDTOTest {

	private String houseId;

	@BeforeEach
	public void setup() {

		this.houseId = EntityGenericUtil.getString();
	}

	@Test
	public void getInstanceTest() {

		HouseRequestDTO request = new HouseRequestDTO(this.houseId);

		assertNotNull(request);
		assertEquals(this.houseId, request.getHouseId());
	}

	@Test
	public void getInstanceVaziaTest() {

		HouseRequestDTO request = new HouseRequestDTO();

		assertNotNull(request);
		assertEquals(null, request.getHouseId());
	}

	@Test
	public void getInstanceComBuilderTest() {

		HouseRequestDTO request = HouseRequestDTO
				.builder()
				.houseId(this.houseId)
				.build();

		assertNotNull(request);
		assertEquals(this.houseId, request.getHouseId());
	}

	@Test
	public void setAndGetAllFieldsTest() {

		HouseRequestDTO request = new HouseRequestDTO();
		request.setHouseId(this.houseId);

		assertEquals(this.houseId, request.getHouseId());
	}
	
	@Test
	public void getEqualsTest() {

		HouseRequestDTO request = new HouseRequestDTO(this.houseId);
		
		HouseRequestDTO request2 = new HouseRequestDTO(this.houseId);

		assertNotNull(request);
		assertNotNull(request2);
		assertEquals(request, request2);
	}
	
	@Test
	public void getHashCodeTest() {

		HouseRequestDTO request = new HouseRequestDTO(this.houseId);
		
		HouseRequestDTO request2 = new HouseRequestDTO(this.houseId);

		assertNotNull(request);
		assertNotNull(request2);
		assertEquals(request.hashCode(), request2.hashCode());
	}
	
	@Test
	public void getToStringTest() {

		HouseRequestDTO request = new HouseRequestDTO(this.houseId);

		assertNotNull(request);
		assertNotNull(request.toString());
	}

}
