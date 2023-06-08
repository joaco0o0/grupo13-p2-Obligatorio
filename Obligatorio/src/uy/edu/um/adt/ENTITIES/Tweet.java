package uy.edu.um.adt.ENTITIES;

public class Tweet {

    private int tweetNumber;
    private String userName;
    private String userDescription;
    private int userCreated;
    private int userFollowers;
    private int userFriends;
    private long userFavourites;
    private boolean userVerified;
    private String date;
    private String text;
    private String hashtags;
    private String source;
    private boolean isRetweet;

    public Tweet(String tweetNumber, String userName, String userDescription, String userCreated, String userFollowers, String userFriends, String userFavourites, String userVerified, String date, String text, String hashtags, String source, String isRetweet) {
        this.tweetNumber = Integer.parseInt(tweetNumber);
        this.userName = userName;
        this.userDescription = userDescription;
        this.userCreated = Integer.parseInt(userCreated);
        this.userFollowers = Integer.parseInt(userFollowers);
        this.userFriends = Integer.parseInt(userFriends);
        this.userFavourites = Long.parseLong(userFavourites);
        this.userVerified = Boolean.parseBoolean(userVerified);
        this.date = date;
        this.text = text;
        this.hashtags = hashtags;
        this.source = source;
        this.isRetweet = Boolean.parseBoolean(isRetweet);
    }

    public int getTweetNumber() {
        return tweetNumber;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserDescription() {
        return userDescription;
    }

    public int getUserCreated() {
        return userCreated;
    }

    public int getUserFollowers() {
        return userFollowers;
    }

    public int getUserFriends() {
        return userFriends;
    }

    public long getUserFavourites() {
        return userFavourites;
    }

    public boolean isUserVerified() {
        return userVerified;
    }

    public String getDate() {
        return date;
    }

    public String getText() {
        return text;
    }

    public String getHashtags() {
        return hashtags;
    }

    public String getSource() {
        return source;
    }

    public boolean isRetweet() {
        return isRetweet;
    }
}
