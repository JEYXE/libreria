package com.proyecto.libreria.Modelo;

import java.util.List;

import jakarta.persistence.*;
@Entity
@Table(name = "libros")
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer codigo;
    private String titulo;
    @ManyToOne
    private Autor autor;
    private List<String> lenguajes;
    private Integer totalDescargas;
    
    public Libro() {
    }

    public Libro(DatosLibro datosLibro,Autor autor){
        this.codigo= datosLibro.codigo();
        this.titulo= datosLibro.titulo();
        this.autor=autor;
        this.lenguajes=datosLibro.lenguajes();
        this.totalDescargas=datosLibro.totalDescargas();  
    }
    @Override
    public String toString() {
        return   
                ", titulo='" + titulo +
                ", autor='" + autor +
                ", lenguajes='" + lenguajes +
                ", total de descargas='" + totalDescargas  ;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public List<String> getLenguajes() {
        return lenguajes;
    }

    public void setLenguajes(List<String> lenguajes) {
        this.lenguajes = lenguajes;
    }

    public Integer getTotalDescargas() {
        return totalDescargas;
    }

    public void setTotalDescargas(Integer totalDescargas) {
        this.totalDescargas = totalDescargas;
    }
    
}
