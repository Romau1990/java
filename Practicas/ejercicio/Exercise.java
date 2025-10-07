package ejercicio;
import javax.swing.*;
import java.util.*;


public class Exercise {
    public static void main(String[] args) {
        


        // if(n == 12){
        //     System.out.println("me acabas de pasar el valor" + n);
        //     JOptionPane.showMessageDialog(null, "el número es: "+  n);
        // }
        // else if(n < 12){
        //     JOptionPane.showMessageDialog(null, "El valor que me acabas de pasar es menor a 12");
        // }
        // else{
        //     JOptionPane.showMessageDialog(null,"Me acabas de pasar un valor mayor a 12" );
        // }
        
    

       

        // int bankAccount = 5000; 

        // while(true){
        //     JOptionPane.showMessageDialog(null, "hola. Bienvenido al juego");
        //     int play = JOptionPane.showConfirmDialog(null, "quieres comenzar a jugar?");
            

        //     if(play == 0){
        //         int val = (int)(Math.random() * 10);
        //         int playerChoice = Integer.parseInt(JOptionPane.showInputDialog(null, "Elige un número del 1 al 10"));
        //         if(playerChoice == val){
        //             JOptionPane.showMessageDialog(null, "Felicidades has acertado");
        //         }
                
        //     }
        //     else{
        //         break; 
        //     }
        // }



        String [][] questions = {
            {"Que animal no es un mamifero?","omnitorrinco", "Koala", "Muercielago","2"},
            {"¿Cuál de estos animales no es un mamífero?", "Cocodrilo", "Delfín", "Murciélago", "1"},
            {"¿Cuál de estos planetas no pertenece al sistema solar?", "Vulcano", "Marte", "Júpiter","1"},
            {"¿Cuál de estos no es un lenguaje de programación?","Java", "Python","Photoshop", "3"},
            {"¿Cuál de estas ciudades no está en Europa?", "París", "Madrid", "Tokio","3"},
            {"¿Cuál de estos no es un instrumento musical de cuerda?",  "Guitarra", "Batería", "Violín","2"},
            {"¿Cuál de estos colores no está en la bandera de Francia?", "Azul", "Verde", "Rojo", "2"},
            {"¿Cuál de estos animales pone huevos?", "Gallina", "Perro", "Gato", "2"},
            {"¿Cuál de estos no es un océano?", "Amazonas", "Atlántico", "Pacífico", "1"},
            {"¿Cuál de estos países no limita con Argentina?", "Chile","México", "Uruguay", "2"},
            {"¿Cuál de estas bebidas no contiene alcohol?", "Agua", "Vino", "Cerveza","1"}
        };


        




        while(true){
            int decision = JOptionPane.showConfirmDialog(null,"Quieres jugar este quizz?");
            if(decision == 0){
                JOptionPane.showMessageDialog(null,"Muy bien, dejame planificar las preguntas...");


                for(int i = 0; i < 4; i++){
                    try{
                        Thread.sleep(1500); 
                        System.out.println("creando preguntas...");
                    }
                    catch(InterruptedException e){
                        e.printStackTrace();
                    }
                }

                JOptionPane.showMessageDialog(null, "Todo listo, aquí vamos");
                Scanner scan = new Scanner(System.in);
                    
                for(int i = 0; i<questions.length; i++){
                    int randomIndex= (int)(Math.random() * questions.length);
                    String question = questions[randomIndex][0];
                    String rightAnswer = questions[randomIndex][questions[randomIndex].length - 1];


                    System.out.println(question + " choose the number 1 2 or 3");
                    System.out.println("1- " + questions[randomIndex][1] + " 2- " + questions[randomIndex][2] + " 3- " + questions[randomIndex][3]);

                    String chosenAnswer = scan.nextLine();
                    if(chosenAnswer.equals(rightAnswer)){
                        JOptionPane.showMessageDialog(null, "Correcto");
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "mal");
                    }
                }
            }
            else{
                JOptionPane.showMessageDialog(null,"Te esperamos cuando quieras...Cobarde");
                break;
            }
        }



        // Contar vocales
        // Pide al usuario que ingrese una palabra y muestra cuántas vocales tiene. Usa un bucle y charAt().


        












    }
}