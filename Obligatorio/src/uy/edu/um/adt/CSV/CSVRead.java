package uy.edu.um.adt.CSV;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

import uy.edu.um.adt.ENTITIES.Tweet;
import uy.edu.um.adt.TADS.MyLinkedList.Mylist;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

public class CSVRead {
    private static final String Ruta_Archivo = "Obligatorio/src/uy/edu/um/adt/CSV/prueba.csv";

    public static void main(String[] args) {
        List<Tweet> tweetList = new Mylist<>();

        try {
            Reader reader = Files.newBufferedReader(Paths.get(Ruta_Archivo));
            CSVParser parser = new CSVParser(reader, CSVFormat.DEFAULT);
            for (CSVRecord record : parser) {
                Tweet tweet = new Tweet();
                tweet.setTweetNumber(record.get(0));
                tweet.setUserName(record.get(1));
                tweet.setUserDescription(record.get(2));
                tweet.setUserCreated(record.get(3));
                tweet.setUserFollowers(record.get(4));
                tweet.setUserFriends(record.get(5));
                tweet.setUserFavourites(record.get(6));
                tweet.setUserVerified(record.get(7));
                tweet.setDate(record.get(8));
                tweet.setText(record.get(9));
                tweet.setHashtags(record.get(10));
                tweet.setSource(record.get(11));
                tweet.setIsRetweet(record.get(12));

                tweetList.add(tweet);
            }

        } catch (IOException ex) {
            Logger.getLogger(CSVRead.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
