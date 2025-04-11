package UD7Tarea4;

import java.util.function.Predicate;

public class Ej4 {
    public static void main(String[] args) {
        Predicate<Integer> validate = v -> v !=100;
        System.out.println(validate.test(250)); // True
        System.out.println(validate.test(100)); // False
    }
}
