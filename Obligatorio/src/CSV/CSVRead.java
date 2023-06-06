package CSV;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.IOException;

public class CSVRead {
public static void main(String[] args) {
        try (InputStream inputStream = CSVRead.class.getResourceAsStream("archivo.csv");
             BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
