package PetShop; 
import java.util.*;


public class PetShop{
    
    public PetShop(){
        
    }
    private ArrayList<Customer> customerList = new ArrayList<>();

    public void addCustomer(Customer customer){
        customerList.add(customer);
    }

    public void addCustomers(Customer ...customer){
        for(Customer ct: customer){
            customerList.add(ct);
        }
    }

    public void checkLength(){
        System.out.println(customerList.size());
    }

    public void showList(){
        for(Customer ct: customerList){

            if(ct.petNumber() == 0){
                System.out.println(ct.name() + " No tiene mascota registrada");
                customerList.remove(ct);
            }
            else{
                System.out.println("-------CUSTOMER INFO-------");
                System.out.println("Name: " + ct.name());
                System.out.println("Surname: " + ct.surname());
                System.out.println("Tel: " + ct.tel());
                System.out.println("Address: " + ct.address());
                System.out.println("ID: " + ct.id());
            }
            
        }
    }

    public void showCustomerPet(Customer customer){
        System.out.println("------OWNER: " + customer.name() + "--------");
        System.out.println("------NUMBER OF PETS: " + customer.petNumber()+ "---------");

        customer.petList();
    }

    public void showData(Customer customer){
        
    }

}
ArrayList<String> listaFrutas = new ArrayList<>(List.of("Banana", "Manzana", "Pera", "Anana", "Naranja"));


Iterator<String> it = listaFrutas.next();
while(it.hasNext()){
    if(it.next().startsWith("M")){
        it.remove();
    }
}