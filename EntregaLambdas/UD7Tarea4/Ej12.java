package UD7Tarea4;

import java.util.function.*;

public class Ej12 {
    public static void main(String[] args) {
        Ciudad ciudad1 = new Ciudad("Madrid", 3200000);
        Ciudad ciudad2 = new Ciudad("madrid", 3300000);
        Ciudad ciudad3 = new Ciudad("Barcelona", 1600000);
        Ciudad ciudad4 = new Ciudad("Madrid", 3400000);
        Predicate<Ciudad> mismaCiudad = ciudad -> ciudad.getNombre().equalsIgnoreCase(ciudad1.getNombre());
        System.out.println(mismaCiudad.test(ciudad2)); // True
        System.out.println(mismaCiudad.test(ciudad4)); // True
        System.out.println(mismaCiudad.test(ciudad3)); // False
    }
}
