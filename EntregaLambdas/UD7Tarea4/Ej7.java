package UD7Tarea4;

import org.w3c.dom.ls.LSOutput;

import java.util.List;
import java.util.function.Predicate;

public class Ej7 {
    public static void main(String[] args) {
        Predicate<Integer> validate = v -> v.equals(22);
        List<Integer> numeros = List.of(26, 42, 22, 35, 7, 92, 5, 22, 28,11,47);
        System.out.println(numeros.stream().filter(validate).count()); // cuenta cuantos 22 hay en la lista
    }
}
