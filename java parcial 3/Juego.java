import javax.swing.*;
import java.util.*;

public class Juego {
    public static void main(String[] args) {

        Scanner game = new Scanner(System.in);

        
        var choice = JOptionPane.showConfirmDialog(null,"Bienvenido superviviente, listo para comenzar tu aventura? presiona CONTINUAR si lo estas o CANCELAR si quieres abanonar");

        if (choice == 1) {
            JOptionPane.showMessageDialog(null, "has abandonado la partida");
        } else {

            // COMIENZA EL JUEGO
            int turno = 0;
            int test = 0;
            ListadoItems.darArma();
            ListadoItems.darItem();

            String nombreJugador = JOptionPane.showInputDialog("Cual es tu nombre?");
            Jugador.nombre(nombreJugador);
            System.out.println("Bien %s, comienzas tu aventura con un");
            Jugador.verStats();
            System.out.println("eres un superviviente y solo tienes disponible un ");

        }

    }
}

class Jugador {
    static String nombre;
    static ArrayList<ListadoItems> mochila = new ArrayList<>();


    //Métodos del personaje

    static public void nombre(String playerName) {
        Jugador.nombre = playerName;
    }

    static public void verStats() {
        System.out.println("Nombre jugador: " + Jugador.nombre);
    }
}

class ListadoItems {
    static ArrayList<Item> listaItems = new ArrayList<>();
    static ArrayList<Arma> listaArmas = new ArrayList<>();

    static public void añadirArma(Arma arma) {
        listaArmas.add(arma);
    }

    static public void añadirItem(Item item) {
        listaItems.add(item);
    }

    // entrega un arma inicial al jugador
    static public Arma darArma() {
        var indexArma = (int) (Math.random() * ListadoItems.listaArmas.size());
        System.out.println(ListadoItems.listaArmas.get(indexArma).nombre);
        return ListadoItems.listaArmas.get(indexArma);
    }

    // entrega un item inicial al jugador
    static public Item darItem() {
        var indexItem = (int) (Math.random() * ListadoItems.listaArmas.size());
        var cantidadItem = (int) ((Math.random() +1) * 5);
        System.out.println(ListadoItems.listaArmas.get(indexItem).nombre + " x" + cantidadItem);
        return ListadoItems.listaItems.get(indexItem);
    }


    static {
        // === ARMAS ===
        añadirArma(new Arma("Cuchillo", 3, 6, 1, 100, "Cuchillo de cocina afilado.", "corte"));
        añadirArma(new Arma("Hacha", 5, 10, 5, 120, "Hacha de supervivencia pesada.", "corte"));
        añadirArma(new Arma("Barra de metal", 4, 8, 4, 150, "Barra sólida de metal oxidada.", "impacto"));
        añadirArma(new Arma("Arco y flecha", 6, 12, 3, 80, "Arco de madera con cuerdas tensadas.", "perforante"));
        añadirArma(new Arma("Sartén", 2, 5, 3, 200, "Sartén de hierro, ideal para golpear cabezas.", "impacto"));
        añadirArma(new Arma("Pistola 9mm y balas", 8, 14, 2, 90, "Pistola semiautomática con munición.", "perforante"));
        añadirArma(new Arma("Llave de tuercas", 3, 7, 3, 130, "Herramienta de metal resistente.", "impacto"));
        añadirArma(new Arma("Nada", 0, 0, 0, 0, "No tenés un arma equipada.", "ninguno"));
        añadirArma(new Arma("Bisturí", 2, 4, 1, 50, "Instrumento quirúrgico muy filoso.", "corte"));
        añadirArma(new Arma("Destornillador", 2, 5, 1, 80, "Destornillador común, útil y mortal.", "perforante"));

        // === ITEMS ===
        añadirItem(new Item("Vendaje", 0, 0, 1, 1, "Sirve para detener hemorragias leves.", "ninguno"));
        añadirItem(new Item("Carne cruda", 0, 0, 2, 1, "Carne sin cocinar, puede enfermarte.", "ninguno"));
        añadirItem(new Item("Botella de agua", 0, 0, 1, 1, "Agua limpia para hidratarte.", "ninguno"));
        añadirItem(new Item("Chatarra", 0, 0, 3, 1, "Restos metálicos, útiles para reparar cosas.", "ninguno"));
        añadirItem(new Item("Electronicos", 0, 0, 2, 1, "Piezas electrónicas para fabricar o reparar.", "ninguno"));
        añadirItem(new Item("Fosforos", 0, 0, 1, 1, "Caja con fósforos secos.", "ninguno"));
        añadirItem(new Item("Linterna", 0, 0, 2, 80, "Linterna de mano para iluminar.", "ninguno"));
        añadirItem(new Item("Sobre de dormir", 0, 0, 3, 200, "Permite descansar y recuperar energía.", "ninguno"));
        añadirItem(new Item("Fuegos artificiales", 0, 0, 2, 1, "Sirven para distraer enemigos o iluminar.", "ninguno"));
        añadirItem(new Item("Antibioticos", 0, 0, 1, 1, "Curan infecciones o enfermedades leves.", "ninguno"));
        añadirItem(new Item("Garzúa", 0, 0, 1, 100, "Herramienta para forzar cerraduras.", "ninguno"));
        añadirItem(new Item("madera", 0, 0, 2, 0, "Sirve para reparar y construir", "ninguno"));
    }

}

// plantilla de items
class Item {
    String nombre;
    int dañoMin;
    int dañoMax;
    int peso;
    int durabilidad;
    String descripcion;
    String tipoDaño;
    int cantidad; 

    public Item(String nombre, int dañoMin, int dañoMax, int peso, int durabilidad, String descripcion,String tipoDaño) {
        this.nombre = nombre;
        this.dañoMin = dañoMin;
        this.dañoMax = dañoMax;
        this.peso = peso;
        this.durabilidad = durabilidad;
        this.descripcion = descripcion;
        this.tipoDaño = tipoDaño;
        this.cantidad = 0; 
    }
}

class Arma {
    String nombre;
    int dañoMin;
    int dañoMax;
    int peso;
    int durabilidad;
    String descripcion;
    String tipoDaño;
    int cantidad;

    public Arma(String nombre, int dañoMin, int dañoMax, int peso, int durabilidad, String descripcion,
            String tipoDaño) {
        this.nombre = nombre;
        this.dañoMin = dañoMin;
        this.dañoMax = dañoMax;
        this.peso = peso;
        this.durabilidad = durabilidad;
        this.descripcion = descripcion;
        this.tipoDaño = tipoDaño;
        this.cantidad = 0;
    }
}