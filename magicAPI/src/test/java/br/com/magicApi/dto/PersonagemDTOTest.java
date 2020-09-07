package br.com.magicApi.dto;

import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.hasToString;
import static org.junit.Assert.assertThat;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.magicApi.EntityGenericUtil;
import junit.framework.TestCase;

/**
 * Classe de teste que representa os cenários de testes da classe {@link PersonagemDTO}
 * @author Yallamy Nascimento (yallamy@gmail.com)
 * @since 6 de set de 2020
 */
@RunWith(SpringRunner.class)
public class PersonagemDTOTest {
	
	private Validator validator;
	
	private String name;
	
	private String role;
	
	private String school;
	
	private String house;
	
	private String patronus;

	@Before
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

		TestCase.assertNotNull(request);
		TestCase.assertEquals(this.name, request.getName());
		TestCase.assertEquals(this.role, request.getRole());
		TestCase.assertEquals(this.school, request.getSchool());
		TestCase.assertEquals(this.house, request.getHouse());
		TestCase.assertEquals(this.patronus, request.getPatronus());
	}
	
	@Test
	public void getInstanceVaziaTest() {

		PersonagemDTO request = new PersonagemDTO();

		TestCase.assertNotNull(request);
		TestCase.assertEquals(null, request.getName());
		TestCase.assertEquals(null, request.getRole());
		TestCase.assertEquals(null, request.getSchool());
		TestCase.assertEquals(null, request.getHouse());
		TestCase.assertEquals(null, request.getPatronus());
	}
	
	@Test
	public void getInstanceTestNameNull() {

		PersonagemDTO request = new PersonagemDTO(null, this.role, this.school, 
				this.house, this.patronus);

		TestCase.assertNotNull(request);
		Set<ConstraintViolation<PersonagemDTO>> violations = validator.validate(request);
		assertTrue(violations.size() == 1);
		assertThat(violations, contains(hasProperty("propertyPath", hasToString("name"))));
	}
	
	@Test
	public void getInstanceTestRoleNull() {

		PersonagemDTO request = new PersonagemDTO(this.name, null, this.school, 
				this.house, this.patronus);

		TestCase.assertNotNull(request);
		Set<ConstraintViolation<PersonagemDTO>> violations = validator.validate(request);
		assertTrue(violations.size() == 1);
		assertThat(violations, contains(hasProperty("propertyPath", hasToString("role"))));
	}
	
	@Test
	public void getInstanceTestSchoolNull() {

		PersonagemDTO request = new PersonagemDTO(this.name, this.role, null, 
				this.house, this.patronus);

		TestCase.assertNotNull(request);
		Set<ConstraintViolation<PersonagemDTO>> violations = validator.validate(request);
		assertTrue(violations.size() == 1);
		assertThat(violations, contains(hasProperty("propertyPath", hasToString("school"))));
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

		TestCase.assertEquals(this.name, request.getName());
		TestCase.assertEquals(this.role, request.getRole());
		TestCase.assertEquals(this.school, request.getSchool());
		TestCase.assertEquals(this.house, request.getHouse());
		TestCase.assertEquals(this.patronus, request.getPatronus());
	}
	
	@Test
	public void getEqualsTest() {

		PersonagemDTO request = new PersonagemDTO(this.name, this.role, this.school, 
				this.house, this.patronus);
		
		PersonagemDTO request2 = new PersonagemDTO(this.name, this.role, this.school, 
				this.house, this.patronus);

		TestCase.assertNotNull(request);
		TestCase.assertNotNull(request2);
		TestCase.assertEquals(request, request2);
	}
	
	@Test
	public void getHashCodeTest() {

		PersonagemDTO request = new PersonagemDTO(this.name, this.role, this.school, 
				this.house, this.patronus);
		
		PersonagemDTO request2 = new PersonagemDTO(this.name, this.role, this.school, 
				this.house, this.patronus);

		TestCase.assertNotNull(request);
		TestCase.assertNotNull(request2);
		TestCase.assertEquals(request.hashCode(), request2.hashCode());
	}
	
	@Test
	public void getToStringTest() {

		PersonagemDTO request = new PersonagemDTO(this.name, this.role, this.school, 
				this.house, this.patronus);

		TestCase.assertNotNull(request);
		TestCase.assertNotNull(request.toString());
	}
}
