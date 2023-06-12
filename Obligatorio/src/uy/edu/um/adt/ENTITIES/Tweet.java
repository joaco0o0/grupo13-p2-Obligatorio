package uy.edu.um.adt.ENTITIES;

import uy.edu.um.adt.TADS.MyLinkedList.MyLinkedList;
import uy.edu.um.adt.TADS.MyLinkedList.Mylist;

public class Tweet {
    private long tweetNumber;
    private Usuario userName;
    private String userLocation;
    private String userDescription;
    private int favorites;
    private Fecha date;
    private String text;
    private Mylist<Hashtag> hashtags;
    private String source;
    private boolean retweeted;

    public Tweet(long tweetNumber, String userName, String userLocation, String userDescription, int favorites, Fecha date, String text, String source, boolean retweeted) {
        this.tweetNumber = tweetNumber;
        this.userName = new Usuario(userName);
        this.userLocation = userLocation;
        this.userDescription = userDescription;
        this.favorites = favorites;
        this.date = date;
        this.text = text;
        this.hashtags = new MyLinkedList<>();
        this.source = source;
        this.retweeted = retweeted;
    }

    public long getTweetNumber() {
        return tweetNumber;
    }

    public Usuario getUserName() {
        return userName;
    }

    public String getUserLocation() {
        return userLocation;
    }

    public String getUserDescription() {
        return userDescription;
    }

    public int getFavorites() {
        return favorites;
    }

    public Fecha getDate() {
        return date;
    }

    public String getText() {
        return text;
    }

    public Mylist<Hashtag> getHashtags() {
        return hashtags;
    }

    public String getSource() {
        return source;
    }

    public boolean isRetweeted() {
        return retweeted;
    }
}
