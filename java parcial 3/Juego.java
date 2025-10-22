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

            Scanner game = new Scanner(System.in);

            // pide el nombre del jugador =========================================================================================

            String nombreJugador = JOptionPane.showInputDialog("Cual es tu nombre?");
            if (nombreJugador == null || nombreJugador.isBlank()) {
                while (nombreJugador == null || nombreJugador.isBlank()) {
                    nombreJugador = JOptionPane.showInputDialog("Cual es tu nombre?");
                }
            } else {
                Jugador.nombre(nombreJugador);
            }

            // items iniciales agregados automaticamente a la mochila del personaje ===============================================

            ListadoItems.darArma();
            ListadoItems.darItem();

            // Consejos rápidos antes de iniciar la partida =======================================================================

            System.out.println(
                    "========================================================================================================= ");
            System.out.println(
                    "HINT: Si esta es tu primera partida, no dudes en visitar la consola de comandos escribiendo 'comandos'");
            System.out.println(String.format("Bien %s, comienzas tu aventura con: ", nombreJugador));
            System.out.println("----------------------");
            Jugador.verMochila();
            System.out.println("----------------------");

            // variables del juego ==================================================================
            Area.estacionRandom();
            Area.rollearClima();
            Area.rollearTemp();
            Boolean estadoJuego = true;
            Boolean haViajado = false;
            int contadorEstacion = 0;

            // Bucle del juego ======================================================================

            while (true) {

                Jugador.calcularVida();

                if (contadorEstacion == 10) {
                    Area.rollearEstacion();
                    Area.rollearClima();
                    Area.rollearTemp();
                    contadorEstacion = 0;
                }
                // opciones estaticas de menu (se mostrarán siempre como ayuda memoria para el jugador ===========================================================
                System.out.println(Juego.CYAN +
                        "=== MENU ============================================================================================================================= ");
                System.out.println("turno: " + Jugador.getTurno() + " ----------" + " nombre: " + nombreJugador
                        + " ----------" + " dinero: " + Jugador.dinero + " ---------- " + "vida: " + Jugador.vida
                        + " ---------- " + "area: " + Jugador.areaActual);
                System.out.println("Estacion: " + Area.estacion + " ---------- " + "Clima: " + Area.clima
                        + " ---------- " + "temperatura: " + Area.temperatura + " ---------- " + Jugador.pesoTotalItems + "/" + Jugador.pesoMaximo );
                System.out.print("Ver comandos -> comandos ----------");
                System.out.println("salir del juego-> salir |");
                System.out.println(
                        "====================================================================================================================================");

                // en accion tomada, además de salir iniciar podría usar esta instancia
                // paradescansar, curarme, etc.

                System.out.println(Juego.BLANCO + "¿Que harás ahora?");
                System.out.println(
                        "----------------------------------------------------------------------------------------------------------------");
                var accionTomada = game.nextLine().toLowerCase();

                // trozo de lógica que permite reconocer ciertos comandos con más de una palabra
                String[] partes = accionTomada.split(" ", 2);
                String comando = partes[0];
                String parametro = partes.length > 1 ? partes[1] : "";

                // Acciones del jugador
                switch (comando) {
                    case "equipar":
                        Jugador.equipar(parametro);
                        break;

                    case "mapa":
                        System.out.println(
                                "Recuerda que puedes elegir un sitio a donde ir cada vez. Cada sitio te mostrará cuantos turnos necesitaras para llegar hasta ese punto.");
                        System.out.println(
                                "Cada turno consumira un poco de tu energia, ten cuidado con eso. Si quieres mantenerte alimentado e hidratado usa los items que encuentres en el juego");
                        Jugador.verMapa();
                        break;

                    case "salir":
                        JOptionPane.showMessageDialog(null, "has abandonado la partida");
                        estadoJuego = false;
                        System.exit(0);
                        break;

                    case "viajar":
                        // seleccion de area
                        System.out.println(
                                "----------------------------------------------------------------------------------------------------------------");
                        System.out.println(Juego.BLANCO + "A donde quieres ir? Si no estas seguro puedes ver el mapa");
                        System.out.println(
                                "----------------------------------------------------------------------------------------------------------------");
                        String sitioElegido = game.nextLine().trim();
                        Boolean sitioEncontrado = false;
                        for (String a : Area.ListaAreas) {
                            var split = a.split("-");
                            String sitio = split[0].trim();

                            var t = a.split(":");
                            int turno = Integer.parseInt(t[1].trim());

                            if (sitio.equalsIgnoreCase(sitioElegido)) {
                                sitioEncontrado = true;
                                Jugador.incrementarTurno(turno);
                                Jugador.viajar(sitioElegido);
                                break;
                            }
                        }
                        if (sitioEncontrado == false) {
                            System.out.println(Juego.ROJO + "ese sitio no existe en el mapa. Revisa nuevamente");
                        } else if (sitioEncontrado == true) {
                            haViajado = true;
                        }

                        if (sitioElegido.equalsIgnoreCase("mapa")) {
                            Jugador.verMapa();
                        }
                        contadorEstacion++;
                        break;

                    case "lootear":
                        if (haViajado == false) {
                            System.out.println(Juego.ROJO + "Necesitas viajar a algun sitio primero");
                        } else if (haViajado == true) {
                            Jugador.calcularPeso();
                            Jugador.lootear();
                        }
                        break;

                    case "mochila":
                        Jugador.verMochila();
                        break;

                    case "curar":
                        Jugador.curar();
                        break;

                    case "info":
                        Jugador.verStats();
                        Jugador.verEstado();
                        break;

                    case "estado":
                        Jugador.estadoActual();
                        break;

                    case "descansar":
                        System.out.println(
                                "cuantas horas quieres descansar? Cada hora descansada equivale a un turno. Ten en cuenta eso. Pon 0 para cancelar");
                        int horas = game.nextInt();
                        game.nextLine();
                        Jugador.descansar(horas);
                        break;
                    
                    case "dejar": 
                        System.out.println("Que items quieres dejar?");
                        Jugador.verMochila();
                        String itemElegido = game.nextLine();
                        Jugador.dejar(itemElegido);
                        break;

                    case "comandos":
                        Comandos.verComandos();
                        break;

                    default:
                        System.out.println(Juego.ROJO + "El comando seleccionado no existe");
                        break;
                }

            }
        }

    }
}
