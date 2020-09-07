package br.com.magicApi.dto;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.magicApi.EntityGenericUtil;
import junit.framework.TestCase;

/**
 * Classe de teste que representa os cenários de testes da classe {@link PersonagemRequestDTO}
 * @author Yallamy Nascimento (yallamy@gmail.com)
 * @since 6 de set de 2020
 */
@RunWith(SpringRunner.class)
public class PersonagemRequestDTOTest {
	
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

		PersonagemRequestDTO request = new PersonagemRequestDTO(this.id, this.name, this.role, 
				this.school, this.house, this.patronus);

		TestCase.assertNotNull(request);
		TestCase.assertEquals(this.id, request.getId());
		TestCase.assertEquals(this.name, request.getName());
		TestCase.assertEquals(this.role, request.getRole());
		TestCase.assertEquals(this.school, request.getSchool());
		TestCase.assertEquals(this.house, request.getHouse());
		TestCase.assertEquals(this.patronus, request.getPatronus());
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

		TestCase.assertEquals(this.id, request.getId());
		TestCase.assertEquals(this.name, request.getName());
		TestCase.assertEquals(this.role, request.getRole());
		TestCase.assertEquals(this.school, request.getSchool());
		TestCase.assertEquals(this.house, request.getHouse());
		TestCase.assertEquals(this.patronus, request.getPatronus());
	}
	
	@Test
	public void getEqualsTest() {

		PersonagemRequestDTO request = new PersonagemRequestDTO(this.id, this.name, this.role, 
				this.school, this.house, this.patronus);
		
		PersonagemRequestDTO request2 = new PersonagemRequestDTO(this.id, this.name, this.role, 
				this.school, this.house, this.patronus);

		TestCase.assertNotNull(request);
		TestCase.assertNotNull(request2);
		TestCase.assertEquals(request, request2);
	}
	
	@Test
	public void getHashCodeTest() {

		PersonagemRequestDTO request = new PersonagemRequestDTO(this.id, this.name, this.role, 
				this.school, this.house, this.patronus);
		
		PersonagemRequestDTO request2 = new PersonagemRequestDTO(this.id, this.name, this.role, 
				this.school, this.house, this.patronus);

		TestCase.assertNotNull(request);
		TestCase.assertNotNull(request2);
		TestCase.assertEquals(request.hashCode(), request2.hashCode());
	}
	
	@Test
	public void getToStringTest() {

		PersonagemRequestDTO request = new PersonagemRequestDTO(this.id, this.name, this.role, 
				this.school, this.house, this.patronus);

		TestCase.assertNotNull(request);
		TestCase.assertNotNull(request.toString());
	}

}
