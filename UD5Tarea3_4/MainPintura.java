package UD5Tarea3_4;

import java.util.ArrayList;

public class MainPintura {
    public static void main(String[] args) {
        Pintura pintura = new Pintura(250);
        ArrayList<Forma> formas = new ArrayList<>();
        formas.add(new Rectangulo("rectangulo",20,35));
        formas.add(new Esfera("esfera",15));
        formas.add(new Cilindro("cilindro",10,30));

        for (Forma forma : formas){
            pintura.pinturaNecesaria(forma);
        }
    }
}
