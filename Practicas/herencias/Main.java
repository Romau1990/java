package herencias;
import java.util.*;
import javax.swing.*;

public class Main{
    public static void main(String[] args) {
        
        Car miniCooper = new Car(4,"red","Minicooper","gas",250,"daily use", true);


        // miniCooper.isConvertible();

        // miniCooper.getColor();

        // miniCooper.getBrand();
        Motorbike Harley = new Motorbike(2, "black", "Harley Davidson", "gas", 200, "roadlife");
        Harley.getColor();
        Harley.changeColor("blue");
        Harley.getColor();
    }
}