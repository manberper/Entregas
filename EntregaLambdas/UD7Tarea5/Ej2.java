package UD7Tarea5;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class Ej2 {
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        Consumer<Integer> numeros = num -> System.out.println(num);
        integerList.add(1);
        integerList.add(2);
        integerList.add(3);
        integerList.add(4);
        integerList.add(5);
        integerList.add(6);
        integerList.add(7);
        integerList.add(8);
        integerList.add(9);
        integerList.add(10);

        integerList.forEach(numeros);


    }
}
