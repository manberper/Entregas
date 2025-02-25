public class Guerrero extends Heroes{
    protected int fuerza;

    public Guerrero(String nombre, int nivel, int vida, int fuerza) {
        super(nombre, nivel, vida);
        this.fuerza = fuerza;
    }

    @Override
    public void habilidadEspecial() {
        System.out.println(nombre + " ataca con un golpe fuerte!");
    }

    @Override
    public String toString() {
        return super.toString() + "Fuerza: " + fuerza + "\n";
    }
}
