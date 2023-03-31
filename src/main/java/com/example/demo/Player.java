package com.example.demo;

public class Player {
    private String fName;
    private String lName;

    public Player(String fName, String lName, int goals) {
        this.fName = fName;
        this.lName = lName;
        this.goals = goals;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    private int goals;
}
