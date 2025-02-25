import java.util.ArrayList;

public abstract class Heroes {
    protected String nombre;
    protected int nivel;
    protected int puntosVida;
    protected ArrayList<Armas> arsenal;

    public Heroes(String nombre, int nivel, int puntosVida) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.puntosVida = puntosVida;
        this.arsenal = new ArrayList<>();
    }

    public void agregarArma(Armas arma) {
        arsenal.add(arma);
        System.out.println("Arma '" + arma.getNombreArma() + "' añadida a " + nombre);
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        String resultado = "Nombre: " + nombre + "\n" +
                "Nivel: " + nivel + "\n" +
                "Puntos de Vida: " + puntosVida + "\n" +
                "Arsenal:\n";
        if (arsenal.isEmpty()) {
            resultado += "No tiene armas\n";
        } else {
            for (Armas arma : arsenal) {
                resultado += "  - " + arma.getNombreArma() + " (Daño: " + arma.getDmg() + ")\n";
            }
        }
        return resultado;
    }

    public abstract void habilidadEspecial();

}

