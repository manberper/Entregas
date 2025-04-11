package UD7Tarea5;

import java.time.LocalDate;
import java.util.function.Supplier;

public class Ej12y13 {
    public static void main(String[] args) {
        Supplier<Programador> programadorSupplier = () -> new Programador("Ana López",1500, LocalDate.of(2022, 5, 15));
        Programador prueba = programadorSupplier.get();
        System.out.println(prueba);

        System.out.println();

        Supplier<Programador> programadorSupplier1 =() -> new Programador("Perico Lospalotes");
        Programador prueba1 = programadorSupplier1.get();
        System.out.println(prueba1);

    }
}
