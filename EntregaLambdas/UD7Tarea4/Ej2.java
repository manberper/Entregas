package UD7Tarea4;

import java.util.function.Predicate;

public class Ej2 {
    public static void main(String[] args) {
        Predicate<Integer> validate = v -> v >=100 && v<=300;
        System.out.println(validate.test(250)); // True
        System.out.println(validate.test(95)); // False
    }
}
