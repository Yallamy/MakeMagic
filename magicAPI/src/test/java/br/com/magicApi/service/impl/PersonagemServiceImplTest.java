package br.com.magicApi.service.impl;

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
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.magicApi.EntityGenericUtil;
import br.com.magicApi.dto.externo.HouseRequestDTO;
import br.com.magicApi.dto.externo.HouseResponseDTO;
import br.com.magicApi.entity.Personagem;
import br.com.magicApi.exception.CustomException;
import br.com.magicApi.externo.rest.PotterApiClient;
import br.com.magicApi.repository.PersonagemRepository;
import junit.framework.TestCase;

/**
 * Classe de teste que representa os cenários de testes da classe {@link PersonagemServiceImpl}
 * @author Yallamy Nascimento (yallamy@gmail.com)
 * @since 6 de set de 2020
 */
@RunWith(SpringRunner.class)
public class PersonagemServiceImplTest {

	@InjectMocks
	private PersonagemServiceImpl personagemServiceImpl;
	
	@Mock
	private PersonagemRepository repository;
	
	@Mock
	private PotterApiClient potterApiClient;
	
	@Mock
	private HouseResponseDTO houseResponse;
	
	private Personagem personagem;
	
	private Page<Personagem> page;
	
	private Pageable pageable;
	
	private Validator validator;

	@SuppressWarnings("unchecked")
	@Before
	public void setup() throws CustomException {
		
		this.personagem = Personagem.builder()
				.id(EntityGenericUtil.getLong())
				.name(EntityGenericUtil.getString())
				.role(EntityGenericUtil.getString())
				.school(EntityGenericUtil.getString())
				.house(EntityGenericUtil.getString())
				.patronus(EntityGenericUtil.getString())
				.build();
		
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        this.validator = factory.getValidator();

		Mockito.when(this.potterApiClient.getHouse(
				Mockito.any(HouseRequestDTO.class))).thenReturn(this.houseResponse);
		Mockito.when(this.repository.save(
				Mockito.any(Personagem.class))).thenReturn(this.personagem);
		Mockito.when(this.repository.getOne(
				Mockito.any(Long.class))).thenReturn(this.personagem);
		Mockito.when(this.repository.findAll(
				Mockito.any(Example.class), Mockito.any(Pageable.class))).thenReturn(this.page);
		
	}
	
	//create
	@Test
	public void createTest() throws CustomException {

		Personagem request = Personagem.builder()
				.name(EntityGenericUtil.getString())
				.role(EntityGenericUtil.getString())
				.school(EntityGenericUtil.getString())
				.house(EntityGenericUtil.getString())
				.patronus(EntityGenericUtil.getString())
				.build();
		
		Personagem response = this.personagemServiceImpl.create(request);

		TestCase.assertNotNull(response);
		TestCase.assertNotNull(response.getId());
	}
	
	@Test
	public void createPersonagemSemHouseTest() throws CustomException {

		Personagem request = Personagem.builder()
				.name(EntityGenericUtil.getString())
				.role(EntityGenericUtil.getString())
				.school(EntityGenericUtil.getString())
				.patronus(EntityGenericUtil.getString())
				.build();
		
		Personagem response = this.personagemServiceImpl.create(request);

		TestCase.assertNotNull(response);
		TestCase.assertNotNull(response.getId());
	}
	
	@Test(expected=CustomException.class)
	public void createPersonagemSemNameTest() throws CustomException {

		Personagem request = Personagem.builder()
				.role(EntityGenericUtil.getString())
				.school(EntityGenericUtil.getString())
				.house(EntityGenericUtil.getString())
				.patronus(EntityGenericUtil.getString())
				.build();
		
		Personagem response = this.personagemServiceImpl.create(request);

		TestCase.assertNotNull(response);
		Set<ConstraintViolation<Personagem>> violations = validator.validate(request);
		assertTrue(violations.size() == 1);
		assertThat(violations, contains(hasProperty("propertyPath", hasToString("name"))));
	}
	
