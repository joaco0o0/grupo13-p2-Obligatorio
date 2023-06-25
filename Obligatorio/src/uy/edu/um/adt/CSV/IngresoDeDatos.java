package uy.edu.um.adt.CSV;
import java.io.*;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import uy.edu.um.adt.ENTITIES.*;
import uy.edu.um.adt.TADS.MyBinaryTree.MyBinarySearchTreeImpl;
import uy.edu.um.adt.TADS.MyBinaryTree.MySearchBinaryTree;
import uy.edu.um.adt.TADS.MyHash.MyHash;
import uy.edu.um.adt.TADS.MyHash.MyHashImpl;
import uy.edu.um.adt.TADS.MyLinkedList.MyLinkedList;
import uy.edu.um.adt.TADS.MyLinkedList.Mylist;

public class IngresoDeDatos {
    static MyHash<Long, Tweet> tweets = new MyHashImpl<>(640000);
    static MyHash<String, Hashtag> hashtags = new MyHashImpl<>(45000);
    static MyHash<Long, Usuario> usuarios = new MyHashImpl<>(123000);
    static Mylist<Long> listaClaves = new MyLinkedList<>();
    static int cantTweets, cantUsuarios, cantHashtags;
    public static Mylist<Piloto> pilotos = new MyLinkedList<>();

    public static int getCantTweets() {
        return cantTweets;
    }

    public static int getCantUsuarios() {
        return cantUsuarios;
    }

    public static int getCantHashtags() {
        return cantHashtags;
    }

    public static Mylist<Long> getListaClaves() {
        return listaClaves;
    }

    public static MyHash<Long, Tweet> getTweets() {
        return tweets;
    }

    public static MyHash<String, Hashtag> getHashtags() {
        return hashtags;
    }

    public static MyHash<Long, Usuario> getUsuarios() {
        return usuarios;
    }

    public static Mylist<Piloto> getPilotos() {
        return pilotos;
    }

    public static void IngresarDatos(String ruta_Archivo) {
        try (CSVParser parser = new CSVParser(new FileReader(ruta_Archivo), CSVFormat.DEFAULT)) {
            parser.iterator().next();
            int fila = 0;
            cantTweets = 0;
            int cantUsuarios = 0;
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
                long tweetCode = fila;
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
                }catch (NumberFormatException e){
                    System.out.println("Tweet rechazado: " + fila);
                    continue;
                }

                //Hashtags
                String hashtagsString = record.get(11).replaceAll("[\\[\\]\"]", "").replaceAll("\\s", "");
                MyLinkedList<Hashtag> listahashtag = new MyLinkedList<>();
                for (String hashtagUnico : hashtagsString.split(",")){
                    listahashtag.add(new Hashtag(hashtagUnico));
                    hashtags.put(hashtagUnico, new Hashtag(hashtagUnico));
                }

                //Ingresar Datos
                Tweet newtweet = new Tweet(tweetCode, userCode, tweetText , retweet, favoritos, fechaTweet,listahashtag);
                cantTweets++;
                tweets.put(tweetCode, newtweet);
                if (!usuarios.containsKey(userCode)) {
                    Usuario usuarioTemp = new Usuario(nombre, userCode, verificado);
                    usuarios.put(userCode, usuarioTemp);
                    cantUsuarios++;
                    usuarios.get(userCode).addTweet(newtweet);
                    fila ++;
                }else{
                    usuarios.get(userCode).addTweet(newtweet);
                }
            }
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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //hacer las fechas id unico
    public static Long generarClaveUnica(String cadena) {
        long hash = cadena.hashCode();
        long hashPositivo = Math.abs(hash);
        return  hashPositivo;

    }
}


