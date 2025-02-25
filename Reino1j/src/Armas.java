import java.util.ArrayList;

public class Armas {
    protected String nombreArma;
    protected int dmg;

    public Armas(String nombreArma, int dmg) {
        this.nombreArma = nombreArma;
        this.dmg = dmg;
    }

    public static Armas encuentraArmas(ArrayList<Armas> armas, String nombre) {
        for (Armas arma : armas) {
            if (arma.nombreArma.contains(nombre)) {
                return arma;
            }
        }
        return null;
    }

    public String getNombreArma() {
        return nombreArma;
    }

    public void setNombreArma(String nombreArma) {
        this.nombreArma = nombreArma;
    }

    public int getDmg() {
        return dmg;
    }

    public void setDmg(int dmg) {
        this.dmg = dmg;
    }

    @Override
    public String toString() {
        return "Armas{" +
                "nombreArma='" + nombreArma + '\'' +
                ", dmg=" + dmg +
                '}';
    }
}
