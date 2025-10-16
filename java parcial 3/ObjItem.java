
//Aquí se encuentran las templates de los objetos separados por armas y consumibles y unidos por una clase padre ObjItem.

public abstract class ObjItem {
    String nombre;
    int nivel;
    int peso;
    int durabilidad;
    String descripcion;
    int cantidad;
    String[] proposito;

    public ObjItem(String nombre, int nivel, int peso, int durabilidad, String descripcion, String proposito[]) {
        this.nombre = nombre;
        this.nivel = nivel;
        this.peso = peso;
        this.durabilidad = durabilidad;
        this.descripcion = descripcion;
        this.proposito = proposito;
        this.cantidad = 0;
    }

    public String getNombre() {
        return this.nombre;
    }

    public int getNivel() {
        return this.nivel;
    }

    public int getPeso() {
        return this.peso;
    }

    public int getDurabilidad() {
        return this.durabilidad;
    }

    public String getDescription() {
        return this.descripcion;
    }

    public String[] getProposito() {
        return this.proposito;
    }

    public void verInfo() {
        System.out.println("------------" + this.nombre + "---------------");
        System.out.println("nombre: " + this.nombre);
        System.out.println("nivel: " + this.nivel);
        System.out.println("peso: " + this.peso);
        System.out.println("durabilidad: " + this.durabilidad);
        System.out.println("descripcion: " + this.descripcion);
        System.out.println("descripcion: " + this.proposito);
        System.out.println("cantidad: " + this.cantidad);
    }

    public void basicInfo() {
        System.out.println(this.nombre + " "+this.nivel+ " x" + this.cantidad);
    }
}


class Item extends ObjItem {
    public Item(String nombre, int nivel, int peso, int durabilidad, String descripcion, String proposito[]) {
        super(nombre, nivel, peso, durabilidad, descripcion, proposito);
    }
}

// Clase Arma con atributos de daño
class Arma extends ObjItem {
    int dañoMin;
    int dañoMax;
    String tipoDaño;

    public Arma(String nombre, int nivel, int dañoMin, int dañoMax, int peso, int durabilidad, String descripcion,
            String tipoDaño, String proposito[]) {
        super(nombre,nivel, peso, durabilidad, descripcion, proposito);
        this.dañoMin = dañoMin;
        this.dañoMax = dañoMax;
        this.tipoDaño = tipoDaño;
    }

    public void verInfo() {
        System.out.println("------------" + this.nombre + "---------------");
        System.out.println("Item: " + this.nombre);
        System.out.println("Item: " + this.nivel);
        System.out.println("daño: " + this.dañoMin + "-" + this.dañoMax);
        System.out.println("tipo de daño: " + this.tipoDaño);
        System.out.println("peso: " + this.peso);
        System.out.println("durabilidad: " + this.durabilidad);
        System.out.println("descripcion: " + this.descripcion);
        System.out.println("descripcion: " + this.proposito);
        System.out.println("cantidad: " + this.cantidad);
    }

    public String getNombre() {
        return this.nombre;
    }

    public void basicInfo() {
        System.out.println(this.nombre + " " + this.dañoMin + "-" + this.dañoMax + " x" + this.cantidad);
    }

    public String[] getProposito() {
        return this.proposito;
    }
}
