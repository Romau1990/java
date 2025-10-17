public class Area {
    static String area;
    static int nivel;

    public Area(String area, int nivel) {

        String[] ListaAreas = new String[] { "Casa", "Ciudad", "playa", "Colina", "basurero", "bosque","sitio en construcción", "caverna", "campo", "Tienda", "iglesia abandonada", "caravana", "puente" };
        Area.area = area;
        Area.nivel = nivel;
    }

    static void areaSeleccionada(String area) {

        switch (area) {
            case "basurero":

                // se incrementa turno en el area porque cada area cuesta x cantidad de turnos
                Jugador.incrementarTurno(1);
                Estado.infeccion();

        }

    }
}





//Guarde esto para luego estudiar Collections.
// ArrayList<String> areasDeJuego = new ArrayList<>(Arrays.asList(areas));
// Collections.shuffle(areasDeJuego);