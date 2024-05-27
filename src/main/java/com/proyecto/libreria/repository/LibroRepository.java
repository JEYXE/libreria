package com.proyecto.libreria.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.proyecto.libreria.Modelo.Libro;

public interface LibroRepository extends JpaRepository<Libro,Long> {
    @Query("SELECT l FROM Libro l WHERE l.codigo= :codigo")
    Libro findByCodigo(Integer codigo);

}
