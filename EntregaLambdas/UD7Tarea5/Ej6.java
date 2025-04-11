package UD7Tarea5;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class Ej6 {
    public static void main(String[] args) {
        Supplier<Map<String, String>> crearMapa = () -> new HashMap<>();
        Map<String, String> mapa = crearMapa.get();
        mapa.put("1", "Madrid");
        mapa.put("2", "Barcelona");
        mapa.put("3", "Valencia");
        mapa.put("4", "Sevilla");
        mapa.put("5", "Bilbao");

        System.out.println("Mapa creado: " + mapa);
    }
}
