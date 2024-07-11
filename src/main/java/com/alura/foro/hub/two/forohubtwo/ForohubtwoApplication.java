package com.alura.foro.hub.two.forohubtwo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ForohubtwoApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ForohubtwoApplication.class, args);
		MenuPrincipal menuPrincipal = context.getBean(MenuPrincipal.class);
		menuPrincipal.mostrarMenu();
	}
}
