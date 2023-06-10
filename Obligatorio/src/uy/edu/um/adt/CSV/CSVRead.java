package uy.edu.um.adt.CSV;


import uy.edu.um.adt.ENTITIES.Usuario;
import uy.edu.um.adt.ENTITIES.Hashtag;
import uy.edu.um.adt.ENTITIES.Tweet;
import uy.edu.um.adt.ENTITIES.Fecha_y_Hora;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import uy.edu.um.adt.TADS.MyLinkedList.MyLinkedList;


import java.io.FileReader;
import java.io.IOException;

public class CSVRead {

    private MyLinkedList<Usuario> Usuarios;
    private MyLinkedList<Tweet> tweets;
    private MyLinkedList<Hashtag> hashtags;

    public MyLinkedList<Usuario> getUsuarios() {
        return Usuarios;
    }

    public void setUsers(MyLinkedList<Usuario> Usuario) {
        this.Usuarios = Usuario;
    }

    public MyLinkedList<Tweet> getTweets() {
        return tweets;
    }

    public void setTweets(MyLinkedList<Tweet> tweets) {
        this.tweets = tweets;
    }

    public MyLinkedList<Hashtag> getHashtags() {
        return hashtags;
    }

    public void setHashtags(MyLinkedList<Hashtag> hashtags) {
        this.hashtags = hashtags;
    }

    public CSVRead(){
        this.Usuarios = new MyLinkedList<>();
        this.tweets =  new MyLinkedList<>();
        this.hashtags = new MyLinkedList<>();
    }

    public void CSVReader() {
        String CSV = "src/uy/edu/um/adt/CSV/prueba.csv";

        try (FileReader reader = new FileReader(CSV);
             CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT)) {
            for (CSVRecord csvRecord : csvParser) {

                try {
                    //CSV TWEET LIST

                    //tweet number
                    long tweetNumber = Long.parseLong(csvRecord.get(0));

                    //user Name
                    String userName = csvRecord.get(1);


                    //user location
                    String location = csvRecord.get(2);

                    //tweet description
                    String userDescription = csvRecord.get(3);

                    //user creation date
                    String[] fechayHora = csvRecord.get(4).split(" ");
                    String[] fechaComponents = fechayHora[0].split("/");
                    int anio = Integer.parseInt(fechaComponents[0]);
                    int mes = Integer.parseInt(fechaComponents[1]);
                    int dia = Integer.parseInt(fechaComponents[2]);
                    String[] horaComponents = fechayHora[1].split(":");
                    int hora = Integer.parseInt(horaComponents[0]);
                    int minuto = Integer.parseInt(horaComponents[1]);
                    Fecha_y_Hora fecha = new Fecha_y_Hora(anio, mes, dia, hora, minuto);

                    //user followers
                    int followers = (int) Double.parseDouble(csvRecord.get(5));

                    //user friends
                    int friends = (int) Double.parseDouble(csvRecord.get(6));

                    //tweet favorites
                    int favorites = (int) Double.parseDouble(csvRecord.get(7));

                    //user verified
                    boolean verified = Boolean.parseBoolean(csvRecord.get(8));

                    //tweet date
                    String[] fechaTweet = csvRecord.get(9).split(" ");
                    String[] fechaTweetComponents = fechaTweet[0].split("/");
                    int aniotweet = Integer.parseInt(fechaTweetComponents[0]);
                    int mestweet = Integer.parseInt(fechaTweetComponents[1]);
                    int diatweet = Integer.parseInt(fechaTweetComponents[2]);
                    String[] horatweetComponents = fechayHora[1].split(":");
                    int horatweet = Integer.parseInt(horatweetComponents[0]);
                    int minutotweet = Integer.parseInt(horatweetComponents[1]);
                    Fecha_y_Hora fechatweet = new Fecha_y_Hora(aniotweet, mestweet, diatweet, horatweet, minutotweet);

                    //tweet text
                    String text = csvRecord.get(10);

                    //tweet hashtags
                    String[] hashtags = csvRecord.get(11).split(",");
                    MyLinkedList<Hashtag> hashtagsList = new MyLinkedList<>();

                    //tweet sourse
                    String source = csvRecord.get(12);

                    //tweet retweeted
                    boolean retweeted = Boolean.parseBoolean(csvRecord.get(13));

                    //Agregar a lista de tweets
                    Tweet tweet = new Tweet(tweetNumber, userName, location, userDescription, favorites, fechatweet, text, source, retweeted);
                    for(int i=0; i<hashtags.length; i++){
                        Hashtag hashtag = new Hashtag(hashtags[i]);
                        hashtagsList.add(hashtag);
                    }
                    tweets.add(tweet);


                    //Agregar a lista de usuarios
                    Usuario usario = new Usuario(userName);
                    Usuario.addTweet(tweetNumber, userName, location, userDescription, favorites, fechatweet, text, source, retweeted);
                    Usuarios.add(usario);

                    //Agregar a lista de hashtags
                    for(int i=0; i<hashtags.length; i++){
                        Hashtag hashtag = new Hashtag(hashtags[i]);
                        hashtagsList.add(hashtag);
                    }
                    this.hashtags = hashtagsList;

                } catch (Exception ignored) {
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        CSVRead csvRead = new CSVRead();
        csvRead.CSVReader();
        System.out.println(csvRead.getTweets().size());
        System.out.println(csvRead.getUsuarios().size());
        System.out.println(csvRead.getHashtags().size());
    }
}
