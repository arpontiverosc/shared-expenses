package com.clean.architecture.sharedexpenses;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SharedExpensesApplication {

	public static void main(String[] args) {
		SpringApplication.run(SharedExpensesApplication.class, args);
	}

}

//Limpiar core de framework, crear getter y setters, no utilizar @Service
//utilizar builders
//crear usuarios y enviar a una cosa para tener una base de datos de memoria rápida y comperoabar la existencia
//test integración con contenedores
//volumen con la base de datos
//dockerizado el jar
//desplegar en AWS
