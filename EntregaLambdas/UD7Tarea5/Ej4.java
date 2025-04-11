package UD7Tarea5;

import java.util.function.Supplier;

public class Ej4 {
    public static void main(String[] args) {
        Supplier<String> supplier = () -> "Java es un lenguaje de programación";

        String mensaje = supplier.get();
        System.out.println(mensaje);
    }
}
