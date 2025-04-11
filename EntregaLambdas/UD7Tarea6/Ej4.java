package UD7Tarea6;

import java.util.*;
import java.util.function.Function;

public class Ej4 {
    public static void main(String[] args) {
        List<String> textos = Arrays.asList("Hola", "Mundo", "Programación", "Java");
        Function<String, Integer> calcularLongitud = String::length;
        Map<String, Integer> mapaTextos = convertirListaEnMap(textos, calcularLongitud);

        mapaTextos.forEach((texto, longitud) -> System.out.println(texto + " " + longitud));
    }

    public static Map<String, Integer> convertirListaEnMap(
            List<String> lista,
            Function<String, Integer> funcion) {

        Map<String, Integer> mapa = new HashMap<>();

        for (String texto : lista) {
            mapa.put(texto, funcion.apply(texto));
        }

        return mapa;
    }
}