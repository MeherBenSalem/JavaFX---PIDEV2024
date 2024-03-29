package com.example.projectpi.entites;

import java.sql.Date;

public class User {
    private int userID;
    private String username;
    private String email;
    private String password;
    private Date dateJoined;

    public User() {
    }

    public User(int userID, String username, String email, String password, Date dateJoined) {
        this.userID = userID;
        this.username = username;
        this.email = email;
        this.password = password;
        this.dateJoined = dateJoined;
    }

    public User(String username, String email, String password, Date dateJoined) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.dateJoined = dateJoined;
    }

    @Override
    public String toString() {
        return "User{" +
                "userID=" + userID +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", dateJoined=" + dateJoined +
                '}';
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDateJoined() {
        return dateJoined;
    }

    public void setDateJoined(Date dateJoined) {
        this.dateJoined = dateJoined;
    }
}
