package UD7Tarea6;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Ej9 {

    public static void main(String[] args) {
        String resultado = calculaPot(2, 4);
        System.out.println(resultado);
    }

    public static String calculaPot(int base, int exponente) {
        BiFunction<Integer, Integer, Double> potencia = (a, b) -> Math.pow(a, b);
        Function<Double, String> doubleStringFunction = numero -> "Resultado: " + numero;

        return potencia.andThen(doubleStringFunction).apply(base, exponente);
    }
}