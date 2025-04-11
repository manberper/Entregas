package UD7Tarea4;

public class City { // renombrar a ciudad, está duplicado por el ej11
    private String nombre;
    private int numeroHabitantes;

    public City(String nombre, int numeroHabitantes) { // renombrar a ciudad, está duplicado por el ej11
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

