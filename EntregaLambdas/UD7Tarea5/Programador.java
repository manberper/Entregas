package UD7Tarea5;
import java.time.LocalDate;
import java.util.function.Supplier;

public class Programador {
    private String nombre;
    private double sueldo;
    private LocalDate fechaInicio;

    public Programador(String nombre, double sueldo, LocalDate fechaInicio) {
        this.nombre = nombre;
        this.sueldo = sueldo;
        this.fechaInicio = fechaInicio;
    }

    public Programador(String nombre) {
        this(nombre, 50000.0, LocalDate.now()); // 50k por defecto ejercicio 14
    }

    public static Programador fabricaProgramadores(Supplier<Programador> supplier) {
        return supplier.get();
    }

    @Override
    public String toString() {
        return "Programador{" +
                "nombre='" + nombre + '\'' +
                ", sueldo=" + sueldo +
                ", fechaInicio=" + fechaInicio +
                '}';
    }
}