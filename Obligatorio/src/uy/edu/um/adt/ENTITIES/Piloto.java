package uy.edu.um.adt.ENTITIES;

public class Piloto {
    private String nombre;
    private int numero;

    public Piloto(String nombre){
        this.nombre = nombre;
        this.numero = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public int getNumero() {
        return numero;
    }

    public void add1(){
        this.numero++;
    }
}

