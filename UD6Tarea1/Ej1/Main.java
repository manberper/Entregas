package UD6Tarea1.Ej1;

import java.util.Collections;
import java.util.Scanner;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    static TelefonoMovil tlf = new TelefonoMovil("666777888");

    public static int imprimirMenu() {
        boolean entradaValida = false;
        int opcion = -1;
        while (!entradaValida) {

            System.out.println("\nElige una opción: ");
            System.out.println("0 - Para imprimir menu");
            System.out.println("1 - Para imprimir contactos");
            System.out.println("2 - Para buscar contacto");
            System.out.println("3 - Para añadir");
            System.out.println("4 - Para saber cuantos contactos existen");
            System.out.println("5 - Para modificar");
            System.out.println("6 - Para eliminar");
            System.out.println("7 - Para eliminar todos los contactos");
            System.out.println("8 - Para ordenar la lista de contactos");
            System.out.println("10 - Para salir");
            System.out.println("99 - Realizar prueba de contactos");

            try {
                opcion = sc.nextInt();
                sc.nextLine(); // buffer
                if (opcion >= 0 && (opcion <= 10 || opcion == 99)) {
                    entradaValida = true; // Opción válida, terminar el ciclo
                } else {
                    System.out.println("Opción no válida. Intenta de nuevo.");
                }
            } catch (Exception e) {
                sc.nextLine(); // buffer
                System.out.println("Solo se permiten números.");
            }
        }
        return opcion;
    }
    public static String validarNombre(){
        boolean entradaNombre = false;
        String nombre = "";

        // Validación del nombre
        while (!entradaNombre) {
            System.out.println("Introduce el nombre del contacto:");
            nombre = sc.nextLine();

            if (nombre.isEmpty()) {
                System.out.println("El nombre no puede estar vacío.");
            } else if (!Character.isLetter(nombre.charAt(0))) {
                System.out.println("El nombre debe comenzar por una letra.");
            } else if (tlf.existeNombre(nombre))  {
                System.out.println("No se admiten contactos con nombre duplicado.");
            } else {
                entradaNombre = true;
                System.out.println("Nombre válido: " + nombre);
            }
        }
        return nombre;
    }
    public static String validarNumero(){
        boolean entradaNumero = false;
        String numero = "";
        // Validación del número
        while (!entradaNumero) {
            try {
                System.out.println("Introduce el número de teléfono de usuario (9 dígitos):");
                int num = sc.nextInt();
                numero = String.valueOf(num);

                if (numero.length() != 9) {  // Valida exactamente 9 dígitos
                    System.out.println("El número debe tener exactamente 9 dígitos.");
                } else if (num < 0) {
                    System.out.println("No se admiten números negativos.");
                } else if (tlf.findContact(numero) != null) {
                    System.out.println("El número ya existe en la lista de contactos.");
                } else {
                    System.out.println("Número válido: " + numero);
                    entradaNumero = true;
                }
            } catch (Exception e) {
                System.out.println("Entrada inválida. Sólo se permiten números.");
                sc.next(); // Limpia el buffer del scanner
            }
        }
        return numero;
    }
    public static void addContacto() {
        String nombre = validarNombre();
        String numero = validarNumero();

        // Buscamos el contacto por nombre
        Contacto contactoExistente = tlf.findContact(nombre);

        // Si el contacto no existe, lo agregamos
        if (contactoExistente == null) {
            tlf.addNewContact(nombre, numero, tlf.myContacts);
            System.out.println("Contacto agregado.");
        } else {
            System.out.println("Este contacto ya existe en la lista.");
        }
    }
    public static void buscarContacto(){
        System.out.println("Introduce nombre o numero de teléfono.");
        tlf.queryContact(sc.nextLine());
        System.out.println();
    }
    public static void modificaContacto() {
        System.out.println("Introduce el nombre del contacto para modificar:");
        String nombre = sc.nextLine();

        Contacto contactoOriginal = tlf.findContact(nombre);

        if (contactoOriginal == null) {
            System.out.println("El contacto no existe.");
            return;
        }

        String nombreNuevo = validarNombre();
        if (nombreNuevo.equals("0") || nombreNuevo.equalsIgnoreCase(contactoOriginal.name)) {
            System.out.println("Se utilizará el mismo nombre.");
            nombreNuevo = contactoOriginal.name;
        }

        String numeroNuevo = validarNumero();
        if (numeroNuevo.equals("0") || numeroNuevo.equals(contactoOriginal.phoneNumber)) {
            System.out.println("Se utilizará el mismo número.");
            numeroNuevo = contactoOriginal.phoneNumber;
        }

        Contacto contactoModificado = new Contacto(nombreNuevo, numeroNuevo);
        tlf.updateContact(contactoOriginal, contactoModificado);
    }
    public static void eliminaContacto(){
        System.out.println("Introduce el nombre del contacto a eliminar:");
        String nombre = sc.nextLine();
        tlf.removeContact(nombre);
    }
    public static void pruebaContactos(){
        // Contactos de prueba
        String[][] contactosPrueba = {
                {"Ana", "123456789"},
                {"Carlos", "987654321"},
                {"María", "456789123"},
                {"Luis", "789123456"},
                {"Elena", "321654987"},
                {"Javier", "654987321"},
                {"Sofía", "852963741"},
                {"Andrés", "369147258"},
                {"Lucía", "147258369"},
                {"Pedro", "951753852"}
        };
        for (String[] datos : contactosPrueba) {
            String nombre = datos[0];
            String numero = datos[1];
            tlf.addNewContact(nombre, numero, tlf.myContacts);
        }
    }

    public static void main(String[] args) {
        int opc = imprimirMenu();
        boolean bucle = true;
        while(bucle) {
            switch (opc) {
                case 0:
                    imprimirMenu();
                    break;
                case 1:
                    tlf.printContacts();
                    break;
                case 2:
                    buscarContacto();
                    break;
                case 3:
                    addContacto();
                    break;
                case 4:
                    tlf.contarContactos();
                    break;
                case 5:
                    modificaContacto();
                    break;
                case 6:
                    eliminaContacto();
                    break;
                case 7:
                    tlf.borrarTodo();
                    break;
                case 8:
                    Collections.sort(tlf.myContacts);
                    break;
                case 10:
                    bucle = false;
                    break;
                case 99:
                    pruebaContactos();
                    break;
                default:
                    System.out.println("Entrada no válida");
                    break;
            }
            if (bucle) {
                opc = imprimirMenu(); // Pedir la siguiente opción
            }
        }
    }
}
