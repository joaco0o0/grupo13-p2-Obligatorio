package uy.edu.um.adt.CSV;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import uy.edu.um.adt.ENTITIES.*;
import uy.edu.um.adt.TADS.MyHash.MyHash;
import uy.edu.um.adt.TADS.MyHash.MyHashImpl;
import uy.edu.um.adt.TADS.MyLinkedList.MyLinkedList;
import uy.edu.um.adt.TADS.MyLinkedList.Mylist;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CSVreader {
    private MyHash<String , Hashtag> hashtags;
    private MyHash<Long, Usuario> usuarios;
    private MyHash<Long, Tweet> tweets;
    private Mylist<Long> listaClaves = new MyLinkedList<>();
    private Mylist<Long> listaClavesTwit = new MyLinkedList<>();
    private Mylist<Piloto> pilotos;


    public Mylist<Hashtag> getHashtags() {
        return hashtags.values();
    }

    public Mylist<Usuario> getUsuarios() {
        return usuarios.values();
    }

    public Mylist<Tweet> getTweets() {
        return tweets.values();
    }

    public Mylist<Piloto> getPilotos() {
        return pilotos;
    }

    public MyHash<Long, Usuario> getUsuariosHash() {
        return usuarios;
    }

    public MyHash<Long, Tweet> getTweetsHash() {
        return tweets;
    }

    public MyHash<String,Hashtag> getHashtagsHash() {
        return hashtags;
    }

    public Mylist<Long> getListaClaves() {
        return listaClaves;
    }
    public Mylist<Long> getListaClavesTwit() {
        return listaClavesTwit;
    }

    public CSVreader() {
        this.hashtags = new MyHashImpl<>(65000);
        this.usuarios = new MyHashImpl<>(150000);
        this.tweets = new MyHashImpl<>(650000);
    }

    public void CargarDatos(String ruta_Archivo) {
        try (CSVParser parser = new CSVParser(new FileReader(ruta_Archivo), CSVFormat.DEFAULT)) {
            parser.iterator().next();
            int fila = 0;
            int cantidadususarios = 0;
            for (CSVRecord record : parser) {
                //Usuario
                String nombre = record.get(1);
                String fechaCreado = record.get(4);
                long userCode = generarClaveUnica(fechaCreado);
                boolean verificado;
                try {
                    verificado = Boolean.parseBoolean(record.get(8));
                } catch (NumberFormatException e) {
                    continue;
                }

                //Tweet
                long tweetCode = Long.parseLong(record.get(0));
                String tweetText = record.get(10);
                boolean retweet;
                try {
                    retweet = Boolean.parseBoolean(record.get(13));
                } catch (NumberFormatException e) {
                    continue;
                }
                int favoritos;
                try {
                    if (record.get(7).contains(".")) {
                        double doubleValue = Double.parseDouble(record.get(7));
                        favoritos = (int) Math.round(doubleValue);
                    } else {
                        favoritos = Integer.parseInt(record.get(7));
                    }
                } catch (NumberFormatException e) {
                    continue;
                }
                Fecha fechaTweet;
                try {
                    String fechatweet = record.get(9).split(" ")[0];
                    String[] fechaComponents = fechatweet.split("[/-]");
                    long mes = Long.parseLong(fechaComponents[1]);
                    long dia = Long.parseLong(fechaComponents[2]);
                    long anio = Long.parseLong(fechaComponents[0]);
                    fechaTweet = new Fecha(anio, mes, dia);
                } catch (NumberFormatException e) {
                    System.out.println("Tweet rechazado: " + fila);
                    continue;
                }

                //Hashtags
                String hashtagsString = record.get(11).replaceAll("[\\[\\]\"]", "").replaceAll("\\s", "");
                MyLinkedList<Hashtag> listahashtag = new MyLinkedList<>();
                for (String hashtagUnico : hashtagsString.split(",")) {
                    listahashtag.add(new Hashtag(hashtagUnico));
                    hashtags.put(hashtagUnico, new Hashtag(hashtagUnico));
                }

                //Ingresar Datos
                Tweet newtweet = new Tweet(tweetCode, userCode, tweetText, retweet, favoritos, fechaTweet, listahashtag);
                tweets.put(tweetCode, newtweet);
                listaClavesTwit.add(tweetCode);
                if (!usuarios.containsKey(userCode)) {
                    Usuario usuarioTemp = new Usuario(nombre, userCode, verificado);
                    usuarios.put(userCode, usuarioTemp);
                    listaClaves.add(userCode);
                    cantidadususarios++;
                    usuarios.get(userCode).addTweet(newtweet);
                    fila++;
                } else {
                    usuarios.get(userCode).addTweet(newtweet);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static Long generarClaveUnica(String cadena) {
        long hash = cadena.hashCode();
        long hashPositivo = Math.abs(hash);
        return hashPositivo;

    }
}
