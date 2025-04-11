package UD7Tarea5;

import java.util.LinkedHashMap;

public class Ej10 {
    public static void main(String[] args) {
        LinkedHashMap<Integer, String> map = new LinkedHashMap<>();
        map.put(1, "Casa");
        map.put(2, "Silla");
        map.put(3, "Avion");
        map.put(4, "Carretera");
        map.put(5, "Montaña");

        map.forEach((key, value) -> System.out.println("Clave: " + key + "-||- Valor: " + value));
    }
}
