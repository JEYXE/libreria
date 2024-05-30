package com.proyecto.libreria.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.proyecto.libreria.Modelo.Libro;

public interface LibroRepository extends JpaRepository<Libro,Long> {
    @Query("SELECT l FROM Libro l WHERE l.codigo= :codigo")
    Libro findByCodigo(Integer codigo);

    @Query("SELECT l FROM Libro l WHERE l.lenguajes ilike :idioma")
    List<Libro> librosPorIdioma(String idioma);

    List<Libro> findTop10ByOrderByTotalDescargasDesc();

}
