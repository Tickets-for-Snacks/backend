package com.generation.ticketforsnacks.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;


import com.generation.ticketforsnacks.model.Categorias;

@Repository
public interface CategoriasRepository extends JpaRepository<Categorias, Long>
{
	public List <Categorias> findAllByDescricaoCategoriaContainingIgnoreCase (@Param ("descricaocategoria") String descricaoCategoria);

	
}
