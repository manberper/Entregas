public class Mago extends Heroes{
    protected int mana;

    public Mago(String nombre, int nivel, int puntosVida, int mana) {
        super(nombre, nivel, puntosVida);
        this.mana = mana;
    }


    @Override
    public void habilidadEspecial() {
        System.out.println(nombre + " lanza un hechizo poderoso!");
    }

    @Override
    public String toString() {
        return super.toString() + "Mana: " + mana + "\n";
    }
}
