public class Asesino extends Heroes{
    protected int sigilo;

    public Asesino(String nombre, int nivel, int vida, int sigilo) {
        super(nombre, nivel, vida);
        this.sigilo = sigilo;
    }

    @Override
    public void habilidadEspecial() {
        System.out.println(nombre + " asesina en las sombras!");
    }

    @Override
    public String toString() {
        return super.toString() + "Sigilo: " + sigilo + "\n";
    }
}
