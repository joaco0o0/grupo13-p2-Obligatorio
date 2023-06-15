package uy.edu.um.adt.ENTITIES;

import uy.edu.um.adt.TADS.MyLinkedList.MyLinkedList;

public class Tweet {
    private long tweetNumber;
    private long userCode;
    private String text;
    private boolean retweeted;
    private int favorites;
    private Fecha date;
    private MyLinkedList<Hashtag> hashtags;

    public Tweet(long tweetNumber, long  userCode, String text, boolean retweeted, int favorites, Fecha date, MyLinkedList<Hashtag> hashtags) {
        this.tweetNumber = tweetNumber;
        this.userCode = userCode;
        this.text = text;
        this.retweeted = retweeted;
        this.favorites = favorites;
        this.date = date;
        this.hashtags = hashtags;
    }
}