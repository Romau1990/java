import java.util.*;

public class Encuentro {
    static ArrayList<Enemigo> listaEnemigos = new ArrayList<>();
    static Enemigo enemigo = null;
    static String area = null;
    static Scanner scan; 
    static {
        scan = new Scanner(System.in);
        Encuentro.addEnemigo(new Enemigo("Mutaracha", 5, new int[] { 1, 3 }, new String[] { "picar" }, new String[] { "nada" }, 1, 5,new String[] { "bosque", "campo", "colina", "casa", "playa" }, "insecto"));
        Encuentro.addEnemigo(new Enemigo("rata rabiosa", 5, new int[] { 1, 5 }, new String[] { "morder" }, new String[] { "nada" },1, 5, new String[] { "bosque", "campo", "colina", "casa", "playa" }, "animal mutado"));
        Encuentro.addEnemigo(new Enemigo("deformidad pululante", 10, new int[] { 3, 6 }, new String[] { "triturar" },new String[] { "nada" }, 1, 5, new String[] { "caverna", "colina", "planta nuclear" }, "deformidad"));
        Encuentro.addEnemigo(new Enemigo("chupoptero", 5, new int[] { 1, 3 }, new String[] { "picar" }, new String[] { "nada" }, 1,5, new String[] { "bosque", "campo", "colina", "casa", "playa" }, "insecto"));
        Encuentro.addEnemigo(new Enemigo("engendro irradiado", 6, new int[] { 2, 4 }, new String[] { "triturar" },new String[] { "nada" }, 1, 5, new String[] { "planta nuclear", "hospital", "sitio en construccion" },"deformidad"));
        Encuentro.addEnemigo(new Enemigo("lobo salvaje", 8, new int[] { 3, 5 }, new String[] { "morder" },new String[] { "nada" }, 1, 5, new String[] { "bosque", "campo", "colina" }, "animal mutado"));
        Encuentro.addEnemigo(new Enemigo("perro deforme", 6, new int[] { 3, 5 }, new String[] { "morder" }, new String[] { "nada" },1, 5, new String[] { "bosque", "campo", "colina", "casa", "playa" }, "animal mutado"));
        Encuentro.addEnemigo(new Enemigo("goliat amorfo", 18, new int[] { 8, 10 }, new String[] { "triturar" },new String[] { "nada" }, 1, 5,new String[] { "planta nuclear", "sitio en construccion", "hospital", "caverna" }, "deformidad"));
        Encuentro.addEnemigo(new Enemigo("monstruosidad", 30, new int[] { 20, 35 }, new String[] { "ejecutar" },new String[] { "nada" }, 1, 5, new String[] { "bosque", "campo", "colina", "casa", "playa" },"deformidad"));
        Encuentro.addEnemigo(new Enemigo("devorador", 15, new int[] { 8, 14 },new String[] { "embestir", "triturar", "morder", "arañar" }, new String[] { "nada" }, 1, 5,new String[] { "bosque", "campo", "colina", "casa", "playa" }, "deformidad"));

        Encuentro.addEnemigo(new Enemigo("bandido", 10, new int[] { 4, 8 }, new String[] { "melee" },new String[] { "nada" }, 1, 5, new String[] { "casa", "campo", "ciudad", "sitio en construccion","colina", "playa", "bosque", "caravana" },"humano"));
        Encuentro.addEnemigo(new Enemigo("soldado", 15, new int[] { 12, 16 }, new String[] { "arma", "melee" },new String[] { "nada" }, 1, 5, new String[] { "casa", "campo", "ciudad", "sitio en construccion","colina", "playa", "bosque", "caravana" },"humano"));
        Encuentro.addEnemigo(new Enemigo("canibal", 8, new int[] { 5, 8 }, new String[] { "melee" },new String[] { "nada" }, 1, 5, new String[] { "casa", "campo", "ciudad","sitio en construccion", "colina", "playa", "bosque", "caravana", "caverna" },"humano"));
        Encuentro.addEnemigo(new Enemigo("humano irradiado", 6, new int[] { 4, 7 }, new String[] { "morder", "arañar" },new String[] { "nada" }, 1, 5, new String[] { "casa", "campo", "ciudad","sitio en construccion", "colina", "playa", "bosque", "caravana" },"animal mutado"));

    }

    static public void addEnemigo(Enemigo enemigo) {
        listaEnemigos.add(enemigo);
    }

    static public void elegirEnemigo() {

        // capturamos el enemigo a enfrentar
        Enemigo hostil = null;

        // nos aseguramos que los enemigos correspondan al area donde se encuentra el// jugador
        Encuentro.area = Jugador.areaActual;

        // filtramos los enemigos potenciales que cumplan dicha condicion
        List<Enemigo> enemigosFiltrados = listaEnemigos.stream()
                .filter(enemigo -> Arrays.asList(enemigo.getHabitat()).contains(Encuentro.area)).toList();

        // establecemos un limite de busqueda entre los enemigos posibles
        int randomIndex = (int) (Math.random() * enemigosFiltrados.size());

        for (int i = 0; i < enemigosFiltrados.size(); i++) {
            hostil = enemigosFiltrados.get(randomIndex);
        }
        // guardamos el enemigo
        Encuentro.enemigo = hostil;

    }

    static public void Combate(){

        Encuentro.elegirEnemigo();
        System.out.println("Te has topado con un: " + Encuentro.enemigo);
        System.out.println("Que piensas hacer?");
        System.out.println("1-> atacar");
        System.out.println("2-> esconderte");
        System.out.println("3-> huir");
        System.out.println("4-> distraer");
        String accionTomada = scan.nextLine();


        switch(accionTomada){
            case "1":
            // metodo atacar
            break;

            case "2":
            // metodo esconderse
            break;

            case "3": 
            // metodo huir
            break; 

            case "4": 
            // metodo distraer
            break;

        }
    }

}
