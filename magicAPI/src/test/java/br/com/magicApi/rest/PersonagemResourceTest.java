package br.com.magicApi.rest;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.google.gson.Gson;

import br.com.magicApi.MagicAPI;
import br.com.magicApi.dto.PersonagemDTO;
import br.com.magicApi.dto.PersonagemRequestDTO;

/**
 * Classe de teste que representa os cenários de testes da classe {@link PersonagemResource}
 * @author Yallamy Nascimento (yallamy@gmail.com)
 * @since 6 de set de 2020
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = MagicAPI.class)
public class PersonagemResourceTest {
	
	private MockMvc mockMvc;
	
	@Autowired
	private PersonagemResource personagemResource;
	
	@Autowired
	private Gson gson;
	
	private String urlBase = "/api/magic/personagem/";
	
	private PersonagemDTO request;

	@Before
	public void setup() {
		
		this.mockMvc = MockMvcBuilders.standaloneSetup(personagemResource)
				.setCustomArgumentResolvers(new PageableHandlerMethodArgumentResolver())
				.build();
		
		this.request = new PersonagemDTO("Harry Potter", "student", 
				"Hogwarts School of Witchcraft and Wizardry", 
				"5a05e2b252f721a3cf2ea33f", "stag");
	}
	
	//create
	@Test
	public void createTest() throws Exception {
		
		this.mockMvc.perform(MockMvcRequestBuilders.post(this.urlBase)
				.content(gson.toJson(request))
        		.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());
		
	}
	
	@Test
	public void createPersonagemSemHouseTest() throws Exception {

		this.request.setHouse(null);
		
		this.mockMvc.perform(MockMvcRequestBuilders.post(this.urlBase)
				.content(gson.toJson(request))
        		.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());
	
	}
	
	@Test
	public void createPersonagemSemNameTest() throws Exception {

		this.request.setName(null);
		
		this.mockMvc.perform(MockMvcRequestBuilders.post(this.urlBase)
				.content(gson.toJson(request))
        		.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isBadRequest());
	}
	
	@Test
	public void createPersonagemSemRoleTest() throws Exception {

		this.request.setRole(null);
		
		this.mockMvc.perform(MockMvcRequestBuilders.post(this.urlBase)
				.content(gson.toJson(request))
        		.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isBadRequest());
		
	}
	
	@Test
	public void createPersonagemSemSchoolTest() throws Exception {

		this.request.setSchool(null);
		
		this.mockMvc.perform(MockMvcRequestBuilders.post(this.urlBase)
				.content(gson.toJson(request))
        		.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isBadRequest());
	}
	
	//update
	@Test
	public void updateTest() throws Exception {
		
		this.request.setName("Godric Gryffindor");

		this.mockMvc.perform(MockMvcRequestBuilders.put(this.urlBase + 1)
				.content(gson.toJson(request))
        		.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void updatePersonagemSemHouseTest() throws Exception {

		this.request.setName("Harry Potter");
		this.request.setHouse(null);

		this.mockMvc.perform(MockMvcRequestBuilders.put(this.urlBase + 1)
				.content(gson.toJson(request))
        		.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void updateNotFoundTest() throws Exception {
		
		this.request.setName("Godric Gryffindor");

		this.mockMvc.perform(MockMvcRequestBuilders.put(this.urlBase + 15)
				.content(gson.toJson(request))
        		.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isNotFound());
	}
	
	@Test
	public void updatePersonagemSemNameTest() throws Exception {

		this.request.setName(null);
		
		this.mockMvc.perform(MockMvcRequestBuilders.put(this.urlBase + 1)
				.content(gson.toJson(request))
        		.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isBadRequest());
	}
	
	@Test
	public void updatePersonagemSemRoleTest() throws Exception {

		this.request.setRole(null);
		
		this.mockMvc.perform(MockMvcRequestBuilders.put(this.urlBase + 1)
				.content(gson.toJson(request))
        		.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isBadRequest());
	}
	
	@Test
	public void updatePersonagemSemSchoolTest() throws Exception {

		this.request.setSchool(null);
		
		this.mockMvc.perform(MockMvcRequestBuilders.put(this.urlBase + 1)
				.content(gson.toJson(request))
        		.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isBadRequest());
	}
	
	//retrieve
	@Test
	public void retrieveTest() throws Exception {
		
		this.mockMvc.perform(MockMvcRequestBuilders.get(this.urlBase + 1)
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void retrieveNotFoundTest() throws Exception {
		
		this.mockMvc.perform(MockMvcRequestBuilders.get(this.urlBase + 15)
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isNotFound());
	}
	
	//list
	@Test
	public void listTest() throws Exception {
		
		PersonagemRequestDTO filtro = PersonagemRequestDTO.builder()
				.id(1l)
				.name(request.getName())
				.role(request.getRole())
				.school(request.getSchool())
				.house(request.getHouse())
				.patronus(request.getPatronus())
				.build();

		this.mockMvc.perform(MockMvcRequestBuilders.get(this.urlBase)
				.content(this.gson.toJson(filtro))
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	
	@Test
	public void listPorIdTest() throws Exception {

		PersonagemRequestDTO filtro = PersonagemRequestDTO.builder().id(1l).build();
		
		this.mockMvc.perform(MockMvcRequestBuilders.get(this.urlBase)
				.content(this.gson.toJson(filtro))
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void listPorNameTest() throws Exception {

		PersonagemRequestDTO filtro = PersonagemRequestDTO.builder()
				.name(request.getName()).build();
		
		this.mockMvc.perform(MockMvcRequestBuilders.get(this.urlBase)
				.content(this.gson.toJson(filtro))
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void listPorRoleTest() throws Exception {

		PersonagemRequestDTO filtro = PersonagemRequestDTO.builder()
				.role(request.getRole()).build();
		
		this.mockMvc.perform(MockMvcRequestBuilders.get(this.urlBase)
				.content(this.gson.toJson(filtro))
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	
	@Test
	public void listPorSchoolTest() throws Exception {

		PersonagemRequestDTO filtro = PersonagemRequestDTO.builder()
				.school(request.getSchool()).build();
		
		this.mockMvc.perform(MockMvcRequestBuilders.get(this.urlBase)
				.content(this.gson.toJson(filtro))
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	
	@Test
	public void listPorHouseTest() throws Exception {

		PersonagemRequestDTO filtro = PersonagemRequestDTO.builder()
				.house(request.getHouse()).build();
		
		this.mockMvc.perform(MockMvcRequestBuilders.get(this.urlBase)
				.content(this.gson.toJson(filtro))
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void listPorPatronusTest() throws Exception {

		PersonagemRequestDTO filtro = PersonagemRequestDTO.builder()
				.patronus(request.getPatronus()).build();
		
		this.mockMvc.perform(MockMvcRequestBuilders.get(this.urlBase)
				.content(this.gson.toJson(filtro))
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	//delete
	@Test
	public void deleteTest() throws Exception {
		
		this.mockMvc.perform(MockMvcRequestBuilders.delete(this.urlBase + 1)
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isOk());
	}
	
	@Test
	public void deletePersonagemNullTest() throws Exception {
		
		this.mockMvc.perform(MockMvcRequestBuilders.delete(this.urlBase + 15)
				.header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
				.andExpect(MockMvcResultMatchers.status().isNotFound());
	}

}
