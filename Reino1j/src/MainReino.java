import java.util.ArrayList;
import java.util.Scanner;

public class MainReino {
    private final static Scanner sc = new Scanner(System.in);
    private final static ArrayList<Armas> armas = new ArrayList<>();
    private final static ArrayList<Heroes> gremio = new ArrayList<>();

    public static void menu(){
        System.out.println("""
                0. Salir del programa.
                1. Añadir un nuevo héroe.
                2. Añadir un arma nueva al arsenal.
                3. Eliminar un héroe por su nombre.
                4. Buscar un héroe y mostrar sus detalles.
                5. Listar todos los héroes registrados en el gremio.
                6. Listar todas las armas registradas.
                7. Añadir un arma a un héroe.
                99. Prueba general.""");
    }

    public static void suich(int sel){
        switch (sel){
            case 0:
                System.out.println("Saliendo..");
                break;
            case 1:
                introducirHeroe();
                break;
            case 2:
                introducirArma();
                break;
            case 3:
                System.out.println("Introduce el nombre de un heroe para eliminar.");
                gremio.remove(buscaHeroe(sc.nextLine()));
                break;
            case 4:
                System.out.println("Introduce el nombre de un héroe para buscar.");
                String nombreBuscar = sc.nextLine();
                Heroes hero = buscaHeroe(nombreBuscar);
                if (hero != null) {
                    System.out.println(hero.toString());
                } else {
                    System.out.println("Héroe no encontrado.");
                }
                break;
            case 5:
                listaHeroes();
                break;
            case 6:
                listaArmas();
                break;
            case 7:
                introduceArmaHeroe();
                break;
            case 99:
                pruebaGeneral();
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }

    public static void introducirHeroe(){
        System.out.println("""
                Selecciona un tipo de heroe:
                1. Guerrero
                2. Mago
                3. Arquero
                4. Asesino""");
        int selHeroe = pedirInt();

        String nombre = "";
        int nivel = 0;
        int vida = 0;
        Armas arma = null;

        do {
            System.out.println("Introduce un nombre para el heroe:");
            nombre = sc.nextLine();
        } while (!validarNombre(nombre));

        System.out.println("Introduce un nivel para el heroe: (1-100)");
        nivel = pedirInt();

        System.out.println("Introduce la cantidad de vida del heroe: (1-100)");
        vida = pedirInt();

        System.out.println("Selecciona un arma para el heroe:");
        listaArmas();
        String nombreArma = sc.nextLine();
        arma = buscaArma(nombreArma);

        if (arma == null) {
            System.out.println("Arma no encontrada. El héroe no tendrá arma.");
        }
        Heroes nuevoHeroe = null;

        switch (selHeroe) {
            case 1:
                System.out.println("Introduce la cantidad de fuerza del héroe: (1-100)");
                int fuerza = pedirInt();
                nuevoHeroe = new Guerrero(nombre, nivel, vida, fuerza);
                break;
            case 2:
                System.out.println("Introduce la cantidad de maná del héroe: (1-100)");
                int mana = pedirInt();
                nuevoHeroe = new Mago(nombre, nivel, vida, mana);
                break;
            case 3:
                System.out.println("Introduce la cantidad de puntería del héroe: (1-100)");
                int punteria = pedirInt();
                nuevoHeroe = new Arquero(nombre, nivel, vida, punteria);
                break;
            case 4:
                System.out.println("Introduce la cantidad de sigilo del héroe: (1-100)");
                int sigilo = pedirInt();
                nuevoHeroe = new Asesino(nombre, nivel, vida, sigilo);
                break;
            default:
                System.out.println("Opción no válida.");
                return;
        }

// Si se ha creado un héroe válido, le asignamos el arma y lo agregamos al gremio
        if (nuevoHeroe != null) {
            if (arma != null) {
                nuevoHeroe.agregarArma(arma);
            }
            gremio.add(nuevoHeroe);
            System.out.println("Héroe añadido correctamente.");
        }
    }

    public static void introducirArma() {
        System.out.println("Introduce el nombre del arma:");
        String nombreArma = sc.nextLine();

        System.out.println("Introduce el daño del arma (1-100):");
        int dmg = pedirInt();
        sc.nextLine(); // buffer

        armas.add(new Armas(nombreArma,dmg));

        System.out.println("Arma '" + nombreArma + "' con daño " + dmg + " añadida al arsenal.");
    }

    public static Heroes buscaHeroe(String nombre) {
        // esto hace busquedas parciales
        String nombreBusqueda = nombre.toLowerCase();
        for (Heroes hero : gremio) {
            if (hero.getNombre().toLowerCase().contains(nombreBusqueda)) {
                return hero;
            }
        }
        return null;
    }

    public static void listaHeroes(){
        for (Heroes hero : gremio){
            System.out.println(hero.toString());
        }
    }

    public static void listaArmas() {
        if (armas.isEmpty()) {
            System.out.println("No hay armas disponibles.");
        } else {
            for (Armas arma : armas) {
                System.out.println(arma.toString());
            }
        }
    }

    public static void pruebaGeneral() {
        armas.add(new Armas("Espada", 50));         // 0
        armas.add(new Armas("Hacha", 60));          // 1
        armas.add(new Armas("Bastón Arcano", 40));  // 2
        armas.add(new Armas("Orbe Místico", 55));   // 3
        armas.add(new Armas("Arco Largo", 45));     // 4
        armas.add(new Armas("Ballesta", 50));       // 5
        armas.add(new Armas("Dagas", 35));          // 6
        armas.add(new Armas("Shuriken", 30));       // 7

        // Crear héroes con armas adecuadas a su clase
        Heroes g = new Guerrero("Arthur", 30, 200, 80);
        g.agregarArma(armas.get(0)); // Espada
        g.agregarArma(armas.get(1)); // Hacha
        gremio.add(g);

        Heroes m = new Mago("Merlin", 40, 150, 300);
        m.agregarArma(armas.get(2)); // Bastón Arcano
        m.agregarArma(armas.get(3)); // Orbe Místico
        gremio.add(m);

        Heroes a = new Arquero("Robin", 35, 180, 90);
        a.agregarArma(armas.get(4)); // Arco Largo
        a.agregarArma(armas.get(5)); // Ballesta
        gremio.add(a);

        Heroes s = new Asesino("Ezio", 38, 160, 95);
        s.agregarArma(armas.get(6)); // Dagas
        s.agregarArma(armas.get(7)); // Shuriken
        gremio.add(s);

        System.out.println("Se han añadido 4 héroes con armas adecuadas a su clase.");
    }

    public static void introduceArmaHeroe() {
        System.out.println("Introduce el nombre del héroe al que deseas añadir un arma:");
        String nombreHeroe = sc.nextLine();
        Heroes heroe = buscaHeroe(nombreHeroe);

        if (heroe == null) {
            System.out.println("Héroe no encontrado.");
            return;
        }

        System.out.println("Selecciona un arma para añadir al héroe:");
        listaArmas();
        String nombreArma = sc.nextLine();
        Armas arma = buscaArma(nombreArma);

        if (arma == null) {
            System.out.println("Arma no encontrada.");
        } else {
            heroe.agregarArma(arma);
            System.out.println("Arma '" + arma.getNombreArma() + "' añadida al héroe '" + heroe.getNombre() + "'.");
        }
    }

    public static Armas buscaArma(String nombre) {
        String nombreBusqueda = nombre.toLowerCase();
        for (Armas arma : armas) {
            if (arma.getNombreArma().toLowerCase().contains(nombreBusqueda)) {
                return arma;
            }
        }
        return null;
    }

    public static int pedirInt(){
        int num;
            try {
                num = sc.nextInt();
                if (num > 0 || num < 101) {
                    sc.nextLine();
                    return num;
                } else {
                    System.out.println("Valor invalido");
                    sc.nextLine();
                }
            } catch (Exception e) {
                System.err.println("Solo se admiten números!!");
                sc.nextLine();
            }
        return pedirInt();
    }

    private static boolean validarNombre(String nom) {
        if (buscaHeroe(nom) != null) {
            System.out.println("El heroe con nombre " + nom + " ya existe.");
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        boolean selValida = false;
        int sel;
        while (!selValida){
            try {
                menu();
                sel = pedirInt();
                if (sel != 0){
                    suich(sel); // el metodo con el switch
                } else if (sel == 0) {
                    System.out.println("Saliendo..");
                    selValida = true;
                    return;
                } else System.out.println("Opción no válida.");
            } catch (Exception e) {
                System.out.println("Solo se admiten números.");
                sc.nextLine();
            }
        }
    }
}
