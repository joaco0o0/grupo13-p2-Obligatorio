package uy.edu.um.adt.ENTITIES;

import uy.edu.um.adt.TADS.MyLinkedList.MyLinkedList;
import uy.edu.um.adt.TADS.MyLinkedList.Mylist;

public class Usuario {
    private String user_name;
    private long id;
    private int followers;
    private boolean verified;
    private Mylist<Tweet> tweets;

    public Usuario(String userName, long userCode, int followers,boolean verified) {
        this.user_name = userName;
        this.id = userCode;
        this.followers = followers;
        this.verified = verified;
        this.tweets = new MyLinkedList<>();
    }
}
