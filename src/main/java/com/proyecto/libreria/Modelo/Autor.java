package com.proyecto.libreria.Modelo;


import java.util.List;
import java.util.stream.Collectors;
import jakarta.persistence.*;

@Entity
@Table(name = "autores")
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    @Column(unique = true)
    private String nombre;
    private Integer anoNacimiento;
    private Integer anoFallecimiento;
    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Libro> libros;

    public Autor() {
    }

    public Autor(DatosAutor datosAutor){
        this.nombre= datosAutor.nombre();
        this.anoNacimiento= datosAutor.anoNacimiento();
        this.anoFallecimiento= datosAutor.anoFallecimiento(); 
    }
  
    @Override
    public String toString() {
        return  "\n********** AUTOR **********\n"+
                "NOMBRE: " + nombre + 
                "\nAÑO DE NACIMIENTO:" + anoNacimiento +
                "\nAÑO DE FALLECIMIENTO: " + anoFallecimiento +
                "\nLIBROS: " + String.join(",",libros.stream()
                .map(l-> l.getTitulo())
                .collect(Collectors.toList()))+
                "\n*****************************";
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getAnoNacimiento() {
        return anoNacimiento;
    }

    public void setAnoNacimiento(Integer anoNacimiento) {
        this.anoNacimiento = anoNacimiento;
    }

    public Integer getAnoFallecimiento() {
        return anoFallecimiento;
    }

    public void setAnoFallecimiento(Integer anoFallecimiento) {
        this.anoFallecimiento = anoFallecimiento;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }
}
