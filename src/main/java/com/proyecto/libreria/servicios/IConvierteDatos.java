package com.proyecto.libreria.servicios;

public interface IConvierteDatos {
    <T> T obtenerDatos(String json, Class<T> clase);
}
