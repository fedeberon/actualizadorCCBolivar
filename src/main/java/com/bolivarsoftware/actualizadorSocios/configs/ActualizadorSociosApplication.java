package com.bolivarsoftware.actualizadorSocios.configs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.bolivarsoftware")
public class ActualizadorSociosApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActualizadorSociosApplication.class, args);
	}
}
