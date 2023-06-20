package uy.edu.um.adt.CSV;
import java.io.*;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import uy.edu.um.adt.ENTITIES.Fecha;
import uy.edu.um.adt.ENTITIES.Hashtag;
import uy.edu.um.adt.ENTITIES.Tweet;
import uy.edu.um.adt.ENTITIES.Usuario;
import uy.edu.um.adt.TADS.MyHash.MyHashImpl;
import uy.edu.um.adt.TADS.MyLinkedList.MyLinkedList;


public class CSVRead {

    private MyHashImpl<String , Usuario> usuarios;
    private MyLinkedList<Tweet> tweets;


    public MyHashImpl< String , Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(MyHashImpl< String , Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public MyLinkedList<Tweet> getTweets() {
        return tweets;
    }

    public void setTweets(MyLinkedList<Tweet> tweets) {
        this.tweets = tweets;
    }

    public CSVRead() {
        this.usuarios = new MyHashImpl<String,Usuario>(100) {
        };
        this.tweets = new MyLinkedList<Tweet>() {
        };
    }

    public void csvread(String rutaArchivo) throws IOException {
        try (FileReader lector = new FileReader(rutaArchivo);
             CSVParser csvparser = new CSVParser(lector, CSVFormat.DEFAULT)) {

            int fila = 0;
            for (CSVRecord csvRecord : csvparser) {
                if (fila != 0) {
                    try {
                        String[] fechaUsuario = csvRecord.get(4).split(" ");
                        String[] fechaComponents = fechaUsuario[0].split("/");
                        int anio = Integer.parseInt(fechaComponents[0]);
                        int mes = Integer.parseInt(fechaComponents[1]);
                        int dia = Integer.parseInt(fechaComponents[2]);
                        String[] horaComponents = fechaUsuario[1].split(":");
                        int hora = Integer.parseInt(horaComponents[0]);
                        int minuto = Integer.parseInt(horaComponents[1]);
                        long userCode = minuto + hora * 100L + dia * 10000L + mes * 1000000L + anio * 100000000L;
                        String userCodeString = String.valueOf(userCode);
                        String name = csvRecord.get(1);
                        boolean verified = Boolean.parseBoolean(csvRecord.get(8));

                        long tweetId = Long.parseLong(csvRecord.get(0));
                        int favorites = (int) Double.parseDouble(csvRecord.get(6));
                        String text = csvRecord.get(10);
                        boolean isRetweet = Boolean.parseBoolean(csvRecord.get(13));
                        String hashtagsString = csvRecord.get(11).replaceAll("[\\[\\]\"]", "").replaceAll("\\s", "");
                        String[] hashtagsArray = hashtagsString.split(",");
                        MyLinkedList<Hashtag> hashtagsTweet = new MyLinkedList<>();
                        for (String s : hashtagsArray) {
                            Hashtag hashtag = new Hashtag(s, tweetId);
                            hashtagsTweet.add(hashtag);
                        }
                        String[] FechaTweet = csvRecord.get(9).split(" ");
                        String[] FechaTComponents = FechaTweet[0].split("/");
                        int anioT = Integer.parseInt(FechaTComponents[0]);
                        int mesT = Integer.parseInt(FechaTComponents[1]);
                        int diaT = Integer.parseInt(FechaTComponents[2]);
                        Fecha fecha = new Fecha(diaT, mesT, anioT);


                        Tweet tweet = new Tweet(tweetId, userCode, text, isRetweet, favorites, fecha, hashtagsTweet);
                        tweets.add(tweet);
                        Usuario user = new Usuario(name, userCode, verified);
                        usuarios.put(userCodeString, user);

                        user.addTweet(tweet);
                    } catch (Exception ignored) {
                    }

                } else {
                    fila++;
                }
            }
            System.out.println("Se cargaron " + tweets.size() + " tweets");
            System.out.println("Se cargaron " + usuarios.size() + " usuarios");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public MyLinkedList Pilotos() {
        String archivo = "\"C:\\Desktop\\obligatorio2023csv\\drivers.txt\"";
        MyLinkedList<String> pilotos = new MyLinkedList<>();
        try (BufferedReader lector = new BufferedReader(new FileReader(archivo))) {
            String fila;
            while ((fila = lector.readLine()) != null) {
                pilotos.add(fila);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return pilotos;
    }
}