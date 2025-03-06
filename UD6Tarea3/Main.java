package UD6Tarea3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static HashMap<Integer, Ubicacion> ubicaciones = new HashMap<>();

    public static void main(String[] args) {
        boolean jugarDeNuevo = true;

        while (jugarDeNuevo) {
            iniciarJuego();

            System.out.print("¿Deseas jugar de nuevo? (S/N): ");
            String respuesta = sc.nextLine().toUpperCase();

            if (!respuesta.equals("S")) {
                jugarDeNuevo = false;
                System.out.println("Gracias por jugar. ¡Hasta la próxima!");
            }
        }

        sc.close();
    }

    public static void iniciarJuego() {
        creaMapa();

        int ubicacionActual = 0;
        boolean juegoActivo = true;

        while (juegoActivo) {
            Ubicacion ubicacion = ubicaciones.get(ubicacionActual);
            System.out.println(ubicacion.getDescripcion());

            // Mostrar las salidas
            System.out.print("Tus salidas válidas son: ");
            for (Map.Entry<String, Integer> exit : ubicacion.getExits().entrySet()) {
                System.out.print(exit.getKey() + " ");
            }
            System.out.println();

            String direccion = validarEntrada(ubicacion);

            if (direccion.equals("Q")) {
                System.out.println("Has salido del juego.");
                juegoActivo = false; // Terminar el bucle del juego
            } else {
                ubicacionActual = ubicacion.getExits().get(direccion);
            }
        }
    }

    public static String validarEntrada(Ubicacion ubicacion) {
        boolean valido = false;
        while (!valido) {
            System.out.print("Elige una dirección (o Q para salir): ");
            String entrada = sc.nextLine().toUpperCase();

            if (ubicacion.getExits().containsKey(entrada) || entrada.equals("Q")) {
                valido = true;
                return entrada;
            } else {
                System.out.println("Entrada no válida. Por favor, elige una dirección válida.");
            }
        }
        return "";
    }

    public static void creaMapa() {
        // ubicaciones
        ubicaciones.put(0, new Ubicacion(0, "Estás sentado en la clase de programación"));
        ubicaciones.put(1, new Ubicacion(1, "Estás en la cima de una montaña"));
        ubicaciones.put(2, new Ubicacion(2, "Estás bañándote en la playa"));
        ubicaciones.put(3, new Ubicacion(3, "Estás dentro de un edificio muy alto"));
        ubicaciones.put(4, new Ubicacion(4, "Estás de pie en un puente"));
        ubicaciones.put(5, new Ubicacion(5, "Estás en un bosque"));

        // las salidas
        ubicaciones.get(0).addExit("N", 1);
        ubicaciones.get(0).addExit("O", 2);
        ubicaciones.get(0).addExit("E", 3);
        ubicaciones.get(0).addExit("S", 4);
        ubicaciones.get(0).addExit("Q", 0);

        ubicaciones.get(1).addExit("N", 5);
        ubicaciones.get(1).addExit("O", 2);
        ubicaciones.get(1).addExit("E", 3);
        ubicaciones.get(1).addExit("S", 4);
        ubicaciones.get(1).addExit("Q", 0);

        ubicaciones.get(2).addExit("N", 5);
        ubicaciones.get(2).addExit("Q", 0);

        ubicaciones.get(3).addExit("O", 1);
        ubicaciones.get(3).addExit("Q", 0);

        ubicaciones.get(4).addExit("E",2);
        ubicaciones.get(4).addExit("N",1);
        ubicaciones.get(4).addExit("Q",0);

        ubicaciones.get(5).addExit("S", 1);
        ubicaciones.get(5).addExit("O", 2);
        ubicaciones.get(5).addExit("Q", 0);    }
}
