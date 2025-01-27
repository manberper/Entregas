package UD5Tarea3_4;

import java.util.ArrayList;
import java.util.Scanner;

public class MainPintura {
    public static void main(String[] args) {
        Pintura pintura = new Pintura(250);
        ArrayList<Forma> formas = new ArrayList<>();
        formas.add(new Rectangulo("rectangulo",20,35));
        formas.add(new Esfera("esfera",15));
        formas.add(new Cilindro("cilindro",10,30));

        Scanner sc = new Scanner(System.in);

        int bucle = -1;
        while (bucle != 0) {

            System.out.println("""
                Selecciona una forma con la que trabajar:
                1. Rectangulo.
                2. Esfera.
                3. Cilindro.""");
            int sel = sc.nextInt();

            switch (sel) {
                case 1:
                    System.out.println("Introduce el nombre del rectángulo:");
                    sc.nextLine(); // Limpiar el búfer antes de leer cadenas
                    String nombre = sc.nextLine();
                    System.out.println("Introduce la longitud del rectángulo:");
                    double longitud = sc.nextDouble();
                    System.out.println("Introduce el ancho del rectángulo:");
                    double ancho = sc.nextDouble();
                    formas.add(new Rectangulo(nombre, longitud, ancho));
                    break;

                case 2:
                    System.out.println("Introduce el nombre de la esfera:");
                    sc.nextLine(); // Limpiar el búfer antes de leer cadenas
                    nombre = sc.nextLine();
                    System.out.println("Introduce el radio de la esfera:");
                    double radio = sc.nextDouble();
                    formas.add(new Esfera(nombre, radio));
                    break;

                case 3:
                    System.out.println("Introduce el nombre del cilindro:");
                    sc.nextLine(); // Limpiar el búfer antes de leer cadenas
                    nombre = sc.nextLine();
                    System.out.println("Introduce el radio del cilindro:");
                    radio = sc.nextDouble();
                    System.out.println("Introduce el alto del cilindro:");
                    double alto = sc.nextDouble();
                    formas.add(new Cilindro(nombre, radio, alto));
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

            System.out.println("""
                    ¿Quieres introducir más formas?
                    1. Continuar
                    0. Ver resultados""");
            bucle = sc.nextInt();
        }



        for (Forma forma : formas){
            pintura.pinturaNecesaria(forma);
        }
    }
}
