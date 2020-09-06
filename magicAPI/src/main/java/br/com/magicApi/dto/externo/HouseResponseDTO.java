package br.com.magicApi.dto.externo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Classe que representa a entidade de response do serviço houses da PotterAPI.
 * @author Yallamy Nascimento (yallamy@gmail.com)
 * @since 5 de set de 2020
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HouseResponseDTO {

	private String _id;

	private String name;

	private String mascot;

	private String headOfHouse;

	private String houseGhost;

	private String founder;

	private String school;
}
