package br.com.magicApi.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.magicApi.EntityGenericUtil;

/**
 * Classe de teste que representa os cenários de testes da classe {@link PersonagemResponseDTO}
 * @author Yallamy Nascimento (yallamy@gmail.com)
 * @since 6 de set de 2020
 */
public class PersonagemResponseDTOTest {

	private Long id;
	
	private String name;
	
	private String role;
	
	private String school;
	
	private String house;
	
	private String patronus;
	
	@BeforeEach
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

		assertNotNull(response);
		assertEquals(this.id, response.getId());
		assertEquals(this.name, response.getName());
		assertEquals(this.role, response.getRole());
		assertEquals(this.school, response.getSchool());
		assertEquals(this.house, response.getHouse());
		assertEquals(this.patronus, response.getPatronus());
	}
	
	@Test
	public void getInstanceVaziaTest() {

		PersonagemResponseDTO response = new PersonagemResponseDTO();

		assertNotNull(response);
		assertEquals(null, response.getId());
		assertEquals(null, response.getName());
		assertEquals(null, response.getRole());
		assertEquals(null, response.getSchool());
		assertEquals(null, response.getHouse());
		assertEquals(null, response.getPatronus());
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

		assertEquals(this.id, response.getId());
		assertEquals(this.name, response.getName());
		assertEquals(this.role, response.getRole());
		assertEquals(this.school, response.getSchool());
		assertEquals(this.house, response.getHouse());
		assertEquals(this.patronus, response.getPatronus());
	}
	
	@Test
	public void getEqualsTest() {

		PersonagemResponseDTO response = new PersonagemResponseDTO(this.id, this.name, this.role, 
				this.school, this.house, this.patronus);
		
		PersonagemResponseDTO response2 = new PersonagemResponseDTO(this.id, this.name, this.role, 
				this.school, this.house, this.patronus);

		assertNotNull(response);
		assertNotNull(response2);
		assertEquals(response, response2);
	}
	
	@Test
	public void getHashCodeTest() {

		PersonagemResponseDTO response = new PersonagemResponseDTO(this.id, this.name, this.role, 
				this.school, this.house, this.patronus);
		
		PersonagemResponseDTO response2 = new PersonagemResponseDTO(this.id, this.name, this.role, 
				this.school, this.house, this.patronus);

		assertNotNull(response);
		assertNotNull(response2);
		assertEquals(response.hashCode(), response2.hashCode());
	}
	
	@Test
	public void getToStringTest() {

		PersonagemResponseDTO response = new PersonagemResponseDTO(this.id, this.name, this.role, 
				this.school, this.house, this.patronus);

		assertNotNull(response);
		assertNotNull(response.toString());
	}

}
