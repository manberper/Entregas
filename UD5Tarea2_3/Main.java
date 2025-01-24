package UD5Tarea2_3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Toner toner = new Toner(0,"MarcaSuperGuay");
        Impresora impresora = new Impresora(toner,0,true);

        // Añadir tinta al toner
        toner.setNivelTinta(90);

        impresora.imprimir(26); // imprime x numero de páginas
        System.out.println(toner.getNivelTinta()); // devuelve el nivel de tinta restanteº

        // Ahora imprime a una cara
        impresora.setDobleCara(false);

        // Vuelve a imprimir páginas
        impresora.imprimir(14);
        System.out.println(toner.getNivelTinta());
    }
}