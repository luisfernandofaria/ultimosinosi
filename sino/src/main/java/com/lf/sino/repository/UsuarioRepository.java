package com.lf.sino.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lf.sino.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

	Optional<Usuario> findByEmail(String email);

}
