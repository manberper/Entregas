package UD5Tarea2_3;

public class Toner {
    protected int nivelTinta;
    protected String marcaToner;

    public Toner(int nivelTinta, String marcaToner) {
        if (nivelTinta < 0){
            this.nivelTinta = -1;
        } else if (nivelTinta > 100) {
            this.nivelTinta = 100;
        } else this.nivelTinta = nivelTinta;
        this.marcaToner = marcaToner;
    }

    public int getNivelTinta() {
        return nivelTinta;
    }

    public void setNivelTinta(int masTinta) {
        if (masTinta < 0){
            System.out.println("Valor de tinta incompatible.");
            this.nivelTinta = -1;
        } else if (masTinta + nivelTinta > 100) {
            System.out.println("Has metido mucha tinta, la has liado pero el toner está lleno.");
            this.nivelTinta = 100;
        } else this.nivelTinta = this.nivelTinta + masTinta;
    }


}
