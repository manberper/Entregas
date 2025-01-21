package Geometricas;

public class MainGeometricas {
    public static void main(String[] args) {
        Cilindro prueba = new Cilindro(3,5);
        System.out.println(prueba.getVolumen());

        // Prueba con números negativos, debe devolver 0
        Cilindro pruebaNegativo = new Cilindro(-3, 5);
        System.out.println(pruebaNegativo.getVolumen());
    }
}
