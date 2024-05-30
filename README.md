# Librería - Proyecto de Gestión de Libros

Este proyecto es una aplicación de gestión de libros desarrollada en Java utilizando Spring Boot. Proporciona un consumo de API para buscar libros en la API Gutendex, persistir datos en una base de datos PostgreSQL y consultar información sobre libros y autores.

## Funcionalidades

1. **Buscar Libro en API Gutendex:**
   - La aplicación permite buscar libros utilizando la API Gutendex.
   - Los resultados se pueden filtrar por título, autor, total de descargas y lenguaje.

2. **Persistencia en Base de Datos PostgreSQL:**
   - Los libros encontrados se almacenan en una base de datos PostgreSQL.
   - Se utiliza Spring Data JPA para interactuar con la base de datos.

3. **Consulta de Datos de Libros y Autores:**
   - La aplicación proporciona funciones para consultar información sobre libros y autores.
   - Se pueden obtener detalles como título, autor, lenguaje, año de nacimiento y muerte del autor.

## Configuración

1. **Requisitos previos:**
   - Java 11 o superior instalado.
   - PostgreSQL instalado y configurado.

2. **Configuración de la Base de Datos:**
   - Crea una base de datos en PostgreSQL para almacenar los datos de la librería.
   - Actualiza las propiedades de conexión en `application.properties`.

3. **Ejecución del Proyecto:**
   - Clona este repositorio.
   - Ejecuta la aplicación usando `./mvnw spring-boot:run`.

## Contribución

¡Siéntete libre de contribuir al proyecto! Puedes abrir problemas, enviar solicitudes de extracción o mejorar la documentación.
