package UD7Tarea4;

import java.util.List;
import java.util.function.Predicate;

public class Ej8 {
    public static void main(String[] args) {
        Predicate<String> validateStarts = v -> v.startsWith("A");
        Predicate<String> validateLength = n -> n.length() == 5;
        Predicate<String> validateCombinado = validateStarts.or(validateLength);
        List<String> names = List.of("Ana","Juan","Marta","Pepico","Jose","Manuel");
        names.stream().filter(validateCombinado).forEach(s -> System.out.println(s));
    }
}
