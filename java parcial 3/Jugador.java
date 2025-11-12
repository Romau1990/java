import java.util.*;

//Metodos y propiedades exclusivas del Jugador. 

public class Jugador {

    static ArrayList<ObjItem> mochila = new ArrayList<>();
    static String areaActual = "campamento";
    static String nombre;
    static int dinero = 10;
    static int turno = 0;
    static int nivel = 1;
    static int exp = 0; // experiencia se ganará en combate
    static int pesoTotalItems;
    static int pesoMaximo = 10;
    static int espacioDisponible = (pesoMaximo - pesoTotalItems);
    static int fuerza = 5; // permite cargar más en la mochila
    static int resistencia = 5; // permite huir y moverte mas veces en un mismo turno
    static int percepcion = 5; // permite enconrar más y mejor loot
    static int ingenio = 5; // permite craftear mejor, más rapido y usar menos recursos
    static int voluntad = 5; // permite resistir más en el combate, y pasar más tiempo sin comer, tomar agua
                             // o dormir.
    static int destreza = 5; // aumenta las chances de esquivar ataques a corta y larga distancia
    static int vida = 100;
    static int nutricion = 100;
    static int hidratacion = 100;
    static int energia = 100;
    static int temperatura = 36;
    static int contadorQuemadura = 0;
    static int exitoCrafteo = 50;
    static int exitoPunteria = 50;
    static int defensaGeneral = 5;
    static int defensaVestimenta = 0;
    static ObjItem[] equipo = new ObjItem[1];

    static Boolean radiacion = false;
    static Boolean inanicion = false;
    static Boolean deshidratacion = false;
    static Boolean cansancio = false;
    static Boolean hipotermia = false;
    static Boolean insolacion = false;
    static Boolean fiebre = false;
    static Boolean quemaduras = false;
    static String estado = "Sano";

    // Calcular la vida del jugador
    // ===========================================================================================

    static public void calcularVida() {
        if (Jugador.vida <= 0) {
            Jugador.vida = 0;
            System.out.println(Juego.ROJO + "Estas muerto has sobrevivido " + Jugador.turno + " turnos");
            System.exit(0);
        }
    }

    // static public void calcularPeso() {
    // if (Jugador.pesoTotalItems >= Jugador.pesoMaximo) {
    // System.out.println(Juego.ROJO + "No puedes cargar más peso. Descarta algo de
    // tu mochila usando el comando -> dejar");
    // }
    // }

    // Ganar experiencia
    // ===========================================================================================

    static public void ganarExp(int expGanada) {
        if (Jugador.exp >= 10) {
            Scanner scanner = new Scanner(System.in);
            System.out.println(Juego.VERDE + "Has subido de nivel. Tienes 1 punto disponible");
            System.out.println("Puedes elegir un atributo para mejorar. Escribe el nombre del atributo para mejorarlo");
            String atributo = scanner.nextLine().trim().toLowerCase();
            Jugador.vida += 10;

            switch (atributo) {
                case "fuerza":
                    Jugador.fuerza++;
                    Jugador.pesoMaximo += 2;
                    break;
                case "resistencia":
                    Jugador.resistencia++;
                    Jugador.energia += 5;
                    break;
                case "percepcion":
                    Jugador.percepcion++;
                    Jugador.exitoPunteria += 5;
                    break;
                case "ingenio":
                    Jugador.ingenio++;
                    Jugador.exitoCrafteo += 5;
                    break;
                case "voluntad":
                    Jugador.voluntad++;
                    Jugador.defensaGeneral += 2;
            }
            Jugador.exp = 0;
        } else {
            System.out.println("Has ganado " + expGanada + " de experiencia");
            Jugador.exp += expGanada;
        }
    }

    // Elegir atributo a mejorar
    // ===========================================================================================

    static public void mejorarAtributo() {
        System.out.println("------------ estado de" + Jugador.nombre + "------------");
        System.out.println("fuerza: " + Jugador.fuerza + " (+) - aumenta capacidad de carga");
        System.out.println("resistencia: " + Jugador.resistencia
                + " (+) - permite huir de combates con mayor efectividad y más energía");
        System.out.println("destreza: " + Jugador.destreza + " (+) - mejores chances de esquivar ataques");
        System.out.println("percepcion: " + Jugador.percepcion + " (+) - mejor y más loot");
        System.out.println("ingenio: " + Jugador.ingenio + " (+) - mejor crafteo");
        System.out.println("voluntad: " + Jugador.voluntad + " (+) - mayor resistencia al daño y efectos secundarios");
        System.out.println("----------------------------------------------------");
    }

