import javax.swing.*;
import java.util.*;

//Listado de todos los items del juego. Aquí se añaden y se manipulan. 

public class ListadoItems {
        static ArrayList<Item> listaItems = new ArrayList<>(); // solo accceso a Items
        static ArrayList<Arma> listaArmas = new ArrayList<>(); // solo acceso a Armas
        static ArrayList<ObjItem> todoElLoot = new ArrayList<>(); // aca uso ObjItems que es padre de item y arma por
                                                                  // ende
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
                // System.out.println(ListadoItems.listaArmas.get(indexArma).nombre + " x" +
                // "1");
                Jugador.mochila.add(ListadoItems.listaArmas.get(indexArma));
                ListadoItems.listaArmas.get(indexArma).cantidad++;
                return ListadoItems.listaArmas.get(indexArma);
        }

        // entrega un item inicial al jugador
        static public Item darItem() {
                var indexItem = (int) (Math.random() * ListadoItems.listaArmas.size());
                var cantidadItem = (int) ((Math.random() + 1) * 5);
                // System.out.println(ListadoItems.listaItems.get(indexItem).nombre + " x" +
                // cantidadItem); // muestra la info
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
                añadirArma(new Arma("Cuchillo", 1, 3, 6, 1, 100, "Cuchillo de cocina afilado.", "corte",
                                new String[] { "arma", "recoleccion" }));
                añadirArma(new Arma("Hacha", 3, 5, 10, 5, 120, "Hacha de supervivencia pesada.", "corte",
                                new String[] { "arma", "talar" }));
                añadirArma(new Arma("Barra de metal", 2, 4, 8, 4, 150, "Barra sólida de metal oxidada.", "impacto",
                                new String[] { "arma" }));
                añadirArma(new Arma("Arco y flecha", 3, 6, 12, 3, 80, "Arco de madera con cuerdas tensadas.",
                                "perforante",
                                new String[] { "arma", "caceria" }));
                añadirArma(new Arma("Sartén", 1, 2, 5, 3, 200, "Sartén de hierro, ideal para golpear cabezas.",
                                "impacto",
                                new String[] { "arma", "cocina", "recipiente" }));
                añadirArma(new Arma("Pistola 9mm y balas", 4, 8, 14, 2, 90, "Pistola semiautomática con munición.",
                                "perforante",
                                new String[] { "arma", "caceria" }));
                añadirArma(new Arma("Llave de tuercas", 1, 3, 7, 3, 130, "Herramienta de metal resistente.", "impacto",
                                new String[] { "arma", "desguace" }));
                añadirArma(new Arma("Nada", 1, 0, 0, 0, 0, "No tenés un arma equipada.", "ninguno",
                                new String[] { "nada" }));
                añadirArma(new Arma("Bisturí", 1, 2, 4, 1, 50, "Instrumento quirúrgico muy filoso.", "corte",
                                new String[] { "arma", "recoleccion", "curar", "reparacion" }));
                añadirArma(new Arma("Destornillador", 1, 2, 5, 1, 80, "Destornillador común, útil y mortal.",
                                "perforante",
                                new String[] { "arma", "desguace", "reparacion" }));

                // === ITEMS ===
                añadirItem(new Item("Vendaje", 1, 1, 1, "Sirve para detener hemorragias leves.",
                                new String[] { "curar" }));
                añadirItem(new Item("Carne cruda", 1, 2, 1, "Carne sin cocinar, puede enfermarte.",
                                new String[] { "arma", "recoleccion" }));
                añadirItem(new Item("Botella de agua", 1, 1, 1, "Agua limpia para hidratarte.",
                                new String[] { "hidratacion", "recipiente" }));
                añadirItem(new Item("Chatarra", 1, 3, 1, "Restos metálicos, útiles para reparar cosas.",
                                new String[] { "reparacion", "creacion" }));
                añadirItem(new Item("Electronicos", 1, 2, 1, "Piezas electrónicas para fabricar o reparar.",
                                new String[] { "reparacion", "creacion" }));
                añadirItem(new Item("Fosforos", 1, 1, 1, "Caja con fósforos secos.",
                                new String[] { "encender", "cocinar", "iluminar" }));
                añadirItem(new Item("Linterna", 1, 2, 80, "Linterna de mano para iluminar.",
                                new String[] { "iluminar" }));
                añadirItem(new Item("Sobre de dormir", 1, 3, 200, "Permite descansar y recuperar energía.",
                                new String[] { "descansar", "abrigar" }));
                añadirItem(new Item("Fuegos artificiales", 1, 2, 1, "Sirven para distraer enemigos o iluminar.",
                                new String[] { "arma", "recoleccion" }));
                añadirItem(new Item("Antibioticos", 1, 1, 1, "Curan infecciones o enfermedades leves.",
                                new String[] { "antibiotico" }));
                añadirItem(new Item("Garzúa", 1, 1, 100, "Herramienta para forzar cerraduras.",
                                new String[] { "abrir" }));
                añadirItem(new Item("madera", 1, 2, 0, "Sirve para reparar y construir",
                                new String[] { "reparacion", "creacion" }));
                añadirItem(new Item("carne enlatada", 1, 2, 0, "Alimento no muy sabroso pero quita el hambre",
                                new String[] { "alimentacion", "recipiente" }));

        }

}
