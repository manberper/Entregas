package UD5Tarea5.Ej7;

import java.util.ArrayList;
import java.util.Collections;

public class MainEj7 {
    public static void main(String[] args) {
        ArrayList<Estudiante> estudiantes = new ArrayList<>();
        estudiantes.add(new Estudiante("Patri",12,170));
        estudiantes.add(new Estudiante("Manuel",43,173));
        estudiantes.add(new Estudiante("Javier",72,189));
        estudiantes.add(new Estudiante("Alicia",52,168));
        estudiantes.add(new Estudiante("Alberto",35,189));

        System.out.println("Lista sin ordenar:");
        for (Estudiante e : estudiantes) {
            System.out.println(e);
        }
        // Ordenar la lista usando Comparable
        Collections.sort(estudiantes);

        System.out.println("Lista ordenada:");
        for (Estudiante e : estudiantes) {
            System.out.println(e);
        }
    }
}
