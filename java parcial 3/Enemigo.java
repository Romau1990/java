import java.util.*;

public class Enemigo {
    String nombre;
    int hp;
    int[] daño;
    String[] habilidades;
    String[] objetos;
    int nivel;
    int defensa;
    String[] habitat;
    String especie;

    public Enemigo(String nombre, int hp, int[] daño, String[] habilidades, String[] objetos, int nivel, int defensa,String[] habitat, String especie) {
        this.nombre = nombre;
        this.hp = hp;
        this.daño = daño;
        this.habilidades = habilidades;
        this.objetos = objetos;
        this.nivel = nivel;
        this.defensa = defensa;
        this.habitat = habitat;
        this.especie = especie;
    }

    public String[] getHabitat() {
        return habitat;
    }
}
