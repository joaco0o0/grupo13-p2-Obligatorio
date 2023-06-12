package uy.edu.um.adt.ENTITIES;

import uy.edu.um.adt.TADS.MyLinkedList.Mylist;

public class Tweet {
    private long tweetNumber;
    private long userCode;
    private String text;
    private String source;
    private boolean retweeted;
    private String favorites;
    private Fecha date;
    private String[] hashtags;

    public Tweet(long tweetNumber, long userCode, String text, String source, boolean retweeted, String favorites, Fecha date, String[] hashtags) {
        this.tweetNumber = tweetNumber;
        this.userCode = userCode;
        this.text = text;
        this.source = source;
        this.retweeted = retweeted;
        this.favorites = favorites;
        this.date = date;
        this.hashtags = hashtags;
    }
}