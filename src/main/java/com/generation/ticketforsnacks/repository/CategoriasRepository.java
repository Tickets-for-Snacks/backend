package com.generation.ticketforsnacks.repository;
import java.util.List;

<<<<<<< HEAD
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.generation.ticketforsnacks.model.Categorias;

@Repository
public interface CategoriasRepository extends JpaRepository<Categorias, Long>
{
  public List <Categorias> findAllByDescricaoCategoriaContainingIgnoreCase (@Param ("descricaoCategoria") String descricaoCategoria);
=======
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;
>>>>>>> 131000f453fa5b49757cf6f4c733c30f23b83085

import com.generation.ticketforsnacks.model.Categorias;

@Repository
public interface CategoriasRepository extends JpaRepository<Categorias, Long>
{
	public List <Categorias> findAllByDescricaoCategoriaContainingIgnoreCase (@Param ("descricaocategoria") String descricaoCategoria);

	
}
