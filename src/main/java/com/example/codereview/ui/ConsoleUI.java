package com.example.codereview.ui;

import com.example.codereview.highscore.Score;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.IntStream;

public class ConsoleUI {

    public String askForPlayerName() {
        System.out.println("Enter player name: ");
        Scanner input = new Scanner(System.in);
        String player = input.nextLine();
        System.out.println(String.format("Welcome %s", player));
        return player;
    }

    public void showInstructions() {
        System.out.println("\n--- Welcome to Guessing Game ---");
        System.out.println("\nI am thinking of a number between 0 and 1000, your job is to guess the number!");
    }

    public int askForNumberFromPlayer() {
        System.out.println("What is your guess? ");
        Scanner input = new Scanner(System.in);
        return input.nextInt();
    }

    public void promptHigher() {
        System.out.println("Incorrect, my number is higher.");
    }

    public void promptLower() {
        System.out.println("Incorrect, my number is lower.");
    }

    public void correct(Integer numberOfGuesses) {
        System.out.println("Congratulations, you guessed it in " + numberOfGuesses + " rounds");
    }

    public void showHighscores(List<Score> scores) {
        System.out.println(String.format("\n%25s", "--- Highscore ---"));
        System.out.println(String.format("Pos %15s %15s", "Player", "Guesses"));
        StringBuilder b = new StringBuilder();
        scores.sort(Comparator.comparing(Score::getNumGuesses));
        IntStream.range(0, scores.size())
                .forEach(i -> {
                    Score score = scores.get(i);
                    b.append(String.format("%d, %15s %15d \n", i + 1, score.getPlayer(), score.getNumGuesses()));
                });
        System.out.println(b);
    }

    public boolean askForAnotherGame() {
        System.out.println("Play again? (Y/N): ");
        Scanner input = new Scanner(System.in);
        String yesOrNo = input.nextLine();
        return yesOrNo.equals("Y");
    }

    public void showGuesses(List<Integer> guesses) {
        System.out.println("Num guesses = " + guesses.size());
        System.out.println("Your guesses = " + guesses);
    }

    public void sayGoodbye() {
        System.out.println("Thanks for playing!");
    }

    public boolean shouldClearScores() {
        System.out.println("Clear scores? (Y/N)");
        Scanner input = new Scanner(System.in);
        String yesOrNo = input.nextLine();
        return yesOrNo.equals("Y");
    }
}
