import javax.swing.*;
import java.util.*;

//Juego principal

public class Juego {

    public static final String RESET = "\u001B[0m";

    // Colores de texto
    public static final String NEGRO = "\u001B[30m";
    public static final String ROJO = "\u001B[31m";
    public static final String VERDE = "\u001B[32m";
    public static final String AMARILLO = "\u001B[33m";
    public static final String AZUL = "\u001B[34m";
    public static final String MAGENTA = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String BLANCO = "\u001B[37m";

    // Colores de fondo
    public static final String BG_NEGRO = "\u001B[40m";
    public static final String BG_ROJO = "\u001B[41m";
    public static final String BG_VERDE = "\u001B[42m";
    public static final String BG_AMARILLO = "\u001B[43m";
    public static final String BG_AZUL = "\u001B[44m";
    public static final String BG_MAGENTA = "\u001B[45m";
    public static final String BG_CYAN = "\u001B[46m";
    public static final String BG_BLANCO = "\u001B[47m";

    // Estilos
    public static final String NEGRITA = "\u001B[1m";
    public static final String SUBRAYADO = "\u001B[4m";
    public static final String REVERSE = "\u001B[7m";

    public static void main(String[] args) {

        var choice = JOptionPane.showConfirmDialog(null,
                "Bienvenido superviviente, listo para comenzar tu aventura? presiona CONTINUAR si lo estas o CANCELAR si quieres abanonar");

        if (choice == 1) {
            JOptionPane.showMessageDialog(null, "has abandonado la partida");
        } else {

            // COMIENZA EL JUEGO

            // INICIALIZACION DE VARIABLES Y DATOS _________________________________________

            String[] areas = new String[] { "Casa", "Ciudad", "playa", "Colina", "basurero", "bosque",
                    "sitio en construcción", "caverna", "campo", "Tienda", "iglesia abandonada", "caravana", "puente" };

            ArrayList<String> areasDeJuego = new ArrayList<>(Arrays.asList(areas));
            Collections.shuffle(areasDeJuego);

            Scanner game = new Scanner(System.in);

            // pide el nombre del jugador
            String nombreJugador = JOptionPane.showInputDialog("Cual es tu nombre?");
            if (nombreJugador == null || nombreJugador.isBlank()) {
                while (nombreJugador == null || nombreJugador.isBlank()) {
                    nombreJugador = JOptionPane.showInputDialog("Cual es tu nombre?");
                }
            } else {
                Jugador.nombre(nombreJugador);
            }

            // INTRO DEL
            // JUEGO_______________________________________________________________

            // items iniciales agregados automaticamente a la mochila del personaje.
            ListadoItems.darArma();
            ListadoItems.darItem();

            // Consejos rápidos antes de iniciar la partida
            System.out.println(
                    "Recuerda que puedes elegir un sitio a donde ir cada vez. Cada sitio te mostrará cuantos turnos necesitaras para llegar hasta ese punto.");
            System.out.println(
                    "Cada turno consumira un poco de tu energia, ten cuidado con eso. Si quieres mantenerte alimentado e hidratado usa los items que encuentres en el juego");
            System.out.println(String.format("Bien %s, comienzas tu aventura con: ", nombreJugador));
            System.out.println("----------------------");
            Jugador.verMochila();
            System.out.println("----------------------");

            // BUCLE DEL
            // JUEGO_______________________________________________________________________

            Boolean estadoJuego = true;
            int turno = 0;

            while (true) {

                // opciones estaticas de menu (se mostrarán siempre como ayuda memoria para el
                // jugador)
                System.out.println("=== MENU ==== ");
                System.out.println("turno: " + turno + " nombre: " + nombreJugador);
                System.out.print("ver comandos -> comandos ----------");
                System.out.println("salir del juego-> salir |");

                // en accion tomada, además de salir iniciar podría usar esta instancia para
                // descansar, curarme, etc.
                System.out.println(
                        "----------------------------------------------------------------------------------------------------------------");
                System.out.println("¿Que harás ahora?");
                var accionTomada = game.nextLine().toLowerCase();
                if (accionTomada.equalsIgnoreCase("comandos")) {
                    Comandos.verComandos();
                } else if (accionTomada.equalsIgnoreCase("salir")) {
                    JOptionPane.showMessageDialog(null, "has abandonado la partida");
                    System.exit(0);
                }

                // trozo de lógica que permite reconocer ciertos comandos con más de una palabra
                String[] partes = accionTomada.split(" ", 2);
                String comando = partes[0];
                String parametro = partes.length > 1 ? partes[1] : "";

                // Acciones del jugador

                switch (comando) {
                    case "equipar":
                        Jugador.equipar(parametro);
                        break;

                    case "viajar":
                        // seleccion de area
                        System.out.println("----------------------");
                        System.out.println("A donde quieres ir?");

                        String sitioElegido = game.nextLine();
                        Jugador.viajar(sitioElegido);

                        System.out.println("----------------------");
                        System.out.println("has llegado al sitio: " + sitioElegido);
                        break;
                }

            }

        }

    }
}



                        // for (var i = 0; i < 4; i++) {
                        //     var turnoSitio = (int) (Math.random() * 5);
                        //     String nombreSitio = areasDeJuego.get(i);
                        //     System.out.println(nombreSitio + "------------------" + turnoSitio + " turnos");
                        // }