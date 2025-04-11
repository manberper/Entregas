package UD7Tarea4;

import java.util.function.BiPredicate;

public class Ej5 {
    public static void main(String[] args) {
        BiPredicate<String,String> validate =(s, s2) -> s.equals(s2);
        System.out.println(validate.test("Hola","Hola")); // True
        System.out.println(validate.test("Hola","Adios")); // False
    }
}
