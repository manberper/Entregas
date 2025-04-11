package UD7Tarea4;

import java.util.List;
import java.util.function.Predicate;

public class Ej9 {
    public static void main(String[] args) {
        Predicate<String> validateStarts = v -> v.startsWith("P");
        Predicate<String> validateNot =Predicate.not(validateStarts);
        List<String> names = List.of("Ana","Juan","Marta","Pepico","Jose","Manuel");
        names.stream().filter(validateNot).forEach(s -> System.out.println(s));
    }
}
