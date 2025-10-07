package PetShop;
import java.util.*;

public class PetMain{
    public static void main(String[] args) {

        Pet pet1  = new Pet("Manchita", 12, "Female", "Dog", "Healthy");
        Pet pet2 = new Pet("Nube", 6, "Female", "Dog", "healthy");

        Customer customer1 = new Customer("Rodrigo", "Alvarez", 26456456, "Luis alberto de herrera 3216");

        customer1.addPet(pet1, pet2);


        Customer customer2 = new Customer("Mariana", "Martinez", 78645645, "Luis alberto de herrera 3217");
        Customer customer3 = new Customer("Jessica", "Alvez", 56532465, "Luis alberto de herrera 3218");
        Customer customer4 = new Customer("Jose", "Gonzalez", 156456435, "Luis alberto de herrera 3219");
        PetShop petShop = new PetShop();
        petShop.addCustomers(customer1,customer2,customer3,customer4);
        petShop.showData(customer1);
        petShop.showList();
        petShop.checkLength();
    }
}