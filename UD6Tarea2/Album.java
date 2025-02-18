package UD6Tarea2;
import java.util.ArrayList;
import java.util.LinkedList;

public class Album{
    protected String nombre;
    protected String artista;
    protected ArrayList<Cancion> canciones;

    public Album(String nombre, String artista) {
        this.nombre = nombre;
        this.artista = artista;
        this.canciones = new ArrayList<>();
    }

    public String getArtista() {
        return artista;
    }

    private Cancion findSong(String nombre) {
        for (Cancion cancion : canciones) {
            if (cancion.getTitulo().equalsIgnoreCase(nombre)) {
                return cancion;
            }
        }
        return null;
    }

    public boolean addSong(String titulo, double duracion){
        if (findSong(titulo) == null){
            canciones.add(new Cancion(titulo,duracion));
            return true;
        } else return false;
    }

    public boolean addToPlayList(int num, LinkedList<Cancion> playlist) {
        if (num >= 0 && num < canciones.size()) {
            playlist.add(canciones.get(num));
            return true;
        }
        return false;
    }

    public boolean addToPlayList(String titulo, LinkedList<Cancion> playlist) {
        Cancion cancion = findSong(titulo);
        if (cancion != null) {
            playlist.add(cancion);
            return true;
        }
        return false;
    }

    public boolean removeFromPlaylist(String titulo, LinkedList<Cancion> playlist){
        Cancion cancion = findSong(titulo);
        if (playlist.contains(cancion)){
            playlist.remove(cancion);
            return true;
        }
        return false;
    }

    public String getNombre() {
        return nombre;
    }
}