	@Test(expected=CustomException.class)
	public void createPersonagemSemRoleTest() throws CustomException {

		Personagem request = Personagem.builder()
				.name(EntityGenericUtil.getString())
				.school(EntityGenericUtil.getString())
				.house(EntityGenericUtil.getString())
				.patronus(EntityGenericUtil.getString())
				.build();
		
		Personagem response = this.personagemServiceImpl.create(request);

		TestCase.assertNotNull(response);
		Set<ConstraintViolation<Personagem>> violations = validator.validate(request);
		assertTrue(violations.size() == 1);
		assertThat(violations, contains(hasProperty("propertyPath", hasToString("role"))));
	}
	
	@Test(expected=CustomException.class)
	public void createPersonagemSemSchoolTest() throws CustomException {

		Personagem request = Personagem.builder()
				.name(EntityGenericUtil.getString())
				.role(EntityGenericUtil.getString())
				.house(EntityGenericUtil.getString())
				.patronus(EntityGenericUtil.getString())
				.build();
		
		Personagem response = this.personagemServiceImpl.create(request);

		TestCase.assertNotNull(response);
		Set<ConstraintViolation<Personagem>> violations = validator.validate(request);
		assertTrue(violations.size() == 1);
		assertThat(violations, contains(hasProperty("propertyPath", hasToString("school"))));
	}
	
	//update
	@Test
	public void updateTest() throws CustomException {

		Personagem request = Personagem.builder()
				.name(EntityGenericUtil.getString())
				.role(EntityGenericUtil.getString())
				.school(EntityGenericUtil.getString())
				.house(EntityGenericUtil.getString())
				.patronus(EntityGenericUtil.getString())
				.build();
		
		this.personagemServiceImpl.update(request);
	}
	
	@Test
	public void updatePersonagemSemHouseTest() throws CustomException {

		Personagem request = Personagem.builder()
				.name(EntityGenericUtil.getString())
				.role(EntityGenericUtil.getString())
				.school(EntityGenericUtil.getString())
				.patronus(EntityGenericUtil.getString())
				.build();
		
		this.personagemServiceImpl.update(request);
	}
	
	@Test(expected=CustomException.class)
	public void updatePersonagemSemNameTest() throws CustomException {

		Personagem request = Personagem.builder()
				.role(EntityGenericUtil.getString())
				.school(EntityGenericUtil.getString())
				.house(EntityGenericUtil.getString())
				.patronus(EntityGenericUtil.getString())
				.build();
		
		this.personagemServiceImpl.update(request);

		Set<ConstraintViolation<Personagem>> violations = validator.validate(request);
		assertTrue(violations.size() == 1);
		assertThat(violations, contains(hasProperty("propertyPath", hasToString("name"))));
	}
	
	@Test(expected=CustomException.class)
	public void updatePersonagemSemRoleTest() throws CustomException {

		Personagem request = Personagem.builder()
				.name(EntityGenericUtil.getString())
				.school(EntityGenericUtil.getString())
				.house(EntityGenericUtil.getString())
				.patronus(EntityGenericUtil.getString())
				.build();
		
		this.personagemServiceImpl.update(request);

		Set<ConstraintViolation<Personagem>> violations = validator.validate(request);
		assertTrue(violations.size() == 1);
		assertThat(violations, contains(hasProperty("propertyPath", hasToString("role"))));
	}
	
	@Test(expected=CustomException.class)
	public void updatePersonagemSemSchoolTest() throws CustomException {

		Personagem request = Personagem.builder()
				.name(EntityGenericUtil.getString())
				.role(EntityGenericUtil.getString())
				.house(EntityGenericUtil.getString())
				.patronus(EntityGenericUtil.getString())
				.build();
		
		this.personagemServiceImpl.update(request);

		Set<ConstraintViolation<Personagem>> violations = validator.validate(request);
		assertTrue(violations.size() == 1);
		assertThat(violations, contains(hasProperty("propertyPath", hasToString("school"))));
	}
	
	//retrieve
	@Test(expected=CustomException.class)
	public void retrieveTest() throws CustomException {
		
		Personagem response = this.personagemServiceImpl.retrieve(EntityGenericUtil.getLong());

		TestCase.assertNotNull(response);
		TestCase.assertNotNull(response.getId());
		TestCase.assertEquals(this.personagem, response);
	}
	
	@Test
	public void retrieveNotFoundTest() throws CustomException {
		
		Mockito.when(this.repository.getOne(
				Mockito.any(Long.class))).thenReturn(null);
		
		Personagem response = this.personagemServiceImpl.retrieve(EntityGenericUtil.getLong());

		TestCase.assertNull(response);
	}
	
