package uy.edu.um.adt.ENTITIES;

import uy.edu.um.adt.TADS.MyLinkedList.MyLinkedList;
import uy.edu.um.adt.TADS.MyLinkedList.Mylist;

public class Tweet {
    private long tweetNumber;
    private Usuario userName;
    private String userLocation;
    private String userDescription;
    private int favorites;
    private Fecha_y_Hora date;
    private String text;
    private Mylist<Hashtag> hashtags;
    private String source;
    private boolean retweeted;

    public Tweet(long tweetNumber, String userName, String userLocation, String userDescription, int favorites, Fecha_y_Hora date, String text, String source, boolean retweeted) {
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

    public void addHashtag(Hashtag hashtag){
        this.hashtags.add(hashtag);
    }

    public long getTweetNumber() {
        return tweetNumber;
    }

    public void setTweetNumber(long tweetNumber) {
        this.tweetNumber = tweetNumber;
    }

    public String getUserName() {
        return userName.getUserName();
    }

    public String getUserLocation() {
        return userLocation;
    }

    public void setUserLocation(String userLocation) {
        this.userLocation = userLocation;
    }

    public String getUserDescription() {
        return userDescription;
    }

    public void setUserDescription(String userDescription) {
        this.userDescription = userDescription;
    }

    public int getFavorites() {
        return favorites;
    }

    public void setFavorites(int favorites) {
        this.favorites = favorites;
    }

    public Fecha_y_Hora getDate() {
        return date;
    }

    public void setDate(Fecha_y_Hora date) {
        this.date = date;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Mylist<Hashtag> getHashtags() {
        return hashtags;
    }

    public void setHashtags(Mylist<Hashtag> hashtags) {
        this.hashtags = hashtags;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public boolean isRetweeted() {
        return retweeted;
    }

    public void setRetweeted(boolean retweeted) {
        this.retweeted = retweeted;
    }
}
