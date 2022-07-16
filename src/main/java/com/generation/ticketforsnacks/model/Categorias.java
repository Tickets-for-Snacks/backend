package com.generation.ticketforsnacks.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table (name = "tb_categorias")
public class Categorias {
	
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	//not blank- não pode não escrever nada
	//not null- tem que ter alguma coisa, por exemplo um espaço 
	@NotBlank (message = "Caro snacker. É necessário ser preenchido.")
	@Size (min = 10, max = 1000)
	private String descricaoCategoria;
	
	@NotBlank 
	@Size (max = 10)
	private String iconeCategoria;
	
	@JsonIgnoreProperties("categorias")
	@OneToMany(mappedBy = "categorias", cascade = CascadeType.REMOVE)
	private List<Produtos> produtos;

	public Long getId()
	{
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	

	public String getDescricaoCategoria()
	{
		return descricaoCategoria;
	}

	public void setDescricaoCategoria(String descricaoCategoria)
	{
		this.descricaoCategoria = descricaoCategoria;
	}

	public String getIconeCategoria()
	{
		return iconeCategoria;
	}

	public void setIconeCategoria(String iconeCategoria)
	{
		this.iconeCategoria = iconeCategoria;
	}

	public List<Produtos> getProdutos()
	{
		return produtos;
	}

	public void setProdutos(List<Produtos> produtos)
	{
		this.produtos = produtos;
	}

	

	

	
}

