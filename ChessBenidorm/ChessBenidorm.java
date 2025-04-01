package LecturaEscritura;
import java.util.*;
import java.io.*;

public class ChessBenidorm {
    public static ArrayList<String[]> leer(String ruta) {
        ArrayList<String[]> datos = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(ruta))) {
            // esto descarta dos líneas
            br.readLine();
            br.readLine();

            String linea;
            while ((linea = br.readLine()) != null) {
                datos.add(linea.split(";"));
            }
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }

        return datos;
    }

    public static void escribir(ArrayList<String[]> datos, String ruta) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ruta))) {
            bw.write("Lista de jugadores alojados en Hotel Melià\n" +
                    "\n" +
                    "Ranking        Nombre\n" +
                    "---------------------------------------\n");
            for (String[] fila : datos) {
                if (fila.length > 0) {
                    String ultimaCelda = fila[fila.length - 1];
                    if (ultimaCelda.toUpperCase().contains("H")) {
                        bw.write(fila[0] + " -- " + fila[2]);
                        bw.newLine();
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error al escribir el archivo: " + e.getMessage());
        }
    }
    public static void main(String[] args) {
        String origen = "/home/manuel/Descargas/jugadores.txt";
        String destino = "/home/manuel/Descargas/alojados.txt";
        ArrayList<String[]> datos = leer(origen);
        escribir(datos,destino);
    }
}
