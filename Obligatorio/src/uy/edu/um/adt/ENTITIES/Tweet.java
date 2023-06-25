package uy.edu.um.adt.ENTITIES;

import uy.edu.um.adt.TADS.MyBinaryTree.MySearchBinaryTree;
import uy.edu.um.adt.TADS.MyHash.MyHash;
import uy.edu.um.adt.TADS.MyLinkedList.MyLinkedList;

public class Tweet {
    private long tweetNumber;
    private Long userCode;
    private String text;
    private boolean retweeted;
    private int favorites;
    private Fecha date;
    private MyLinkedList<Hashtag> hashtags;


    public Tweet(long tweetNumber, long userCode, String text, boolean retweeted, int favorites, Fecha date, MyLinkedList<Hashtag> hashtags) {
        this.tweetNumber = tweetNumber;
        this.userCode = userCode;
        this.text = text;
        this.retweeted = retweeted;
        this.favorites = favorites;
        this.date = date;
        this.hashtags = hashtags;
    }

    public long getTweetNumber() {
        return tweetNumber;
    }

    public boolean isRetweeted() {
        return retweeted;
    }

    public int getFavorites() {
        return favorites;
    }

    public MyLinkedList<Hashtag> getHashtags() {
        return hashtags;
    }

    public Long getUserCode() {
        return userCode;
    }

    public String getText() {
        return text;
    }

    public Fecha getFecha() {
        return date;
    }

}