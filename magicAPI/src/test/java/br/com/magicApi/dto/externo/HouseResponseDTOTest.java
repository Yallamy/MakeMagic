package br.com.magicApi.dto.externo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.magicApi.EntityGenericUtil;

/**
 * Classe de teste que representa os cenários de testes da classe {@link HouseResponseDTO}
 * @author Yallamy Nascimento (yallamy@gmail.com)
 * @since 6 de set de 2020
 */
public class HouseResponseDTOTest {
	
	private String _id;

	private String name;

	private String mascot;

	private String headOfHouse;

	private String houseGhost;

	private String founder;

	private String school;

	@BeforeEach
	public void setup() {

		this._id = EntityGenericUtil.getString();
		this.name = EntityGenericUtil.getString();
		this.mascot = EntityGenericUtil.getString();
		this.headOfHouse = EntityGenericUtil.getString();
		this.houseGhost = EntityGenericUtil.getString();
		this.founder = EntityGenericUtil.getString();
		this.school = EntityGenericUtil.getString();
	}

	@Test
	public void getInstanceTest() {

		HouseResponseDTO response = new HouseResponseDTO(this._id, this.name, this.mascot, 
				this.headOfHouse, this.houseGhost, this.founder, this.school);

		assertNotNull(response);
		assertEquals(this._id, response.get_id());
		assertEquals(this.name, response.getName());
		assertEquals(this.mascot, response.getMascot());
		assertEquals(this.headOfHouse, response.getHeadOfHouse());
		assertEquals(this.houseGhost, response.getHouseGhost());
		assertEquals(this.founder, response.getFounder());
		assertEquals(this.school, response.getSchool());
	}

	@Test
	public void getInstanceVaziaTest() {

		HouseResponseDTO response = new HouseResponseDTO();

		assertNotNull(response);
		assertEquals(null, response.get_id());
		assertEquals(null, response.getName());
		assertEquals(null, response.getMascot());
		assertEquals(null, response.getHeadOfHouse());
		assertEquals(null, response.getHouseGhost());
		assertEquals(null, response.getFounder());
		assertEquals(null, response.getSchool());
	}

	@Test
	public void setAndGetAllFieldsTest() {

		HouseResponseDTO response = new HouseResponseDTO();
		response.set_id(this._id);
		response.setName(this.name);
		response.setMascot(this.mascot);
		response.setHeadOfHouse(this.headOfHouse);
		response.setHouseGhost(this.houseGhost);
		response.setFounder(this.founder);
		response.setSchool(this.school);

		assertEquals(this._id, response.get_id());
		assertEquals(this.name, response.getName());
		assertEquals(this.mascot, response.getMascot());
		assertEquals(this.headOfHouse, response.getHeadOfHouse());
		assertEquals(this.houseGhost, response.getHouseGhost());
		assertEquals(this.founder, response.getFounder());
		assertEquals(this.school, response.getSchool());
	}
	
	@Test
	public void getEqualsTest() {

		HouseResponseDTO response = new HouseResponseDTO(this._id, this.name, this.mascot, 
				this.headOfHouse, this.houseGhost, this.founder, this.school);
		
		HouseResponseDTO response2 = new HouseResponseDTO(this._id, this.name, this.mascot, 
				this.headOfHouse, this.houseGhost, this.founder, this.school);

		assertNotNull(response);
		assertNotNull(response2);
		assertEquals(response, response2);
	}
	
	@Test
	public void getHashCodeTest() {

		HouseResponseDTO response = new HouseResponseDTO(this._id, this.name, this.mascot, 
				this.headOfHouse, this.houseGhost, this.founder, this.school);
		
		HouseResponseDTO response2 = new HouseResponseDTO(this._id, this.name, this.mascot, 
				this.headOfHouse, this.houseGhost, this.founder, this.school);

		assertNotNull(response);
		assertNotNull(response2);
		assertEquals(response.hashCode(), response2.hashCode());
	}
	
	@Test
	public void getToStringTest() {

		HouseResponseDTO response = new HouseResponseDTO(this._id, this.name, this.mascot, 
				this.headOfHouse, this.houseGhost, this.founder, this.school);

		assertNotNull(response);
		assertNotNull(response.toString());
	}


}
