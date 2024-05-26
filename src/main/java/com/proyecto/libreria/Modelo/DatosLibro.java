package com.proyecto.libreria.Modelo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosLibro(
    @JsonAlias("id") Integer codigo,
    @JsonAlias("title") String titulo,
    @JsonAlias("authors") List<DatosAutor> datosAutor,
    @JsonAlias("languages") List<String> lenguajes,
    @JsonAlias("download_count") Integer totalDescargas
) {

}
