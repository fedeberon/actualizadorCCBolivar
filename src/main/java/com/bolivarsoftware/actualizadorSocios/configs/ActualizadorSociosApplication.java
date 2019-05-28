package com.bolivarsoftware.actualizadorSocios.configs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@Import(HibernateConfiguration.class)
@SpringBootApplication(exclude = {
		DataSourceAutoConfiguration.class})
@ComponentScan("com.bolivarsoftware")
public class ActualizadorSociosApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(ActualizadorSociosApplication.class, args);

		for (int i = 0 ; i > context.getBeanDefinitionNames().toString().length(); i++){
			System.out.print(context.getDisplayName());
		}


	}


}