    // Ver estado ✅
    // ===========================================================================================

    static public void verEstado() {
        System.out.println("------------ estado de" + Jugador.nombre + "------------");
        System.out.println("radiacion: " + Jugador.radiacion);
        System.out.println("inanicion: " + Jugador.inanicion);
        System.out.println("deshidratacion: " + Jugador.deshidratacion);
        System.out.println("cansancio: " + Jugador.cansancio);
        System.out.println("hipotermia: " + Jugador.hipotermia);
        System.out.println("insolacion: " + Jugador.insolacion);
        System.out.println("fiebre: " + Jugador.fiebre);
        System.out.println("fiebre: " + Jugador.quemaduras);
        System.out.println("----------------------------------------------------");
    }

    // Nombre del jugador ✅
    // ===========================================================================================

    static public void nombre(String playerName) {
        Jugador.nombre = playerName;
    }

    // ver los turnos de la partida
    // ===========================================================================================

    static public int getTurno() {
        return Jugador.turno;
    }

    // Incrementar turno ✅
    // ===========================================================================================

    static public int incrementarTurno(int turno) {
        if (Jugador.nutricion > 0) {
            Jugador.nutricion -= (5 * turno);
        }

        if (Jugador.hidratacion > 0) {
            Jugador.hidratacion -= (5 * turno);
        }

        if (Jugador.energia > 0) {
            Jugador.energia -= (5 * turno);
        }

        Estado.inanicion();
        Estado.deshidratacion();
        Estado.cansancio();

        if (Jugador.radiacion == true) {
            Estado.radiacion();
        }

        if (Jugador.fiebre == true) {
            Estado.fiebre();
        }

        if (Jugador.hipotermia == true) {
            Estado.hipotermia();
        }

        if (Jugador.insolacion == true) {
            Estado.insolacion();
        }

        if (Jugador.quemaduras == true) {
            Estado.quemadura();
        }

        return Jugador.turno += turno;
    }

    // Ver stats ✅
    // ===========================================================================================

    static public void verStats() {
        System.out.println("-------- " + Jugador.nombre + "stats " + " --------");
        System.out.println("-------- " + Jugador.dinero + "stats " + " --------");
        System.out.println("Turno: " + Jugador.turno);
        System.out.println(String.format(
                "nombre: %s \nnivel: %d \nfuerza: %d \nresistencia: %d \npersepcion: %d \ningenio: %d \nvoluntad: %d \ndestreza: %d \nvida: %d",
                Jugador.nombre, Jugador.nivel, Jugador.fuerza, Jugador.resistencia, Jugador.percepcion, Jugador.ingenio,
                Jugador.voluntad, Jugador.destreza, Jugador.vida));
    }

    // Estado actual ✅
    // ===========================================================================================

    static public void estadoActual() {
        System.out.println("------ " + "estado de " + Jugador.nombre + " ------");
        System.out.println(String.format(
                "vida: %d \nnutricion: %d \nhidratacion: %d \nenergia: %d \ntemperatura: %d \nestado: %s", Jugador.vida,
                Jugador.nutricion, Jugador.hidratacion, Jugador.energia, Jugador.temperatura, Jugador.estado));
    }

    // Ver mochila ✅
    // ===========================================================================================

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

    // Generar loot -> solo crea la lógica pero se ejecuta en lootear ✅
    // ===========================================================================================

    static void generarLoot() {

    }

    // lootear ✅
    // ===========================================================================================

