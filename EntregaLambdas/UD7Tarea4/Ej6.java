package UD7Tarea4;

import java.util.List;
import java.util.function.Predicate;

public class Ej6 {
    public static void main(String[] args) {
        Predicate<Integer> validate = v -> v >=25 && v<=30;
        List<Integer> numeros = List.of(26, 42, 35, 7, 92, 5, 28,11,47);
        numeros.stream().filter(validate).forEach(integer -> System.out.println(integer));
        // for (Integer num : numeros){if (validate.test(num)) System.out.println(num);}

    }
}
