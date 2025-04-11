package UD7Tarea6;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Ej8 {
    public static void main(String[] args) {
        BiFunction<Integer, Integer, Double> potencia = (a, b) -> Math.pow(a, b);
        Function<Double, String> doubleStringFunction = numero -> "Resultado: " + numero;

        String res = potencia.andThen(doubleStringFunction).apply(2, 4);
        System.out.println(res);
    }
}
