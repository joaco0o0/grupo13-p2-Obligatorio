package uy.edu.um.adt.FUNCIONES;

import uy.edu.um.adt.ENTITIES.Fecha;
import uy.edu.um.adt.ENTITIES.Tweet;
import uy.edu.um.adt.TADS.MyHash.MyHash;
import uy.edu.um.adt.TADS.MyLinkedList.Mylist;

public interface obligatorio {
    void PilotosMasMencionados(int anio, int mes);//Funcion 1
    void usuariosMasTwits();//Funcion 2
    public int cantHashtagsDistintos(int dia, int mes, int anio); //Funcion 3
    void hashtagMasUsado(int dia, int mes, int anio);//Funcion 4
    public void topCuentasMasFavoritos();//Funcion 5
    int cantidadDeTweetsPalabraFrase(String palabraFrase);//Funcion 6
}