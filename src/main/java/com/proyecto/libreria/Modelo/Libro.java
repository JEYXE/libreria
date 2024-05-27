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
    private String lenguajes;
    private Integer totalDescargas;
    
    public Libro() {
    }

    public Libro(DatosLibro datosLibro,Autor autor){
        this.codigo= datosLibro.codigo();
        this.titulo= datosLibro.titulo();
        this.autor=autor;
        this.lenguajes=datosLibro.lenguajes().get(0);
        this.totalDescargas=datosLibro.totalDescargas();  
    }
    @Override
    public String toString() {
        return  "\n********** LIBRO **********\n"+
                "\nTITULO: " + titulo +
                "\nAUTOR: " + autor.getNombre() +
                "\nLENGUAJE: " + lenguajes +
                "\nTOTAL DESCARGAS: " + totalDescargas  ;
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

  

    public Integer getTotalDescargas() {
        return totalDescargas;
    }

    public void setTotalDescargas(Integer totalDescargas) {
        this.totalDescargas = totalDescargas;
    }

    public String getLenguajes() {
        return lenguajes;
    }

    public void setLenguajes(String lenguajes) {
        this.lenguajes = lenguajes;
    }
    
}
