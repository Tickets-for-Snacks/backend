 package com.generation.ticketforsnacks.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.generation.ticketforsnacks.model.Produtos;



@Repository
public interface ProdutoRepository extends JpaRepository<Produtos, Long> {
	public List <Produtos> findAllByNomeTicketContainingIgnoreCase(@Param("nomeTicket") String nomeTicket);

}

