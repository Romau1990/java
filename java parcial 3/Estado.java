public class Estado {
    // cada uno de estos se aplica en base a cuantos puntos le queda al jugador.
    static int infectionCount = 0;

    // ----------------------------------------------------------------------------------------
    static public void infeccion() {
        int chancesInfeccion = (int) (Math.random() * 10);

        if (chancesInfeccion > 6 && !Jugador.estado.equalsIgnoreCase("infectado")) {
            System.out.println(Juego.ROJO + "Te has infectado");
            Jugador.estado = "Infectado";
            Estado.fiebre();
            System.out.println(Juego.ROJO + "-5 de vida por infeccion");
            Jugador.vida -= 5;
            Estado.infectionCount++;
        } else if (Jugador.estado.equalsIgnoreCase("Infectado")) {
            System.out.println(Juego.ROJO + "-5 de vida por infeccion");
            Jugador.vida -= 5;
            Estado.infectionCount++;
            System.out.println(Juego.BLANCO);
        }

        if (infectionCount == 15) {
            System.out.println(Juego.ROJO + "GAME OVER: La infeccion te ha carcomido.");
            Jugador.vida = 0;
            System.exit(0);
        }
    }
    // ----------------------------------------------------------------------------------------

    static public void hipotermia() {
        if (Jugador.temperatura < 35 && Jugador.hipotermia == false) {
            System.out.println(Juego.ROJO + "tienes hipotermia. Busca refugio o enciende una fogata y permanece allí");
            Jugador.hipotermia = true;
            Jugador.destreza -= 1;
        } else if (Jugador.hipotermia == true) {
            Estado.fiebre();
            Jugador.estado = "enfermo";
            System.out.println(Juego.ROJO + "-5 de vida por hipotermia");
            Jugador.vida -= 5;
            System.out.println(Juego.BLANCO);
        }
    }

    // ----------------------------------------------------------------------------------------

    static public void insolacion() {
        if (Jugador.temperatura > 40 && Jugador.insolacion == false) {
            System.out.println(Juego.ROJO + "tienes insolacion. Busca refugio o toma liquidos para resistir");
            Jugador.insolacion = true;
            Jugador.voluntad -= 1;
        } else if (Jugador.insolacion == true) {
            Estado.fiebre();
            Jugador.estado = "enfermo";
            System.out.println(Juego.ROJO + "-5 de vida por insolacion");
            Jugador.vida -= 5;
            Jugador.hidratacion -= 5;
            System.out.println(Juego.BLANCO);
        }
    }

    // ----------------------------------------------------------------------------------------

    static public void deshidratacion() {
        if (Jugador.hidratacion < 40 && Jugador.hidratacion >= 20) {
            Jugador.estado = "sediento";
            System.out.println(Juego.BLANCO + "Estas ligeramente sediento, intenta tomar liquidos");
        } else if (Jugador.hidratacion < 20 && Jugador.deshidratacion == false) {
            Jugador.estado = "muy sediento";
            System.out.println(
                    Juego.AMARILLO + "Tienes mucha sed y estas deshidratado. Considera tomar liquidos urgentemente");
            Jugador.deshidratacion = true;
            Jugador.destreza -= 3;
            Jugador.resistencia -= 3;
        } else if (Jugador.hidratacion <= 0 && Jugador.deshidratacion == true) {
            Jugador.hidratacion = 0;
            Jugador.estado = "muriendo de sed";
            System.out.println(Juego.ROJO + "-10 de vida porque estas muriendo de sed");
            Jugador.vida -= 10;
            System.out.println(Juego.BLANCO);
        }
    }

    // ----------------------------------------------------------------------------------------

    static public void inanicion() {
        if (Jugador.nutricion < 40 && Jugador.nutricion >= 20) {
            Jugador.estado = "hambriento";
            System.out.println(Juego.BLANCO + "Estas ligeramente hambriento, intenta comer algo");
        } else if (Jugador.nutricion < 20 && Jugador.inanicion == false) {
            Jugador.estado = "muy hambriento";
            System.out.println(Juego.AMARILLO
                    + "Tienes mucha hambre y tienes sintomas de inanicion. Considera comer urgentemente");
            Jugador.inanicion = true;
            Jugador.destreza -= 3;
            Jugador.resistencia -= 3;
        } else if (Jugador.nutricion <= 0 && Jugador.inanicion == true) {
            Jugador.estado = "famelico";
            Jugador.nutricion = 0;
            System.out.println(Juego.ROJO + "-10 de vida porque estas muriendo de hambre");
            Jugador.vida -= 10;
            System.out.println(Juego.BLANCO);
        }
    }

    // ----------------------------------------------------------------------------------------

    static public void fiebre() {
        int chances = (int) (Math.random() * 10);
        if (chances > 7 && Jugador.fiebre == false) {
            Jugador.fiebre = true;
        } else if (Jugador.fiebre == true) {
            System.out.println(Juego.ROJO + "Tienes fiebre. Te sientes cansado");
            Jugador.voluntad -= 3;
            System.out.println(Juego.BLANCO);
        }
    }

    // ----------------------------------------------------------------------------------------

    static public void quemadura() {
        int chances = (int) (Math.random() * 10);
        if (chances > 7 && Jugador.quemaduras == false) {
            Jugador.quemaduras = true;
            Jugador.estado = "quemado";
            Jugador.contadorQuemadura++;
            System.out.println(Juego.ROJO
                    + "Tu piel esta quemada. Ten cuidado o podría ser peor. Usa protector solar, aloe vera o busca refugio del sol");
            Jugador.voluntad -= 3;
            System.out.println(Juego.BLANCO);
            int chancesFiebre = (int) (Math.random() * 10);
            if (Jugador.fiebre == false && chancesFiebre >= 7) {
                Jugador.fiebre = true;
            }

            if (Jugador.contadorQuemadura == 3) {
                Jugador.insolacion = true;
                Jugador.fiebre = true;
            }
        }
    }

    // ----------------------------------------------------------------------------------------

    static public void radiacion() {
        if (Jugador.radiacion == false) {
            Jugador.radiacion = true;
            Jugador.estado = "irradiado";
            System.out.println(Juego.ROJO + "Te encuentras irradiado, busca pildoras contra la radiacion urgentemente");
        } else if (Jugador.radiacion == true) {
            System.out.println(Juego.ROJO + "-5 de vida por radiacion");
            Jugador.vida -= 10;
            System.out.println(Juego.BLANCO);
        }
    }

    // ----------------------------------------------------------------------------------------

    static public void cansancio() {
        if (Jugador.energia < 40 && Jugador.cansancio == false) {
            Jugador.cansancio = true;
            System.out.println(
                    "Te encuentras algo cansado, intenta descansar. Puedes buscar un refugio, usar un saco de dormir o intentar dormir al aire libre");
            Jugador.destreza -= 1;
        }
    }

    // ----------------------------------------------------------------------------------------

    // static public void intoxicacion() {
    // if (Jugador.energia < 40 && Jugador.cansancio == false) {

    // }
    // }

}
