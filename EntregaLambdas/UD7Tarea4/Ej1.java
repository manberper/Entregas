package UD7Tarea4;

import java.util.function.Predicate;

public class Ej1 {
    public static void main(String[] args) {
        Predicate<Integer> validate = v -> v >100;
        System.out.println(validate.test(238)); // True
        System.out.println(validate.test(7)); // False

    }
}
