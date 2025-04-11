package UD7Tarea5;

import java.util.function.BiConsumer;

public class Ej8 {
    public static void main(String[] args) {
        BiConsumer<Integer, Integer> sum = (x, y) -> System.out.println(x+y);
        BiConsumer<Integer, Integer> rest = (x, y) -> System.out.println(x-y);
        BiConsumer<Integer, Integer> div = (x, y) -> System.out.println(Math.divideExact(x,y));

        sum.accept(-9,7);
        rest.accept(-9,7);
        div.accept(-9,7);
    }
}
