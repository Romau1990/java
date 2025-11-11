import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.*;

public class Area {
    static String area;
    static int temperatura;
    static String estacion;
    static int duracionEstacion;
    static String clima;
    static ArrayList<String> listadoEstaciones = new ArrayList<>(List.of("Primavera", "Verano", "Otoño", "Invierno"));

    static int nivel;
    static String[] ListaAreas = new String[] { "casa -> turno: 1", "ciudad -> turno: 2", "playa -> turno: 2",
            "colina -> turno: 3",
            "basurero -> turnos: 2", "bosque -> turno: 2", "sitio en construcción -> turno: 1", "caverna -> turno: 4",
            "campo -> turno: 1", "tienda -> turno: 1",
            "iglesia abandonada -> turno: 1", "caravana -> turno: 1", "puente -> turno: 1",
            "planta nuclear -> turno: 4", "hospital -> turno: 3", "estacion de policia -> turno: 4" };

    static void estacionRandom() {
        var indexRandom = (int) (Math.random() * Area.listadoEstaciones.size());
        String estacionRandom = Area.listadoEstaciones.get(indexRandom);
        Area.estacion = estacionRandom;
    }

    static void rollearTemp() {
        switch (Area.estacion) {
            case "Primavera":
                Area.temperatura = (int) (Math.random() * (25 - 14 + 1)) + 14;
                break;

            case "Verano":
                Area.temperatura = (int) (Math.random() * (40 - 25 + 1)) + 25;
                break;

            case "Otoño":
                Area.temperatura = (int) (Math.random() * (15 - 8 + 1)) + 8;
                break;

            case "Invierno":
                Area.temperatura = (int) (Math.random() * (10 - 0 + 1)) + 0;
                break;

        }
    }

    static void rollearClima() {
        ArrayList<String> listadoClimas = new ArrayList<>(
                List.of("Lluvioso", "Soleado", "Humedo", "Ventoso", "Seco", "Agradable", "Fresco"));
        int index = (int) (Math.random() * listadoClimas.size());
        Area.clima = listadoClimas.get(index);
    }

    static void rollearEstacion() {
        if (Area.estacion.equalsIgnoreCase("Primavera")) {
            Area.estacion = "Verano";
        } else if (Area.estacion.equalsIgnoreCase("Verano")) {
            Area.estacion = "Otoño";
        } else if (Area.estacion.equalsIgnoreCase("Otoño")) {
            Area.estacion = "Invierno";
        } else if (Area.estacion.equalsIgnoreCase("Invierno")) {
            Area.estacion = "Primavera";
        }
    }

    static void verAreas() {
        Arrays.asList(Area.ListaAreas).forEach(a -> {
            System.out.println(Juego.BLANCO + a);
        });
    }

    static void areaSeleccionada(String area) {

        switch (area) {
            case "casa":
                // se incrementa turno en el area porque cada area cuesta x cantidad de turnos
                break;

            case "ciudad":
                // se incrementa turno en el area porque cada area cuesta x cantidad de turnos
                break;

            case "playa":
                if (Area.temperatura > 25) {
                    Estado.quemadura();
                    Jugador.hidratacion -= 2;
                }
                Jugador.hidratacion -= 2;
                Jugador.energia -= 2;
                // se incrementa turno en el area porque cada area cuesta x cantidad de turnos
                break;

            case "colina":
                // se incrementa turno en el area porque cada area cuesta x cantidad de turnos
                break;

            case "basurero":
                // se incrementa turno en el area porque cada area cuesta x cantidad de turnos
                Estado.infeccion();
                break;

            case "bosque":
                // se incrementa turno en el area porque cada area cuesta x cantidad de turnos
                break;

            case "sitio en construccion":
                // se incrementa turno en el area porque cada area cuesta x cantidad de turnos
                break;

            case "caverna":
                // se incrementa turno en el area porque cada area cuesta x cantidad de turnos
                break;

            case "campo":
                // se incrementa turno en el area porque cada area cuesta x cantidad de turnos
                break;

            case "tienda":
                // se incrementa turno en el area porque cada area cuesta x cantidad de turnos
                break;

            case "iglesia abandonada":
                // se incrementa turno en el area porque cada area cuesta x cantidad de turnos
                break;

            case "caravana":
                // se incrementa turno en el area porque cada area cuesta x cantidad de turnos
                break;

            case "puente":
                // se incrementa turno en el area porque cada area cuesta x cantidad de turnos
                break;

            case "planta nuclear":
                if (Jugador.equipo[0] == null
                        || !Arrays.asList(Jugador.equipo[0].getProposito()).contains("radiacion")) {
                    Estado.radiacion();
                } else {
                    System.out.println("Estas usando un equipo contra la radiación, estas seguro");
                }
                break;

            case "hospital":
                var chance2 = Math.random() * 10;
                if (chance2 > 5) {
                    Estado.infeccion();
                }
                break;

            case "estacion de policia":
                break;
        }

    }
}

// Guarde esto para luego estudiar Collections.
// ArrayList<String> areasDeJuego = new ArrayList<>(Arrays.asList(areas));
// Collections.shuffle(areasDeJuego);