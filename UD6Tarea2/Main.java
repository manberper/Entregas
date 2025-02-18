package UD6Tarea2;
import java.util.*;

public class Main {
    private static LinkedList<Cancion> playlist = new LinkedList<>();
    private static Iterator<Cancion> iterator;
    private static Cancion currentSong = null;
    private static ArrayList<Album> albums = new ArrayList<>();

    public static void menu() {
        System.out.println("\nMenú:");
        System.out.println("0 - Salir de la lista de reproducción.");
        System.out.println("1 - Reproducir siguiente canción en la lista.");
        System.out.println("2 - Reproducir la canción previa de la lista.");
        System.out.println("3 - Repetir la canción actual.");
        System.out.println("4 - Imprimir la lista de canciones en la playlist.");
        System.out.println("5 - Ordenar lista de reproducción.");
        System.out.println("6 - Eliminar canción de la playlist.");
        System.out.println("7 - Mostrar lista de albums.");
        System.out.println("8 - Mostrar canciones de un album.");
        System.out.println("99 - Volver a imprimir el menú");
    }
    public static int pedirNumero(){
        Scanner sc = new Scanner(System.in);
        boolean selValida = false;
        int sel = -1;
        while (!selValida) {
            menu();
            try {
                sel = sc.nextInt();
                if (sel >= 0){
                    selValida = true;
                }
            } catch (Exception e) {
                System.out.println("Solo se admiten números");
                sc.nextLine();
            }
        }
        return sel;
    }
    public static void cancionesAlbum(String nombre){
        if (albums.contains(nombre)) {
            for (Album alb : albums) {
                if (alb.getNombre().equalsIgnoreCase(nombre)) {
                    System.out.println(alb.canciones);
                }
            }
        } else System.out.println("Album no encontrado.");
    }
    public static void play(ArrayList<Album> albums) {
        Scanner sc = new Scanner(System.in);
        boolean direccion = true;
        boolean play = true;

        while (play) {
            if (currentSong != null) {
                System.out.println("Reproduciendo: " + currentSong);
            }

            int sel = pedirNumero();
            switch (sel) {
                case 0:
                    System.out.println("Saliendo de la lista de reproducción.");
                    play = false;
                    return;
                case 1:
                    if (iterator.hasNext() && !direccion) {
                        iterator.next();
                        currentSong = iterator.next();
                        direccion = true;
                    } else if (iterator.hasNext()) {
                        currentSong = iterator.next();
                    } else {
                        System.out.println("Has llegado al final de la playlist.");
                    }
                    break;
                case 2:
                    if (playlist.indexOf(currentSong) > 0) {
                        currentSong = playlist.get(playlist.indexOf(currentSong) - 1);
                        iterator = playlist.listIterator(playlist.indexOf(currentSong));
                        direccion = false;
                    } else {
                        System.out.println("Estás al inicio de la playlist.");
                        direccion = true;
                    }
                    break;
                case 3:
                    if (currentSong != null) {
                        System.out.println("Repitiendo: " + currentSong);
                    } else {
                        System.out.println("No hay canción actual para repetir.");
                    }
                    break;
                case 4:
                    System.out.println("Lista de canciones en la playlist:");
                    for (Cancion cancion : playlist) {
                        for (Album album : albums){
                            if (album.canciones.contains(cancion)){
                                System.out.println(album.getArtista()+", "+ cancion);
                            }
                        }
                    }
                    break;
                case 5:
                    System.out.println("Ordenar lista de reproducción.");
                    Collections.sort(playlist);
                    break;
                case 6:
                    System.out.println("Eliminar canción de la playlist.");
                    if (currentSong != null){
                        iterator.remove();
                    }

                    if (iterator.hasNext()) {
                        currentSong = iterator.next();
                        System.out.println(currentSong);
                    } else System.out.println("Has llegado al final de la playlist.");
                    break;
                case 7:
                    for (Album alb : albums){
                        System.out.println(alb.getNombre());
                    }
                    break;
                case 8:
                    System.out.println("Introduce el nombre del album: ");
                    String nom = sc.nextLine();
                    cancionesAlbum(nom);
                    break;
                case 99:
                    menu();
                    break;
                default:
                    System.out.println("Opción no válida. Intenta de nuevo.");
            }
        }
    }

    public static void main(String[] args) {

        albums.add(new Album("Album1","Artista1"));
        albums.add(new Album("Album2","Artista2"));
        albums.get(0).addSong("Cancion 1", 3.2);
        albums.get(0).addSong("Cancion 2",4.0);
        albums.get(0).addSong("Cancion 3", 3.0);
        albums.get(1).addSong("Cancion 1", 2.4);
        albums.get(1).addSong("Cancion 2",3.2);
        albums.get(1).addSong("Cancion 3", 5.0);

        albums.get(0).addToPlayList(0,playlist);
        albums.get(0).addToPlayList(1,playlist);
        albums.get(0).addToPlayList(2,playlist);
        albums.get(1).addToPlayList(0,playlist);
        albums.get(1).addToPlayList(1,playlist);
        albums.get(1).addToPlayList(2,playlist);
        iterator = playlist.iterator();

        //menu();
        play(albums);
    }
}

