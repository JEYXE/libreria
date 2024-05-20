package Modelo;

import java.util.List;

public class Libros {
   
    private Integer id;
    private String titulo;
    private Autor Autor;
    private List categorias;
    private List lenguajes;
    private Integer totalDescargas;
    
    public Libros() {
    }
    public Libros(DatosLibro datosLibro){
        this.id = datosLibro.id();
        this.titulo= datosLibro.titulo();
        this.categorias= datosLibro.categorias();
        this.lenguajes=datosLibro.lenguajes();
        this.totalDescargas=datosLibro.totalDescargas();  
    }
    @Override
    public String toString() {
        return  "id='" + id + 
                ", titulo='" + titulo +
                ", categorias='" + categorias +
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
        return Autor;
    }
    public void setAutor(Autor autor) {
        Autor = autor;
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
