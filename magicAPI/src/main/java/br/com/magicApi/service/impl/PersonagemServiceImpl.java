package br.com.magicApi.service.impl;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.magicApi.dto.externo.HouseRequestDTO;
import br.com.magicApi.entity.Personagem;
import br.com.magicApi.exception.CustomException;
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

	/*
	 * (non-Javadoc)
	 * @see br.com.magicApi.service.PersonagemService#create(br.com.magicApi.entity.Personagem)
	 */
	@Override
	public Personagem create(@Valid Personagem personagem) throws CustomException {
		
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
	public void update(@Valid Personagem personagem) throws CustomException {
		
		if(Objeto.notBlank(personagem.getHouse())) {
			
			potterApiClient.getHouse(
					HouseRequestDTO.builder().houseId(personagem.getHouse()).build());
		}
		
		repository.save(personagem);
	}
	
	/*
	 * (non-Javadoc)
	 * @see br.com.magicApi.service.PersonagemService#retrieve(java.lang.Long)
	 */
	@Override
	public Personagem retrieve(Long id) throws CustomException {
		
		return repository.getOne(id);
	}

	/*
	 * (non-Javadoc)
	 * @see br.com.magicApi.service.PersonagemService#delete(br.com.magicApi.entity.Personagem)
	 */
	@Override
	public void delete(Personagem personagem) throws CustomException {
		
		repository.delete(personagem);
	}

	/*
	 * (non-Javadoc)
	 * @see br.com.magicApi.service.PersonagemService#list(br.com.magicApi.entity.Personagem)
	 */
	@Override
	public List<Personagem> list(Personagem personagem) throws CustomException {
		// TODO Auto-generated method stub
		return null; //FIXME
	}

}
