import java.util.*;
import javax.swing.*;

class Main{


    public static void main(String[] args) {
        Info person = new Info();

        

        Info.saludar("Rodrigo");
        person.setName("Rodrigo");
        System.out.println(person.getName());
        person.myCi(12354);
        System.out.println(person.getCi());
    }
}

class Info{
    private String name; 
    private int ci;

    public Info(){ //metodo constructor
        this.name = null;
        this.ci = 0;
    }

    public void setName(String n){ //agrego nombre y cambio null por el parametro
        this.name = n; 
    }

    public String getName(){ //obtengo el nombre agregado
        return this.name;
    }

    public void myCi(int id){
        this.ci = id; 
    }

    public int getCi(){
        return this.ci;
    }

    static void saludar(String n){ //método estatico que no requiere de generar una instancia. 
        System.out.println("hola " + n);
    }
}