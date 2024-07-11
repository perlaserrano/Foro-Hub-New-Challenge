package com.alura.foro.hub.two.forohubtwo.repository;

import com.alura.foro.hub.two.forohubtwo.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByUsername(String username);
}
