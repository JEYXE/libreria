package com.proyecto.libreria.main;


import java.util.*;


import org.springframework.dao.DataIntegrityViolationException;
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

                    ***** BIENVENIDOS A LA LIBRERIA *****

                    Por favor seleccione una opción:

                    1 - Buscar libros por título 

                    2 - Listar libros registrados

                    3 - Listar autores registrados

                    4 - Buscar autores vivos en determinado año

                    5 - Buscar libros por idioma

                    6 - Buscar Autor por nombre

                    7 - Top 10 libros mas descargados
                                  
                    Q - Salir

                    *************************************
                    """;
            System.out.println(menu);
            opcion = teclado.next();
            teclado.nextLine();
            switch (opcion) {
                case "1":buscaLibro();
                    break;
                case "2":buscaLibros();
                    break;
                case "3":buscaAutores();
                    break;
                case "4":buscaAutoresVivos();
                    break;
                case "5":buscaPorIdioma();
                    break;
                case "6":buscaAutorPorNombre();
                    break;
                case "7":librosMasDescargados();
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
        System.out.println(URL_BASE + nombreLibro.replace(" ", "%20"));
        var json = consumoApi.obtenerDatos(URL_BASE + nombreLibro.replace(" ", "%20") );
        DatosBusqueda busqueda = conversor.obtenerDatos(json, DatosBusqueda.class);
        return busqueda;
    }

    private void buscaLibro() {
        DatosBusqueda datos = getDatosLibro();
        if(datos.count()==0){
            System.out.println("\nlos criterios de busqueda no arrojaron resultados\n");
        }else{
            DatosLibro datosLibro = datos.libros().get(0);
            DatosAutor datosAutor = datosLibro.datosAutor().get(0);
            Libro libroDb =repositorioLibro.findByCodigo(datosLibro.codigo());
            if (libroDb!= null) {
                System.out.println(libroDb);
            }
            else{
                Autor autorDb= repositorioAutor.findByNombre(datosAutor.nombre());
                if (autorDb!= null) {
                    System.out.println(autorDb);
                    Libro libro =new Libro(datosLibro,autorDb);
                    try{
                        repositorioLibro.save(libro);
                        System.out.println(libro);
                    }
                    catch(DataIntegrityViolationException e){
                        System.out.println("lo sentimos no fue posible guardar el libro");
                    }
                }
                else{
                    Autor autor =new Autor(datosAutor);
                    Libro libro =new Libro(datosLibro,autor);
                    try{
                        repositorioAutor.save(autor);
                        repositorioLibro.save(libro);
                        System.out.println(libro);
                    }
                    catch(DataIntegrityViolationException e){
                        System.out.println("lo sentimos no fue posible guardar el libro");
                    }
                }
            }
        }
    }
    private void buscaLibros(){
        List <Libro> libros= repositorioLibro.findAll();
        libros.forEach(System.out::println);
    }
    private void buscaAutores(){
        List <Autor> autores= repositorioAutor.findAll();
        autores.forEach(System.out::println);
    }
    private void buscaAutoresVivos(){
        System.out.println("\nIndica el año a consultar\n");
        var ano=0;
        ano = teclado.nextInt();
        List <Autor> autores= repositorioAutor.autoresVivos(ano);
        autores.forEach(System.out::println);
    }
    private void buscaPorIdioma(){
        System.out.println("\nEscribe el idioma a consultar (Ej: es,en)\n");
        var idioma=" ";
        idioma = teclado.next();
        List <Libro> libros= repositorioLibro.librosPorIdioma(idioma);
        libros.forEach(System.out::println);
    }
    private void buscaAutorPorNombre(){
        System.out.println("\nEscribe el nombre del autor que desea consultar\n");
        var nombreAutor=" ";
        nombreAutor = teclado.next();
        List <Autor> autores= repositorioAutor.AutorPorNombre(nombreAutor);
        autores.forEach(System.out::println);
    }
    private void librosMasDescargados(){
        List<Libro> libros=repositorioLibro.findTop10ByOrderByTotalDescargasDesc();
        libros.forEach(System.out::println);
    }
}
