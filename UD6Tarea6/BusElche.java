package UD6Tarea6;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BusElche {
    private static final Map<Integer, Parada> paradas = new HashMap<>();
    private static final Map<String, Linea> lineas = new HashMap<>();

    public static int pedirInt(){
       Scanner sc = new Scanner(System.in);
        int num;
        try {
            num = sc.nextInt();
            if (num > 0) {
                sc.nextLine();
                return num;
            } else {
                System.out.println("Valor invalido");
                sc.nextLine();
            }
        } catch (Exception e) {
            System.err.println("Solo se admiten números!!");
            sc.nextLine();
        }
        return -1;
    }

    private static void creaRutas() {
        // Crear paradas
        paradas.put(1, new Parada(1, "Doctor Caro", "C / Doctor Caro"));
        paradas.put(2, new Parada(2, "Avinguda llibertat", "Avinguda llibertat 11"));
        paradas.put(3, new Parada(3, "Federico García Lorca", "Asilo"));
        paradas.put(71, new Parada(71, "Parada 71", "Dirección 71"));
        paradas.put(335, new Parada(335, "Gabriel Miro", "c/ Gabriel Miro"));

        // Crear líneas y tiempos
        Linea lineaA = new Linea("A");
        lineaA.agregarTiempo(1, 2, 75);
        lineaA.agregarTiempo(2, 3, 60);
        lineas.put("A", lineaA);

        Linea lineaI = new Linea("I");
        lineaI.agregarTiempo(3, 71, 50);
        lineaI.agregarTiempo(71, 335, 100);
        lineas.put("I", lineaI);

        Linea lineaJ = new Linea("J");
        lineaJ.agregarTiempo(2, 89, 40);
        lineaJ.agregarTiempo(89, 90, 80);
        lineas.put("J", lineaJ);
    }

    private static int calculaRuta(int inicio, int fin, String lineaInicio) {
        // siempre que devuelve -1 indica que no encuentra parada o conexión para imprimir que no existe
        Linea lineaActual = lineas.get(lineaInicio);
        Linea lineaFinal = null;
        int tiempoTotal = 0;
        int paradaActual = inicio;

        if (lineaActual == null) return -1;

        // buscar la linea de fin
        for (Linea linea : lineas.values()) {
            if (linea.getParadas().contains(fin)) {
                lineaFinal = linea;
                break;
            }
        }

        if (lineaFinal == null) return -1;

        // si no hay que cambiar de linea
        if (lineaActual.getParadas().contains(fin)) {
            while (paradaActual != fin) {
                int siguienteParada = -1;
                int tiempoMinimo = Integer.MAX_VALUE;

                // Buscar la conexión con el tiempo mínimo desde la parada actual
                for (int paradaDestino : lineaActual.getParadas()) {
                    int tiempo = lineaActual.getTiempo(paradaActual, paradaDestino);
                    if (tiempo != -1 && tiempo < tiempoMinimo) {
                        siguienteParada = paradaDestino;
                        tiempoMinimo = tiempo;
                    }
                }

                if (siguienteParada == -1) return -1;

                tiempoTotal += tiempoMinimo;
                paradaActual = siguienteParada;
            }
            return tiempoTotal;
        }

        // buscar la conexion en comun
        int paradaComun = -1;
        for (Integer parada : lineaActual.getParadas()) {
            if (lineaFinal.getParadas().contains(parada)) {
                paradaComun = parada;
                break;
            }
        }

        if (paradaComun == -1) return -1;

        // calcula el tiempo hasta el cambio de linea
        while (paradaActual != paradaComun) {
            int siguienteParada = -1;
            int tiempoMinimo = Integer.MAX_VALUE;

            for (int paradaDestino : lineaActual.getParadas()) {
                int tiempo = lineaActual.getTiempo(paradaActual, paradaDestino);
                if (tiempo != -1 && tiempo < tiempoMinimo) {
                    siguienteParada = paradaDestino;
                    tiempoMinimo = tiempo;
                }
            }

            if (siguienteParada == -1) return -1;

            tiempoTotal += tiempoMinimo;
            paradaActual = siguienteParada;
        }

        // cambia a la ultima linea y calcula el tiempo
        while (paradaActual != fin) {
            int siguienteParada = -1;
            int tiempoMinimo = Integer.MAX_VALUE;

            for (int paradaDestino : lineaFinal.getParadas()) {
                int tiempo = lineaFinal.getTiempo(paradaActual, paradaDestino);
                if (tiempo != -1 && tiempo < tiempoMinimo) {
                    siguienteParada = paradaDestino;
                    tiempoMinimo = tiempo;
                }
            }

            if (siguienteParada == -1) return -1;

            tiempoTotal += tiempoMinimo;
            paradaActual = siguienteParada;
        }

        return tiempoTotal;
    }

    private static void imprimeParadas() {
        for (Map.Entry<Integer, Parada> parada : paradas.entrySet()) {
            System.out.println(parada.getValue());
        }
    }

    private static void imprimeLinea(int num) {
        for (Map.Entry<String, Linea> linea : lineas.entrySet()) {
            if (linea.getValue().getParadas().contains(num)) {
                System.out.println("Línea " + linea.getKey());
            }
        }
    }

    public static void main(String[] args) {
        boolean selVal = false;
        int paradaInicio = 0;
        int paradaFin = 0;
        Parada inicio = null;
        String lineaInicio = "";
        Parada fin = null;
        creaRutas();

        Scanner sc = new Scanner(System.in);

        while (!selVal) {
            System.out.print("Elige parada de inicio: \n");
            imprimeParadas();
            paradaInicio = pedirInt();
            inicio = paradas.get(paradaInicio);
            if (inicio == null) {
                System.out.println("Parada no encontrada.");
            } else selVal = true;
        }

        System.out.println("Has elegido " + inicio);

        selVal = false;
        while (!selVal) {
            imprimeLinea(paradaInicio);
            System.out.print("Bus Línea: ");
            lineaInicio = sc.next().toUpperCase();
            // te deja elegir lineas que no están en esta parada, termina en un error de que no existe la ruta
            Linea linea = lineas.get(lineaInicio);
            if (linea == null) {
                System.out.println("Línea no encontrada.");
            } else selVal = true;
        }


        selVal= false;
        while (!selVal) {
            System.out.print("Elige parada fin: \n");
            imprimeParadas();
            paradaFin = pedirInt();
            fin = paradas.get(paradaFin);
            if (fin == null) {
                System.out.println("Parada no encontrada.");
            } else selVal = true;
        }
        System.out.println("Has elegido " + fin);

        int tiempoTotal = calculaRuta(paradaInicio, paradaFin, lineaInicio);
        if (tiempoTotal == -1) {
            System.out.println("No existe esa ruta");
        } else {
            System.out.println("Tiempo trayecto: " + tiempoTotal + " segundos, " + (tiempoTotal / 60) + " minutos y " + (tiempoTotal % 60) + " segundos.");
        }
    }
}
