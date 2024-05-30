package com.proyecto.libreria.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import com.proyecto.libreria.Modelo.Autor;

public interface AutorRepository extends JpaRepository<Autor,Long> {
    Autor findByNombre(String nombre);

    @Query("SELECT a FROM Autor a WHERE a.anoNacimiento<=:ano and a.anoFallecimiento>=:ano")
    List<Autor> autoresVivos(Integer ano);

    @Query("SELECT a FROM Autor a WHERE a.nombre ILIKE %:nombreAutor%")
    List<Autor> AutorPorNombre(String nombreAutor);
}
