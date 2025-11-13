public class Comandos {
    static void verComandos() {
        System.out.println("==== MENU DE COMANDOS ================================");
        System.out.println("mapa -> ve todos los sitios disponibles para viajar");
        System.out.println("viajar -> viajar a un sitio del mapa elegido");
        System.out.println("el [] establece que debes usar el nombre del item");
        System.out.println("salir -> abandonar partida");
        System.out.println("lootear -> rebuscar items");
        System.out.println("mochila -> ver mochila");
        System.out.println("usar [item] -> utilizar un item especifico");
        System.out.println("descansar -> recargar energia");
        System.out.println("estado actual -> ver la condicion de salud actual de tu personaje");
        System.out.println("ver stats -> ver las estadisticas de tu personaje");
        System.out.println("equipar [item] -> preparar un arma especifica");
        System.out.println("=================================================================");
    }

    static void infoMenu(String nombreJugador) {
        System.out.println(Juego.CYAN +
                "=== MENU ============================================================================================================================= ");
        System.out.println("turno: " + Jugador.getTurno() + " ----------" + " nombre: " + nombreJugador
                + " ----------" + " dinero: " + Jugador.dinero + " ---------- " + "vida: " + Jugador.vida
                + " ---------- " + "area: " + Jugador.areaActual);
        System.out.println("Estacion: " + Area.estacion + " ---------- " + "Clima: " + Area.clima
                + " ---------- " + "temperatura: " + Area.temperatura + " ---------- " + Jugador.pesoTotalItems
                + "/" + Jugador.pesoMaximo);
        System.out.print("Ver comandos -> comandos ----------");
        System.out.println("salir del juego-> salir |");
        System.out.println(
                "====================================================================================================================================");
    }
}