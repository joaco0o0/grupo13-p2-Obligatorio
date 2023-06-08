package uy.edu.um.adt.CSV;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

import uy.edu.um.adt.ENTITIES.Tweet;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import uy.edu.um.adt.TADS.MyLinkedList.MyLinkedList;

public class CSVRead {
    private static final String Ruta_Archivo = "Obligatorio/src/uy/edu/um/adt/CSV/prueba.csv";

    public static void main(String[] args) {
        MyLinkedList<Tweet> tweetList = new MyLinkedList<>();

        try {
            Reader reader = Files.newBufferedReader(Paths.get(Ruta_Archivo));
            CSVParser parser = new CSVParser(reader, CSVFormat.DEFAULT);
            for (CSVRecord record : parser) {
                Tweet tweet = new Tweet(record.get(0),record.get(1),record.get(2),record.get(3),record.get(4),record.get(5),record.get(6),record.get(7),record.get(8),record.get(9),record.get(10),record.get(11),record.get(12));
                tweetList.add(tweet);
            }

        } catch (IOException ex) {
            Logger.getLogger(CSVRead.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
