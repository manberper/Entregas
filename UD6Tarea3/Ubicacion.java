package UD6Tarea3;

import java.util.HashMap;
import java.util.Map;

public class Ubicacion {
    private int id; // Identificador de la ubicación
    private String descripcion; // Descripción de la ubicación
    private Map<String, Integer> exits; // Mapa de salidas (dirección -> id de la siguiente ubicación)

    // Constructor
    public Ubicacion(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
        this.exits = new HashMap<>(); // Inicializa el mapa de salidas como un HashMap
    }

    // Getter para el id
    public int getId() {
        return id;
    }

    // Getter para la descripción
    public String getDescripcion() {
        return descripcion;
    }

    // Getter para el mapa de salidas
    public Map<String, Integer> getExits() {
        return exits; // Devuelve el mapa de salidas
    }

    // Método para añadir una salida
    public void addExit(String direccion, int idUbicacion) {
        exits.put(direccion, idUbicacion); // Añade una salida al mapa
    }
}