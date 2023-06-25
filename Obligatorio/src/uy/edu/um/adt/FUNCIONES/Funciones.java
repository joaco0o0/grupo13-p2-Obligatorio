package uy.edu.um.adt.FUNCIONES;

import uy.edu.um.adt.ENTITIES.Hashtag;
import uy.edu.um.adt.ENTITIES.Tweet;
import uy.edu.um.adt.ENTITIES.Usuario;
import uy.edu.um.adt.TADS.MyHash.MyHash;
import uy.edu.um.adt.TADS.MyLinkedList.Mylist;

public interface Funciones {
    //Funcion 1
    void usuariosMasTwits(MyHash<Long, Tweet> twits, MyHash<Long, Usuario> usuarios,Mylist<Long> listaClaves);//Funcion 2
    //Funcion 3
    Hashtag hashtagMasUsado();//Funcion 4
    //Funcion 5
    int cantidadDeTweetsPalabraFrase();//Funcion 6
}
