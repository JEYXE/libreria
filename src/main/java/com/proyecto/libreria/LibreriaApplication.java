package com.proyecto.libreria;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.proyecto.libreria.main.Main;
import com.proyecto.libreria.repository.AutorRepository;
import com.proyecto.libreria.repository.LibroRepository;

@SpringBootApplication
public class LibreriaApplication implements CommandLineRunner {
	
	@Autowired
	private LibroRepository repositoryLibro;
	@Autowired
	private AutorRepository repositoryAutor;
	public static void main(String[] args) {
		SpringApplication.run(LibreriaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Main main = new Main(repositoryLibro,repositoryAutor);
		main.muestraElMenu();
	}
	
}
