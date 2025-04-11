package UD7Tarea5;

import java.util.function.BiConsumer;

public class Ej9 {
    public static void calculator(int a, int b, BiConsumer<Integer, Integer> operation) {
        operation.accept(a, b);
    }
    public static void main(String[] args) {
        BiConsumer<Integer, Integer> sum = (x, y) -> System.out.println("Suma: " + (x + y));
        BiConsumer<Integer, Integer> rest = (x, y) -> System.out.println("Resta: " + (x - y));
        BiConsumer<Integer, Integer> mult = (x, y) -> System.out.println("Multiplicación: " + (x * y));
        BiConsumer<Integer, Integer> div = (x, y) -> System.out.println("División: " + (x * y));

        System.out.println("Se calcula con los numeros -9 y 7:");
        calculator(-9, 7, sum);
        calculator(-9, 7, rest);
        calculator(-9, 7, mult);
        calculator(-9, 7, div);

    }
}