    static void lootear() {

        // metodo de testeo
        int isLocked = (int) (Math.random() * 10);
        ObjItem lockPick = null;

        for (ObjItem item : Jugador.mochila) {
            if (Arrays.asList(item.getProposito()).contains("abrir")) {
                lockPick = item;
            }
        }

        if (isLocked > 7 && lockPick == null) {
            System.out.println("Esta cerrado con llave... necesito una garzúa");
            return;
        } else if (isLocked > 7 && lockPick != null) {
            var unlockAttempt = Math.random() * 10;
            if (unlockAttempt < 5) {
                System.out.println("la garzúa se ha roto");
                lockPick.cantidad--;
                return;
            } else {
                Jugador.generarLoot();
            }
        } else {
            Jugador.generarLoot();
        }

        ObjItem itemObtenido = ListadoItems.randomItem();
        double itemPeso = itemObtenido.getPeso();
        int ganaDinero = (int) (Math.random() * 10);

        int espacioDisponible = Jugador.pesoMaximo - Jugador.pesoTotalItems;

        if (Jugador.pesoTotalItems >= Jugador.pesoMaximo || itemPeso > espacioDisponible) {
            System.out.println(
                    Juego.ROJO + "No puedes cargar más peso. Descarta algo de tu mochila usando el comando -> dejar");

        } else {

            Area.areaSeleccionada(Jugador.areaActual);
            System.out.println(Juego.BLANCO + "Has obtenido:");
            Jugador.incrementarTurno(1);

            boolean yaLoTenia = false;

            if (itemObtenido instanceof Item) {

                for (ObjItem itemEnMochila : Jugador.mochila) {

                    if (itemEnMochila instanceof Item
                            && itemEnMochila.getNombre().equalsIgnoreCase(itemObtenido.getNombre())) {
                        itemEnMochila.cantidad++; // ...aumentamos la cantidad del item que YA teníamos
                        yaLoTenia = true;
                        break; // Salimos del bucle, ya terminamos
                    }
                }
            }

            if (yaLoTenia == false) {
                Jugador.mochila.add(itemObtenido);
            }

            Jugador.pesoTotalItems += itemPeso;

            if (yaLoTenia) {
                System.out.println(itemObtenido.getNombre() + " (x1)");
            } else {
                itemObtenido.basicInfo(); // Muestra la info completa si es la primera vez
            }
        }

        // Lógica del dinero (esto estaba bien)
        if (ganaDinero >= 8) {
            int cantidadDinero = (int) (Math.random() * 10);
            System.out.println(Juego.BLANCO + "Has conseguido " + "$" + cantidadDinero);
            Jugador.dinero += cantidadDinero;
        }

    }

    // Ver mapa ✅
    // ===========================================================================================

    static void verMapa() {
        Area.verAreas();
    }

    // Crear
    // ===========================================================================================

    static void crear() {
        System.out.println("acabas de crear un item");
    }

    // Viajar ✅
    // ===========================================================================================

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
                Jugador.areaActual = area;
                System.out.println(Juego.BLANCO + "Que harás ahora " + Jugador.nombre + "?");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

    static void recargar() {
    }

    // Dejar ✅ (detalle con algunos objetos que parecen no desaparecer ni disminuir
    // el peso del jugador)
    // ===========================================================================================

    static void dejar(String itemElegido) {

        Jugador.mochila.forEach(item -> {
            if (itemElegido.trim().equalsIgnoreCase(item.getNombre())) {
                item.cantidad--;
                Jugador.pesoTotalItems -= item.getPeso();
            } else if (Jugador.pesoTotalItems < 0) {
                Jugador.pesoTotalItems = 0;
            }
        });

        Jugador.mochila.removeIf(item -> {
            return item.cantidad == 0;
        });

    }

    // reducir peso
    // ==============================================================================
    static void calcularPeso(ObjItem item) {
        if (Jugador.pesoTotalItems < 0) {
            Jugador.pesoTotalItems = 0;
        }
        Jugador.pesoTotalItems -= item.getPeso();
    }

    // Descartar de la mochila
    // ==================================================================

    static void descartar() {
        Jugador.mochila.removeIf(i -> {
            return i.cantidad <= 0;

        });
    }

    // Curar ✅
    // ===========================================================================================

    static void curar() {
        Scanner choice = new Scanner(System.in);
        List<ObjItem> filtered = Jugador.mochila.stream()
                .filter(arr -> Arrays.asList(arr.getProposito()).contains("antibiotico") ||
                        Arrays.asList(arr.getProposito()).contains("curar"))
                .toList();

        if (filtered.isEmpty()) {
            System.out.println(Juego.ROJO + "No tienes items para curar en tu mochila");
            return;
        }

        System.out.println(Juego.BLANCO + "Cual item usaras?");

        filtered.forEach(item -> {
            System.out.println(item.nombre + " x" + item.cantidad + " " + item.descripcion);
        });

        String selectedItem = choice.nextLine();

        // filtered.forEach(item -> {
        // if (item.nombre.equalsIgnoreCase(selectedItem.trim())) {
        // System.out.println(Juego.VERDE + "has recuperado +10 de vida");
        // Jugador.incrementarTurno(item.cantidadTurnos);
        // Jugador.vida += 10;
        // item.cantidad--;
        // }
        // });

        Jugador.mochila.forEach(item -> {
            if (item.getNombre().equalsIgnoreCase(selectedItem.trim())
                    && Arrays.asList(item.getProposito()).contains("curar")) {
                System.out.println(Juego.VERDE + "has recuperado +10 de vida");
                Jugador.incrementarTurno(item.cantidadTurnos);
                Jugador.vida += 10;
                item.cantidad--;
                calcularPeso(item);
            }

            else if (item.getNombre().equalsIgnoreCase(selectedItem.trim())
                    && Arrays.asList(item.getProposito()).contains("antibiotico")
                    && Jugador.estado.equalsIgnoreCase("Infectado")) {
                System.out.println(Juego.VERDE + "Has curado la infeccion");
                Jugador.estado = "sano";
                item.cantidad--;
                calcularPeso(item);
            }

        });

        descartar();

    }

