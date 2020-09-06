package br.com.magicApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.magicApi.entity.Personagem;

/**
 * Repositório da entidade {@link Personagem}
 * @author Yallamy Nascimento (yallamy@gmail.com)
 * @since 5 de set de 2020
 */
@Repository
public interface PersonagemRepository extends JpaRepository<Personagem, Long>{

}
