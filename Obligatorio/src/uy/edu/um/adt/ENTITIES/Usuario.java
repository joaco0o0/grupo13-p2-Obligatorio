package uy.edu.um.adt.ENTITIES;

import uy.edu.um.adt.TADS.MyLinkedList.MyLinkedList;
import uy.edu.um.adt.TADS.MyLinkedList.Mylist;

public class Usuario {
    private String userName;
    private long userCode;
    private boolean verified;
    private Mylist<Tweet> tweets;

    public Usuario(String userName, long userCode, boolean verified) {
        this.userName = userName;
        this.userCode = userCode;
        this.verified = verified;
        this.tweets = new MyLinkedList<>();
    }

    public void addTweet(Tweet tweet){
        tweets.add(tweet);
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj){
            return true;
        }
        Usuario other = (Usuario) obj;
        return userCode == other.userCode && userName.equals(other.userName);
    }

}