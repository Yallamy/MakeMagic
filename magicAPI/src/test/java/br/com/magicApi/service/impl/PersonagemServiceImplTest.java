package br.com.magicApi.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.NoSuchElementException;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.magicApi.EntityGenericUtil;
import br.com.magicApi.dto.externo.HouseRequestDTO;
import br.com.magicApi.dto.externo.HouseResponseDTO;
import br.com.magicApi.entity.Personagem;
import br.com.magicApi.exception.CustomException;
import br.com.magicApi.externo.rest.PotterApiClient;
import br.com.magicApi.repository.PersonagemRepository;

/**
 * Classe de teste que representa os cenários de testes da classe {@link PersonagemServiceImpl}
 * @author Yallamy Nascimento (yallamy@gmail.com)
 * @since 6 de set de 2020
 */
@SpringBootTest
public class PersonagemServiceImplTest {

	@InjectMocks
	private PersonagemServiceImpl personagemServiceImpl;
	
	@Mock
	private PersonagemRepository repository;
	
	@Mock
	private PotterApiClient potterApiClient;
	
	@Mock
	private HouseResponseDTO houseResponse;
	
	@Mock
	private Pageable pageable;
	
	@Mock
	private Page<Personagem> page;
	
	private Optional<Personagem> personagemResponse;
	
	private Personagem personagem;

	@SuppressWarnings("unchecked")
	@BeforeEach
	public void setup() throws CustomException {
		
		this.personagem = Personagem.builder()
				.id(EntityGenericUtil.getLong())
				.name(EntityGenericUtil.getString())
				.role(EntityGenericUtil.getString())
				.school(EntityGenericUtil.getString())
				.house(EntityGenericUtil.getString())
				.patronus(EntityGenericUtil.getString())
				.build();
		
		personagemResponse = Optional.of(this.personagem);

		Mockito.when(this.potterApiClient.getHouse(
				Mockito.any(HouseRequestDTO.class))).thenReturn(this.houseResponse);
		Mockito.when(this.repository.save(
				Mockito.any(Personagem.class))).thenReturn(this.personagem);
		Mockito.when(this.repository.findById(
				Mockito.any(Long.class))).thenReturn(this.personagemResponse);
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
		
		this.personagemServiceImpl.init();
		Personagem response = this.personagemServiceImpl.create(request);

		assertNotNull(response);
		assertNotNull(response.getId());
	}
	
	@Test
	public void createPersonagemSemHouseTest() throws CustomException {

		Personagem request = Personagem.builder()
				.name(EntityGenericUtil.getString())
				.role(EntityGenericUtil.getString())
				.school(EntityGenericUtil.getString())
				.patronus(EntityGenericUtil.getString())
				.build();
		
		this.personagemServiceImpl.init();
		Personagem response = this.personagemServiceImpl.create(request);

		assertNotNull(response);
		assertNotNull(response.getId());
	}
	
	@Test()
	public void createPersonagemSemNameTest() throws CustomException {

		Personagem request = Personagem.builder()
				.role(EntityGenericUtil.getString())
				.school(EntityGenericUtil.getString())
				.house(EntityGenericUtil.getString())
				.patronus(EntityGenericUtil.getString())
				.build();
		
		this.personagemServiceImpl.init();
		
		assertThrows(CustomException.class, () -> {
			this.personagemServiceImpl.create(request);
		});
	}
	
	@Test()
	public void createPersonagemSemRoleTest() throws CustomException {

		Personagem request = Personagem.builder()
				.name(EntityGenericUtil.getString())
				.school(EntityGenericUtil.getString())
				.house(EntityGenericUtil.getString())
				.patronus(EntityGenericUtil.getString())
				.build();
		
		this.personagemServiceImpl.init();
		
		assertThrows(CustomException.class, () -> {
			this.personagemServiceImpl.create(request);
		});
	}
	
	@Test()
	public void createPersonagemSemSchoolTest() throws CustomException {

		Personagem request = Personagem.builder()
				.name(EntityGenericUtil.getString())
				.role(EntityGenericUtil.getString())
				.house(EntityGenericUtil.getString())
				.patronus(EntityGenericUtil.getString())
				.build();
		
		this.personagemServiceImpl.init();

		assertThrows(CustomException.class, () -> {
			this.personagemServiceImpl.create(request);
		});
	}
	
