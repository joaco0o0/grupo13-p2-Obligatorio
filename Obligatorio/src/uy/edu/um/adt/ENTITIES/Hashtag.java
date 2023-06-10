package uy.edu.um.adt.ENTITIES;

public class Hashtag {
private String hashtag;
    private int cantidad;

    public Hashtag(String hashtag) {
        this.hashtag = hashtag;
        this.cantidad = 1;
    }



    public int getCantidad() {
        return cantidad;
    }
    public void agruegarUno(){
       cantidad++;
    }
}
