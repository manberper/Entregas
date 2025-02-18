package UD6Tarea2;

public class Cancion implements Comparable<Cancion> {
    protected String titulo;
    protected double duracion;

    public Cancion(String titulo, double duracion) {
        this.titulo = titulo;
        this.duracion = duracion;
    }

    public String getTitulo() {
        return titulo;
    }


    @Override
    public String toString() {
        return this.titulo+": "+this.duracion;
    }

    @Override
    public int compareTo(Cancion o) {
        return this.titulo.compareTo(o.titulo);
    }
}
