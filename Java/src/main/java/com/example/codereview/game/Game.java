package com.example.codereview.game;

import com.example.codereview.highscore.FileHighscore;
import com.example.codereview.model.user.User;
import com.example.codereview.service.UserService;
import com.example.codereview.ui.ConsoleUI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Component
public class Game {
    @Autowired
    private UserService userService;

    private ConsoleUI consoleUI;
    private FileHighscore highscore;
    private int number;
    private List<Integer> guesses;

    public Game() {
        consoleUI = new ConsoleUI();
        highscore = new FileHighscore();
    }

    public void start() throws IOException {
        consoleUI.showInstructions();

        String player = consoleUI.askForPlayerName();
        if (player.equals("admin")) {
            if (consoleUI.shouldClearScores()) {
                highscore.clearScores();
            }
            return;
        }

        while (true) {
            startRound();
            highscore.addScore(player, guesses.size());
            consoleUI.showGuesses(guesses);
            consoleUI.showHighscores(highscore.getScores());
            boolean playAgain = consoleUI.askForAnotherGame();
            userService.addResult(createUserObject(player,guesses.size()));
            if (!playAgain) {
                consoleUI.sayGoodbye();
                break;
            }
        }
    }

    private User createUserObject(String player, int size) {
        return new User(player,size);
    }

    private void thinkOfNumber() {
        Random rand = new Random();
        number = rand.nextInt(1000);
    }

    private void startRound() {
        guesses = new ArrayList<>();
        thinkOfNumber();
        int guess = consoleUI.askForNumberFromPlayer();
        guesses.add(guess);
        while (guess != number) {
            if (guess < number) {
                consoleUI.promptHigher();
            } else {
                consoleUI.promptLower();
            }
            guess = consoleUI.askForNumberFromPlayer();
            guesses.add(guess);
        }
        consoleUI.correct(guesses.size());
    }
}
