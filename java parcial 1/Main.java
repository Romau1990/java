import java.util.*;
import javax.swing.*;


public class Main {
    public static void main(String[] args) {
        

        int saldo = 1000;
        int montoApuesta;
        int eleccionUsuario; 
        int posicionPelotita = (int)(Math.random() *4);

        //1-NO 0-SI
        int listo = JOptionPane.showConfirmDialog(null, "Listo para comenzar a jugar?");
        

        if(listo == 0){
            
            Scanner scan = new Scanner(System.in);
            System.out.println("Elige un numero del 1 al 3");
            eleccionUsuario = scan.nextInt();
            System.out.println("Cuanto dinero quieres apostar?");
            montoApuesta = scan.nextInt();
            int confirm = JOptionPane.showConfirmDialog(null, "Estas seguro de que queres apostar " + montoApuesta + "?");
            while(true){
                if(confirm == 0){
                    if(montoApuesta > saldo){
                        System.out.println("No tienes dinero suficiente para apostar");
                        break;
                    }
                    else{
                        System.out.println("Ahora tu saldo es de " + saldo); 
                        System.out.println("La posicion de la pelotita era: " + posicionPelotita);
                        if(eleccionUsuario == posicionPelotita){
                            System.out.println("Acertaste!");
                        }
                        else{
                            System.out.println("Fallaste. Lo sentimos mucho");
                            saldo -= montoApuesta;
                            System.out.println("Ahora tu saldo es de: " + saldo);
                        }
                        break;    
                    }
                }
                else{
                    System.out.println("Cuanto dinero quieres apostar?");
                    montoApuesta = scan.nextInt();
                    confirm = JOptionPane.showConfirmDialog(null, "Estas seguro de que queres apostar " + montoApuesta + "?");
                }
            }
            
        }
        else{
            JOptionPane.showMessageDialog(null, "Cagon");
        }
    }
}
