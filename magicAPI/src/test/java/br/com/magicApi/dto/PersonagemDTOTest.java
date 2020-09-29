package br.com.magicApi.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.com.magicApi.EntityGenericUtil;

/**
 * Classe de teste que representa os cenários de testes da classe {@link PersonagemDTO}
 * @author Yallamy Nascimento (yallamy@gmail.com)
 * @since 6 de set de 2020
 */
public class PersonagemDTOTest {
	
	private Validator validator;
	
	private String name;
	
	private String role;
	
	private String school;
	
	private String house;
	
	private String patronus;

	@BeforeEach
	public void setup() {

		this.name = EntityGenericUtil.getString();
		this.role = EntityGenericUtil.getString();
		this.school = EntityGenericUtil.getString();
		this.house = EntityGenericUtil.getString();
		this.patronus = EntityGenericUtil.getString();
		
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        this.validator = factory.getValidator();
	}

	@Test
	public void getInstanceTest() {

		PersonagemDTO request = new PersonagemDTO(this.name, this.role, this.school, 
				this.house, this.patronus);

		assertNotNull(request);
		assertEquals(this.name, request.getName());
		assertEquals(this.role, request.getRole());
		assertEquals(this.school, request.getSchool());
		assertEquals(this.house, request.getHouse());
		assertEquals(this.patronus, request.getPatronus());
	}
	
	@Test
	public void getInstanceVaziaTest() {

		PersonagemDTO request = new PersonagemDTO();

		assertNotNull(request);
		assertEquals(null, request.getName());
		assertEquals(null, request.getRole());
		assertEquals(null, request.getSchool());
		assertEquals(null, request.getHouse());
		assertEquals(null, request.getPatronus());
	}
	
	@Test
	public void getInstanceTestNameNull() {

		PersonagemDTO request = new PersonagemDTO(null, this.role, this.school, 
				this.house, this.patronus);

		assertNotNull(request);
		Set<ConstraintViolation<PersonagemDTO>> violations = validator.validate(request);
		assertTrue(violations.size() == 1);
	}
	
	@Test
	public void getInstanceTestRoleNull() {

		PersonagemDTO request = new PersonagemDTO(this.name, null, this.school, 
				this.house, this.patronus);

		assertNotNull(request);
		Set<ConstraintViolation<PersonagemDTO>> violations = validator.validate(request);
		assertTrue(violations.size() == 1);
	}
	
	@Test
	public void getInstanceTestSchoolNull() {

		PersonagemDTO request = new PersonagemDTO(this.name, this.role, null, 
				this.house, this.patronus);

		assertNotNull(request);
		Set<ConstraintViolation<PersonagemDTO>> violations = validator.validate(request);
		assertTrue(violations.size() == 1);
	}

	@Test
	public void setAndGetAllFieldsTest() {

		PersonagemDTO request = new PersonagemDTO(EntityGenericUtil.getString(), 
				EntityGenericUtil.getString(), EntityGenericUtil.getString(), 
				EntityGenericUtil.getString(), EntityGenericUtil.getString());
		
		request.setName(this.name);
		request.setRole(this.role);
		request.setSchool(this.school);
		request.setHouse(this.house);
		request.setPatronus(this.patronus);

		assertEquals(this.name, request.getName());
		assertEquals(this.role, request.getRole());
		assertEquals(this.school, request.getSchool());
		assertEquals(this.house, request.getHouse());
		assertEquals(this.patronus, request.getPatronus());
	}
	
	@Test
	public void getEqualsTest() {

		PersonagemDTO request = new PersonagemDTO(this.name, this.role, this.school, 
				this.house, this.patronus);
		
		PersonagemDTO request2 = new PersonagemDTO(this.name, this.role, this.school, 
				this.house, this.patronus);

		assertNotNull(request);
		assertNotNull(request2);
		assertEquals(request, request2);
	}
	
	@Test
	public void getHashCodeTest() {

		PersonagemDTO request = new PersonagemDTO(this.name, this.role, this.school, 
				this.house, this.patronus);
		
		PersonagemDTO request2 = new PersonagemDTO(this.name, this.role, this.school, 
				this.house, this.patronus);

		assertNotNull(request);
		assertNotNull(request2);
		assertEquals(request.hashCode(), request2.hashCode());
	}
	
	@Test
	public void getToStringTest() {

		PersonagemDTO request = new PersonagemDTO(this.name, this.role, this.school, 
				this.house, this.patronus);

		assertNotNull(request);
		assertNotNull(request.toString());
	}
}
