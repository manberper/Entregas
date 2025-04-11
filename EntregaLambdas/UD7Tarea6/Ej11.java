package UD7Tarea6;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

public class Ej11 {
    public static void main(String[] args) {
        List<String> textos = Arrays.asList("Hola", "Mundo", "Programación", "Java");
        BiFunction<String, Integer, String> filtrarPorLongitud = (texto, tam) -> texto.length() > tam ? texto : null;
        int tamMinimo = 4;
        textos.forEach(texto -> {
            String resultado = filtrarPorLongitud.apply(texto, tamMinimo);
            System.out.println("Texto: " + texto + " - Resultado: " + resultado);
        });
    }
}