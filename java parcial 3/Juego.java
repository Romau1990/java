import javax.swing.*;
import java.util.*;

public class Juego {
    public static void main(String[] args) {

        var choice = JOptionPane.showConfirmDialog(null,
                "Bienvenido superviviente, listo para comenzar tu aventura? presiona CONTINUAR si lo estas o CANCELAR si quieres abanonar");

        if (choice == 1) {
            JOptionPane.showMessageDialog(null, "has abandonado la partida");
        } else {

            // COMIENZA EL JUEGO

            // INICIALIZACION DE VARIABLES Y DATOS _________________________________________

            String[] areasDelJuego = { "Casa", "Ciudad", "playa", "Colina", "basurero", "bosque",
                    "sitio en construcción", "caverna", "campo", "Tienda", "iglesia abandonada", "caravana", "puente" };

            Boolean estadoJuego = true;
            Scanner game = new Scanner(System.in);
            int turno = 0;
            ListadoItems.darArma();
            ListadoItems.darItem();
            String nombreJugador = JOptionPane.showInputDialog("Cual es tu nombre?");
            Jugador.nombre(nombreJugador);

            // INTRO DEL
            // JUEGO_______________________________________________________________

            System.out.println(
                    "Recuerda que puedes elegir un sitio a donde ir cada vez. Cada sitio te mostrará cuantos turnos necesitaras para llegar hasta ese punto.");
            System.out.println(
                    "Cada turno consumira un poco de tu energia, ten cuidado con eso. Si quieres mantenerte alimentado e hidratado usa los items que encuentres en el juego");
            System.out.println(String.format("Bien %s, comienzas tu aventura con: ", nombreJugador));
            System.out.println("----------------------");
            Jugador.verMochila();
            System.out.println("----------------------");
            System.out.println("para equipar tu arma escribe equipar");

            // BUCLE DEL
            // JUEGO_______________________________________________________________________

            while (estadoJuego = true) {

                // opciones de menu
                System.out.println("=== MENU ==== ");
                System.out.println("ver comandos -> comandos");
                System.out.println("¿Que harás ahora?");
                var accionTomada = game.nextLine();
                System.out.println(accionTomada);

                if (accionTomada.equalsIgnoreCase("comandos")) {
                    Comandos.verComandos();
                } else {
                    // sitios
                    for (var i = 0; i < 5; i++) {
                        int indexAreas = (int) (Math.random() * areasDelJuego.length);
                        int cantidadTurnos = (int) (Math.random() * 5);
                        System.out.println(areasDelJuego[indexAreas] + "---" + cantidadTurnos + " turnos");
                    }

                   switch(accionTomada){
                     case "comando desconocido":
                        System.out.println("Todavia no se");
                        break;
                   }









                }

            }

        }

    }
}

// Accion genera la interaccion entre el enemigo y el jugador. Es decir, la
// batalla.
class Accion {
    static void atacar() {
    }

    static void disparar() {
    }

    static void huir() {
    }

}

// Consola de comandos

class Comandos {
    static void verComandos() {
        System.out.println("==== MENU DE COMANDOS ====");
        System.out.println("el [] establece que debes usar el nombre del item");
        System.out.println("salir -> abandonar partida");
        System.out.println("lootear -> abandonar partida");
        System.out.println("ver mochila -> abandonar partida");
        System.out.println("usar [item] -> utilizar un item especifico");
        System.out.println("descansar -> recargar energia");
        System.out.println("estado actual -> ver la condicion de salud actual de tu personaje");
        System.out.println("ver stats -> ver las estadisticas de tu personaje");
        System.out.println("equipar [item] -> ver las estadisticas de tu personaje");

    }
}

// voy a cambiar ObjItem por ListadoItems

class Jugador {
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
    static int vida = 0;
    static int nutricion = 100;
    static int hidratacion = 100;
    static int energia = 100;
    static int temperatura = 36;
    static String estado = "Sano";

    static public void nombre(String playerName) {
        Jugador.nombre = playerName;
    }

    static public void verStats() {
        System.out.println("--------" + Jugador.nombre + "stats " + "--------");
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

    static void equipar() {
    }

    static void soltar(String item) {
        Jugador.mochila.removeIf(obj -> obj.getNombre().equalsIgnoreCase(item));
    }
}

// LISTA DE TODOS LOS ITEMS DEL JUEGO
class ListadoItems {
    static ArrayList<Item> listaItems = new ArrayList<>(); // solo accceso a Items
    static ArrayList<Arma> listaArmas = new ArrayList<>(); // solo acceso a Armas
    static ArrayList<ObjItem> todoElLoot = new ArrayList<>(); // aca uso ObjItems que es padre de item y arma por ende
                                                              // tiene acceso a ambos.

