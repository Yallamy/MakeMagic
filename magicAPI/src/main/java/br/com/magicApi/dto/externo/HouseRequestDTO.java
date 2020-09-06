package br.com.magicApi.dto.externo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Classe que representa a entidade de request do serviço houses da PotterAPI.
 * @author Yallamy Nascimento (yallamy@gmail.com)
 * @since 5 de set de 2020
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HouseRequestDTO {

	private String houseId;
}
