package uy.edu.um.adt.FUNCIONES;
import uy.edu.um.adt.ENTITIES.ClaveYTwit;
import uy.edu.um.adt.ENTITIES.Hashtag;
import uy.edu.um.adt.ENTITIES.Tweet;
import uy.edu.um.adt.ENTITIES.Usuario;
import uy.edu.um.adt.TADS.MyHash.MyHash;
import uy.edu.um.adt.TADS.MyLinkedList.MyLinkedList;
import uy.edu.um.adt.TADS.MyLinkedList.Mylist;


public class FuncionesImpl implements Funciones {
    public static void quickSortByTwit(MyLinkedList<ClaveYTwit> list) {
        if (list == null || list.size() <= 1) {
            return;
        }
        sort(list, 0, list.size() - 1);
    }

    private static void sort(MyLinkedList<ClaveYTwit> list, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(list, low, high);
            sort(list, low, pivotIndex - 1);
            sort(list, pivotIndex + 1, high);
        }
    }

    private static int partition(MyLinkedList<ClaveYTwit> list, int low, int high) {
        ClaveYTwit pivot = list.get(high);
        int i = low - 1;

        if (pivot != null) {
            for (int j = low; j < high; j++) {
                if (list.get(j).getTwit() >= pivot.getTwit()) {
                    i++;
                    swap(list, i, j);
                }
            }

            swap(list, i + 1, high);
            return i + 1;
        }

        return high;
    }

    private static void swap(MyLinkedList<ClaveYTwit> list, int i, int j) {
        ClaveYTwit temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
    @Override
    public void usuariosMasTwits(MyHash<Long, Tweet> twits, MyHash<Long, Usuario> usuarios, Mylist<Long> listaClaves) {
        Mylist<ClaveYTwit> listaClavesYTwits = new MyLinkedList<>();
        MyLinkedList<ClaveYTwit> lista15ClavesYTwitsOrdenada = new MyLinkedList<>();
        System.out.println(listaClaves.size());
        System.out.println(usuarios.size());
        for (int i = 0; i < listaClaves.size(); i++) {
            int cantidadTwits = usuarios.get(listaClaves.get(i)).getTweets().size();
            ClaveYTwit claveYTwit = new ClaveYTwit(listaClaves.get(i), cantidadTwits);
            listaClavesYTwits.add(claveYTwit);
        }
        for (int i = 0; i < 15; i++) {
            lista15ClavesYTwitsOrdenada.add(listaClavesYTwits.get(i));
        }
        quickSortByTwit(lista15ClavesYTwitsOrdenada);
        for (int i = 15; i < listaClavesYTwits.size(); i++) {
            if (listaClavesYTwits.get(i).getTwit() > lista15ClavesYTwitsOrdenada.get(14).getTwit()) {
                lista15ClavesYTwitsOrdenada.removeWithIndex(14);
                lista15ClavesYTwitsOrdenada.add(listaClavesYTwits.get(i));
                quickSortByTwit(lista15ClavesYTwitsOrdenada);
            }
        }
        for (int i = 1; i < lista15ClavesYTwitsOrdenada.size()+1; i++) {
            String username = usuarios.get(lista15ClavesYTwitsOrdenada.get(i).getClave()).getUserName();
            if (usuarios.get(lista15ClavesYTwitsOrdenada.get(i).getClave()).isVerified()) {
                System.out.println(i + " " + username + " " + "Verificado" + " " + lista15ClavesYTwitsOrdenada.get(i).getTwit());

            }
            else{
                System.out.println(i + " " + username + " " + "No Verificado" + " " + lista15ClavesYTwitsOrdenada.get(i).getTwit());
            }
        }
    }

    @Override
    public Hashtag hashtagMasUsado() {
        return null;
    }

    @Override
    public int cantidadDeTweetsPalabraFrase() {
        return 0;
    }

}