    static public void añadirArma(Arma arma) {
        listaArmas.add(arma);
        todoElLoot.add(arma);
    }

    static public void añadirItem(Item item) {
        listaItems.add(item);
        todoElLoot.add(item);
    }

    // entrega un arma inicial al jugador
    static public Arma darArma() {
        var indexArma = (int) (Math.random() * ListadoItems.listaArmas.size());
        System.out.println(ListadoItems.listaArmas.get(indexArma).nombre + " x" + "1");
        Jugador.mochila.add(ListadoItems.listaArmas.get(indexArma));
        ListadoItems.listaArmas.get(indexArma).cantidad++;
        return ListadoItems.listaArmas.get(indexArma);
    }

    // entrega un item inicial al jugador
    static public Item darItem() {
        var indexItem = (int) (Math.random() * ListadoItems.listaArmas.size());
        var cantidadItem = (int) ((Math.random() + 1) * 5);
        System.out.println(ListadoItems.listaItems.get(indexItem).nombre + " x" + cantidadItem); // muestra la info
        ListadoItems.listaItems.get(indexItem).cantidad = cantidadItem;
        Jugador.mochila.add(ListadoItems.listaItems.get(indexItem));
        return ListadoItems.listaItems.get(indexItem);
    }

    static public ObjItem randomItem() {
        var cantidadItem = (int) ((Math.random() + 1) * 5);
        var index = (int) (Math.random() * ListadoItems.todoElLoot.size());
        Jugador.mochila.add(ListadoItems.todoElLoot.get(index));
        ListadoItems.todoElLoot.get(index).cantidad = cantidadItem;
        return ListadoItems.todoElLoot.get(index);
    }

    static {
        // === ARMAS ===
        añadirArma(new Arma("Cuchillo", 3, 6, 1, 100, "Cuchillo de cocina afilado.", "corte",
                new String[] { "arma", "recoleccion" }));
        añadirArma(new Arma("Hacha", 5, 10, 5, 120, "Hacha de supervivencia pesada.", "corte",
                new String[] { "arma", "talar" }));
        añadirArma(new Arma("Barra de metal", 4, 8, 4, 150, "Barra sólida de metal oxidada.", "impacto",
                new String[] { "arma" }));
        añadirArma(new Arma("Arco y flecha", 6, 12, 3, 80, "Arco de madera con cuerdas tensadas.", "perforante",
                new String[] { "arma", "caceria" }));
        añadirArma(new Arma("Sartén", 2, 5, 3, 200, "Sartén de hierro, ideal para golpear cabezas.", "impacto",
                new String[] { "arma", "cocina", "recipiente" }));
        añadirArma(new Arma("Pistola 9mm y balas", 8, 14, 2, 90, "Pistola semiautomática con munición.", "perforante",
                new String[] { "arma", "caceria" }));
        añadirArma(new Arma("Llave de tuercas", 3, 7, 3, 130, "Herramienta de metal resistente.", "impacto",
                new String[] { "arma", "desguace" }));
        añadirArma(new Arma("Nada", 0, 0, 0, 0, "No tenés un arma equipada.", "ninguno", new String[] { "nada" }));
        añadirArma(new Arma("Bisturí", 2, 4, 1, 50, "Instrumento quirúrgico muy filoso.", "corte",
                new String[] { "arma", "recoleccion", "curar", "reparacion" }));
        añadirArma(new Arma("Destornillador", 2, 5, 1, 80, "Destornillador común, útil y mortal.", "perforante",
                new String[] { "arma", "desguace", "reparacion" }));

        // === ITEMS ===
        añadirItem(new Item("Vendaje", 1, 1, "Sirve para detener hemorragias leves.", new String[] { "curar" }));
        añadirItem(new Item("Carne cruda", 2, 1, "Carne sin cocinar, puede enfermarte.",
                new String[] { "arma", "recoleccion" }));
        añadirItem(new Item("Botella de agua", 1, 1, "Agua limpia para hidratarte.",
                new String[] { "hidratacion", "recipiente" }));
        añadirItem(new Item("Chatarra", 3, 1, "Restos metálicos, útiles para reparar cosas.",
                new String[] { "reparacion", "creacion" }));
        añadirItem(new Item("Electronicos", 2, 1, "Piezas electrónicas para fabricar o reparar.",
                new String[] { "reparacion", "creacion" }));
        añadirItem(new Item("Fosforos", 1, 1, "Caja con fósforos secos.",
                new String[] { "encender", "cocinar", "iluminar" }));
        añadirItem(new Item("Linterna", 2, 80, "Linterna de mano para iluminar.", new String[] { "iluminar" }));
        añadirItem(new Item("Sobre de dormir", 3, 200, "Permite descansar y recuperar energía.",
                new String[] { "descansar", "abrigar" }));
        añadirItem(new Item("Fuegos artificiales", 2, 1, "Sirven para distraer enemigos o iluminar.",
                new String[] { "arma", "recoleccion" }));
        añadirItem(new Item("Antibioticos", 1, 1, "Curan infecciones o enfermedades leves.",
                new String[] { "antibiotico" }));
        añadirItem(new Item("Garzúa", 1, 100, "Herramienta para forzar cerraduras.", new String[] { "abrir" }));
        añadirItem(
                new Item("madera", 2, 0, "Sirve para reparar y construir", new String[] { "reparacion", "creacion" })); // falta
                                                                                                                        // agregar
                                                                                                                        // los
                                                                                                                        // propositos
        añadirItem(new Item("carne enlatada", 2, 0, "Alimento no muy sabroso pero quita el hambre",
                new String[] { "alimentacion", "recipiente" }));
    }

}

// plantilla de clases

// Clase padre solo con atributos comunes
abstract class ObjItem {
    String nombre;
    int peso;
    int durabilidad;
    String descripcion;
    int cantidad;
    String[] proposito;

