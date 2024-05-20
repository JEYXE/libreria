package com.proyecto.libreria;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.proyecto.libreria.main.Main;

@SpringBootApplication
public class LibreriaApplication implements CommandLineRunner {
	
	public static void main(String[] args) {
		SpringApplication.run(LibreriaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Main main = new Main();
		main.muestraElMenu();
	}
	
}
