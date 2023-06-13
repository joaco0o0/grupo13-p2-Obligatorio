package uy.edu.um.adt.CSV;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Logger;
import java.util.logging.Level;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import uy.edu.um.adt.ENTITIES.Fecha;
import uy.edu.um.adt.ENTITIES.Hashtag;
import uy.edu.um.adt.ENTITIES.Tweet;
import uy.edu.um.adt.ENTITIES.Usuario;
import uy.edu.um.adt.TADS.MyLinkedList.MyLinkedList;

public class CSVRead {

    private MyLinkedList<Usuario> usuarios = new MyLinkedList<>();
    private MyLinkedList<Tweet> tweets = new MyLinkedList<>();


    private static final String Ruta_Archivo = "C:\\Users\\Evo-i7\\OneDrive\\Documentos\\FIUM\\2023\\Prog 2\\f1_dataset.csv";

    public void csvread(String[] args) {
        try {
            Reader lector = Files.newBufferedReader(Paths.get(Ruta_Archivo));
            CSVParser parser = new CSVParser(lector, CSVFormat.DEFAULT);
            for(CSVRecord fila : parser) {
                if(fila.getRecordNumber()!=1) {
                    //Tweet ID
                    long tweetID = Long.parseLong(fila.get(0));
                    //user name
                    String userName = fila.get(1);
                    //user location
                    String location = fila.get(2);
                    //user description
                    String userDescription = fila.get(3);
                    //user creation date
                    String[] fechayHora = fila.get(4).split(" ");
                    long userCode = 0;
                    if (fechayHora.length >= 2) {
                        String[] fechaComponents = fechayHora[0].split("/");
                        if (fechaComponents.length >= 3) {
                            int anio = Integer.parseInt(fechaComponents[0]);
                            int mes = Integer.parseInt(fechaComponents[1]);
                            int dia = Integer.parseInt(fechaComponents[2]);
                            String[] horaComponents = fechayHora[1].split(":");
                            if (horaComponents.length >= 2) {
                                int hora = Integer.parseInt(horaComponents[0]);
                                int minuto = Integer.parseInt(horaComponents[1]);
                                userCode = (long)minuto+hora*100+dia*10000+mes*1000000+anio*100000000;
                            }
                        }
                    }
                    //user followers
                    int followers = Integer.parseInt(fila.get(5));
                    //user friends
                    String friends = fila.get(6);
                    //tweet favourites
                    String favourites = fila.get(7);
                    //user verified
                    boolean verified = Boolean.parseBoolean(fila.get(8));
                    //Tweet date
                    String[] fechaTweet = fila.get(9).split(" ");
                    Fecha tweetDate = null;
                    if(fechaTweet.length>=2) {
                        String[] fechaTComponents = fechaTweet[0].split("/");
                        if (fechaTComponents.length >= 3) {
                            int anioT = Integer.parseInt(fechaTComponents[0]);
                            int mesT = Integer.parseInt(fechaTComponents[1]);
                            int diaT = Integer.parseInt(fechaTComponents[2]);
                            String[] horaTComponents = fechaTweet[1].split(":");
                            if (horaTComponents.length >= 2) {
                                int horaT = Integer.parseInt(horaTComponents[0]);
                                int minutoT = Integer.parseInt(horaTComponents[1]);
                                tweetDate = new Fecha(anioT, mesT, diaT, horaT, minutoT);
                            }
                        }
                    }
                    //tweet text
                    String text = fila.get(10);
                    //tweet hashtags
                    String[] hashtags = fila.get(11).split("', '");
                    String primerHashtag = hashtags[0];
                    primerHashtag = primerHashtag.replace("['", "");
                    hashtags[0] = primerHashtag;
                    String ultimoHashtag = hashtags[hashtags.length-1];
                    ultimoHashtag = ultimoHashtag.replace("']", "");
                    hashtags[hashtags.length-1] = ultimoHashtag;
                    //tweet source
                    String source = fila.get(12);
                    //tweet retweeted
                    boolean retweeted = Boolean.parseBoolean(fila.get(13));

                    //Creo el usuario si es necesario
                    Usuario user = new Usuario( userName, userCode,  followers, verified);
                    if(usuarios.contains(user) == false){
                        usuarios.add(user);
                    }

                    //Creo el tweet
                    Tweet tweet = new Tweet(tweetID,userCode, text, source, retweeted, favourites, tweetDate, hashtags);
                    tweets.add(tweet);

                }

            }

        } catch (IOException e) {
            Logger.getLogger(CSVRead.class.getName()).log(Level.SEVERE, null, e);
        }
    }


    public static void main(String[] args) {
        CSVRead obj = new CSVRead();
        obj.csvread(args);
    }
}