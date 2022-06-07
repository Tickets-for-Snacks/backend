package com.generation.ticketforsnacks.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table (name = "tb_categorias")
public class Categorias {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	//not blank- não pode não escrever nada
	//not null- tem que ter alguma coisa, por exemplo um espaço 
	@NotBlank (message = "Caro snacker. É necessário ser preenchido.")
	@Size (min = 5, max = 1000)
	private String descricaoCategoria;
	
	@NotBlank 
	@Size (min = 5, max = 1000)
	private String iconeCategoria;
	
	//@ManytoOne add qnd for hora hihihi
	@Size (min = 5, max = 150)
	private String tipoTemaCategoria;

	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	}

	


