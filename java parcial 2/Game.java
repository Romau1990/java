import java.util.*;
import javax.swing.*;

public class Game {
  public static void main(String[] args) {

    // variables necesarias para el juego
    int saldo = 1000;
    int eleccionUsuario;
    int montoApuesta;
    int posicionPelotita = (int) Math.ceil(Math.random() * 3);

    // Juego
    do {
      int ready = JOptionPane.showConfirmDialog(null, "Listo para comenza el juego?");

      if (ready == 0) {
        Scanner apuesta = new Scanner(System.in);
        System.out.println("Cuanto quieres apostar?");
        montoApuesta = apuesta.nextInt();
        if (montoApuesta <= saldo) {
          if (montoApuesta >= 50) {
            System.out.println("En  que baso esta la pelotita? Indica eligiendo un numero del 1 al 3");
            System.out.println("[x] [x] [x]");
            Scanner eleccion = new Scanner(System.in);
            eleccionUsuario = eleccion.nextInt();
            switch (posicionPelotita) {
              case 1:
                System.out.println("[o] [x] [x]");
                break;

              case 2:
                System.out.println("[x] [o] [x]");
                break;

              case 3:
                System.out.println("[x] [x] [o]");
                break;
            }
            if (eleccionUsuario == posicionPelotita) {
              System.out
                  .println("Felicidades has ganado la partida. La pelotita estaba en la posicion " + posicionPelotita);
            } else {
              saldo -= montoApuesta;
              System.out.println("Lo siento has fallado. Tu saldo actual es de " + saldo);
            }
          }
          else{
            System.out.println("El monto minimo para apostar es de 50");
          }

        } else {
          System.out.println("No tienes suficiente dinero para apostar ese monto");
        }
      } else {
        JOptionPane.showMessageDialog(null, "Sos  un cobarde.");
        break;
      }
    } // fin del do
    while (saldo > 0);

    // la persona ya no tiene más dinero en su saldo
    if (saldo <= 0) {
      System.out.println("Lo sentimos ludopata, ya no podes seguir apostando porque sos pobre.");
    }

  }
}