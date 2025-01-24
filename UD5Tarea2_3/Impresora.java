package UD5Tarea2_3;

public class Impresora {
    private Toner toner;
    private int paginasImpresas;
    private boolean dobleCara;

    public Impresora(Toner toner, int paginasImpresas, boolean dobleCara) {
        this.toner = toner;
        this.paginasImpresas = paginasImpresas;
        this.dobleCara = dobleCara;
    }

    public void setDobleCara(boolean dobleCara) {
        this.dobleCara = dobleCara;
    }

    public int getPaginasImpresas() {
        return paginasImpresas;
    }

    public void imprimir(int pag){
        if (dobleCara && toner.nivelTinta >= pag){
            System.out.println("La impresora utiliza las dos caras... imprimiendo..");
            System.out.println("Se han impreso " + (pag/2) + " páginas");
            this.paginasImpresas = paginasImpresas + pag/2;
            this.toner.nivelTinta = toner.nivelTinta - pag;
        } else if (!dobleCara && toner.nivelTinta >= pag){
            System.out.println("Impresión a una cara... imprimiendo..");
            System.out.println("Se han impreso "+ pag + " paginas.");
            this.paginasImpresas = paginasImpresas + pag;
            this.toner.nivelTinta = toner.nivelTinta - pag;
        } else {
            if (toner.nivelTinta < pag || toner.nivelTinta < 1) {
                System.out.println("Nivel de tinta insuficiente para esta impresión.");
            }
        }
    }
}
