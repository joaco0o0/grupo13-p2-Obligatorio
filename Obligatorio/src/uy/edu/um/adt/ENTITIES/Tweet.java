package uy.edu.um.adt.ENTITIES;

import uy.edu.um.adt.TADS.MyLinkedList.MyLinkedList;

public class Tweet {
    private long tweetNumber;
    private Usuario usuario;
    private String text;
    private boolean retweeted;
    private Long favorites;
    private Fecha date;
    private MyLinkedList<Hashtag> hashtags;


    public Tweet(long tweetNumber, Usuario usuario, String text, boolean retweeted, Long favorites, Fecha date, MyLinkedList<Hashtag> Hashtags) {
        this.tweetNumber = tweetNumber;
        this.usuario = usuario;
        this.text = text;
        this.retweeted = retweeted;
        this.favorites = favorites;
        this.date = date;
        this.hashtags = hashtags;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public Fecha getDate() {
        return date;
    }

    public String getText() {
        return text;
    }

}