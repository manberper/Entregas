package UD7Tarea6;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

public class Ej12 {
    public static void main(String[] args) {
        List<String> stringList = Arrays.asList("Hola", "Mundo", "Programación", "Java");
        String cond = "Pro";
        BiFunction<String, String, String> filtrarPorPrefijo = (texto, condicion) -> texto.startsWith(condicion) ? texto : null;

        stringList.forEach(str -> {
            String resultado = filtrarPorPrefijo.apply(str, cond);
            System.out.println("Texto: " + str + " - resultado: " + resultado);
        });
    }
}