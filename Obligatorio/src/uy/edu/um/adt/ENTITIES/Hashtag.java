package uy.edu.um.adt.ENTITIES;

import java.util.Locale;

public class Hashtag {
    private String hashtag;
    private String hashtagID;

    public Hashtag(String hashtag) {
        this.hashtag = hashtag;
        this.hashtagID = hashtag.toLowerCase(Locale.ROOT); //tomamos iguales los hashtages escritos en mayusculas o en minusculas
    }

    public String getId() {
        return hashtagID;
    }
}
