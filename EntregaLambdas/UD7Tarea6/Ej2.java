package UD7Tarea6;

import java.util.function.Function;

public class Ej2 {
    public static void main(String[] args) {
        Function<Integer, Integer> doubleFunction = n -> n * n;
        System.out.println(doubleFunction.apply(4));
    }
}
