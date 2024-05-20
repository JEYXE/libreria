package com.proyecto.libreria.main;

import java.util.Scanner;
import com.proyecto.libreria.servicios.ConsumoApi;
import com.proyecto.libreria.servicios.ConvierteDatos;

import Modelo.DatosBusqueda;
import Modelo.DatosLibro;
import Modelo.Libros;

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
        System.out.println("Escribe el nombre del libro que deseas buscar");
        var nombreLibro = teclado.nextLine();
        System.out.println(URL_BASE + nombreLibro.replace(" ", "%20"));
        var json = consumoApi.obtenerDatos(URL_BASE + nombreLibro.replace(" ", "+") );
        //System.out.println(json);
        DatosBusqueda busqueda = conversor.obtenerDatos(json, DatosBusqueda.class);
        System.out.println(busqueda);
        return busqueda;
    }

    private void buscaLibro() {
        DatosBusqueda datos = getDatosLibro();
        //Libros libro = new Libros(datos);
        //repositorio.save(serie);
        //datosSeries.add(datos);
        //System.out.println(libro);
    }

}
