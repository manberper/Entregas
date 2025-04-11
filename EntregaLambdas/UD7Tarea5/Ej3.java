package UD7Tarea5;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Ej3 {
    public static void main(String[] args) {
        List<String> nombres = new ArrayList<>();
        Consumer<String> nombre = name -> System.out.println(name.charAt(name.length() -1));
        nombres.add("Pepe");
        nombres.add("Juan");
        nombres.add("Ana");
        nombres.add("Elena");
        nombres.add("Mar");
        nombres.add("Alexa");
        nombres.add("Raul");
        nombres.add("Carla");
        nombres.add("Bernardo");
        nombres.forEach(nombre);


    }
}
