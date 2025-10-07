package herencias;
import java.util.*;
import javax.swing.*;

public class Motorbike extends Vehiculos{
    public Motorbike(int space, String color, String brand, String fuel, int loadCapacity, String purpose){
        super(space, color, brand, fuel, loadCapacity, purpose);
    }

    Boolean convertible = false; 
    Boolean hasWindows = false; 
    int wheels = 2; 
    int headlights = 1;

    public void isConvertible(){
        System.out.println(convertible);
    }
    public void hasWindows(){
        System.out.println(hasWindows);
    }
    public void getWheels(){
        System.out.println("The motorbike has " + wheels + " wheels obviously");
    }
    public void getHeadlights(){
        System.out.println("The motorbike only has " + headlights + " headlight");
    }
}
