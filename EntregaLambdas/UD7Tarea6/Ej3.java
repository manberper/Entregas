package UD7Tarea6;

import java.util.function.Function;

public class Ej3 {
    public static void main(String[] args) {
        Function<String,Integer> stringIntegerFunction = s -> s.length();
        Function<Integer, Integer> potencia = n -> n * n;

        int largo = stringIntegerFunction.apply("Programación");
        int res = potencia.apply(largo);
        System.out.println(res);
    }
}
