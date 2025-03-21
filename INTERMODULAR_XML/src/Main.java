import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    private static final Scanner sc = new Scanner(System.in);
    private static final int nombreMax = 32;
    private static final int mailMax = 64;
    private static final String regexMail = "^[\\w.-]+@[a-zA-Z0-9]+(\\.[a-zA-Z0-9]+)*\\.[a-zA-Z]{2,}$";
    private static final String formatoFecha = "yyyy/MM/dd";
    private static final ArraysUsuario usuarios = new ArraysUsuario();

    public static void menu() {
        System.out.println("\nSelecciona una opción:");
        System.out.println("0. Salir del programa");
        System.out.println("1. Insertar nuevo usuario");
        System.out.println("2. Eliminar usuario existente");
        System.out.println("3. Actualizar usuario existente");
        System.out.println("4. Consultar un usuario");
        System.out.println("5. Imprimir usuarios");
        System.out.println("6. Imprimir usuarios XML");
        System.out.println("99 Prueba usuarios");
    }

    public static void suich(int sel) {
        switch (sel) {
            case 0:
                System.out.println("Saliendo...");
                break;
            case 1:
                insertarUsuario();
                break;
            case 2:
                eliminarUsuario();
                break;
            case 3:
                actualizarUsuario();
                break;
            case 4:
                consultarUsuario();
                break;
            case 5:
                usuarios.printContacts();
                break;
            case 6:
                xmlToString();
                break;
            case 99:
                pruebaUsuarios();
                break;
            default:
                System.out.println("Opción no válida.");
        }
    }

    public static void insertarUsuario() {
        boolean salir = false;
        while (!salir) {
            int idUsuario;
            do {
                idUsuario = pedirID();
                if (idUsuario == -1) {
                    System.out.println("Saliendo...");
                    salir = true;
                    return;
                }
            } while (!validarID(idUsuario));

            sc.nextLine(); // para el buffer

            String nombre;
            do {
                System.out.print("Nombre (máximo 32 caracteres): ");
                nombre = sc.nextLine();
            } while (!validarNombre(nombre));

            String mail = "";
            do {
                System.out.print("Correo electrónico (máximo 64 caracteres): ");
                mail = sc.nextLine();
            } while (!validarEmail(mail));

            String fRegistro;
            do {
                System.out.print("Fecha de registro (formato yyyy/MM/dd): ");
                fRegistro = sc.nextLine();
            } while (!validarFecha(fRegistro));

            usuarios.addNewContact(idUsuario, nombre, mail, fRegistro, usuarios.usuarios);
            System.out.println("Usuario agregado correctamente.\n");
        }
    }

    public static void eliminarUsuario() {
        System.out.print("Ingrese el ID del usuario a eliminar: ");
        int idUsuario = sc.nextInt();
        sc.nextLine();
        if (usuarios.removeContact(idUsuario)) {
            System.out.println("Usuario eliminado correctamente.");
        } else {
            System.out.println("No se encontró un usuario con ese ID.");
        }
    }

    public static void actualizarUsuario() {
        System.out.print("Ingrese el ID del usuario a actualizar: ");
        int idUsuario = sc.nextInt();
        sc.nextLine();
        Usuario usuarioExistente = usuarios.findUsuario(idUsuario);
        if (usuarioExistente == null) {
            System.out.println("No se encontró un usuario con ese ID.");
            return;
        }

        String nombre;
        do {
            System.out.print("Nuevo nombre (máximo 32 caracteres): ");
            nombre = sc.nextLine();
        } while (!validarNombre(nombre));

        String mail;
        do {
            System.out.print("Nuevo correo electrónico (máximo 64 caracteres): ");
            mail = sc.nextLine();
        } while (!validarEmail(mail));

        String fRegistro;
        do {
            System.out.print("Nueva fecha de registro (formato yyyy/MM/dd): ");
            fRegistro = sc.nextLine();
        } while (!validarFecha(fRegistro));

        Usuario usuarioActualizado = new Usuario(idUsuario, nombre, mail, fRegistro);
        usuarios.updateUsuario(usuarioExistente, usuarioActualizado);
        System.out.println("Usuario actualizado correctamente.");
    }

    public static void consultarUsuario() {
        sc.nextLine();
        System.out.print("Ingrese el nombre o correo del usuario a consultar: ");
        String clave = sc.nextLine();
        usuarios.queryContact(clave);
    }

    public static void xmlToString(){

        if (usuarios.usuarios.isEmpty()){
            System.err.println("No hay usuarios registrados.");
        } else {
            System.out.println("<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>");
            System.out.println("<USUARIOS>");
            for (Usuario user : usuarios.usuarios) {
                System.out.println(user.aXml()); // Imprimir el XML de cada usuario
            }
            System.out.println("\n</USUARIOS>");
        }

    }

    private static boolean validarID(int id) {
        if (usuarios.findUsuario(id) != null) {
            System.out.println("El usuario con ID " + id + " ya existe.");
            return false;
        }
        return true;
    }

    private static boolean validarNombre(String nombre) {
        if (nombre.length() > nombreMax) {
            System.out.println("Error: El nombre no puede exceder los 32 caracteres.");
            return false;
        }
        return true;
    }

    private static boolean validarEmail(String email) {
        if (email.length() > mailMax) {
            System.out.println("Error: El correo no puede exceder los 64 caracteres.");
            return false;
        }
        if (!Pattern.matches(regexMail, email)) {
            System.out.println("Error: Formato de correo inválido.");
            return false;
        }
        return true;
    }

    private static boolean validarFecha(String fecha) {
        SimpleDateFormat sdf = new SimpleDateFormat(formatoFecha);
        sdf.setLenient(false);
        try {
            Date fechaIngresada = sdf.parse(fecha);
            Date hoy = sdf.parse(sdf.format(new Date()));
            if (fechaIngresada.after(hoy)) {
                System.out.println("Error: No se pueden introducir fechas futuras.");
                return false;
            }
        } catch (ParseException e) {
            System.out.println("Error: Formato de fecha incorrecto.");
            return false;
        }
        return true;
    }

    public static int pedirID(){
       boolean selValida = false;
       int idusuario = Integer.MAX_VALUE;
       while (!selValida) {
           try {
               System.out.println("Introduce la id de usuario. (-1 para volver).");
               idusuario = sc.nextInt();
               if (idusuario >= -1) {
                   selValida = true;
                   return idusuario;
               } else System.out.println("El número debe ser superior a 0.");
           } catch (Exception e) {
               System.out.println("Solo se admiten números.");
               sc.nextLine();
           }
       }    return Integer.MIN_VALUE;
    }

    public static void pruebaUsuarios() {
        // Añadir 5 usuarios de prueba
        usuarios.addNewContact(1, "Juan Perez", "juan.perez@example.com", "2023-10-01", usuarios.usuarios);
        usuarios.addNewContact(2, "Maria Garcia", "maria.garcia@example.com", "2023-10-02", usuarios.usuarios);
        usuarios.addNewContact(3, "Carlos Lopez", "carlos.lopez@example.com", "2023-10-03", usuarios.usuarios);
        usuarios.addNewContact(4, "Ana Martinez", "ana.martinez@example.com", "2023-10-04", usuarios.usuarios);
        usuarios.addNewContact(5, "Luis Sanchez", "luis.sanchez@example.com", "2023-10-05", usuarios.usuarios);
    }

    public static void main(String[] args) {
        int sel;
        boolean selValida = false;

        while (!selValida){
            try {
                menu();
                sel = sc.nextInt();
                if (sel != 0){
                    suich(sel); // el metodo con el switch
                } else if (sel == 0) {
                    System.out.println("Saliendo..");
                    selValida = true;
                    return;
                } else System.out.println("Opción no válida.");
            } catch (Exception e) {
                System.out.println("Solo se admiten números.");
            }
        }
    }
}
