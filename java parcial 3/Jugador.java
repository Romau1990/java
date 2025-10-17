import java.util.ArrayList;
import java.util.Arrays;
import java.util.TimerTask;

//Metodos y propiedades exclusivas del Jugador. 

public class Jugador {

    static ArrayList<ObjItem> mochila = new ArrayList<>();

    static String nombre;
    static int nivel = 1;
    static int fuerza = 0; // permite cargar más en la mochila
    static int resistencia = 0; // permite huir y moverte mas veces en un mismo turno
    static int percepcion = 0; // permite enconrar más y mejor loot
    static int ingenio = 0; // permite craftear mejor, más rapido y usar menos recursos
    static int voluntad = 0; // permite resistir más en el combate, y pasar más tiempo sin comer, tomar agua
                             // o dormir.
    static int destreza = 0; // aumenta las chances de esquivar ataques a corta y larga distancia
    static int vida = 100;
    static int nutricion = 100;
    static int hidratacion = 100;
    static int energia = 100;
    static int temperatura = 36;
    static Boolean inanicion = false;
    static Boolean deshidratacion = false;
    static Boolean cansancio = false;
    static Boolean hipotermia = false;
    static Boolean insolacion = false;
    static String estado = "Sano";
    private static int turno = 0;

    static {

        if (nutricion < 40) {
            Estado.inanicion();
        }
        if (hidratacion < 40) {
            Estado.deshidratacion();
        }
        if (energia < 40) {
            Estado.inanicion();
        }
        if (temperatura > 39) {
            Estado.hipotermia();;
        }
        if (temperatura < 35) {
            Estado.insolacion();
        }
        if(vida < 30 && nutricion < 50){
            Estado.infeccion();
        }

    }

    static public void nombre(String playerName) {
        Jugador.nombre = playerName;
    }

    static public void getTurno() {
        System.out.println(Jugador.turno);
    }

    static public int incrementarTurno(int turno) {
        return Jugador.turno += turno;
    }

    static public void verStats() {
        System.out.println("--------" + Jugador.nombre + "stats " + "--------");
        System.out.println("Turno: " + Jugador.turno);
        System.out.println(String.format(
                "nombre: %s \nnivel: %d \nfuerza: %d \nresistencia: %d \npersepcion: %d \ningenio: %d \nvoluntad: %d \ndestreza: %d \nvida: %d",
                Jugador.nombre, Jugador.nivel, Jugador.fuerza, Jugador.resistencia, Jugador.percepcion, Jugador.ingenio,
                Jugador.voluntad, Jugador.destreza, Jugador.vida));
    }

    static public void estadoActual() {
        System.out.println("------" + "estado de " + Jugador.nombre + "------");
        System.out.println(String.format(
                "vida: %d \nnutricion: %d \nhidratacion: %d \nenergia: %d \ntemperatura: %d \nestado: %s", Jugador.vida,
                Jugador.nutricion, Jugador.hidratacion, Jugador.energia, Jugador.temperatura, Jugador.estado));
    }

    static public void verMochila(Boolean verInfoCompleta) {
        for (ObjItem obj : Jugador.mochila) {
            if (obj instanceof Item) {
                Item item = (Item) obj;
                if (verInfoCompleta == false) {
                    item.basicInfo();
                } else {
                    item.verInfo();
                }

            } else if (obj instanceof Arma) {
                Arma arma = (Arma) obj;
                if (verInfoCompleta == false) {
                    arma.basicInfo();
                } else {
                    arma.verInfo();
                }
            }
        }
    }

    static public void verMochila() {
        verMochila(false);
    }

    static void lootear() {
        System.out.println("Has obtenido:");
        ListadoItems.randomItem().basicInfo();
    }

    static void crear() {
        System.out.println("acabas de crear un item");
    }

    static void viajar(String area) {

        System.out.println("Has emprendido tu viaje hasta " + area);
        new Thread(() -> {
            try {
                for (var i = 0; i < 3; i++) {
                    System.out.println("viajando...");
                    Thread.sleep(1000);
                }
                System.out.println("Has llegado a: " + area);
                Area.areaSeleccionada(area);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    static void recargar() {
    }

    static void usar() {
    } // agregaré libros que mejoren ciertas perks.

    static void esconderse() {
        // for(ObjItem obj : Jugador.mochila){
        // System.out.println(obj.getDescription());
        // }
    }

    static void equipar(String weapon) {
        boolean encontrado = false;

        for (ObjItem item : Jugador.mochila) {
            if (item.getNombre().equalsIgnoreCase(weapon)
                    && item.getProposito() != null
                    && Arrays.asList(item.getProposito()).contains("arma")) {

                item.getNombre().concat("[equipado]");
                System.out.println("Te has equipado: " + weapon);
                encontrado = true;
                break; // ya encontraste el arma, no hace falta seguir
            }
        }

        if (!encontrado) {
            System.out.println("No puedes equipar este objeto");
        }
    }

    static void soltar(String item) {
        Jugador.mochila.removeIf(obj -> obj.getNombre().equalsIgnoreCase(item));
    }

}
