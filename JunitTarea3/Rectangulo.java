package UD5Tarea3_4;

public class Rectangulo extends Forma{
    protected double longitud, ancho;

    public Rectangulo(String nombre, double longitud, double ancho) {
        super(nombre);
        this.longitud = longitud;
        this.ancho = ancho;
    }

    @Override
    public double area() {
        return longitud*ancho;
    }

    @Override
    public String toString() {
        return "Rectangulo:" + " nombre: " +this.nombre + " longitud: "+ this.longitud + " ancho: "+this.ancho;
    }
}
