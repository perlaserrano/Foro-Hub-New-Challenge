package com.alura.foro.hub.two.forohubtwo;


import com.alura.foro.hub.two.forohubtwo.domain.Topico;
import com.alura.foro.hub.two.forohubtwo.repository.TopicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

@Component
public class MenuPrincipal {

    @Autowired
    private TopicoRepository topicRepository;

    @Autowired
    private AuthenticationManager authenticationManager;

    public void mostrarMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("**********Bienvenido al sistema de gestión de tópicos********");

        while (true) {
            System.out.println("1. Iniciar sesión");
            System.out.println("2. Salir");
            System.out.println("************************************************************");
            System.out.print("Selecciona una opción: ");
            int opcion = scanner.nextInt();

            if (opcion == 1) {
                System.out.print("Usuario: ");
                String username = scanner.next();

                System.out.print("Contraseña: ");
                String password = scanner.next();

                try {
                    Authentication auth = authenticationManager.authenticate(
                            new UsernamePasswordAuthenticationToken(username, password)
                    );
                    System.out.println("¡Inicio de sesión exitoso!");
                    mostrarMenuCRUD();
                } catch (AuthenticationException e) {
                    System.out.println("Error de autenticación: " + e.getMessage());
                }
            } else if (opcion == 2) {
                System.out.println("Saliendo...");
                break;
            } else {
                System.out.println("Opción no válida");
            }
        }
    }

    private void mostrarMenuCRUD() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("***Menú de Gestión de Tópicos***");
            System.out.println("1. Crear tópico");
            System.out.println("2. Ver todos los tópicos");
            System.out.println("3. Actualizar tópico");
            System.out.println("4. Eliminar tópico");
            System.out.println("5. Volver al menú principal");
            System.out.print("Selecciona una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consume la nueva línea

            switch (opcion) {
                case 1:
                    crearTopico(scanner);
                    break;
                case 2:
                    verTopicos();
                    break;
                case 3:
                    actualizarTopico(scanner);
                    break;
                case 4:
                    eliminarTopico(scanner);
                    break;
                case 5:
                    return; // Volver al menú principal
                default:
                    System.out.println("Opción no válida");
            }
        }
    }

    private void crearTopico(Scanner scanner) {
        System.out.print("Título del tópico: ");
        String title = scanner.nextLine();
        System.out.print("Contenido del tópico: ");
        String content = scanner.nextLine();

        Topico topic = new Topico();
        topic.setTitulo(title);
        topic.setContenido(content);
        topicRepository.save(topic);
        System.out.println("Tópico creado exitosamente");
    }

    private void verTopicos() {
        List<Topico> topics = topicRepository.findAll();
        if (topics.isEmpty()) {
            System.out.println("No hay tópicos disponibles.");
        } else {
            for (Topico topic : topics) {
                System.out.println("ID: " + topic.getId() + ", Título: " + topic.getTitulo() + ", Contenido: " + topic.getContenido());
            }
        }
    }

    private void actualizarTopico(Scanner scanner) {
        System.out.print("ID del tópico a actualizar: ");
        Long id = scanner.nextLong();
        scanner.nextLine(); // Consume la nueva línea

        Optional<Topico> optionalTopic = topicRepository.findById(id);
        if (optionalTopic.isPresent()) {
            Topico topic = optionalTopic.get();

            System.out.print("Nuevo título del tópico: ");
            String title = scanner.nextLine();
            System.out.print("Nuevo contenido del tópico: ");
            String content = scanner.nextLine();

            topic.setTitulo(title);
            topic.setContenido(content);
            topicRepository.save(topic);
            System.out.println("Tópico actualizado exitosamente");
        } else {
            System.out.println("Tópico no encontrado");
        }
    }

    private void eliminarTopico(Scanner scanner) {
        System.out.print("ID del tópico a eliminar: ");
        Long id = scanner.nextLong();
        scanner.nextLine(); // Consume la nueva línea

        if (topicRepository.existsById(id)) {
            topicRepository.deleteById(id);
            System.out.println("Tópico eliminado exitosamente");
        } else {
            System.out.println("Tópico no encontrado");
        }
    }
}