	@Test(expected=CustomException.class)
	public void retrieveComNullTest() throws CustomException {
		
		Mockito.when(this.repository.getOne(
				Mockito.any(Long.class))).thenReturn(null);
		
		Personagem response = this.personagemServiceImpl.retrieve(EntityGenericUtil.getLong());

		TestCase.assertNotNull(response);
	}
	
	//delete
	@Test
	public void deleteTest() throws CustomException {
		
		this.personagemServiceImpl.delete(this.personagem);
	}
	
	@Test(expected=CustomException.class)
	public void deletePersonagemNullTest() throws CustomException {
		
		this.personagemServiceImpl.delete(null);
	}
	
	@Test(expected=CustomException.class)
	public void deletePersonagemSemIdTest() throws CustomException {

		Personagem request = Personagem.builder()
				.name(EntityGenericUtil.getString())
				.role(EntityGenericUtil.getString())
				.school(EntityGenericUtil.getString())
				.house(EntityGenericUtil.getString())
				.patronus(EntityGenericUtil.getString())
				.build();
		
		this.personagemServiceImpl.delete(request);
	}
	
	//list
	@Test
	public void listTest() throws CustomException {

		Personagem request = Personagem.builder()
				.build();
		
		Page<Personagem> response = this.personagemServiceImpl.list(request, pageable);

		TestCase.assertNotNull(response);
		TestCase.assertNotNull(response.getContent().size() == 1);
	}
	
	@Test
	public void listComPersonagemNullTest() throws CustomException {
		
		Page<Personagem> response = this.personagemServiceImpl.list(null, pageable);

		TestCase.assertNotNull(response);
		TestCase.assertNotNull(response.getContent().size() == 1);
	}
	
	@Test(expected=CustomException.class)
	public void listComPageableNullTest() throws CustomException {
		
		Personagem request = Personagem.builder()
				.build();
		
		Page<Personagem> response = this.personagemServiceImpl.list(request, null);

		TestCase.assertNotNull(response);
		TestCase.assertNotNull(response.getContent().size() == 1);
	}
	
	@Test
	public void listPorIdTest() throws CustomException {

		Personagem request = Personagem.builder()
				.id(EntityGenericUtil.getLong())
				.build();
		
		Page<Personagem> response = this.personagemServiceImpl.list(request, pageable);

		TestCase.assertNotNull(response);
		TestCase.assertNotNull(response.getContent().size() == 1);
	}
	
	@Test
	public void listPorNameTest() throws CustomException {

		Personagem request = Personagem.builder()
				.name(EntityGenericUtil.getString())
				.build();
		
		Page<Personagem> response = this.personagemServiceImpl.list(request, pageable);

		TestCase.assertNotNull(response);
		TestCase.assertNotNull(response.getContent().size() == 1);
	}
	
	@Test
	public void listPorRoleTest() throws CustomException {

		Personagem request = Personagem.builder()
				.role(EntityGenericUtil.getString())
				.build();
		
		Page<Personagem> response = this.personagemServiceImpl.list(request, pageable);

		TestCase.assertNotNull(response);
		TestCase.assertNotNull(response.getContent().size() == 1);
	}
	
	
	@Test
	public void listPorSchoolTest() throws CustomException {

		Personagem request = Personagem.builder()
				.school(EntityGenericUtil.getString())
				.build();
		
		Page<Personagem> response = this.personagemServiceImpl.list(request, pageable);

		TestCase.assertNotNull(response);
		TestCase.assertNotNull(response.getContent().size() == 1);
	}
	
	
	@Test
	public void listPorHouseTest() throws CustomException {

		Personagem request = Personagem.builder()
				.house(EntityGenericUtil.getString())
				.build();
		
		Page<Personagem> response = this.personagemServiceImpl.list(request, pageable);

		TestCase.assertNotNull(response);
		TestCase.assertNotNull(response.getContent().size() == 1);
	}
	
	@Test
	public void listPorPatronusTest() throws CustomException {

		Personagem request = Personagem.builder()
				.patronus(EntityGenericUtil.getString())
				.build();
		
		Page<Personagem> response = this.personagemServiceImpl.list(request, pageable);

		TestCase.assertNotNull(response);
		TestCase.assertNotNull(response.getContent().size() == 1);
	}
}
