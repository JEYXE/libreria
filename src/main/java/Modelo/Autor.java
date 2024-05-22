package Modelo;

import java.util.List;

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
    private List<Libros> libros;

    public Autor() {
    }

    public Autor(DatosAutor datosAutor){
        this.nombre= datosAutor.nombre();
        this.anoNacimiento= datosAutor.anoNacimiento();
        this.anoFallecimiento= datosAutor.anoFallecimiento(); 
    }
    @Override
    public String toString() {
        return  "nombre='" + nombre + 
                ", año nacimiento='" + anoFallecimiento +
                ", año fallecimiento='" + anoFallecimiento ;
    }
    public void setLibros(Libros libro) {
        
        this.libros.add(libro);
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

    

}
