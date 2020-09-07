package br.com.magicApi.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.magicApi.dto.PersonagemDTO;
import br.com.magicApi.dto.PersonagemRequestDTO;
import br.com.magicApi.dto.PersonagemResponseDTO;
import br.com.magicApi.entity.Personagem;
import br.com.magicApi.exception.CustomException;
import br.com.magicApi.service.PersonagemService;
import br.com.magicApi.util.Constantes;
import br.com.magicApi.util.Util;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 
 * Classe que disponibiliza os serviços para manter o personagem.
 * @author Yallamy Nascimento (yallamy@gmail.com)
 * @since 5 de set de 2020
 */
@RestController
@RequestMapping(value=Constantes.PATH_PERSONAGEM, produces = MediaType.APPLICATION_JSON_VALUE)
@Api(value = Constantes.PATH_PERSONAGEM, produces = MediaType.APPLICATION_JSON_VALUE, tags = { Constantes.TAG_PERSONAGEM })
public class PersonagemResource {
	
	@Autowired
	private PersonagemService service;
	
	/**
	 * Método REST que cria um personagem.
	 * @param character - personagem
	 * @return ResponseEntity<?> - personagem criado ou código de erro HTTP
	 * @author Yallamy Nascimento (yallamy@gmail.com)
	 * @throws CustomException 
	 * @since 5 de set de 2020
	 */
	@RequestMapping(value = "/", method = RequestMethod.POST)
	@ApiOperation(value = Constantes.CREATE_PERSONAGEM, 
		notes = Constantes.CREATE_PERSONAGEM_NOTES, response = PersonagemResponseDTO.class)
	public @ResponseBody ResponseEntity<?> create(@Valid @RequestBody PersonagemDTO character) throws CustomException {
		
		Personagem personagem = Util.convertModelMapper(character, Personagem.class);
		personagem = this.service.create(personagem);
		PersonagemResponseDTO response = Util.convertModelMapper(personagem, PersonagemResponseDTO.class);
		
		return new ResponseEntity<PersonagemResponseDTO>(response, HttpStatus.OK);
	}
	
	/**
	 * Método REST que altera um personagem.
	 * @param id - id do personagem
	 * @param character - personagem
	 * @return ResponseEntity<?> - personagem alterado ou código de erro HTTP
	 * @throws CustomException 
	 * @author Yallamy Nascimento (yallamy@gmail.com)
	 * @since 5 de set de 2020
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	@ApiOperation(value = Constantes.UPDATE_PERSONAGEM, 
		notes = Constantes.UPDATE_PERSONAGEM_NOTES, response = PersonagemResponseDTO.class)
	public @ResponseBody ResponseEntity<?> update(
			@PathVariable("id") Long id,
			@Valid @RequestBody PersonagemDTO character) throws CustomException {
		
		Personagem personagem = Util.convertModelMapper(character, Personagem.class);
		personagem.setId(id);
		
		this.service.update(personagem);
		PersonagemResponseDTO response = Util.convertModelMapper(personagem, PersonagemResponseDTO.class);
		
		return new ResponseEntity<PersonagemResponseDTO>(response, HttpStatus.OK);
	}
	
	/**
	 * Método REST que recupera um personagem.
	 * @param id - id do personagem
	 * @return ResponseEntity<?> - personagem recuperada ou código de erro HTTP
	 * @author Yallamy Nascimento (yallamy@gmail.com)
	 * @throws CustomException 
	 * @since 5 de set de 2020
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	@ApiOperation(value = Constantes.RETRIEVE_PERSONAGEM, 
		notes = Constantes.RETRIEVE_PERSONAGEM_NOTES, response = PersonagemResponseDTO.class)
	public @ResponseBody ResponseEntity<?> retrieve(
			@PathVariable("id") Long id) throws CustomException {
		
		Personagem personagem = this.service.retrieve(id);
		PersonagemResponseDTO response = Util.convertModelMapper(personagem, PersonagemResponseDTO.class);
		
		return new ResponseEntity<PersonagemResponseDTO>(response, HttpStatus.OK);
	}
	
	/**
	 * Método REST que deleta um personagem.
	 * @param id - id do personagem
	 * @return ResponseEntity<?> - personagem deletado ou código de erro HTTP
	 * @author Yallamy Nascimento (yallamy@gmail.com)
	 * @throws CustomException 
	 * @since 5 de set de 2020
	 */
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	@ApiOperation(value = Constantes.DELETE_PERSONAGEM, 
		notes = Constantes.DELETE_PERSONAGEM_NOTES)
	public @ResponseBody ResponseEntity<?> delete(@PathVariable("id") Long id) throws CustomException {
		
		Personagem personagem = Personagem.builder().id(id).build();
		this.service.delete(personagem);
		
		return new ResponseEntity<PersonagemResponseDTO>(HttpStatus.OK);
	}
	
	/**
	 * Método REST que lista os personagens de acordo com os filtros informados.
	 * @param character - filtros do personagem
	 * @return ResponseEntity<?> - lista de personagens ou código de erro HTTP
	 * @author Yallamy Nascimento (yallamy@gmail.com)
	 * @throws CustomException 
	 * @since 5 de set de 2020
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	@ApiOperation(value = Constantes.LIST_PERSONAGEM, 
		notes = Constantes.LIST_PERSONAGEM_NOTES, response = PersonagemResponseDTO.class)
	public @ResponseBody ResponseEntity<Page<?>> list(
			@PageableDefault(value = 30, sort = {"id"}, direction = Sort.Direction.ASC) Pageable pageable,
			@RequestBody PersonagemRequestDTO character) throws CustomException {
		
		Personagem personagem = Util.convertModelMapper(character, Personagem.class);
		Page<Personagem> response = this.service.list(personagem, pageable);
		
		return ResponseEntity.ok(response);
	}

}
