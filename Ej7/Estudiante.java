package UD5Tarea5.Ej7;

public class Estudiante implements Comparable<Estudiante>{
    String nombre;
    int edad;
    int altura;

    public Estudiante(String nombre, int edad, int altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.altura = altura;
    }

    @Override
    public int compareTo(Estudiante o) {
        // Primero ordenamos por altura
        if (this.altura != o.altura) {
            return Integer.compare( o.altura, this.altura);
        }
        // Si la altura es la misma, ordenamos por edad
        return Integer.compare(o.edad, this.edad);
    }

    @Override
    public String toString() {
        return "Estudiante{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", altura=" + altura +
                '}';
    }
}
