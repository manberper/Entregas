package UD6Tarea1.Ej1;

public class Contacto implements Comparable<Contacto>{
    protected String name;
    protected String phoneNumber;

    public Contacto(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }


    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public Contacto createContact(){
        return new Contacto(name,phoneNumber);
    }

    @Override
    public String toString() {
        return "Contacto " +
                "Nombre: '" + getName() + '\'' +
                ", Numero: '" + getPhoneNumber();
    }

    @Override
    public int compareTo(Contacto o) {
        return this.name.compareTo(o.name);
    }
}
