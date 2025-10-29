package com.curso.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan; // Adicionar este import

@SpringBootApplication(scanBasePackages = {"com.curso.boot", "com.mvc.boot"})
@EntityScan("com.mvc.boot.domain") // Adicionar esta anotação
public class MvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(MvcApplication.class, args);
	}

}