	//update
	@Test
	public void updateTest() throws CustomException {

		Personagem request = Personagem.builder()
				.id(EntityGenericUtil.getLong())
				.name(EntityGenericUtil.getString())
				.role(EntityGenericUtil.getString())
				.school(EntityGenericUtil.getString())
				.house(EntityGenericUtil.getString())
				.patronus(EntityGenericUtil.getString())
				.build();
		
		this.personagemServiceImpl.init();
		this.personagemServiceImpl.update(request);
	}
	
	@Test()
	public void updatePersonagemNotFoundTest() throws CustomException {
		
		Mockito.when(this.repository.findById(
				Mockito.any(Long.class))).thenThrow(NoSuchElementException.class);

		Personagem request = Personagem.builder()
				.id(EntityGenericUtil.getLong())
				.name(EntityGenericUtil.getString())
				.role(EntityGenericUtil.getString())
				.school(EntityGenericUtil.getString())
				.house(EntityGenericUtil.getString())
				.patronus(EntityGenericUtil.getString())
				.build();
		
		this.personagemServiceImpl.init();
		
		assertThrows(CustomException.class, () -> {
			this.personagemServiceImpl.update(request);
		});
	}
	
	@Test
	public void updatePersonagemSemHouseTest() throws CustomException {

		Personagem request = Personagem.builder()
				.id(EntityGenericUtil.getLong())
				.name(EntityGenericUtil.getString())
				.role(EntityGenericUtil.getString())
				.school(EntityGenericUtil.getString())
				.patronus(EntityGenericUtil.getString())
				.build();
		
		this.personagemServiceImpl.init();
		this.personagemServiceImpl.update(request);
	}
	
	@Test()
	public void updatePersonagemSemNameTest() throws CustomException {

		Personagem request = Personagem.builder()
				.id(EntityGenericUtil.getLong())
				.role(EntityGenericUtil.getString())
				.school(EntityGenericUtil.getString())
				.house(EntityGenericUtil.getString())
				.patronus(EntityGenericUtil.getString())
				.build();
		
		this.personagemServiceImpl.init();

		assertThrows(CustomException.class, () -> {
			this.personagemServiceImpl.update(request);
		});
	}
	
	@Test()
	public void updatePersonagemSemRoleTest() throws CustomException {

		Personagem request = Personagem.builder()
				.id(EntityGenericUtil.getLong())
				.name(EntityGenericUtil.getString())
				.school(EntityGenericUtil.getString())
				.house(EntityGenericUtil.getString())
				.patronus(EntityGenericUtil.getString())
				.build();
		
		this.personagemServiceImpl.init();
		
		assertThrows(CustomException.class, () -> {
			this.personagemServiceImpl.update(request);
		});
	}
	
	@Test()
	public void updatePersonagemSemSchoolTest() throws CustomException {

		Personagem request = Personagem.builder()
				.id(EntityGenericUtil.getLong())
				.name(EntityGenericUtil.getString())
				.role(EntityGenericUtil.getString())
				.house(EntityGenericUtil.getString())
				.patronus(EntityGenericUtil.getString())
				.build();
		
		this.personagemServiceImpl.init();
		
		assertThrows(CustomException.class, () -> {
			this.personagemServiceImpl.update(request);
		});
	}
	
	//retrieve
	@Test
	public void retrieveTest() throws CustomException {
		
		Personagem response = this.personagemServiceImpl.retrieve(EntityGenericUtil.getLong());

		assertNotNull(response);
		assertNotNull(response.getId());
		assertEquals(this.personagem, response);
	}
	
	@Test()
	public void retrieveNotFoundTest() throws CustomException {
		
		Mockito.when(this.repository.findById(
				Mockito.any(Long.class))).thenThrow(NoSuchElementException.class);
		
		assertThrows(CustomException.class, () -> {
			this.personagemServiceImpl.retrieve(EntityGenericUtil.getLong());
		});
	}
	
