package UD6Tarea1.Ej1;

import java.util.ArrayList;
import java.util.Objects;

public class TelefonoMovil implements Comparable<Contacto> {
    protected String myNumber;
    protected ArrayList<Contacto> myContacts;

    public TelefonoMovil(String newNumber) {
        this.myNumber = newNumber;
        this.myContacts = new ArrayList<>();
    }


    public boolean addNewContact(String nombre, String numero, ArrayList<Contacto> myContacts) {
        Contacto contactoExistente = findContact(nombre); // Busca por nombre
        if (contactoExistente == null) {
            Contacto nuevoContacto = new Contacto(nombre, numero);
            myContacts.add(nuevoContacto);
            System.out.println("Contacto creado.");
            return true;
        } else {
            System.out.println("El contacto ya existe.");
            return false;
        }
    }

    public boolean updateContact(Contacto contacto, Contacto updateContacto) {
        Contacto contactoExistente = findContact(contacto.name);
        if (contactoExistente != null) {
            int posicion = myContacts.indexOf(contactoExistente);
            myContacts.set(posicion, updateContacto);
            System.out.println("Contacto actualizado correctamente.");
            return true;
        }
        System.out.println("El contacto no existe.");
        return false;
    }

    public boolean removeContact(String nombre) {
        Contacto contacto = findContact(nombre);
        if (contacto != null) {
            myContacts.remove(contacto);
            System.out.println("Contacto borrado");
            return true;
        } else {
            System.out.println("El contacto no existe.");
            return false;
        }
    }

    public Contacto findContact(String nombre) {
        for (Contacto contacto : myContacts) {
            if (contacto.name.equalsIgnoreCase(nombre) || contacto.phoneNumber.equalsIgnoreCase(nombre)) {
                return contacto;
            }
        }
        return null;
    }

    public void queryContact(String clave) {
        boolean encontrado = false;
        String claveLower = clave.toLowerCase();
        
        for (Contacto contacto : myContacts) {
            if (contacto.name.toLowerCase().contains(claveLower) || contacto.phoneNumber.contains(clave)) {
                System.out.println(contacto.toString());
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontraron contactos con: " + clave);
        }
    }

    public void printContacts() {
        if (myContacts.isEmpty()) {
            System.out.println("No hay contactos guardados.");
            return;
        }

        System.out.println("Lista de contactos:");
        for (Contacto contacto : myContacts) {
            System.out.println("Nombre: " + contacto.getName() + " Número: " + contacto.getPhoneNumber());
        }
    }

    public boolean existeNombre(String nombre){
        for (Contacto contacto : myContacts){
            if (Objects.equals(contacto.name, nombre)){
                return true;
            }
        }
        return false;
    }
    public void contarContactos(){
        System.out.println("El número de contactos almacenados es: "+ myContacts.size());
    }

    public void borrarTodo(){
            myContacts.clear();
            System.out.println("Todos los contactos han sido borrados.");
    }

    @Override
    public int compareTo(Contacto o) {
        return 0;
    }
}