    // equipo en uso

    static public void equipoUsado() {
        System.out.println(Jugador.equipo[0].getNombre());
    }

    // Desinfectar ✅
    // ====================================================================================

    static public void desinfectar() {
        Scanner choice = new Scanner(System.in);
        List<ObjItem> filtered = Jugador.mochila.stream().filter(arr -> {
            return Arrays.asList(arr.getProposito()).contains("antibiotico");
        }).toList();

        if (filtered.isEmpty()) {
            System.out.println(Juego.ROJO + "No tienes items para curar en tu mochila");
            return;
        }

        System.out.println(Juego.BLANCO + "Cual item usaras?");

        filtered.forEach(item -> {
            System.out.println(item.nombre + " x" + item.cantidad + " " + item.descripcion);
        });

        String selectedItem = choice.nextLine();

        filtered.forEach(item -> {
            if (item.nombre.equalsIgnoreCase(selectedItem.trim()) && Jugador.estado == "infectado") {
                System.out.println(Juego.VERDE + "ya no estas infectado");
                Jugador.incrementarTurno(item.cantidadTurnos);
                Jugador.estado = "sano";
                item.cantidad--;
                calcularPeso(item);
            }
        });

        descartar();
    }

    // Esconderse
    // ===========================================================================================

    static void esconderse() {
        // for(ObjItem obj : Jugador.mochila){
        // System.out.println(obj.getDescription());
        // }
    }

    // Descansar ✅ (realizado por IA)
    // ===========================================================================================

    static void descansar() {
        Scanner scan = new Scanner(System.in);
        boolean enSuelo = false;
        ObjItem elegido = null;

        List<ObjItem> filtrado = Jugador.mochila.stream()
                .filter(item -> Arrays.asList(item.getProposito()).contains("descansar"))
                .toList();

        if (filtrado.isEmpty()) {
            System.out.println("No tienes dónde descansar. ¿Descansas en el suelo? (Y/N)");
            String resp = scan.nextLine();
            if (resp.equalsIgnoreCase("Y"))
                enSuelo = true;
        }

        if (!filtrado.isEmpty()) {
            filtrado.forEach(item -> System.out.println(item.getNombre() + " x" + item.cantidad));
            System.out.println("¿Con qué deseas descansar?");
            String choice = scan.nextLine();
            elegido = filtrado.stream()
                    .filter(item -> item.getNombre().equalsIgnoreCase(choice.trim()))
                    .findFirst()
                    .orElse(null);
        }

        if (enSuelo == false && elegido == null) {
            System.out.println("No elegiste una opción válida. No has descansado.");
            return;
        }

        System.out.println("¿Cuántas horas deseas descansar?");
        int hs = scan.nextInt();

        // int energiaObtenida = enSuelo ? hs * 5 : hs * (10 * (elegido != null ?
        // elegido.getNivel() : 1));
        int energiaObtenida = 0;

        if (enSuelo) {
            energiaObtenida = hs * 1;
        } else if (enSuelo == false && elegido != null) {
            energiaObtenida = hs * elegido.getNivel();
        }

        Jugador.energia = Math.min(100, Jugador.energia + (energiaObtenida * 10) + (hs * 5));
        Jugador.incrementarTurno(hs);

        System.out.println(Juego.VERDE + "Descansaste " + hs + " hs. Energía actual: " + Jugador.energia);
    }

    // Equiparse
    // ===========================================================================================

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

    // equipar ropa

