package br.com.magicApi.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import br.com.magicApi.entity.Personagem;
import br.com.magicApi.exception.CustomException;

/**
 * Interface que define os métodos do serviço para manter um personagem.
 * @author Yallamy Nascimento (yallamy@gmail.com)
 * @since 5 de set de 2020
 */
public interface PersonagemService {
	
	/**
	 * Método que cria um personagem.
	 * @param personagem - personagem a ser atualizado
	 * @return Personagem - personagem criado
	 * @throws CustomException 
	 * @author Yallamy Nascimento (yallamy@gmail.com)
	 * @since 5 de set de 2020
	 */
	public Personagem create(Personagem personagem) throws CustomException;;
	
	/**
	 * Método que atualiza um personagem.
	 * @param personagem - personagem a ser atualizado
	 * @throws CustomException 
	 * @author Yallamy Nascimento (yallamy@gmail.com)
	 * @since 5 de set de 2020
	 */
	public void update(Personagem personagem) throws CustomException;;
	
	/**
	 * Método que recupera um personagem
	 * @param id - id do personagem
	 * @return Personagem - personagem recuperado
	 * @throws CustomException
	 * @author Yallamy Nascimento (yallamy@gmail.com)
	 * @since 5 de set de 2020
	 */
	public Personagem retrieve(Long id) throws CustomException;
	
	/**
	 * Método que deleta um personagem.
	 * @param personagem - personagem a ser deletado
	 * @throws CustomException 
	 * @author Yallamy Nascimento (yallamy@gmail.com)
	 * @since 5 de set de 2020
	 */
	public void delete(Personagem personagem) throws CustomException;;
	
	/**
	 * Método que lista os personagens com base nos filtros.
	 * @param personagem - filtros a serem aplicados
	 * @param pageable - paginação
	 * @return Page<Personagem> - lista de personagens
	 * @throws CustomException 
	 * @author Yallamy Nascimento (yallamy@gmail.com)
	 * @since 5 de set de 2020
	 */
	public Page<Personagem> list(Personagem personagem, Pageable pageable) throws CustomException;;

}
