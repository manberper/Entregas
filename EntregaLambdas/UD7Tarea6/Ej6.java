package UD7Tarea6;

import java.util.function.BiFunction;

public class Ej6 {
    public static void main(String[] args) {
        BiFunction<Integer, Integer, Double> potencia = (a, b) -> Math.pow(a, b);
        double res = potencia.apply(2,3);
        System.out.println(res);
    }
}
