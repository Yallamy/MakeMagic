package br.com.magicApi.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.magicApi.EntityGenericUtil;
import br.com.magicApi.dto.PersonagemDTO;
import br.com.magicApi.entity.Personagem;
import junit.framework.TestCase;

/**
 * Classe de teste que representa os cenários de testes da classe {@link Util}
 * @author Yallamy Nascimento (yallamy@gmail.com)
 * @since 6 de set de 2020
 */
@RunWith(SpringRunner.class)
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

		TestCase.assertNotNull(personagem);
		TestCase.assertNotNull(character);
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void convertModelMapperSourceNull() {
		
		Personagem personagem = util.convertModelMapper(null, Personagem.class);

		TestCase.assertNull(personagem);
	}
	
	@SuppressWarnings("static-access")
	@Test
	public void convertModelMapperDestinationNull() {
		
		PersonagemDTO source = new PersonagemDTO(EntityGenericUtil.getString(), 
				EntityGenericUtil.getString(), EntityGenericUtil.getString(), 
				EntityGenericUtil.getString(), EntityGenericUtil.getString());
		
		Personagem personagem = util.convertModelMapper(source, null);

		TestCase.assertNull(personagem);
	}


}
