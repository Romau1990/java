public class Estado {
    //cada uno de estos se aplica en base a cuantos puntos le queda al jugador.
    static int infectionCount = 0;
    static int hipotermiaCount = 0;
    static int insolacionCount = 0;
    static int deshidratacionCount = 0;
    static int inanicionCount = 0;

    static public void infeccion() {
        int chancesInfeccion = (int) (Math.random() * 10);

        if (chancesInfeccion > 6 && !Jugador.estado.equalsIgnoreCase("infectado")) {
            System.out.println(Juego.ROJO + "Te has infectado");
            Jugador.estado = "Infectado";
            System.out.println(Juego.ROJO + "-5 de vida por infeccion");
            Jugador.vida -= 5;
            Estado.infectionCount++;
        }
        else if (Jugador.estado.equalsIgnoreCase("Infectado")) {
            System.out.println(Juego.ROJO + "-5 de vida por infeccion");
            Jugador.vida -= 5;
            Estado.infectionCount++;
        }

        if (infectionCount == 15) {
            System.out.println(Juego.ROJO + "GAME OVER: La infeccion te ha carcomido.");
            Jugador.vida = 0;
            System.exit(0);
        }
    }

    static public void hipotermia() {
        if(Jugador.temperatura < 35){
            Jugador.hipotermia = true;
        }

    }

    static public void insolacion() {
        int chancesInfeccion = (int) (Math.random() * 10);

        if (chancesInfeccion > 1 && !Jugador.estado.equalsIgnoreCase("infectado")) {
            System.out.println(Juego.ROJO + "Te has infectado");
            Jugador.estado = "Infectado";
            System.out.println(Juego.ROJO + "-5 de vida por infeccion");
            Jugador.vida -= 5;
            Estado.infectionCount++;
        }
        else if (Jugador.estado.equalsIgnoreCase("Infectado")) {
            System.out.println(Juego.ROJO + "-5 de vida por infeccion");
            Jugador.vida -= 5;
            Estado.infectionCount++;
        }

        if (infectionCount == 15) {
            System.out.println(Juego.ROJO + "GAME OVER: La infeccion te ha carcomido.");
            Jugador.vida = 0;
            System.exit(0);
        }
    }

    static public void deshidratacion() {
        int chancesInfeccion = (int) (Math.random() * 10);

        if (chancesInfeccion > 1 && !Jugador.estado.equalsIgnoreCase("infectado")) {
            System.out.println(Juego.ROJO + "Te has infectado");
            Jugador.estado = "Infectado";
            System.out.println(Juego.ROJO + "-5 de vida por infeccion");
            Jugador.vida -= 5;
            Estado.infectionCount++;
        }
        else if (Jugador.estado.equalsIgnoreCase("Infectado")) {
            System.out.println(Juego.ROJO + "-5 de vida por infeccion");
            Jugador.vida -= 5;
            Estado.infectionCount++;
        }

        if (infectionCount == 15) {
            System.out.println(Juego.ROJO + "GAME OVER: La infeccion te ha carcomido.");
            Jugador.vida = 0;
            System.exit(0);
        }
    }

    static public void inanicion() {
        int chancesInfeccion = (int) (Math.random() * 10);

        if (chancesInfeccion > 1 && !Jugador.estado.equalsIgnoreCase("infectado")) {
            System.out.println(Juego.ROJO + "Te has infectado");
            Jugador.estado = "Infectado";
            System.out.println(Juego.ROJO + "-5 de vida por infeccion");
            Jugador.vida -= 5;
            Estado.infectionCount++;
        }
        else if (Jugador.estado.equalsIgnoreCase("Infectado")) {
            System.out.println(Juego.ROJO + "-5 de vida por infeccion");
            Jugador.vida -= 5;
            Estado.infectionCount++;
        }

        if (infectionCount == 15) {
            System.out.println(Juego.ROJO + "GAME OVER: La infeccion te ha carcomido.");
            Jugador.vida = 0;
            System.exit(0);
        }
    }

    static public void fiebre() {
        int chancesInfeccion = (int) (Math.random() * 10);

        if (chancesInfeccion > 1 && !Jugador.estado.equalsIgnoreCase("infectado")) {
            System.out.println(Juego.ROJO + "Te has infectado");
            Jugador.estado = "Infectado";
            System.out.println(Juego.ROJO + "-5 de vida por infeccion");
            Jugador.vida -= 5;
            Estado.infectionCount++;
        }
        else if (Jugador.estado.equalsIgnoreCase("Infectado")) {
            System.out.println(Juego.ROJO + "-5 de vida por infeccion");
            Jugador.vida -= 5;
            Estado.infectionCount++;
        }

        if (infectionCount == 15) {
            System.out.println(Juego.ROJO + "GAME OVER: La infeccion te ha carcomido.");
            Jugador.vida = 0;
            System.exit(0);
        }
    }
}
