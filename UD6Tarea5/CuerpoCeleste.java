package UD6Tarea5;

import java.util.Comparator;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class CuerpoCeleste {

    protected enum TipoCuerpoCeleste {
        ESTRELLA, PLANETA, PLANETA_ENANO, LUNA, COMETA, ASTEROIDE
    }
    private String nombre;
    private double periodoOrbital;
    private Set<CuerpoCeleste> satelites;
    private TipoCuerpoCeleste tipoCuerpo;

    public CuerpoCeleste(String nombre, TipoCuerpoCeleste tipoCuerpo, double periodoOrbital) {
        this.nombre = nombre;
        this.tipoCuerpo = tipoCuerpo;
        this.periodoOrbital = periodoOrbital;
        this.satelites = new HashSet<>();
    }

    public String getNombre() {
        return nombre;
    }

    public double getPeriodoOrbital() {
        return periodoOrbital;
    }

    public TipoCuerpoCeleste getTipoCuerpo() {
        return tipoCuerpo;
    }

    public Set<CuerpoCeleste> getSatlites() {
        return satelites;
    }

    public boolean addSatelite(CuerpoCeleste cuerpoCeleste) {
        return satelites.add(cuerpoCeleste);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        CuerpoCeleste that = (CuerpoCeleste) o;
        return Objects.equals(nombre, that.nombre) && tipoCuerpo == that.tipoCuerpo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, tipoCuerpo);
    }

    @Override
    public String toString() {
        return "CuerpoCeleste{" +
                "nombre='" + nombre + '\'' +
                ", periodoOrbital=" + periodoOrbital +
                ", satelites=" + satelites +
                ", tipoCuerpo=" + tipoCuerpo +
                '}';
    }
}
