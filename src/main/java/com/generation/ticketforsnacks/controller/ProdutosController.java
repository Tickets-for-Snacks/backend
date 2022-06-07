package com.generation.ticketforsnacks.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.ticketforsnacks.model.Produtos;
import com.generation.ticketforsnacks.repository.CategoriasRepository;
import com.generation.ticketforsnacks.repository.ProdutoRepository;

@RestController
@RequestMapping ("/produtos")
@CrossOrigin (origins="*", allowedHeaders = "*")


public class ProdutosController {
	
	@Autowired 
	private ProdutoRepository produtoRepository;
	
	@Autowired 
	private CategoriasRepository categoriaRepository;
	
	@GetMapping
    public ResponseEntity<List<Produtos>> getAll(){
		return ResponseEntity.ok(produtoRepository.findAll());	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Produtos>getById(@PathVariable Long id){
		return produtoRepository.findById(id)
				.map(resposta->ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.notFound().build()); 
		
	} 
	@GetMapping("/nometicket/{nomeTicket}")
	public ResponseEntity<List<Produtos>> getByUsuario(@PathVariable String nomeTicket){
		
		return ResponseEntity.ok(produtoRepository.findAllByNomeTicketContainingIgnoreCase(nomeTicket));
		
	}
	@PostMapping
	public ResponseEntity<Produtos> postProdutos(@Valid @RequestBody Produtos produtos){
		return ResponseEntity.status(HttpStatus.CREATED).body(produtoRepository.save(produtos));
	}
	
	@PutMapping
	public ResponseEntity<Produtos> putProdutos(@Valid @RequestBody Produtos produtos){		
		if(!categoriaRepository.existsById(produtos.getCategorias().getId()) || produtos.getId() == null || 
				produtos.getCategorias().getId() == null)
			return ResponseEntity.badRequest().build();

        return ResponseEntity.status(HttpStatus.CREATED).body(produtoRepository.save(produtos));
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?>deleteProdutos(@PathVariable Long id){
		return produtoRepository.findById(id)
				.map(resposta->{
					produtoRepository.deleteById(id);
					return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
				}) .orElse(ResponseEntity.notFound().build());
	
		
	}
}
		
		
	
	