    static public void vestir() {

        List<ObjItem> filtered = Jugador.mochila.stream()
                .filter(item -> Arrays.asList(item.getProposito()).contains("equipo"))
                .toList();

        if (!filtered.isEmpty()) {

            Scanner scan = new Scanner(System.in);

            System.out.println("Que equipamiento quieres usar?");
            filtered.forEach(item -> {
                System.out.println(item.getNombre() + " x" + item.cantidad);
            });
            String choice = scan.nextLine();

            if (choice == null) {
                System.out.println("No has elegido ningún item.");
                return;
            }

            filtered.forEach(item -> {
                if (item.getNombre().equalsIgnoreCase(choice)) {
                    Jugador.equipo[0] = item;
                } else {
                    System.out.println("No tienes tal item en tu inventario");
                }
            });

        } else {
            System.out.println("No tienes items para equipar");
        }

    }

    // Beber ✅
    // ===========================================================================================

    static void beber() {
        Scanner scan = new Scanner(System.in);
        List<ObjItem> filtrados = Jugador.mochila.stream()
                .filter(item -> Arrays.asList(item.getProposito()).contains("hidratacion")).toList();
        if (filtrados.isEmpty()) {
            System.out.println("No tienes items para usar");
            return;
        }

        System.out.println(Juego.BLANCO + "¿Qué quieres beber?");
        filtrados.forEach(item -> {
            System.out.println(item.getNombre() + " x" + item.cantidad);
        });
        String choice = scan.nextLine();

        filtrados.forEach(item -> {
            if (item.getNombre().trim().equalsIgnoreCase(choice)) {
                Jugador.hidratacion += (20 * item.getNivel());
                System.out.println(Juego.VERDE + "+" + (20 * item.getNivel()) + " de hidratación");
                item.cantidad--;
                calcularPeso(item);
            }
        });
        descartar();
    }

    // Comer ✅
    // ===========================================================================================

    static void comer() {
        Scanner scan = new Scanner(System.in);

        List<ObjItem> filtrado = Jugador.mochila.stream()
                .filter(item -> Arrays.asList(item.getProposito()).contains("alimentacion")).toList();
        if (filtrado.isEmpty()) {
            System.out.println("No tienes items para usar");
            return;
        }

        System.out.println("Que deseas comer?");
        filtrado.forEach(item -> {
            System.out.println(item.getNombre() + " x" + item.cantidad);
        });

        String choice = scan.nextLine();

        filtrado.forEach(item -> {
            if (item.getNombre().trim().equalsIgnoreCase(choice)) {
                Jugador.nutricion += (20 * item.getNivel());
                System.out.println(Juego.VERDE + "+" + (20 * item.getNivel()) + " de nutrición");
                item.cantidad--;
                calcularPeso(item);
            }
        });

        descartar();
    }

    // Cocinar
    // ===================================================================================

    static void cocinar() {
        Scanner scan = new Scanner(System.in);

        List<ObjItem> filtrado = Jugador.mochila.stream()
                .filter(item -> Arrays.asList(item.getProposito()).contains("alimentacion") && item.getNivel() == 0)
                .toList();
        System.out.println("Que quieres cocinar?");

        if (filtrado.isEmpty()) {
            System.out.println("No tienes items para cocinar");
        }

        filtrado.forEach(alimento -> {
            System.out.println(alimento.getNombre() + " x" + alimento.cantidad);
        });

        String choice = scan.nextLine();

        filtrado.forEach(alimento -> {
            if (alimento.getNombre().equalsIgnoreCase(choice.trim())) {
            }
            new Thread(() -> {
                try {
                    for (var i = 0; i < 3; i++) {
                        System.out.println("cocinando...");
                        Thread.sleep(1000);
                        alimento.nivel++;
                        alimento.changeName("carne cocida");
                        Jugador.incrementarTurno(2);
                        System.out.println("Listo");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();

        });

    }

    // Hervir
    // ===================================================================================

    static void hervir() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Que quieres hervir?");

        List<ObjItem> filtrado = Jugador.mochila.stream()
                .filter(item -> Arrays.asList(item.getProposito()).contains("hidratacion") && item.getNivel() == 0)
                .toList();

        if (filtrado.isEmpty()) {
            System.out.println("No tienes items para hervir");
        }

        filtrado.forEach(bebida -> {
            System.out.println(bebida.getNombre() + " x" + bebida.cantidad);
        });

        String choice = scan.nextLine();

        filtrado.forEach(bebida -> {
            if (bebida.getNombre().equalsIgnoreCase(choice.trim())) {

                new Thread(() -> {
                    try {
                        for (var i = 0; i < 3; i++) {
                            System.out.println("cocinando...");
                            Thread.sleep(1000);
                            bebida.nivel++;
                            bebida.changeName("agua purificada");
                            Jugador.incrementarTurno(2);
                            System.out.println("Listo");
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }).start();
            }
        });

    }

}
