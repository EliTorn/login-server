package com.example.demo;

public class User {
    public String getUserName() {
        return userName;
    }

    public User(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private String userName;
    private String password;

    public boolean isSameUserName(String userName){
        return this.userName.equals(userName);
    }
    public boolean isSamePerson(String userName, String password){
        return this.userName.equals(userName) && this.password.equals(password);
    }
}
