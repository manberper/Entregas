package UD6Tarea5;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Main {
    private static Map<String, CuerpoCeleste> sistemaSolar = new HashMap<>();
    private static Set<CuerpoCeleste> planetas = new HashSet<>();

    public static void crearSistemaSolar(){
        CuerpoCeleste mercurio = new Planeta("Mercurio", 88);
        agregarCuerpoCeleste(mercurio);

        CuerpoCeleste venus = new Planeta("Venus", 225);
        agregarCuerpoCeleste(venus);

        CuerpoCeleste tierra = new Planeta("Tierra", 365);
        agregarCuerpoCeleste(tierra);

        CuerpoCeleste marte = new Planeta("Marte", 687);
        agregarCuerpoCeleste(marte);

        CuerpoCeleste jupiter = new Planeta("Júpiter", 4332);
        agregarCuerpoCeleste(jupiter);

        CuerpoCeleste saturno = new Planeta("Saturno", 10759);
        agregarCuerpoCeleste(saturno);

        CuerpoCeleste urano = new Planeta("Urano", 30660);
        agregarCuerpoCeleste(urano);

        CuerpoCeleste neptuno = new Planeta("Neptuno", 165);
        agregarCuerpoCeleste(neptuno);

        CuerpoCeleste pluton = new PlanetaEnano("Plutón", 248);
        agregarCuerpoCeleste(pluton);

        CuerpoCeleste luna = new Luna("Luna", 27);
        sistemaSolar.put(luna.getNombre(), luna);
        tierra.addSatelite(luna);

        CuerpoCeleste deimos = new Luna("Deimos", 1.3);
        sistemaSolar.put(deimos.getNombre(), deimos);
        marte.addSatelite(deimos);

        CuerpoCeleste phobos = new Luna("Phobos", 0.3);
        sistemaSolar.put(phobos.getNombre(), phobos);
        marte.addSatelite(phobos);

        CuerpoCeleste io = new Luna("Io", 1.8);
        sistemaSolar.put(io.getNombre(), io);
        jupiter.addSatelite(io);

        CuerpoCeleste europa = new Luna("Europa", 3.5);
        sistemaSolar.put(europa.getNombre(), europa);
        jupiter.addSatelite(europa);

        CuerpoCeleste ganymede = new Luna("Ganímedes", 7.1);
        sistemaSolar.put(ganymede.getNombre(), ganymede);
        jupiter.addSatelite(ganymede);

        CuerpoCeleste callisto = new Luna("Calisto", 16.7);
        sistemaSolar.put(callisto.getNombre(), callisto);
        jupiter.addSatelite(callisto);
    }
    private static void agregarCuerpoCeleste(CuerpoCeleste cuerpo) {
        sistemaSolar.put(cuerpo.getNombre(), cuerpo);
        if (cuerpo.getTipoCuerpo() == CuerpoCeleste.TipoCuerpoCeleste.PLANETA ||
                cuerpo.getTipoCuerpo() == CuerpoCeleste.TipoCuerpoCeleste.PLANETA_ENANO) {
            planetas.add(cuerpo);
        }
    }
    public static void probarDiferenciaInterseccion() {
        // planetas nuevos para probar
        Set<CuerpoCeleste> nuevosPlanetas = new HashSet<>();
        nuevosPlanetas.add(new Planeta("Mercurio", 88));
        nuevosPlanetas.add(new Planeta("Venus", 225));
        nuevosPlanetas.add(new Planeta("Tierra", 365));
        nuevosPlanetas.add(new Planeta("Marte", 687));
        nuevosPlanetas.add(new Planeta("Ceres", 1680)); // Planeta enano que no está en el sistema solar original

        // diferencia
        Set<CuerpoCeleste> diferencia = new HashSet<>(planetas);
        diferencia.removeAll(nuevosPlanetas);

        System.out.println("\nPlanetas en el sistema solar que no están en el nuevo set:");
        for (CuerpoCeleste planeta : diferencia) {
            System.out.println(planeta.getNombre());
        }

        // intersección
        Set<CuerpoCeleste> interseccion = new HashSet<>(planetas);
        interseccion.retainAll(nuevosPlanetas);

        System.out.println("\nPlanetas que están en el sistema solar y en el nuevo set:");
        for (CuerpoCeleste planeta : interseccion) {
            System.out.println(planeta.getNombre());
        }
    }
    public static void main(String[] args) {
        crearSistemaSolar();

        System.out.println("Planetas en el sistema solar:");
        for (CuerpoCeleste planeta : planetas) {
            System.out.println(planeta.getNombre());
        }

        CuerpoCeleste marteSistema = sistemaSolar.get("Marte");
        System.out.println("\nLunas de Marte:");
        for (CuerpoCeleste lunaMarte : marteSistema.getSatlites()) {
            System.out.println(lunaMarte);
        }

        Set<CuerpoCeleste> lunas = new HashSet<>();
        for (CuerpoCeleste planeta : planetas) {
            lunas.addAll(planeta.getSatlites());
        }

        System.out.println("\nTodas las lunas en el sistema solar:");
        for (CuerpoCeleste lunaSistema : lunas) {
            System.out.println(lunaSistema);
        }

        CuerpoCeleste nuevoPluton = new Planeta("Plutón", 884);
        System.out.println("\nAgregando un nuevo Plutón como planeta:");
        if (planetas.add(nuevoPluton)) {
            System.out.println("Plutón agregado como planeta.");
        } else {
            System.out.println("Plutón no se agregó porque ya existe en el set.");
        }

        CuerpoCeleste plutonEnano = new PlanetaEnano("Plutón", 248);
        System.out.println("\nAgregando un nuevo Plutón como planeta enano:");
        if (planetas.add(plutonEnano)) {
            System.out.println("Plutón agregado como planeta enano.");
        } else {
            System.out.println("Plutón no se agregó porque ya existe en el set.");
        }

        Set<CuerpoCeleste> planetasConLunas = new HashSet<>();
        for (CuerpoCeleste planeta : planetas) {
            if (!planeta.getSatlites().isEmpty()) {
                planetasConLunas.add(planeta);
            }
        }

        Set<CuerpoCeleste> planetasSinLunas = new HashSet<>(planetas);
        planetasSinLunas.removeAll(planetasConLunas);

        System.out.println("\nPlanetas con lunas:");
        for (CuerpoCeleste planeta : planetasConLunas) {
            System.out.println(planeta.getNombre());
        }

        System.out.println("\nPlanetas sin lunas:");
        for (CuerpoCeleste planeta : planetasSinLunas) {
            System.out.println(planeta.getNombre());
        }
        probarDiferenciaInterseccion();
    }
}
