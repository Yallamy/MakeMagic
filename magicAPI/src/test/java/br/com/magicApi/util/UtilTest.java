package br.com.magicApi.util;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import br.com.magicApi.EntityGenericUtil;
import br.com.magicApi.dto.PersonagemDTO;
import br.com.magicApi.entity.Personagem;

/**
 * Classe de teste que representa os cenários de testes da classe {@link Util}
 * @author Yallamy Nascimento (yallamy@gmail.com)
 * @since 6 de set de 2020
 */
public class UtilTest {
	
	@InjectMocks
	private Util util;
	
	@SuppressWarnings("static-access")
	@Test
	public void convertModelMapper() {
		
		PersonagemDTO source = new PersonagemDTO(EntityGenericUtil.getString(), 
				EntityGenericUtil.getString(), EntityGenericUtil.getString(), 
				EntityGenericUtil.getString(), EntityGenericUtil.getString());
		
		Personagem personagem = util.convertModelMapper(source, Personagem.class);
		
		PersonagemDTO character = util.convertModelMapper(personagem, PersonagemDTO.class);

		assertNotNull(personagem);
		assertNotNull(character);
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void convertModelMapperSourceNull() {
		
		Personagem personagem = util.convertModelMapper(null, Personagem.class);

		assertNull(personagem);
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void convertModelMapperDestinationNull() {
		
		PersonagemDTO source = new PersonagemDTO(EntityGenericUtil.getString(), 
				EntityGenericUtil.getString(), EntityGenericUtil.getString(), 
				EntityGenericUtil.getString(), EntityGenericUtil.getString());
		
		Personagem personagem = util.convertModelMapper(source, null);

		assertNull(personagem);
	}


}
