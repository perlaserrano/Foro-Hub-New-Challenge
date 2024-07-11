package com.alura.foro.hub.two.forohubtwo.service;


import com.alura.foro.hub.two.forohubtwo.domain.Usuario;
import com.alura.foro.hub.two.forohubtwo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Optional;

@Service
public class UsuarioService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Optional<Usuario> usuarioOptional = usuarioRepository.findByUsername(username);
//        Usuario usuario = usuarioOptional.orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + username));
//        return new UserDetailsImpl(usuario); // Aquí asumiendo que UserDetailsImpl implementa UserDetails
//    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> optionalUsuario = usuarioRepository.findByUsername(username);
        Usuario usuario = optionalUsuario.orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado: " + username));

        return new User(usuario.getUsername(), usuario.getPassword(), Collections.emptyList());
    }
}
