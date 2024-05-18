package com.proyecto.libreria;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.proyecto.libreria.servicios.ConsumoApi;

@SpringBootApplication
public class LibreriaApplication implements CommandLineRunner {
	
	public static void main(String[] args) {
		SpringApplication.run(LibreriaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		var consumoApi= new ConsumoApi();
		var json= consumoApi.obtenerDatos("https://gutendex.com/books/?search=dickens%20great");
		System.out.println(json);
}
}
