package com.proyecto.libreria.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.libreria.Modelo.Autor;

public interface AutorRepository extends JpaRepository<Autor,Long> {

}
