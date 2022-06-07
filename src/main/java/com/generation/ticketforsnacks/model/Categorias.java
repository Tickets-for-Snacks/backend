package com.generation.ticketforsnacks.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

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
<<<<<<< HEAD
	
	public void setId(Long id) {
		this.id = id;
	}
	
	}

	


=======

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricaoCategoria() {
		return descricaoCategoria;
	}

	public void setDescricaoCategoria(String descricaoCategoria) {
		this.descricaoCategoria = descricaoCategoria;
	}

	public String getIconeCategoria() {
		return iconeCategoria;
	}

	public void setIconeCategoria(String iconeCategoria) {
		this.iconeCategoria = iconeCategoria;
	}

	public String getTipoTemaCategoria() {
		return tipoTemaCategoria;
	}

	public void setTipoTemaCategoria(String tipoTemaCategoria) {
		this.tipoTemaCategoria = tipoTemaCategoria;
	}

}
>>>>>>> 131000f453fa5b49757cf6f4c733c30f23b83085
