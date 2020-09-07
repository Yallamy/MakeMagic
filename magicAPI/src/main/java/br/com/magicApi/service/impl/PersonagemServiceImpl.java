package br.com.magicApi.service.impl;

import java.math.BigDecimal;
import java.util.NoSuchElementException;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.magicApi.dto.externo.HouseRequestDTO;
import br.com.magicApi.entity.Personagem;
import br.com.magicApi.exception.CustomException;
import br.com.magicApi.exception.ServiceWsValidacao;
import br.com.magicApi.externo.rest.PotterApiClient;
import br.com.magicApi.repository.PersonagemRepository;
import br.com.magicApi.service.PersonagemService;
import br.com.twsoftware.alfred.object.Objeto;

/**
 * Classe que implementa os métodos do serviço para manter um personagem.
 * @author Yallamy Nascimento (yallamy@gmail.com)
 * @since 5 de set de 2020
 */
@Service
public class PersonagemServiceImpl implements PersonagemService {
	
	@Autowired
	private PersonagemRepository repository;
	
	@Autowired
	private PotterApiClient potterApiClient;
	
	@Autowired
	private Validator validator;
	
	@PostConstruct
	public void init() {

        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        this.validator = factory.getValidator();
	}

	/*
	 * (non-Javadoc)
	 * @see br.com.magicApi.service.PersonagemService#create(br.com.magicApi.entity.Personagem)
	 */
	@Override
	public Personagem create(Personagem personagem) throws CustomException {
		
		Set<ConstraintViolation<Personagem>> violations = validator.validate(personagem);
		
		if(Objeto.isBlank(personagem) || violations.size() > BigDecimal.ZERO.intValue()) {
			throw new CustomException(ServiceWsValidacao.BAD_REQUEST);
		}
		
		if(Objeto.notBlank(personagem.getHouse())) {
			
			potterApiClient.getHouse(
					HouseRequestDTO.builder().houseId(personagem.getHouse()).build());
		}
		
		return repository.save(personagem);
	}

	/*
	 * (non-Javadoc)
	 * @see br.com.magicApi.service.PersonagemService#update(br.com.magicApi.entity.Personagem)
	 */
	@Override
	public void update(Personagem personagem) throws CustomException {
		
		Set<ConstraintViolation<Personagem>> violations = validator.validate(personagem);
		
		if(Objeto.isBlank(personagem) || violations.size() > BigDecimal.ZERO.intValue()
				|| Objeto.isBlank(personagem.getId())) {
			
			throw new CustomException(ServiceWsValidacao.BAD_REQUEST);
		}
		
		try {

			repository.findById(personagem.getId()).get(); 
			
			if(Objeto.notBlank(personagem.getHouse())) {
				
				potterApiClient.getHouse(
						HouseRequestDTO.builder().houseId(personagem.getHouse()).build());
			}
			
			repository.save(personagem);

		} catch(NoSuchElementException ex) {
			throw new CustomException(ServiceWsValidacao.PERSONAGEM_NAO_ENCONTRADO);
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see br.com.magicApi.service.PersonagemService#retrieve(java.lang.Long)
	 */
	@Override
	public Personagem retrieve(Long id) throws CustomException {
		
		if(Objeto.isBlank(id)) {
			throw new CustomException(ServiceWsValidacao.BAD_REQUEST);
		}
		
		try {
			
			return repository.findById(id).get();
			
		} catch(NoSuchElementException ex) {
			throw new CustomException(ServiceWsValidacao.PERSONAGEM_NAO_ENCONTRADO);
		}
	}

	/*
	 * (non-Javadoc)
	 * @see br.com.magicApi.service.PersonagemService#delete(br.com.magicApi.entity.Personagem)
	 */
	@Override
	public void delete(Personagem personagem) throws CustomException {
		
		if(Objeto.isBlank(personagem) || Objeto.isBlank(personagem.getId())) {
			throw new CustomException(ServiceWsValidacao.BAD_REQUEST);
		}
		
		try {
			
			Personagem personagemSalvo = repository.findById(personagem.getId()).get(); 
			repository.delete(personagemSalvo);

		} catch(NoSuchElementException ex) {
			throw new CustomException(ServiceWsValidacao.PERSONAGEM_NAO_ENCONTRADO);
		}
	}


	/*
	 * (non-Javadoc)
	 * @see br.com.magicApi.service.PersonagemService#list(br.com.magicApi.entity.Personagem, org.springframework.data.domain.Pageable)
	 */
	@Override
	public Page<Personagem> list(Personagem personagem, Pageable pageable) throws CustomException {
		
		if(Objeto.isBlank(pageable)) {
			throw new CustomException(ServiceWsValidacao.BAD_REQUEST);
		}
		
		if(Objeto.isBlank(personagem)) {
			personagem = Personagem.builder().build();
		}

		ExampleMatcher matcher = ExampleMatcher.matching().withIgnoreNullValues();
		Example<Personagem> example = Example.of(personagem, matcher);
		
		return repository.findAll(example, pageable); 
	}
}
