package com.agenda.br.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
@Entity
public class Contato {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotBlank(message = "Campo nome é obrigatório!!")
	private String nome;
	
	private String sobrenome;
	
	@NotBlank(message = "Campo telefone é obrigatório!!")
	private String telefone;
	
	private String email;
	
	private String empresa;
}
