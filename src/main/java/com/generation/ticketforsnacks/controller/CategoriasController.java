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

import com.generation.ticketforsnacks.model.Categorias;
import com.generation.ticketforsnacks.repository.CategoriasRepository;

@RestController
@RequestMapping("/categorias")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CategoriasController {
	
	@Autowired
	private CategoriasRepository categoriasRepository;

	@GetMapping
	public ResponseEntity<List<Categorias>> getAll() {

		return ResponseEntity.ok(categoriasRepository.findAll());
	}

	// GetFindById
	@GetMapping("/{id}")
	public ResponseEntity<Categorias> getById(@PathVariable Long id) {
		return categoriasRepository.findById(id).map(resposta -> ResponseEntity.ok(resposta))
				.orElse(ResponseEntity.notFound().build());
	}

	@GetMapping("/descricao/{descricaoCategoria}")
    public ResponseEntity<List<Categorias>> getByDescricaoCategorias(@PathVariable String descricaoCategoria) {
        return ResponseEntity
                .ok(categoriasRepository.findAllByDescricaoCategoriaContainingIgnoreCase(descricaoCategoria));
    }

	@PostMapping
	public ResponseEntity<Categorias> postCategoria(@Valid @RequestBody Categorias categoria) {
		return ResponseEntity.status(HttpStatus.CREATED).body(categoriasRepository.save(categoria));
	}

	@PutMapping
    public ResponseEntity<Categorias> putCategoria(@Valid @RequestBody Categorias categoria) {
        if(categoria.getId() == null)
            return ResponseEntity.badRequest().build();

        return categoriasRepository.findById(categoria.getId()).map(resposta -> {
            return ResponseEntity.ok().body(categoriasRepository.save(categoria));
        }).orElse(ResponseEntity.notFound().build());
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteCategorias(@PathVariable Long id) {

		return categoriasRepository.findById(id).map(resposta -> {
			categoriasRepository.deleteById(id);
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}).orElse(ResponseEntity.notFound().build());
	}

}
