package uy.edu.um.adt.FUNCIONES;

import uy.edu.um.adt.ENTITIES.Fecha;
import uy.edu.um.adt.ENTITIES.Tweet;
import uy.edu.um.adt.TADS.MyHash.MyHash;
import uy.edu.um.adt.TADS.MyLinkedList.Mylist;

public interface obligatorio {
    MyHash<Long, Tweet> getTweetsHash();

    void PilotosMasMencionados(int anio, int mes);//Funcion 1
    void usuariosMasTwits();//Funcion 2
    public int cantHashtagsDistintos(int dia, int mes, int anio); //Funcion 3
    void hashtagMasUsado(Fecha fecha);//Funcion 4
    public void topCuentasMasFavoritos();//Funcion 5
    int cantidadDeTweetsPalabraFrase();//Funcion 6


    int numeroTweetsConPalabra(String Palabra, Mylist<Tweet> tweetsAMirar);

    Mylist<Tweet> ObtenerTweetsDelMes(int mes, Mylist<Tweet> tweetsTotal);

    Mylist<Tweet> ObtenerTweetsDelAnio(int Anio, Mylist<Tweet> tweetsTotal);
}