    public ObjItem(String nombre, int peso, int durabilidad, String descripcion, String propsito[]) {
        this.nombre = nombre;
        this.peso = peso;
        this.durabilidad = durabilidad;
        this.descripcion = descripcion;
        this.proposito = proposito;
        this.cantidad = 0;
    }

    public String getNombre() {
        return this.nombre;
    }

    public int getPeso() {
        return this.peso;
    }

    public int getDurabilidad() {
        return this.durabilidad;
    }

    public String getDescription() {
        return this.descripcion;
    }

    public String[] getProposito() {
        return this.proposito;
    }

    public void verInfo() {
        System.out.println("------------" + this.nombre + "---------------");
        System.out.println("nombre: " + this.nombre);
        System.out.println("peso: " + this.peso);
        System.out.println("durabilidad: " + this.durabilidad);
        System.out.println("descripcion: " + this.descripcion);
        System.out.println("descripcion: " + this.proposito);
        System.out.println("cantidad: " + this.cantidad);
    }

    public void basicInfo() {
        System.out.println(this.nombre + " x" + this.cantidad);
    }
}

// Clase Item sin atributos de daño
class Item extends ObjItem {
    public Item(String nombre, int peso, int durabilidad, String descripcion, String proposito[]) {
        super(nombre, peso, durabilidad, descripcion, proposito);
    }
}

// Clase Arma con atributos de daño
class Arma extends ObjItem {
    int dañoMin;
    int dañoMax;
    String tipoDaño;

    public Arma(String nombre, int dañoMin, int dañoMax, int peso, int durabilidad, String descripcion,
            String tipoDaño, String proposito[]) {
        super(nombre, peso, durabilidad, descripcion, proposito);
        this.dañoMin = dañoMin;
        this.dañoMax = dañoMax;
        this.tipoDaño = tipoDaño;
    }

    public void verInfo() {
        System.out.println("------------" + this.nombre + "---------------");
        System.out.println("Item: " + this.nombre);
        System.out.println("daño: " + this.dañoMin + "-" + this.dañoMax);
        System.out.println("tipo de daño: " + this.tipoDaño);
        System.out.println("peso: " + this.peso);
        System.out.println("durabilidad: " + this.durabilidad);
        System.out.println("descripcion: " + this.descripcion);
        System.out.println("descripcion: " + this.proposito);
        System.out.println("cantidad: " + this.cantidad);
    }

    public void basicInfo() {
        System.out.println(this.nombre + " " + this.dañoMin + "-" + this.dañoMax + " x" + this.cantidad);
    }
}
