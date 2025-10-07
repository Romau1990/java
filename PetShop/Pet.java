package PetShop;
import java.util.ArrayList;


public class Pet{
    public Pet(String name, int age, String gender, String specie, String status){
        this.name = name; 
        this.age = age; 
        this.gender = gender; 
        this.specie = specie; 
        this.status = status; 
    }

    private String name; 
    private int age; 
    private String gender; 
    private String specie; 
    private String status; 

    public String petName(){
        return name;
    }
    public int petAge(){
        return age; 
    }
    public String petGender(){
        return gender;
    }
    public String petSpecie(){
        return specie;
    }
    public String petStatus(){
        return status;
    }
}
