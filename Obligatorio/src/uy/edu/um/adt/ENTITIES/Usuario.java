package uy.edu.um.adt.ENTITIES;

import uy.edu.um.adt.TADS.MyHash.MyHash;
import uy.edu.um.adt.TADS.MyHash.MyHashImpl;
import uy.edu.um.adt.TADS.MyLinkedList.MyLinkedList;
import uy.edu.um.adt.TADS.MyLinkedList.Mylist;



public class Usuario {
    private String userName;
    private Long userCode;
    private boolean verified;
    private Mylist<Tweet> tweets;
    private Long favoritos;

    public Usuario(String userName, Long userCode, boolean verified) {
        this.userName = userName;
        this.userCode = userCode;
        this.verified = verified;
        this.tweets = new MyLinkedList<>();
        this.favoritos = 0L;
    }

    public void addTweet(Tweet tweet){
        tweets.add(tweet);
    }

    public void addFavoritos(Long favoritos){
        this.favoritos += favoritos;
    }

    public Mylist<Tweet> getTweets() {
        return tweets;
    }

    public boolean isVerified() {
        return verified;
    }

    public String getUserName() {
        return userName;
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