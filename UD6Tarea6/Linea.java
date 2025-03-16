package UD6Tarea6;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Linea {
    String id;
    List<int[]> conexiones; // [parada1, parada2, tiempo]

    public Linea(String id) {
        this.id = id;
        this.conexiones = new ArrayList<>();
    }

    public void agregarTiempo(int primera, int segunda, int tiempo) {
        conexiones.add(new int[]{primera, segunda, tiempo});
    }

    public int getTiempo(int primera, int segunda) {
        for (int[] conexion : conexiones) {
            if (conexion[0] == primera && conexion[1] == segunda) {
                return conexion[2];
            }
        }
        return -1;
    }

    public Set<Integer> getParadas() {
        Set<Integer> paradas = new HashSet<>();
        for (int[] conexion : conexiones) {
            paradas.add(conexion[0]);
            paradas.add(conexion[1]);
        }
        return paradas;
    }
}