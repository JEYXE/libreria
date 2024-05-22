package Modelo;

import java.util.List;

import jakarta.persistence.*;

public class Libros {
    @Id
    private Integer id;
    private String titulo;
    @ManyToOne
    private Autor autor;
    private List categorias;
    private List lenguajes;
    private Integer totalDescargas;
    
    public Libros() {
    }

    public Libros(DatosLibro datosLibro){
        this.id = datosLibro.id();
        this.titulo= datosLibro.titulo();
        this.autor=new Autor(datosLibro.datosAutor().stream().findFirst().get());
        this.categorias= datosLibro.categorias();
        this.lenguajes=datosLibro.lenguajes();
        this.totalDescargas=datosLibro.totalDescargas();  
    }
    @Override
    public String toString() {
        return  "id='" + id + 
                ", titulo='" + titulo +
                ", categorias='" + categorias +
                ", autor='" + autor +
                ", lenguajes='" + lenguajes +
                ", total de descargas='" + totalDescargas  ;
    }
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
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
        autor = autor;
    }
    public List getCategorias() {
        return categorias;
    }
    public void setCategorias(List categorias) {
        this.categorias = categorias;
    }
    public List getLenguajes() {
        return lenguajes;
    }
    public void setLenguajes(List lenguajes) {
        this.lenguajes = lenguajes;
    }
    public Integer getTotalDescargas() {
        return totalDescargas;
    }
    public void setTotalDescargas(Integer totalDescargas) {
        this.totalDescargas = totalDescargas;
    }
}
