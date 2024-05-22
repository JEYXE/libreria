package Modelo;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DatosLibro(
    @JsonAlias("id") Integer id,
    @JsonAlias("title") String titulo,
    @JsonAlias("authors") List<DatosAutor> datosAutor,
    @JsonAlias("subjects") List categorias,
    @JsonAlias("languages") List lenguajes,
    @JsonAlias("download_count") Integer totalDescargas
) {

}
