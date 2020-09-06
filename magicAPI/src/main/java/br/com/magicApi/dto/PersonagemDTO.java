package br.com.magicApi.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import br.com.magicApi.util.Constantes;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Classe que encapsula os dados do personagem para transferência dos objetos pelo REST. 
 * @author Yallamy Nascimento (yallamy@gmail.com)
 * @since 5 de set de 2020
 */
@Data
@AllArgsConstructor
@ApiModel(description = Constantes.PERSONAGEM)
public class PersonagemDTO implements Serializable {
	
	private static final long serialVersionUID = 2824483527406999645L;

	@ApiModelProperty(value = Constantes.PERSONAGEM_NAME, position = 1)
	@NotNull
	private String name;
	
	@ApiModelProperty(value = Constantes.PERSONAGEM_ROLE, position = 2)
	@NotNull
	private String role;
	
	@ApiModelProperty(value = Constantes.PERSONAGEM_SCHOOL, position = 3)
	@NotNull
	private String school;
	
	@ApiModelProperty(value = Constantes.PERSONAGEM_HOUSE, position = 4)
	private String house;
	
	@ApiModelProperty(value = Constantes.PERSONAGEM_PATRONUS, position = 5)
	private String patronus;
}
