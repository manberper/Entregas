package UD7Tarea6;

import java.util.function.Function;

public class Ej1 {
    public static void main(String[] args) {
        Function<String,Integer> stringIntegerFunction =s -> s.length();
        int longitud = stringIntegerFunction.apply("Programación");
        System.out.println(longitud);
    }
}
