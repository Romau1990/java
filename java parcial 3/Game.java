
import javax.swing.*;
import java.util.*;

public class Game {
    public static void main(String[] args) {

        
        String arrayArmas[] = { "cuchillo", "hacha", "barra de metal", "arco y flecha", "sartén", "pistola 9mm y balas",
        "llave de tuercas", "nada", "bisturí", "destornillador" };

        String arrayItems[] = { "vendaje", "carne cruda", "botella de agua", "chatarra", "electronicos", "fosforos",
                "linterna", "sobre de dormir", "fuegos artificiales", "antibioticos", "garzúa" };

        
        
        
        
    
        // Juego
        Scanner scan = new Scanner(System.in);
        int armaIndice = (int) (Math.random() * arrayArmas.length);
        int itemIndice = (int) (Math.random() * arrayItems.length);
        int cantidadItems = (int) (Math.random() * 5);
        int test = 1;
        int turno = 0;
        var choice = JOptionPane.showConfirmDialog(null,"Bienvenido superviviente, listo para comenzar tu aventura? presiona CONTINUAR si lo estas o CANCELAR si quieres abanonar");
        if (choice == 1) {
            JOptionPane.showMessageDialog(null, "has abandonado la partida");
        } else {
            String nombreJugador = JOptionPane.showInputDialog("Cual es tu nombre?");
            Personaje jugador = new Personaje(nombreJugador);

            //selección random de arma y objeto principal
            String armaPrincipal = arrayArmas[armaIndice];
            String itemPrincipal = arrayItems[itemIndice];

            
            while (test < 10) {
                System.out.println("día: " + turno);
                test++;
            }
        }

    }
}

// stats del personaje
class Personaje {
    String nombreJugador;String[] mochila;String nombrePersonaje;int peso;int hidratacion;int alimentacion;int concentracion;int estadoAnimo;int estamina;String estadoSalud;

    Personaje(String nombreJugador) {
        this.nombreJugador = nombreJugador;
        ArrayList<Item> mochila = new ArrayList<>();
        this.peso = 5;
        this.hidratacion = 100;
        this.alimentacion = 100;
        this.concentracion = 100;
        this.estadoAnimo = 100;
        this.estamina = 100;
        this.estadoSalud = "optimo";
    }

    public void verStats() {
        System.out.println(this.nombreJugador);
    }

    public void cocinar() {
    }

    public void usar() {
    }

    public void buscar() {
    }

    public void lootear(String ...items){
        
    }

    public void soltar() {
    }

    public void reparar() {
    }

    public void reciclar() {
    }

    public void crear() {
    }

    public void dormir() {
    }

    public void huir() {
    }

    public void atacar() {
    }

    public void disparar() {
    }

    public void endTurn() {

    }

}

// perks del personaje
class Perks {
    int forzarCerradura;int cocinar;int curarHeridas;int reparar;int desguazar;int fuerza;int craftear;int sigilo;int cazadorNato;int agilidad;
    Perks() {
        this.forzarCerradura = 0;
        this.cocinar = 0;
        this.curarHeridas = 0;
        this.reparar = 0;
        this.desguazar = 0;
        this.fuerza = 0; // mejora capacidad de carga y fuerza al combatir o llevar la mochila al maximo
        this.craftear = 0;
        this.sigilo = 0;
        this.cazadorNato = 0; // mejora precision con armas a distancia
        this.agilidad = 0;
    }
}

//listado de items y armas
class ListadoItems{
    static ArrayList<Item> lista = new ArrayList<>();

    static void añadir(Item item){
        lista.add(item);
    }
    static{
        añadir(new Item("sarten", 4,10,1,40,"sirve para matar y cocinar", "contundente"));
        añadir(new Item("Cuchillo", 3, 6, 1, 100, "Cuchillo de cocina afilado.", "corte"));
        añadir(new Item("Hacha", 5, 10, 5, 120, "Hacha de supervivencia pesada.", "corte"));
        añadir(new Item("Barra de metal", 4, 8, 4, 150, "Barra sólida de metal oxidada.", "impacto"));
        añadir(new Item("Arco y flecha", 6, 12, 3, 80, "Arco de madera con cuerdas tensadas.", "perforante"));
        añadir(new Item("Sartén", 2, 5, 3, 200, "Sartén de hierro, ideal para golpear cabezas.", "impacto"));
        añadir(new Item("Pistola 9mm y balas", 8, 14, 2, 90, "Pistola semiautomática con munición.", "perforante"));
        añadir(new Item("Llave de tuercas", 3, 7, 3, 130, "Herramienta de metal resistente.", "impacto"));
        añadir(new Item("Nada", 0, 0, 0, 0, "No tenés un arma equipada.", "ninguno"));
        añadir(new Item("Bisturí", 2, 4, 1, 50, "Instrumento quirúrgico muy filoso.", "corte"));
        añadir(new Item("Destornillador", 2, 5, 1, 80, "Destornillador común, útil y mortal.", "perforante"));
    }

}


//plantilla de items
class Item{
    String nombre; int dañoMin; int dañoMax;  int peso; int durabilidad; String descripcion; String tipoDaño;
    public Item(String nombre, int dañoMin, int dañoMax, int peso, int durabilidad, String descripcion, String tipoDaño){
        this.nombre = nombre;
        this.dañoMin = dañoMin;
        this.dañoMax = dañoMax;
        this.peso = peso; 
        this.durabilidad = durabilidad; 
        this.descripcion = descripcion;  
        this.tipoDaño = tipoDaño;
    }
}










// Juego se supervivencia postapocalíptico zombie

// Concepto- juego por turno donde cada 7 turnos una grupo de zombies ataca.. la
// orda irá creciendo semana a semana agregando enemigos especiales con
// habilidades únicas hasta que eventualmente los jugadores sean derrotados..
// Sin embargo, las perks ganadas durante la partida serán permanentes para la
// próxima ronda cual si fuera un juego roguelite.

// Lo primero es establecer las variables que serán necesarias para llevar a
// cabo el juego
// Establecer los comandos a utilizar como COCINAR, BUSCAR, SOLTAR, USAR,
// REPARAR, RECICLAR, DORMIR ETC.