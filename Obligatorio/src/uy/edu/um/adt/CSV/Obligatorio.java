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

public class Obligatorio {
    static MyHash<Long, Tweet> tweets = new MyHashImpl<>(640000);
    static MyHash<String, Hashtag> hashtags = new MyHashImpl<>(45000);
    static MyHash<Long, Usuario> usuarios = new MyHashImpl<>(123000);
    static int cantTweets, cantUsuarios, cantHashtags;
    public static MyHash<Integer, Piloto> pilotos = new MyHashImpl<>(20);

    public static int getCantTweets() {
        return cantTweets;
    }

    public static int getCantUsuarios() {
        return cantUsuarios;
    }

    public static int getCantHashtags() {
        return cantHashtags;
    }

    public static MyHash<Integer, Piloto> getPilotos() {
        return pilotos;
    }

    public static void IngresarDatos(String ruta_Archivo) {
        try(CSVParser par = new CSVParser(new FileReader(ruta_Archivo), CSVFormat.DEFAULT)){
            par.iterator().next();
            int fila = 1;
            cantHashtags = 0;
            cantTweets = 0;
            cantUsuarios = 0;
            for(CSVRecord record: par){
                //Fecha usuario creado
                String fechaUsuario = record.get(4);
                Long userCode = generarClaveUnica(fechaUsuario);

                //Nombre usuario
                String userName = record.get(3);

                //Usuario Verificado
                boolean verified = Boolean.parseBoolean(record.get(8));

                //favoritos del tweet (likes)
                Long favoritos;
                try {
                    if (record.get(7).contains(".")) {
                        double doubleValue = Double.parseDouble(record.get(7));
                        favoritos = Math.round(doubleValue);
                    } else {
                        favoritos = Long.parseLong(record.get(7));
                    }
                } catch (NumberFormatException e) {
                    continue;
                }

                //Tweet ID
                Long tweetID = Long.parseLong(record.get(0));

                //Tweet text
                String tweetText = record.get(10);

                //Fecha tweet
                String[] fechatweet = record.get(9).split(" ");
                String[] fechaComponentsTweet = fechatweet[0].split("/");
                Long anioTweet = Long.parseLong(fechaComponentsTweet[0]);
                Long mesTweet = Long.parseLong(fechaComponentsTweet[1]);
                Long diaTweet = Long.parseLong(fechaComponentsTweet[2]);
                Fecha fechaTweet = new Fecha(anioTweet, mesTweet, diaTweet);

                //Is retweeted
                boolean retweeted = Boolean.parseBoolean(record.get(13));

                //Hashtags
                String hashtagsString = record.get(11).replaceAll("[\\[\\]\"]", "").replaceAll("\\s", "");
                String[] hashtagsArray = hashtagsString.split(",");
                MyLinkedList<Hashtag> hashtagsTweet = new MyLinkedList<>();

                // Ingesar datos
                Usuario usuario = new Usuario(userName, userCode, verified);
                if(!usuarios.containsKey(userCode)){
                    usuarios.put(userCode, usuario);
                    cantUsuarios++;
                    Tweet tweet = new Tweet(tweetID, usuario, tweetText, retweeted, favoritos, fechaTweet, hashtagsTweet);
                    tweets.put(tweetID, tweet);
                }else {
                    Tweet tweet = new Tweet(tweetID, usuarios.get(userCode), tweetText, retweeted, favoritos, fechaTweet, hashtagsTweet);
                    tweets.put(tweetID, tweet);
                }
                cantTweets ++;
                for(String hashtag: hashtagsArray){
                    Hashtag hashtagNuevo = new Hashtag(hashtag);
                    if(!hashtags.containsKey(hashtagNuevo.getId())){
                        hashtags.put(hashtagNuevo.getId(), hashtagNuevo);
                        cantHashtags++;
                    }
                }
                fila++;
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

    public static void ListarLos10PilotosMasMenionadosEnLaTemporada(int anio, int mes){
        MySearchBinaryTree ArbolBinario = new MyBinarySearchTreeImpl();
        for (Long i = 0L; i < cantTweets; i++) {
            if(tweets.get(i).getDate().getMes() == mes && tweets.get(i).getDate().getAnio() == anio){
                for (int j = 0; j <pilotos.size() ; j++) {
                    if (tweets.get(i).getText().contains(pilotos.get(j).getNombre())){
                        pilotos.get(j).add1();
                    }
                }
            }
        }
        for (int i = 0; i <pilotos.size() ; i++) {
            ArbolBinario.insert(pilotos.get(i).getNumero(),pilotos.get(i));
        }


    }




    public static long generarClaveUnica(String cadena) { //Asumiedo que no hay dos fechaas de creacion exactamente iguales esto genera claves diferentes
        long clave = 0;
        for (int i = 0; i < cadena.length(); i++) {
            clave = clave * 10 + (int) cadena.charAt(i);
        }
        return clave;
    }


}


