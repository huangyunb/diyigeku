package com.example.couple.entity;

public class Score {
    private String score_username;
    private int score;

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public String getScore_username() {
        return score_username;
    }

    public void setScore_username(String score_username) {
        this.score_username = score_username;
    }

    public Score(String score_username, int score) {
        super();
        this.score_username = score_username;
        this.score = score;
    }
}
