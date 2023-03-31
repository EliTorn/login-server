package com.example.demo;

import java.util.Random;

public class RandomNumber {
    private int random;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    private String status;

    public RandomNumber() {
        this.random = new Random().nextInt(1000);
        this.status = "ok";
    }

    public int getRandom() {
        return random;
    }

    public void setRandom(int random) {
        this.random = random;
    }
}
