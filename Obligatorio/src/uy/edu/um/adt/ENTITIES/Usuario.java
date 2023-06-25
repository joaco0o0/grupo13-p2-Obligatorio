package uy.edu.um.adt.ENTITIES;

import uy.edu.um.adt.TADS.MyLinkedList.MyLinkedList;
import uy.edu.um.adt.TADS.MyLinkedList.Mylist;



public class Usuario {
    private String userName;
    private Long userCode;
    private boolean verified;
    private Mylist<Tweet> tweets;
    private int favoritos;

    public Usuario(String userName, Long userCode, boolean verified) {
        this.userName = userName;
        this.userCode = userCode;
        this.verified = verified;
        this.tweets = new MyLinkedList<>();
        this.favoritos = 0;
    }

    public String getUserName() {
        return userName;
    }
    public Long getUserCode() {
        return userCode;
    }
    public boolean isVerified() {
        return verified;
    }
    public Mylist<Tweet> getTweets() {
        return tweets;
    }
    public String getNombre() {
        return userName;
    }
    public void addTweet(Tweet tweet){
        tweets.add(tweet);
    }
    public void setFavoritos(int num){
        if(favoritos < num){ favoritos = num;}
    }
    public int getFavoritos(){
        return favoritos;
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