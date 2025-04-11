package UD7Tarea6;

import java.util.function.BiFunction;
import java.util.function.Function;

public class Ej5 {
    public static void main(String[] args) {
        BiFunction<Integer,Integer,Integer> sumaInt = (x, y) -> x+y;
        System.out.println(sumaInt.apply(8,7));
    }
}
