package br.com.magicApi.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.magicApi.EntityGenericUtil;

/**
 * Classe de teste que representa os cenários de testes da classe {@link PersonagemRequestDTO}
 * @author Yallamy Nascimento (yallamy@gmail.com)
 * @since 6 de set de 2020
 */
public class PersonagemRequestDTOTest {
	
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

		PersonagemRequestDTO request = new PersonagemRequestDTO(this.id, this.name, this.role, 
				this.school, this.house, this.patronus);

		assertNotNull(request);
		assertEquals(this.id, request.getId());
		assertEquals(this.name, request.getName());
		assertEquals(this.role, request.getRole());
		assertEquals(this.school, request.getSchool());
		assertEquals(this.house, request.getHouse());
		assertEquals(this.patronus, request.getPatronus());
	}
	
	@Test
	public void getInstanceVaziaTest() {

		PersonagemRequestDTO request = new PersonagemRequestDTO();

		assertNotNull(request);
		assertEquals(null, request.getId());
		assertEquals(null, request.getName());
		assertEquals(null, request.getRole());
		assertEquals(null, request.getSchool());
		assertEquals(null, request.getHouse());
		assertEquals(null, request.getPatronus());
	}

	@Test
	public void setAndGetAllFieldsTest() {

		PersonagemRequestDTO request = new PersonagemRequestDTO(
				EntityGenericUtil.getLong(), EntityGenericUtil.getString(), 
				EntityGenericUtil.getString(), EntityGenericUtil.getString(), 
				EntityGenericUtil.getString(), EntityGenericUtil.getString());
		
		request.setId(this.id);
		request.setName(this.name);
		request.setRole(this.role);
		request.setSchool(this.school);
		request.setHouse(this.house);
		request.setPatronus(this.patronus);

		assertEquals(this.id, request.getId());
		assertEquals(this.name, request.getName());
		assertEquals(this.role, request.getRole());
		assertEquals(this.school, request.getSchool());
		assertEquals(this.house, request.getHouse());
		assertEquals(this.patronus, request.getPatronus());
	}
	
	@Test
	public void getEqualsTest() {

		PersonagemRequestDTO request = new PersonagemRequestDTO(this.id, this.name, this.role, 
				this.school, this.house, this.patronus);
		
		PersonagemRequestDTO request2 = new PersonagemRequestDTO(this.id, this.name, this.role, 
				this.school, this.house, this.patronus);

		assertNotNull(request);
		assertNotNull(request2);
		assertEquals(request, request2);
	}
	
	@Test
	public void getHashCodeTest() {

		PersonagemRequestDTO request = new PersonagemRequestDTO(this.id, this.name, this.role, 
				this.school, this.house, this.patronus);
		
		PersonagemRequestDTO request2 = new PersonagemRequestDTO(this.id, this.name, this.role, 
				this.school, this.house, this.patronus);

		assertNotNull(request);
		assertNotNull(request2);
		assertEquals(request.hashCode(), request2.hashCode());
	}
	
	@Test
	public void getToStringTest() {

		PersonagemRequestDTO request = new PersonagemRequestDTO(this.id, this.name, this.role, 
				this.school, this.house, this.patronus);

		assertNotNull(request);
		assertNotNull(request.toString());
	}

}
