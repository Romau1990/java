package herencias; 
import java.util.*;
import javax.swing.*;


public class Car extends Vehiculos{
    public Car(int space, String color, String brand, String fuel, int loadCapacity, String purpose, Boolean convertible){
        super(space, color, brand, fuel, loadCapacity, purpose);
        this.convertible = convertible; 
    }
    private Boolean convertible; 

    public void isConvertible(){
        System.out.println(convertible);

    }

}
