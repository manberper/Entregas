package UD7Tarea5;

import java.util.function.Consumer;

public class Ej1 {

    public static void main(String[] args) {
        Consumer<String> stringConsumer = str -> System.out.println(str);
        stringConsumer.accept("Estoy en clase de programación");
    }
}
