package uy.edu.um.adt.ENTITIES;

import uy.edu.um.adt.TADS.MyLinkedList.MyLinkedList;
import uy.edu.um.adt.TADS.MyLinkedList.Mylist;

public class Usuario {
    private String user_name;
    private long id;
    private Mylist<Tweet> tweets;

    public Usuario(String user_name) {
        this.user_name = user_name;
        this.tweets = new MyLinkedList<>();
    }

    public String getUserName() {
        return this.user_name;
    }

    public long getId() {
        return this.id;
    }

    public static void addTweet(long tweetNumber, String userName, String userLocation, String userDescription, int favorites, Fecha_y_Hora date, String text, String source, boolean retweeted){
        Tweet tweet = new Tweet(tweetNumber, userName, userLocation, userDescription, favorites, date, text, source, retweeted);
        Usuario usuario = new Usuario(userName);
        usuario.addTweet(tweetNumber, userName, userLocation, userDescription, favorites, date, text, source, retweeted);
    }

    public Mylist<Tweet> getTweets(){
        return this.tweets;
    }

    public int getTweetsSize(){
        return this.tweets.size();
    }

    public void clearTweets(){
        this.tweets.clear();
    }

    public void removeTweet(Tweet tweet){
        this.tweets.remove(tweet);
    }
}
