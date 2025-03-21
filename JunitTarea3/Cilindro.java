package UD5Tarea3_4;

public class Cilindro extends Forma{
    private double radio, altura;

    public Cilindro(String nombre, double radio, double altura) {
        super(nombre);
        this.radio = radio;
        this.altura = altura;
    }

    @Override
    public double area() {
        return 2 * Math.PI * radio * (radio + altura);
    }

    @Override
    public String toString() {
        return "Cilindro: " + "nombre: " +this.nombre + " radio: "+ this.radio + " altura: "+this.altura;
    }
}
