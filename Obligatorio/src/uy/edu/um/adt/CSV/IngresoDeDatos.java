package uy.edu.um.adt.CSV;
import java.io.*;
import java.util.Collection;
import java.util.HashMap;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import uy.edu.um.adt.ENTITIES.*;
import uy.edu.um.adt.TADS.MyHash.MyHash;
import uy.edu.um.adt.TADS.MyHash.MyHashImpl;
import uy.edu.um.adt.TADS.MyLinkedList.MyLinkedList;
import uy.edu.um.adt.TADS.MyLinkedList.Mylist;

public class IngresoDeDatos {
    static MyHash<Long, Tweet> tweets = new MyHashImpl<>(640000);
    static MyHash<String, Hashtag> hashtags = new MyHashImpl<>(45000);
    static MyHash<Long, Usuario> usuarios = new MyHashImpl<>(123000);
    static int cantTweets;
    static int cantUsuarios;
    static int cantHashtags;
    public static MyHash<Integer, Piloto> pilotos = new MyHashImpl<>(20);

    public int getCantTweets() {
        return cantTweets;
    }

    public int getCantUsuarios() {
        return cantUsuarios;
    }

    public int getCantHashtags() {
        return cantHashtags;
    }

    public static MyHash<Integer, Piloto> getPilotos() {
        return pilotos;
    }

    public static void IngresarDatos(String ruta_Archivo) {
        try(CSVParser par = new CSVParser(new FileReader(ruta_Archivo), CSVFormat.DEFAULT)){
            par.iterator().next();
            cantHashtags = 0;
            cantTweets = 0;
            cantUsuarios = 0;
            for(CSVRecord record: par) {
                //usuario
                String userName = record.get(1);
                Long userCode = generarClaveUnica(record.get(4));
                boolean verificado = Boolean.parseBoolean(record.get(8));
                //Tweet
                Long tweetID = Long.parseLong(record.get(0));
                String tweetText = record.get(10);
                boolean retweet = Boolean.parseBoolean(record.get(13));
                String favoritosString = record.get(7);
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
                String fechatweet = record.get(9).split(" ")[0];
                String[] fechaComponents = fechatweet.split("[/-]");
                long anio = Long.parseLong(fechaComponents[0]);
                long mes = Long.parseLong(fechaComponents[1]);
                long dia = Long.parseLong(fechaComponents[2]);
                Fecha fechaTweet = new Fecha( anio, mes, dia);
                //Hashtag
                String hashtagsString = record.get(11).replaceAll("[\\[\\]\"]", "").replaceAll("\\s", "");
                String[] hashtagsArray = hashtagsString.split(",");
                MyLinkedList<Hashtag> hashtagsTweet = new MyLinkedList<>();

                //Ingresar Datos
                Tweet tweet = new Tweet(tweetID, userCode, tweetText, retweet, favoritos, fechaTweet, hashtagsTweet);
                cantTweets++;
                tweets.put(tweetID, tweet);
                if(!usuarios.containsKey(userCode)){
                    usuarios.put(userCode, new Usuario(userName, userCode, verificado));
                    cantUsuarios++;
                }
                usuarios.get(userCode).addTweet(tweet);
                for (String hashtag : hashtagsArray) {
                    if (!hashtags.containsKey(hashtag)) {
                            hashtags.put(hashtag, new Hashtag(hashtag));
                            cantHashtags++;
                    }
                }
                System.out.println("Tweet: " + tweetID);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String archivo = "Obligatorio/src/uy/edu/um/adt/CSV/drivers.txt";
        try (BufferedReader lector = new BufferedReader(new FileReader(archivo))) {
            String fila;
            int linea = 0;
            while ((fila = lector.readLine()) != null) {
                pilotos.put(linea, new Piloto(fila));
                linea++;
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Long generarClaveUnica(String cadena) {
        long hash = cadena.hashCode();
        long hashPositivo = Math.abs(hash);
        return  hashPositivo;
    }


    public MyHash<Long, Tweet> getTweets() {
        return tweets;
    }

    public MyHash<String, Hashtag> getHashtags() {
        return hashtags;
    }

    public MyHash<Long, Usuario> getUsuarios() {
        return usuarios;
    }

    public static void main(String[] args) {
        IngresoDeDatos.IngresarDatos("C:\\Users\\Evo-i7\\OneDrive\\Escritorio\\f1_dataset.csv");
        System.out.println("Cantidad de usuarios: " + usuarios.size());
        System.out.println("Cantidad de tweets: " + tweets.size());
        System.out.println("Cantidad de hashtags: " + hashtags.size());
    }
}

