public class Arquero extends Heroes{
    protected int precision;

    public Arquero(String nombre, int nivel, int vida, int precision) {
        super(nombre, nivel, vida);
        this.precision = precision;
    }

    @Override
    public void habilidadEspecial() {
        System.out.println(nombre + " dispara una flecha certera!");
    }

    @Override
    public String toString() {
        return super.toString() + "Precisión: " + precision + "\n";
    }
}
