package br.com.magicApi.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import br.com.magicApi.util.Mensagem;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * Classe que representa a entidade personagem.
 * @author Yallamy Nascimento (yallamy@gmail.com)
 * @since 5 de set de 2020
 */
@Table(name = "Personagem")
@Entity
@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor
@DynamicInsert
@DynamicUpdate
@EqualsAndHashCode(of = { "id" }, callSuper = false)
@ToString(of = { "id" })
public class Personagem {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="seq_personagem")
	@Column(name = "id", nullable = false)
	private Long id;
	
	@Column(name = "name", nullable = false)
	@NotEmpty(message = Mensagem.NAME_REQUIRED)
	private String name;
	
	@Column(name = "role", nullable = false)
	@NotEmpty(message = Mensagem.ROLE_REQUIRED)
	private String role;
	
	@Column(name = "school", nullable = false)
	@NotEmpty(message = Mensagem.SCHOOL_REQUIRED)
	private String school;
	
	@Column(name = "house")
	private String house;
	
	@Column(name = "patronus")
	private String patronus;
}
