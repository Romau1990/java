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
                var cantidadItem = (int) ((Math.random() + 1) * 3);
                // System.out.println(ListadoItems.listaItems.get(indexItem).nombre + " x" +
                // cantidadItem); // muestra la info
                ListadoItems.listaItems.get(indexItem).cantidad = cantidadItem;
                Jugador.mochila.add(ListadoItems.listaItems.get(indexItem));
                return ListadoItems.listaItems.get(indexItem);
        }

        // static public ObjItem randomItem() {
        // ObjItem o = ListadoItems.todoElLoot.get((int) (Math.random() *
        // ListadoItems.todoElLoot.size()));
        // ObjItem copia = (o instanceof Item)
        // ? new Item(((Item) o).nombre, ((Item) o).nivel, ((Item) o).peso, ((Item)
        // o).descripcion,
        // ((Item) o).proposito, ((Item) o).cantidadTurnos)
        // : new Arma(((Arma) o).nombre, ((Arma) o).nivel, ((Arma) o).dañoMin, ((Arma)
        // o).dañoMax,
        // ((Arma) o).peso, ((Arma) o).durabilidad, ((Arma) o).descripcion,
        // ((Arma) o).tipoDaño, ((Arma) o).proposito, ((Arma) o).cantidadTurnos);
        // copia.cantidad = (int) ((Math.random() + 1) * 2);
        // Jugador.mochila.add(copia);
        // return copia;
        // }

        static public ObjItem randomItem() {
                ObjItem o = ListadoItems.todoElLoot.get((int) (Math.random() * ListadoItems.todoElLoot.size()));
                ObjItem copia;

                if (o instanceof Item) {
                        copia = new Item(
                                        ((Item) o).nombre,
                                        ((Item) o).nivel,
                                        ((Item) o).peso,
                                        ((Item) o).descripcion,
                                        ((Item) o).proposito,
                                        ((Item) o).cantidadTurnos);

                } else {
                        copia = new Arma(
                                        ((Arma) o).nombre,
                                        ((Arma) o).nivel,
                                        ((Arma) o).dañoMin,
                                        ((Arma) o).dañoMax,
                                        ((Arma) o).peso,
                                        ((Arma) o).durabilidad,
                                        ((Arma) o).descripcion,
                                        ((Arma) o).tipoDaño,
                                        ((Arma) o).proposito,
                                        ((Arma) o).cantidadTurnos);
                }

                // copia.cantidad = 1;
                // Jugador.mochila.add(copia);
                return copia;
        }

        static {
                // === ARMAS ===
                añadirArma(new Arma("Cuchillo", 1, 3, 6, 1, 100, "Cuchillo de cocina afilado.", "corte",
                                new String[] { "arma", "recoleccion" }, 1));
                añadirArma(new Arma("Hacha", 3, 5, 10, 5, 120, "Hacha de supervivencia pesada.", "corte",
                                new String[] { "arma", "talar" }, 1));
                añadirArma(new Arma("Barra de metal", 2, 4, 8, 4, 150, "Barra sólida de metal oxidada.", "impacto",
                                new String[] { "arma" }, 1));
                añadirArma(new Arma("Arco y flecha", 3, 6, 12, 3, 80, "Arco de madera con cuerdas tensadas.",
                                "perforante",
                                new String[] { "arma", "caceria" }, 1));
                añadirArma(new Arma("Sarten", 1, 2, 5, 3, 200, "Sartén de hierro, ideal para golpear cabezas.",
                                "impacto",
                                new String[] { "arma", "cocina", "recipiente" }, 1));
                añadirArma(new Arma("Pistola 9mm y balas", 4, 8, 14, 2, 90, "Pistola semiautomática con munición.",
                                "perforante",
                                new String[] { "arma", "caceria" }, 1));
                añadirArma(new Arma("Llave de tuercas", 1, 3, 7, 3, 130, "Herramienta de metal resistente.", "impacto",
                                new String[] { "arma", "desguace" }, 1));
                añadirArma(new Arma("Nada", 1, 0, 0, 0, 0, "No tenés un arma equipada.", "ninguno",
                                new String[] { "nada" }, 1));
                añadirArma(new Arma("Bisturi", 1, 2, 4, 1, 50, "Instrumento quirúrgico muy filoso.", "corte",
                                new String[] { "arma", "recoleccion", "curar", "reparacion" }, 1));
                añadirArma(new Arma("Destornillador", 1, 2, 5, 1, 80, "Destornillador común, útil y mortal.",
                                "perforante",
                                new String[] { "arma", "desguace", "reparacion" }, 1));

                // === ITEMS ===
                añadirItem(new Item("Vendaje", 1, 1, "Sirve para detener hemorragias leves.",
                                new String[] { "curar" }, 1));
                añadirItem(new Item("Carne cruda", 0, 2, "Carne sin cocinar, puede enfermarte.",
                                new String[] { "alimentacion" }, 3));
                añadirItem(new Item("Botella de agua", 1, 1, "Agua limpia para hidratarte.",
                                new String[] { "hidratacion", "recipiente" }, 0));
                añadirItem(new Item("Chatarra", 1, 3, "Restos metálicos, útiles para reparar cosas.",
                                new String[] { "reparacion", "creacion" }, 0));
                añadirItem(new Item("Electronicos", 1, 2, "Piezas electrónicas para fabricar o reparar.",
                                new String[] { "reparacion", "creacion" }, 0));
                añadirItem(new Item("Fosforos", 1, 1, "Caja con fósforos secos.",
                                new String[] { "encender", "cocinar", "iluminar" }, 1));
                añadirItem(new Item("Linterna", 1, 2, "Linterna de mano para iluminar.",
                                new String[] { "iluminar" }, 0));
                añadirItem(new Item("Sobre de dormir", 2, 3, "Permite descansar y recuperar energía.",
                                new String[] { "descansar", "abrigar" }, 2));
                añadirItem(new Item("Fuegos artificiales", 1, 2, "Sirven para distraer enemigos o iluminar.",
                                new String[] { "distraer" }, 1));
                añadirItem(new Item("Antibioticos", 1, 1, "Curan infecciones o enfermedades leves.",
                                new String[] { "antibiotico" }, 0));
                añadirItem(new Item("Garzua", 1, 1, "Herramienta para forzar cerraduras.",
                                new String[] { "abrir" }, 3));
                añadirItem(new Item("madera", 1, 2, "Sirve para reparar y construir",
                                new String[] { "reparacion", "creacion" }, 0));
                añadirItem(new Item("carne enlatada", 1, 2, "Alimento no muy sabroso pero quita el hambre",
                                new String[] { "alimentacion", "recipiente" }, 2));
                añadirItem(new Item("agua sucia", 0, 2, "Alimento no muy sabroso pero quita el hambre",
                                new String[] { "hidratacion", "recipiente" }, 2));
                añadirItem(new Item("Traje antiradiacion", 2, 2, "traje contra radiacion.",
                                new String[] { "equipo", "radiacion" }, 1));
                añadirItem(new Item("pildoras antiradiacion", 1, 0, "pildoras para curar la radiacion",
                                new String[] { "radiacion" }, 0));

        }

}
