package com.proyecto.libreria.main;

import java.util.stream.Collectors;
import java.util.*;

import com.proyecto.libreria.Modelo.*;
import com.proyecto.libreria.repository.AutorRepository;
import com.proyecto.libreria.repository.LibroRepository;
import com.proyecto.libreria.servicios.ConsumoApi;
import com.proyecto.libreria.servicios.ConvierteDatos;


public class Main {
    private Scanner teclado = new Scanner(System.in);
    private ConsumoApi consumoApi = new ConsumoApi();
    private final String URL_BASE = "https://gutendex.com/books/?search=";
    private ConvierteDatos conversor = new ConvierteDatos();
    private LibroRepository repositorioLibro;
    private AutorRepository repositorioAutor;


    public Main(LibroRepository repositorioLibro,AutorRepository repositorioAutor) {
        this.repositorioLibro= repositorioLibro;
        this.repositorioAutor= repositorioAutor;
    }

    public void muestraElMenu() {
        var opcion = " ";
        while (!opcion.equals("Q")) {
            var menu = """

                    BIENVENIDOS A LA LIBRERIA

                    por favor seleccione una opción:

                    1 - Buscar libros 
                                  
                    Q - Salir
                    """;
            System.out.println(menu);
            opcion = teclado.next();
            teclado.nextLine();

            switch (opcion) {
                case "1":buscaLibro();
                    break;
                case "Q":
                    System.out.println("\nCerrando la aplicación...\n");
                    break;
                default:
                    System.out.println("\nOpción inválida\n");
            }
        }

    }

    private DatosBusqueda getDatosLibro() {
        System.out.println("\nEscribe el nombre del libro que deseas buscar\n");
        var nombreLibro = teclado.nextLine();
        System.out.println(URL_BASE + nombreLibro.replace(" ", "+"));
        var json = consumoApi.obtenerDatos(URL_BASE + nombreLibro.replace(" ", "+") );
        DatosBusqueda busqueda = conversor.obtenerDatos(json, DatosBusqueda.class);
        return busqueda;
    }

    private void buscaLibro() {

        DatosBusqueda datos = getDatosLibro();
        if(datos.count()==0){
            System.out.println("\nlos criterios de busqueda no arrojaron resultados\n");
        }else{
            //System.out.println(datos);
            DatosLibro datosLibro = datos.libros().get(0);
            DatosAutor datosAutor = datosLibro.datosAutor().get(0);
            
            System.out.println(datosAutor);
            System.out.println(datosLibro);
            Autor autor =new Autor(datosAutor);
            System.out.println(autor);
            Libro libro =new Libro(datosLibro,autor);
            System.out.println(libro);
            //autor.setLibros(libro);
            System.out.println(autor);
            //System.out.println(libro.getAutor());
            //repositorio.save(Autor);
            repositorioAutor.save(autor);
            repositorioLibro.save(libro);


        }
        //repositorio.save(serie);
        //datosSeries.add(datos);
        //System.out.println(libro);
    }

}
