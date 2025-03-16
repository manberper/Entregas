package UD6Tarea6;

class Parada {
    int numero;
    String nombre;
    String direccion;

    public Parada(int numero, String nombre, String direccion) {
        this.numero = numero;
        this.nombre = nombre;
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return numero + " - " + nombre + " - " + direccion;
    }
}