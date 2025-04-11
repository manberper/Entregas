package UD7Tarea6;

import java.util.function.Function;

public class Ej7 {
    public static void main(String[] args) {
        Function<Double, String> doubleStringFunction = numero -> "Resultado: " + numero;
        System.out.println(doubleStringFunction.apply(4.17));
    }
}
