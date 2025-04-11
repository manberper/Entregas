package UD7Tarea5;

import java.util.function.Supplier;

public class Ej5 {
    public static void main(String[] args) {
        Supplier<Double> randomSupplier = () -> Math.random();
        System.out.println("Número aleatorio: " + randomSupplier.get());
    }
}
