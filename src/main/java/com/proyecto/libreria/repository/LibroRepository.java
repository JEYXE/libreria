package com.proyecto.libreria.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.proyecto.libreria.Modelo.Libro;

public interface LibroRepository extends JpaRepository<Libro,Long> {

}
