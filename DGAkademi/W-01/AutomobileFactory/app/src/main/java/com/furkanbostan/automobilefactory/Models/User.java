package com.furkanbostan.automobilefactory.Models;

public class User {
    String userUid;
    String userName;
    String userEmail;

    public User(String userUid, String userName, String userEmail) {
        this.userUid = userUid;
        this.userName = userName;
        this.userEmail = userEmail;
    }

    public String getUserUid() {
        return userUid;
    }

    public void setUserUid(String userUid) {
        this.userUid = userUid;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }
}
