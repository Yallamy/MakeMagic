package br.com.magicApi.dto.externo;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.magicApi.EntityGenericUtil;
import junit.framework.TestCase;

/**
 * Classe de teste que representa os cenários de testes da classe {@link HouseResponseDTO}
 * @author Yallamy Nascimento (yallamy@gmail.com)
 * @since 6 de set de 2020
 */
@RunWith(SpringRunner.class)
public class HouseResponseDTOTest {
	
	private String _id;

	private String name;

	private String mascot;

	private String headOfHouse;

	private String houseGhost;

	private String founder;

	private String school;

	@Before
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

		TestCase.assertNotNull(response);
		TestCase.assertEquals(this._id, response.get_id());
		TestCase.assertEquals(this.name, response.getName());
		TestCase.assertEquals(this.mascot, response.getMascot());
		TestCase.assertEquals(this.headOfHouse, response.getHeadOfHouse());
		TestCase.assertEquals(this.houseGhost, response.getHouseGhost());
		TestCase.assertEquals(this.founder, response.getFounder());
		TestCase.assertEquals(this.school, response.getSchool());
	}

	@Test
	public void getInstanceVaziaTest() {

		HouseResponseDTO response = new HouseResponseDTO();

		TestCase.assertNotNull(response);
		TestCase.assertEquals(null, response.get_id());
		TestCase.assertEquals(null, response.getName());
		TestCase.assertEquals(null, response.getMascot());
		TestCase.assertEquals(null, response.getHeadOfHouse());
		TestCase.assertEquals(null, response.getHouseGhost());
		TestCase.assertEquals(null, response.getFounder());
		TestCase.assertEquals(null, response.getSchool());
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

		TestCase.assertEquals(this._id, response.get_id());
		TestCase.assertEquals(this.name, response.getName());
		TestCase.assertEquals(this.mascot, response.getMascot());
		TestCase.assertEquals(this.headOfHouse, response.getHeadOfHouse());
		TestCase.assertEquals(this.houseGhost, response.getHouseGhost());
		TestCase.assertEquals(this.founder, response.getFounder());
		TestCase.assertEquals(this.school, response.getSchool());
	}
	
	@Test
	public void getEqualsTest() {

		HouseResponseDTO response = new HouseResponseDTO(this._id, this.name, this.mascot, 
				this.headOfHouse, this.houseGhost, this.founder, this.school);
		
		HouseResponseDTO response2 = new HouseResponseDTO(this._id, this.name, this.mascot, 
				this.headOfHouse, this.houseGhost, this.founder, this.school);

		TestCase.assertNotNull(response);
		TestCase.assertNotNull(response2);
		TestCase.assertEquals(response, response2);
	}
	
	@Test
	public void getHashCodeTest() {

		HouseResponseDTO response = new HouseResponseDTO(this._id, this.name, this.mascot, 
				this.headOfHouse, this.houseGhost, this.founder, this.school);
		
		HouseResponseDTO response2 = new HouseResponseDTO(this._id, this.name, this.mascot, 
				this.headOfHouse, this.houseGhost, this.founder, this.school);

		TestCase.assertNotNull(response);
		TestCase.assertNotNull(response2);
		TestCase.assertEquals(response.hashCode(), response2.hashCode());
	}
	
	@Test
	public void getToStringTest() {

		HouseResponseDTO response = new HouseResponseDTO(this._id, this.name, this.mascot, 
				this.headOfHouse, this.houseGhost, this.founder, this.school);

		TestCase.assertNotNull(response);
		TestCase.assertNotNull(response.toString());
	}


}
