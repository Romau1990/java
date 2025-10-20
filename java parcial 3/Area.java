import java.util.Arrays;

public class Area {
    static String area;
    static int nivel;
    static String[] ListaAreas = new String[] { "casa -> turno: 1", "ciudad -> turno: 1", "playa -> turno: 1",
            "colina -> turno: 1",
            "basurero -> turnos: 2", "bosque -> turno: 1", "sitio en construcción -> turno: 1", "caverna -> turno: 1",
            "campo -> turno: 1", "tienda -> turno: 1",
            "iglesia abandonada -> turno: 1", "caravana -> turno: 1", "puente -> turno: 1" };

    static void verAreas() {
        Arrays.asList(Area.ListaAreas).forEach(a -> {
            System.out.println(a);
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

            case "iglesia":
                // se incrementa turno en el area porque cada area cuesta x cantidad de turnos
                break;

            case "caravana":
                // se incrementa turno en el area porque cada area cuesta x cantidad de turnos
                break;

            case "puente":
                // se incrementa turno en el area porque cada area cuesta x cantidad de turnos
                break;
        }

    }
}

// Guarde esto para luego estudiar Collections.
// ArrayList<String> areasDeJuego = new ArrayList<>(Arrays.asList(areas));
// Collections.shuffle(areasDeJuego);