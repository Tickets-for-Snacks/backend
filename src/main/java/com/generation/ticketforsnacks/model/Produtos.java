package com.generation.ticketforsnacks.model;

import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
@Table (name = "tb_produtos")
public class Produtos
{
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank (message = "Caro snacker. É necessário ser preenchido.")
	@Size (min = 1, max = 50)
	private String nomeTicket;
	
	@NotNull
	@Digits(integer = 4, fraction = 2, message = "aceita no maximo 4 casa de numero antes do ponto e duas casas apos o ponto")
	private BigDecimal valorTicket;
	
	@NotBlank 
	@Size (max = 1000, message = "Caro snacker. É necessário ter uma descrição.")
	private String descricaoTicket;
	
	private Date dataHoraTicket;
	
	private String foto;
	
	@ManyToOne
	@JsonIgnoreProperties("produtos")
	private Categorias categorias;
	
	@ManyToOne
	@JsonIgnoreProperties("produtos")
	private Usuarios usuarios;

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getNomeTicket()
	{
		return nomeTicket;
	}

	public void setNomeTicket(String nomeTicket)
	{
		this.nomeTicket = nomeTicket;
	}

	public BigDecimal getValorTicket()
	{
		return valorTicket;
	}

	public void setValorTicket(BigDecimal valorTicket)
	{
		this.valorTicket = valorTicket;
	}

	public String getDescricaoTicket()
	{
		return descricaoTicket;
	}

	public void setDescricaoTicket(String descricaoTicket)
	{
		this.descricaoTicket = descricaoTicket;
	}

	public Date getDataHoraTicket()
	{
		return dataHoraTicket;
	}

	public void setDataHoraTicket(Date dataHoraTicket)
	{
		this.dataHoraTicket = dataHoraTicket;
	}

	public String getFoto()
	{
		return foto;
	}

	public void setFoto(String foto)
	{
		this.foto = foto;
	}

	public Categorias getCategoria()
	{
		return categorias;
	}

	public void setCategoria(Categorias categoria)
	{
		this.categorias = categoria;
	}

	public Usuarios getUsuario()
	{
		return usuarios;
	}

	public void setUsuario(Usuarios usuario)
	{
		this.usuarios = usuario;
	}
	
	
}
