package com.generation.ticketforsnacks.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import io.swagger.v3.oas.annotations.media.Schema;

@Entity
@Table (name = "tb_usuarios")
public class Usuarios
{

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	
	//not blank- não pode não escrever nada
	//not null- tem que ter alguma coisa, por exemplo um espaço 
	@Schema(example = "email@email.com.br")
	@NotNull(message = "O atributo Usuário é Obrigatório!")
	@Email(message = "O atributo Usuário deve ser um email válido!")
	private String usuario;
	
	@NotBlank 
	@Size (min = 5, max = 1000)
	private String nome;
	
	@NotBlank 
	@Size (min = 8, message = "Caro snacker. É necessário ter no minimo 8 caracteres.")
	private String senha;
	
	private String foto;
	
	@NotBlank 
	@Size
	private String tipo;
	
	@JsonIgnoreProperties("usuarios")
	@OneToMany(mappedBy = "usuarios", cascade = CascadeType.REMOVE)
	private List<Produtos> produtos;

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getUsuario()
	{
		return usuario;
	}

	public void setUsuario(String usuario)
	{
		this.usuario = usuario;
	}

	public String getNome()
	{
		return nome;
	}

	public void setNome(String nome)
	{
		this.nome = nome;
	}

	public String getSenha()
	{
		return senha;
	}

	public void setSenha(String senha)
	{
		this.senha = senha;
	}

	public String getFoto()
	{
		return foto;
	}

	public void setFoto(String foto)
	{
		this.foto = foto;
	}

	public String getTipo()
	{
		return tipo;
	}

	public void setTipo(String tipo)
	{
		this.tipo = tipo;
	}

	public List<Produtos> getProduto()
	{
		return produtos;
	}

	public void setProduto(List<Produtos> produto)
	{
		this.produtos = produto;
	}

	
	
}
