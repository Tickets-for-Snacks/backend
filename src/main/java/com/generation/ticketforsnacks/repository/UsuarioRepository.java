package com.generation.ticketforsnacks.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.generation.ticketforsnacks.model.Usuarios;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuarios, Long> {

	public Optional<Usuarios> findByUsuario(String usuarios);

}