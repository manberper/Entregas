package UD5Tarea3_4;

public class Esfera extends Forma{
    protected double radio;

    public Esfera(String nombre, double radio) {
        super(nombre);
        this.radio = radio;
    }


    @Override
    public double area() {
        return 4*Math.PI*Math.pow(radio,2);
    }

    @Override
    public String toString() {
        return "Esfera:" + " nombre: " +this.nombre + " radio: "+ this.radio;

    }
}
