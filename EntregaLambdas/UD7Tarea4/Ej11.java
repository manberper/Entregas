package UD7Tarea4;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Ej11 {
    public class Main {
        public static void main(String[] args) {
            List<Ciudad> ciudades = new ArrayList<>();
            ciudades.add(new Ciudad("Madrid", 3200000));
            ciudades.add(new Ciudad("Barcelona", 1600000));
            ciudades.add(new Ciudad("Valencia", 800000));
            ciudades.add(new Ciudad("Sevilla", 690000));
            ciudades.add(new Ciudad("Zaragoza", 670000));
            ciudades.add(new Ciudad("Elche", 230000));
            ciudades.add(new Ciudad("Málaga", 570000));
            ciudades.add(new Ciudad("Murcia", 440000));
            ciudades.add(new Ciudad("Eivissa", 50000));
            ciudades.add(new Ciudad("Elda", 55000));

            Predicate<Ciudad> predicado = ciudad ->
                    ciudad.getNombre().startsWith("E") && ciudad.getNumeroHabitantes() > 100000;

            filtrarCiudades(ciudades, predicado);
        }

        public static void filtrarCiudades(List<Ciudad> ciudades, Predicate<Ciudad> predicado) {
            System.out.println("\nCiudades que cumplen con el criterio:");
            ciudades.stream()
                    .filter(predicado)
                    .forEach(System.out::println);
        }
    }
}
class Ciudad {
    private String nombre;
    private int numeroHabitantes;

    public Ciudad(String nombre, int numeroHabitantes) {
        this.nombre = nombre;
        this.numeroHabitantes = numeroHabitantes;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumeroHabitantes() {
        return numeroHabitantes;
    }

    @Override
    public String toString() {
        return nombre + " (" + numeroHabitantes + " habitantes)";
    }
}