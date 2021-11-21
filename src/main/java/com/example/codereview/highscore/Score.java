package com.example.codereview.highscore;

public class Score {
    private String player;
    private int numGuesses;

    Score(String player, int numGuesses) {
        this.player = player;
        this.numGuesses = numGuesses;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public void setNumGuesses(int numGuesses) {
        this.numGuesses = numGuesses;
    }

    public String getPlayer() {
        return player;
    }

    public int getNumGuesses() {
        return numGuesses;
    }

    @Override
    public String toString() {
        return "Score{" +
                "player='" + player + '\'' +
                ", numGuesses=" + numGuesses +
                '}';
    }
}
