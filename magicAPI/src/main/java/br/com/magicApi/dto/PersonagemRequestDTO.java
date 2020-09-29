package br.com.magicApi.dto;

import java.io.Serializable;

import br.com.magicApi.util.Constantes;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Classe que encapsula os dados do personagem para transferência dos objetos pelo REST. 
 * @author Yallamy Nascimento (yallamy@gmail.com)
 * @since 5 de set de 2020
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ApiModel(description = Constantes.PERSONAGEM)
public class PersonagemRequestDTO implements Serializable {
	
	private static final long serialVersionUID = 2824483527406999645L;
	
	@ApiModelProperty(value = Constantes.PERSONAGEM_NAME, position = 1)
	private Long id;

	@ApiModelProperty(value = Constantes.PERSONAGEM_NAME, position = 2)
	private String name;
	
	@ApiModelProperty(value = Constantes.PERSONAGEM_ROLE, position = 3)
	private String role;
	
	@ApiModelProperty(value = Constantes.PERSONAGEM_SCHOOL, position = 4)
	private String school;
	
	@ApiModelProperty(value = Constantes.PERSONAGEM_HOUSE, position = 5)
	private String house;
	
	@ApiModelProperty(value = Constantes.PERSONAGEM_PATRONUS, position = 6)
	private String patronus;
}
