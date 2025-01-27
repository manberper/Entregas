package UD5Tarea3_4;

public class Pintura {
    protected double cobertura;

    public Pintura(double cobertura) {
        this.cobertura = cobertura;
    }

    public void pinturaNecesaria(Forma forma){
        System.out.println("El objeto "+forma.nombre+" necesita "+ (forma.area()/cobertura)+" de pintura para su cobertura.");;
    }
}
