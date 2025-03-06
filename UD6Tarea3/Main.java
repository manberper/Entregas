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
            // Iniciar el juego
            iniciarJuego();

            // Preguntar al usuario si desea jugar de nuevo
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
        // Crear el mapa de ubicaciones
        creaMapa();

        // Empezar en la ubicación 0 (Clase de programación)
        int ubicacionActual = 0;
        boolean juegoActivo = true;

        while (juegoActivo) {
            // Obtener la ubicación actual
            Ubicacion ubicacion = ubicaciones.get(ubicacionActual);
            System.out.println(ubicacion.getDescripcion());

            // Mostrar las salidas válidas
            System.out.print("Tus salidas válidas son: ");
            for (Map.Entry<String, Integer> exit : ubicacion.getExits().entrySet()) {
                System.out.print(exit.getKey() + " ");
            }
            System.out.println();

            // Leer y validar la dirección del usuario
            String direccion = validarEntrada(ubicacion);

            // Validar la dirección
            if (direccion.equals("Q")) {
                System.out.println("Has salido del juego.");
                juegoActivo = false; // Terminar el bucle del juego
            } else {
                // Mover a la nueva ubicación
                ubicacionActual = ubicacion.getExits().get(direccion);
            }
        }
    }

    public static String validarEntrada(Ubicacion ubicacion) {
        boolean valido = false;
        while (!valido) {
            System.out.print("Elige una dirección (o Q para salir): ");
            String entrada = sc.nextLine().toUpperCase();

            // Verificar si la entrada es válida
            if (ubicacion.getExits().containsKey(entrada) || entrada.equals("Q")) {
                valido = true;
                return entrada; // La entrada es válida
            } else {
                System.out.println("Entrada no válida. Por favor, elige una dirección válida.");
            }
        }
        return "";
    }

    public static void creaMapa() {
        // Crear las ubicaciones
        ubicaciones.put(0, new Ubicacion(0, "Estás sentado en la clase de programación"));
        ubicaciones.put(1, new Ubicacion(1, "Estás en la cima de una montaña"));
        ubicaciones.put(2, new Ubicacion(2, "Estás bañándote en la playa"));
        ubicaciones.put(3, new Ubicacion(3, "Estás dentro de un edificio muy alto"));
        ubicaciones.put(4, new Ubicacion(4, "Estás de pie en un puente"));
        ubicaciones.put(5, new Ubicacion(5, "Estás en un bosque"));

        // Añadir las salidas para cada ubicación
        ubicaciones.get(0).addExit("N", 1);  // Clase de programación -> Montaña (Norte)
        ubicaciones.get(0).addExit("S", 2);  // Clase de programación -> Playa (Sur)
        ubicaciones.get(0).addExit("E", 3);  // Clase de programación -> Edificio (Este)
        ubicaciones.get(0).addExit("O", 4);  // Clase de programación -> Puente (Oeste)
        ubicaciones.get(0).addExit("Q", 0);  // Clase de programación -> Salir (Q)

        ubicaciones.get(1).addExit("N", 5);  // Montaña -> Bosque (Norte)
        ubicaciones.get(1).addExit("S", 2);  // Montaña -> Playa (Sur)
        ubicaciones.get(1).addExit("E", 3);  // Montaña -> Edificio (Este)
        ubicaciones.get(1).addExit("O", 4);  // Montaña -> Puente (Oeste)
        ubicaciones.get(1).addExit("Q", 0);  // Montaña -> Salir (Q)

        ubicaciones.get(2).addExit("N", 1);  // Playa -> Montaña (Norte)
        ubicaciones.get(2).addExit("Q", 0);  // Playa -> Salir (Q)

        ubicaciones.get(3).addExit("O", 1);  // Edificio -> Montaña (Oeste)
        ubicaciones.get(3).addExit("Q", 0);  // Edificio -> Salir (Q)

        ubicaciones.get(4).addExit("E", 1);  // Puente -> Montaña (Este)
        ubicaciones.get(4).addExit("Q", 0);  // Puente -> Salir (Q)

        ubicaciones.get(5).addExit("S", 1);  // Bosque -> Montaña (Sur)
        ubicaciones.get(5).addExit("O", 4);  // Bosque -> Puente (Oeste)
        ubicaciones.get(5).addExit("Q", 0);  // Bosque -> Salir (Q)
    }
}