	@Test()
	public void retrieveComNullTest() throws CustomException {
		
		Mockito.when(this.repository.findById(
				Mockito.any(Long.class))).thenReturn(null);
		
		assertThrows(CustomException.class, () -> {
			this.personagemServiceImpl.retrieve(null);
		});
	}
	
	//delete
	@Test
	public void deleteTest() throws CustomException {
		
		this.personagemServiceImpl.delete(this.personagem);
	}
	
	@Test()
	public void deleteNotFoundTest() throws CustomException {
		
		Mockito.when(this.repository.findById(
				Mockito.any(Long.class))).thenThrow(NoSuchElementException.class);
		
		assertThrows(CustomException.class, () -> {
			this.personagemServiceImpl.delete(this.personagem);
		});
	}
	
	@Test()
	public void deletePersonagemNullTest() throws CustomException {
		
		assertThrows(CustomException.class, () -> {
			this.personagemServiceImpl.delete(null);
		});
	}
	
	@Test()
	public void deletePersonagemSemIdTest() throws CustomException {

		Personagem request = Personagem.builder()
				.name(EntityGenericUtil.getString())
				.role(EntityGenericUtil.getString())
				.school(EntityGenericUtil.getString())
				.house(EntityGenericUtil.getString())
				.patronus(EntityGenericUtil.getString())
				.build();
		
		assertThrows(CustomException.class, () -> {
			this.personagemServiceImpl.delete(request);
		});
	}
	
	//list
	@Test
	public void listTest() throws CustomException {

		Personagem request = Personagem.builder()
				.build();
		
		Page<Personagem> response = this.personagemServiceImpl.list(request, pageable);

		assertNotNull(response);
		assertNotNull(response.getContent().size() == 1);
	}
	
	@Test
	public void listComPersonagemNullTest() throws CustomException {
		
		Page<Personagem> response = this.personagemServiceImpl.list(null, pageable);

		assertNotNull(response);
		assertNotNull(response.getContent().size() == 1);
	}
	
	@Test()
	public void listComPageableNullTest() throws CustomException {
		
		Personagem request = Personagem.builder()
				.build();
		
		assertThrows(CustomException.class, () -> {
			this.personagemServiceImpl.list(request, null);
		});
	}
	
	@Test
	public void listPorIdTest() throws CustomException {

		Personagem request = Personagem.builder()
				.id(EntityGenericUtil.getLong())
				.build();
		
		Page<Personagem> response = this.personagemServiceImpl.list(request, pageable);

		assertNotNull(response);
		assertNotNull(response.getContent().size() == 1);
	}
	
	@Test
	public void listPorNameTest() throws CustomException {

		Personagem request = Personagem.builder()
				.name(EntityGenericUtil.getString())
				.build();
		
		Page<Personagem> response = this.personagemServiceImpl.list(request, pageable);

		assertNotNull(response);
		assertNotNull(response.getContent().size() == 1);
	}
	
	@Test
	public void listPorRoleTest() throws CustomException {

		Personagem request = Personagem.builder()
				.role(EntityGenericUtil.getString())
				.build();
		
		Page<Personagem> response = this.personagemServiceImpl.list(request, pageable);

		assertNotNull(response);
		assertNotNull(response.getContent().size() == 1);
	}
	
	
	@Test
	public void listPorSchoolTest() throws CustomException {

		Personagem request = Personagem.builder()
				.school(EntityGenericUtil.getString())
				.build();
		
		Page<Personagem> response = this.personagemServiceImpl.list(request, pageable);

		assertNotNull(response);
		assertNotNull(response.getContent().size() == 1);
	}
	
	
	@Test
	public void listPorHouseTest() throws CustomException {

		Personagem request = Personagem.builder()
				.house(EntityGenericUtil.getString())
				.build();
		
		Page<Personagem> response = this.personagemServiceImpl.list(request, pageable);

		assertNotNull(response);
		assertNotNull(response.getContent().size() == 1);
	}
	
	@Test
	public void listPorPatronusTest() throws CustomException {

		Personagem request = Personagem.builder()
				.patronus(EntityGenericUtil.getString())
				.build();
		
		Page<Personagem> response = this.personagemServiceImpl.list(request, pageable);

		assertNotNull(response);
		assertNotNull(response.getContent().size() == 1);
	}
}
