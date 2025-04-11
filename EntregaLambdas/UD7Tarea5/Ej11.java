package UD7Tarea5;


import java.time.LocalDate;
import java.util.function.Supplier;

public class Ej11 {
    public static void main(String[] args) {
        Supplier<LocalDate> fechaActual = () -> LocalDate.now(); // localdatetime para mostrar también la hora
        System.out.println("Fecha actual: " + fechaActual.get());
    }
}
