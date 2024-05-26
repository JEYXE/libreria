package com.proyecto.libreria.Modelo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosBusqueda(
    @JsonAlias("count") Integer count,
    @JsonAlias("results") List<DatosLibro> libros) {


}
