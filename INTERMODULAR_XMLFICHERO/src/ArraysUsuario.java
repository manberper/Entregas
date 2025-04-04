import java.util.ArrayList;
import java.util.Objects;

public class ArraysUsuario implements Comparable<Usuario> {
    protected String nombrelista;
    protected ArrayList<Usuario> usuarios;

    public ArraysUsuario() {
       // this.nombrelista = nombrelista;
        this.usuarios = new ArrayList<>();
    }

    public boolean addNewContact(int idUsuario,String nombre, String mail, String fRegistro, ArrayList<Usuario> usuarios) {
        Usuario usuarioExistente = findUsuario(idUsuario); // Busca por nombre
        if (usuarioExistente == null) {
            Usuario nuevoUsuario = new Usuario(idUsuario, nombre, mail, fRegistro);
            usuarios.add(nuevoUsuario);
            System.out.println("Usuario creado.");
            return true;
        } else {
            System.out.println("El usuario ya existe.");
            return false;
        }
    }

    public boolean updateUsuario(Usuario usuario, Usuario updateUsuario) {
        Usuario usuarioExistente = findUsuario(usuario.idUsuario);
        if (usuarioExistente != null) {
            int posicion = usuarios.indexOf(usuarioExistente);
            usuarios.set(posicion, updateUsuario);
            System.out.println("Contacto actualizado correctamente.");
            return true;
        }
        System.out.println("El contacto no existe.");
        return false;
    }

    public boolean removeContact(int idUsuario) {
        Usuario usuario = findUsuario(idUsuario);
        if (usuario != null) {
            usuarios.remove(usuario);
            System.out.println("Usuario borrado");
            return true;
        } else {
            System.out.println("El usuario no existe.");
            return false;
        }
    }

    public Usuario findUsuario(int idUsuario) {
        for (Usuario usuario : usuarios) {
            if (usuario.idUsuario == idUsuario) {
                return usuario;
            }
        }
        return null;
    }

    public void queryContact(String clave) {
        boolean encontrado = false;
        String claveLower = clave.toLowerCase();

        for (Usuario usuario : usuarios) {
            if (usuario.nombre.toLowerCase().contains(claveLower) || usuario.mail.contains(clave)) {
                System.out.println(usuario.toString());
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("No se encontraron usuarios con: " + clave);
        }
    }

    public void printContacts() {
        if (usuarios.isEmpty()) {
            System.out.println("No hay usuarios guardados.");
            return;
        }

        System.out.println("Lista de usuarios:");
        for (Usuario usuario : usuarios) {
            System.out.println("Nombre: " + usuario.getNombre() + " Mail: " + usuario.getMail());
        }
    }

    public boolean existeNombre(String nombre){
        for (Usuario usuario : usuarios){
            if (Objects.equals(usuario.nombre, nombre)){
                return true;
            }
        }
        return false;
    }

    @Override
    public int compareTo(Usuario o) {
        return 0;
    }

}
