package UD7Tarea5;

import java.util.function.Supplier;

public class Ej14 {
    public static void main(String[] args) {
        Supplier<Programador> programadorSupplier = () -> new Programador("Chino Cudeiro");
        Programador p1 = Programador.fabricaProgramadores(programadorSupplier);
        System.out.println("Programador 1: " + p1);
    }
}