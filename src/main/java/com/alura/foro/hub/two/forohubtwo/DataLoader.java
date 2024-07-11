package com.alura.foro.hub.two.forohubtwo;


import com.alura.foro.hub.two.forohubtwo.domain.Usuario;
import com.alura.foro.hub.two.forohubtwo.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public void run(String... args) throws Exception {
        // Crear usuario de prueba
        Usuario usuario = new Usuario();
        usuario.setUsername("marco");
        usuario.setPassword(passwordEncoder.encode("123456"));
        usuarioRepository.save(usuario);
    }
}
