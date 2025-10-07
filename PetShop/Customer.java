package PetShop;
import java.util.ArrayList;
  
public class Customer{
    public Customer(String name, String surname, int tel, String address){
        this.name = name; 
        this.surname = surname; 
        this.tel = tel; 
        this.address = address; 
        id = nextId; 
        nextId++;
    }

    private ArrayList<Pet> petList = new ArrayList<>();
    private String name; 
    public String surname;
    private int tel; 
    private String address; 
    private int id;
    private static int nextId = 0;

    public void addPet(Pet ...pet){
        for(Pet p: pet){
            petList.add(p);
        }
    }

    public int petNumber(){
        return petList.size();
    }

    public void petList(){
        for(Pet pt: petList){
            System.out.println("Pet name:" + pt.petName());
            System.out.println("Pet age: " + pt.petAge());
            System.out.println("Pet gender: " + pt.petGender() );
            System.out.println("Pet specie: " + pt.petSpecie() );
            System.out.println("Pet status: " + pt.petStatus());
            System.out.println("------------------------------");
        }
    }
 
    public String name(){
        return name;
    }
    public String surname(){
        return surname; 
    }
    public int tel(){
        return tel; 
    }
    public String address(){
        return address;
    }
    public int id(){
        return id;
    }


}