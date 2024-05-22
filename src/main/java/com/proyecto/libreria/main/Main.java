package com.proyecto.libreria.main;

import java.util.stream.Collectors;
import java.util.*;

import com.proyecto.libreria.servicios.ConsumoApi;
import com.proyecto.libreria.servicios.ConvierteDatos;

import Modelo.*;


public class Main {
    private Scanner teclado = new Scanner(System.in);
    private ConsumoApi consumoApi = new ConsumoApi();
    private final String URL_BASE = "https://gutendex.com/books/?search=";
    private ConvierteDatos conversor = new ConvierteDatos();

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
            System.out.println(datos);
            System.out.println(datos.libros().stream().findFirst().get());
            Libros libro = new Libros(datos.libros().stream().findFirst().get());
            System.out.println(libro);
            System.out.println(libro.getAutor());


        }
        //repositorio.save(serie);
        //datosSeries.add(datos);
        //System.out.println(libro);
    }

}
