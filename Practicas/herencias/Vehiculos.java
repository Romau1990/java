package herencias;
import java.util.*;
import javax.swing.*;

public class Vehiculos {
    public Vehiculos(int space, String color, String brand, String fuel, int loadCapacity,String purpose){
        this.space = space; 
        this.color = color; 
        this.brand = brand; 
        this.fuel = fuel; 
        this.loadCapacity = loadCapacity; 
        this.purpose = purpose; 
    }
    private int space;
    private String color; 
    private String brand; 
    private String fuel; 
    private int loadCapacity; 
    private String purpose; 

    public void getSpace(){
        System.out.println("It has " + space + " seats");
    }
    public void getColor(){
        System.out.println("it's " + color);
    }
    public void getBrand(){
        System.out.println("It's a " + brand);
    }
    public void getFuel(){
        System.out.println("It runs on "+ fuel);
    }
    public void getLoadCapacity(){
        System.out.println("It loads up to " + loadCapacity + "kg");
    }
    public void getPurpose(){
        System.out.println("It's for " + purpose);
    }
    public void changeColor(String newColor){
        color = newColor;
    }
}
