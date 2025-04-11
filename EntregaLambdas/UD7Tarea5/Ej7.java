package UD7Tarea5;

import java.util.function.BiConsumer;

public class Ej7 {
    public static void main(String[] args) {
        BiConsumer<Integer, Integer> mult = (x,y) -> System.out.println(Math.multiplyExact(x,y));
        mult.accept(-9,7);
    }
}
