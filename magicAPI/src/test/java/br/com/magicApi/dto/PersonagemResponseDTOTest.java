package br.com.magicApi.dto;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.magicApi.EntityGenericUtil;
import junit.framework.TestCase;

/**
 * Classe de teste que representa os cenários de testes da classe {@link PersonagemResponseDTO}
 * @author Yallamy Nascimento (yallamy@gmail.com)
 * @since 6 de set de 2020
 */
@RunWith(SpringRunner.class)
public class PersonagemResponseDTOTest {

	private Long id;
	
	private String name;
	
	private String role;
	
	private String school;
	
	private String house;
	
	private String patronus;
	
	@Before
	public void setup() {

		this.id = EntityGenericUtil.getLong();
		this.name = EntityGenericUtil.getString();
		this.role = EntityGenericUtil.getString();
		this.school = EntityGenericUtil.getString();
		this.house = EntityGenericUtil.getString();
		this.patronus = EntityGenericUtil.getString();
	}

	@Test
	public void getInstanceTest() {

		PersonagemResponseDTO response = new PersonagemResponseDTO(this.id, this.name, this.role, 
				this.school, this.house, this.patronus);

		TestCase.assertNotNull(response);
		TestCase.assertEquals(this.id, response.getId());
		TestCase.assertEquals(this.name, response.getName());
		TestCase.assertEquals(this.role, response.getRole());
		TestCase.assertEquals(this.school, response.getSchool());
		TestCase.assertEquals(this.house, response.getHouse());
		TestCase.assertEquals(this.patronus, response.getPatronus());
	}
	
	@Test
	public void getInstanceVaziaTest() {

		PersonagemResponseDTO response = new PersonagemResponseDTO();

		TestCase.assertNotNull(response);
		TestCase.assertEquals(null, response.getId());
		TestCase.assertEquals(null, response.getName());
		TestCase.assertEquals(null, response.getRole());
		TestCase.assertEquals(null, response.getSchool());
		TestCase.assertEquals(null, response.getHouse());
		TestCase.assertEquals(null, response.getPatronus());
	}

	@Test
	public void setAndGetAllFieldsTest() {

		PersonagemResponseDTO response = new PersonagemResponseDTO(
				EntityGenericUtil.getLong(), EntityGenericUtil.getString(), 
				EntityGenericUtil.getString(), EntityGenericUtil.getString(), 
				EntityGenericUtil.getString(), EntityGenericUtil.getString());
		
		response.setId(this.id);
		response.setName(this.name);
		response.setRole(this.role);
		response.setSchool(this.school);
		response.setHouse(this.house);
		response.setPatronus(this.patronus);

		TestCase.assertEquals(this.id, response.getId());
		TestCase.assertEquals(this.name, response.getName());
		TestCase.assertEquals(this.role, response.getRole());
		TestCase.assertEquals(this.school, response.getSchool());
		TestCase.assertEquals(this.house, response.getHouse());
		TestCase.assertEquals(this.patronus, response.getPatronus());
	}
	
	@Test
	public void getEqualsTest() {

		PersonagemResponseDTO response = new PersonagemResponseDTO(this.id, this.name, this.role, 
				this.school, this.house, this.patronus);
		
		PersonagemResponseDTO response2 = new PersonagemResponseDTO(this.id, this.name, this.role, 
				this.school, this.house, this.patronus);

		TestCase.assertNotNull(response);
		TestCase.assertNotNull(response2);
		TestCase.assertEquals(response, response2);
	}
	
	@Test
	public void getHashCodeTest() {

		PersonagemResponseDTO response = new PersonagemResponseDTO(this.id, this.name, this.role, 
				this.school, this.house, this.patronus);
		
		PersonagemResponseDTO response2 = new PersonagemResponseDTO(this.id, this.name, this.role, 
				this.school, this.house, this.patronus);

		TestCase.assertNotNull(response);
		TestCase.assertNotNull(response2);
		TestCase.assertEquals(response.hashCode(), response2.hashCode());
	}
	
	@Test
	public void getToStringTest() {

		PersonagemResponseDTO response = new PersonagemResponseDTO(this.id, this.name, this.role, 
				this.school, this.house, this.patronus);

		TestCase.assertNotNull(response);
		TestCase.assertNotNull(response.toString());
	}

}
