package uy.edu.um.adt.FUNCIONES;

import uy.edu.um.adt.CSV.CSVreader;
import uy.edu.um.adt.ENTITIES.*;
import uy.edu.um.adt.TADS.MyHash.MyHash;
import uy.edu.um.adt.TADS.MyHash.MyHashImpl;
import uy.edu.um.adt.TADS.MyLinkedList.MyLinkedList;
import uy.edu.um.adt.TADS.MyLinkedList.Mylist;
import uy.edu.um.adt.TADS.MyQueue.MyQueue;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class obligatorioImpl implements obligatorio {

    private MyHash<Long, Usuario> usuariosHash;
    private MyHash<Long, Tweet> tweetsHash;
    private MyHash<String, Hashtag> hashtagsHash;
    public Mylist<Piloto> pilotos;
    private Mylist<Tweet> tweets;
    private Mylist<Usuario> usuarios;
    private CSVreader csvReader;
    private Mylist<Long> listaClaves;
    private Mylist<Long> listaClavesTwit;

    public obligatorioImpl() {
        this.tweets = new MyLinkedList<>();
        this.usuarios = new MyLinkedList<>();
        this.csvReader = new CSVreader();
        this.pilotos = new MyLinkedList<>();
        this.hashtagsHash = new MyHashImpl<>(132000);
        this.usuariosHash = new MyHashImpl<>(1230000);
        this.tweetsHash = new MyHashImpl<>(633000);
        this.listaClaves= new MyLinkedList<>();
        this.listaClavesTwit= new MyLinkedList<>();

    }

    public void cargarTweets(String ruta_Archivo) {
        csvReader.CargarDatos(ruta_Archivo);
        this.usuariosHash = csvReader.getUsuariosHash();
        this.tweetsHash = csvReader.getTweetsHash();
        this.hashtagsHash = csvReader.getHashtagsHash();
        this.tweets = csvReader.getTweets();
        this.usuarios = csvReader.getUsuarios();
        this.listaClaves = csvReader.getListaClaves();
        this.listaClavesTwit = csvReader.getListaClavesTwit();
        String archivo = "Obligatorio/src/uy/edu/um/adt/CSV/drivers.txt";
        try (BufferedReader lector = new BufferedReader(new FileReader(archivo))) {
            String piloto;
            int linea = 0;
            while ((piloto = lector.readLine()) != null) {
                pilotos.add( new Piloto(piloto));
                linea++;
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public Mylist<Long> getListaClaves() {
        return listaClaves;
    }

    public Mylist<Long> getListaClavesTwit() {
        return listaClavesTwit;
    }

    public MyHash<Long, Usuario> getUsuariosHash() {
        return usuariosHash;
    }

    public MyHash<Long, Tweet> getTweetsHash() {
        return tweetsHash;
    }

    public MyHash<String, Hashtag> getHashtagsHash() {
        return hashtagsHash;
    }

    public Mylist<Piloto> getPilotos() {
        return pilotos;
    }

    public Mylist<Tweet> getTweets() {
        return tweets;
    }

    public Mylist<Usuario> getUsuarios() {
        return usuarios;
    }

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
    public Mylist<Tweet> ObtenerTweetsDelMes(int mes, Mylist<Tweet> tweetsTotal){
        Mylist<Tweet> tweetsDelMes = new MyLinkedList<>();
        for (int i = 0; i < tweetsTotal.size(); i++) {
            if(tweetsTotal.get(i).getFecha().getMes()==mes){
                tweetsDelMes.add(tweetsTotal.get(i));
            }
        }
        return tweetsDelMes;
    }
    public int numeroTweetsConPalabra(String Palabra, Mylist<Tweet> tweetsAMirar){
        int contador=0;
        for (int i = 0; i < tweetsAMirar.size(); i++) {
            if(tweetsAMirar.get(i).getText().contains(Palabra)){
                contador++;
            }
        }
        return contador;
    }
    @Override
    public void PilotosMasMencionados(int anio, int mes) {
        MyQueue<Piloto> queue = new MyLinkedList<>();
        Mylist<Tweet> tweetsAMirar =  ObtenerTweetsDelMes(mes, this.tweets);
        for (int i = 0; i < this.pilotos.size(); i++) {
            if (this.pilotos.get(i) == null) {
                System.out.println("Piloto nulo");
            } else {
                int num = numeroTweetsConPalabra(this.pilotos.get(i).getNombre(), tweetsAMirar);
                queue.enqueueWithPriority(this.pilotos.get(i), num);
                this.pilotos.get(i).setCantidad(num);

            }
        }
        for (int i = 0; i < 10; i++) {
            System.out.println(queue.get(i).getNombre() + " " + queue.get(i).getNumero());
        }
    }

    @Override
    public void usuariosMasTwits() {
        Mylist<ClaveYTwit> listaClavesYTwits = new MyLinkedList<>();
        MyLinkedList<ClaveYTwit> lista15ClavesYTwitsOrdenada = new MyLinkedList<>();
        listaClaves = this.getListaClaves();
        usuariosHash = this.getUsuariosHash();
        for (int i = 0; i < listaClaves.size(); i++) {
            int cantidadTwits = usuariosHash.get(listaClaves.get(i)).getTweets().size();
            ClaveYTwit claveYTwit = new ClaveYTwit(listaClaves.get(i), cantidadTwits);
            listaClavesYTwits.add(claveYTwit);
        }
        for (int i = 0; i < 15; i++) {
            lista15ClavesYTwitsOrdenada.add(listaClavesYTwits.get(i));
        }
        quickSortByTwit(lista15ClavesYTwitsOrdenada);
        for (int i = 15; i < listaClavesYTwits.size(); i++) {
            if (listaClavesYTwits.get(i).getTwit() > lista15ClavesYTwitsOrdenada.get(14).getTwit()) {
                lista15ClavesYTwitsOrdenada.set(14, listaClavesYTwits.get(i));
                quickSortByTwit(lista15ClavesYTwitsOrdenada);
            }
        }
        for (int i = 0; i < lista15ClavesYTwitsOrdenada.size(); i++) {
            String username = usuariosHash.get(lista15ClavesYTwitsOrdenada.get(i).getClave()).getUserName();
            ClaveYTwit claveYTwit15 = lista15ClavesYTwitsOrdenada.get(i);
            if (usuariosHash.get(claveYTwit15.getClave()).isVerified()) {
                System.out.println(i+1 + " " + username + " " + "Verificado" + " " + claveYTwit15.getTwit() + "" + "Tweets");

            }
            else{
                System.out.println(i+1 + " " + username + " " + "No Verificado" + " " + claveYTwit15.getTwit() + "" + "Tweets");
            }
        }
    }
    @Override
    public int cantHashtagsDistintos(int dia, int mes, int anio) {
        int cantHashtags = 0;
        Mylist<String> hashtagsSumados = new MyLinkedList<>();
        Mylist<String> hashtagsDia = buscarHashtagsPorFecha(dia, mes, anio);
        for (int i = 0; i < hashtagsDia.size(); i++) {
            if (!hashtagsSumados.contains(hashtagsDia.get(i))) {
                cantHashtags++;
                hashtagsSumados.add(hashtagsDia.get(i));
            }
        }
        System.out.println("La cantidad de hashtags distintos en el día " + dia + " del mes " + mes + " del año " + anio + " es: " + cantHashtags);
        return cantHashtags;
    }

    public Mylist<String> buscarHashtagsPorFecha(int dia, int mes, int anio) {
        MyHash<Long, Tweet> tweets = this.tweetsHash;
        Mylist<String> hashtagsDia = new MyLinkedList<>();
        for (String key : tweets.keys()) {
            try {
                Tweet tweet = tweets.get(Long.parseLong(key));
                if (tweet != null && tweet.getFecha().containsDia(anio, mes, dia)) {
                    MyLinkedList<Hashtag> tweetHashtags = tweet.getHashtags();
                    for (int i = 0; i < tweetHashtags.size(); i++) {
                        String hashtag = tweetHashtags.get(i).getId();
                        if (!hashtagsDia.contains(hashtag)) {
                            hashtagsDia.add(hashtag);
                        }
                    }
                }
            } catch (NumberFormatException e) {
            }
        }
        return hashtagsDia;
    }
    public static String hashtagMasRepetido(Mylist<String> hashtagsDeDia){
        MyHash<String, Integer> hashtags = new MyHashImpl<>(hashtagsDeDia.size());
        for (int i = 0; i < hashtagsDeDia.size(); i++) {
            if (hashtags.contains(hashtagsDeDia.get(i))) {
                hashtags.put(hashtagsDeDia.get(i), hashtags.get(hashtagsDeDia.get(i)) + 1);
            } else {
                hashtags.put(hashtagsDeDia.get(i), 1);
            }
        }
        int max = 0;
        String hashtagMasRepetido = "";
        for (String key : hashtags.keys()) {
            if (hashtags.get(key) > max) {
                max = hashtags.get(key);
                hashtagMasRepetido = key;
            }
        }
        return hashtagMasRepetido;
    }
    @Override
    public void hashtagMasUsado(int dia, int mes, int anio) {
        MyHash<Long,Tweet> twits = this.getTweetsHash();
        MyHash<String, Hashtag> hashtags = this.getHashtagsHash();
        Mylist<Long> twitsClave = this.getListaClavesTwit();
        Mylist<String> hashtagsDelDia = buscarHashtagsPorFecha(dia, mes, anio);
        hashtagsDelDia.remove("f1");
        String hashtagMasRepetido = hashtagMasRepetido(hashtagsDelDia);
        System.out.println("El hashtag más usado en el día " + dia + " del mes " + mes + " del año " + anio + " es: " + hashtagMasRepetido);
    }
    @Override
    public int cantidadDeTweetsPalabraFrase(String palabraFrase) {
        MyHash<Long, Tweet> tweets = this.tweetsHash;
        int cantTweets = 0;
        for (String key : tweets.keys()) {
            try{
                Tweet tweet = tweets.get(Long.parseLong(key));
                if (tweet != null && tweet.getText().contains(palabraFrase)) {
                    cantTweets++;
                }
            }catch(NumberFormatException e){
                continue;
            }
        }
        System.out.println("La cantidad de tweets que contienen la palabra/frase " + palabraFrase + " es: " + cantTweets);
        return cantTweets;

    }

    @Override
    public void topCuentasMasFavoritos() {
        MyQueue<Usuario> queue = new MyLinkedList<>();
        MyQueue<Usuario> lista = new MyLinkedList<>();
        MyHash<Long, Usuario> usuarioMyHash = this.usuariosHash;
        for (int i = 0; i < usuarioMyHash.size(); i++) {
            Usuario user = this.usuarios.findAt(i);
            queue.enqueueWithPriority(user, user.getFavoritos());
        }
        int i = 0;
        while (queue.size() != 0 && i < 7) {
            MyLinkedList<Object> list = new MyLinkedList<>();
            Usuario user = queue.dequeue();
            lista.enqueue(user);
            i++;
        }
        System.out.println("Top 7 de cuentas con más favoritos: ");
        for (int j = 0; j < 7; j++) {
            Usuario user = queue.get(j);
            System.out.println(j+1 + " " + user.getUserName() + " " + user.getFavoritos());
        }
    }

    public void setFavoritos(){
        for(int i = 0 ; i < this.tweets.size(); i++) {
            try {
                Tweet tweet = this.tweets.findAt(i);
                Usuario user = this.usuarios.findAt(i);
                user.setFavoritos(tweet.getFavorites());
            } catch (Exception e) {
            }
        }
    }
}
