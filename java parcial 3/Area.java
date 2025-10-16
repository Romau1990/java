public class Area {
    static String area; 
    static int nivel; 
    public Area(String area, int nivel){
        Area.area = area; 
        Area.nivel = nivel; 

    }
    static void elegir(String area){
        area = area.toLowerCase();
        switch(area){
            case "basurero":
            Jugador.incrementarTurno(1);
            int chancesInfeccion = (int)(Math.random() *10);
            if(chancesInfeccion > 8){
                int infectionCount = 0;
                Jugador.estado = "Infectado";
                Jugador.vida -= 5;
                infectionCount++;
                if(infectionCount == 15){
                    System.out.println("GAME OVER: La infeccion te ha carcomido.");
                    System.exit(0);
                }
            }

        }


    }
}
