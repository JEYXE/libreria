package Modelo;



public class Autor {

    private String nombre;
    private Integer anoNacimiento;
    private Integer anoFallecimiento;

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
