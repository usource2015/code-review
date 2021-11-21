package com.example.codereview.highscore;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileHighscore {

    private final String highscoreFile;

    public FileHighscore() {
        this("src/main/java/com/example/codereview/highscore/highscore.txt");
    }

    public FileHighscore(String highscoreFile) {
        this.highscoreFile = highscoreFile;
    }

    public void addScore(String player, int numGuesses) throws IOException {
        List<Score> scores = load();
        Score existingScore = getScoreForPlayer(player);
        if (existingScore == null) {
            scores.add(new Score(player, numGuesses));
            store(scores);
        } else if (numGuesses < existingScore.getNumGuesses()) {
            scores.removeIf(score -> score.getPlayer().equals(player));
            scores.add(new Score(player, numGuesses));
            store(scores);
        }
    }

    public List<Score> getScores() throws IOException {
        return load();
    }

    public void clearScores() throws IOException {
        clear();
    }

    private Score getScoreForPlayer(String player) throws IOException {
        for (Score score : getScores()) {
            if (score.getPlayer().equals(player)) {
                return score;
            }
        }
        return null;
    }

    private List<Score> load() throws IOException {
        // load scores from file
        List<Score> scores = new ArrayList<>();
        File file = new File(highscoreFile);
        if (!file.exists() && !file.createNewFile()) {
            throw new IOException("No highscore file");
        }
        Stream<String> lines = Files.lines(file.toPath());
        lines.forEach(line -> scores.add(parseLine(line)));
        lines.close();
        return scores;
    }

    private Score parseLine(String line) {
        // parse score from line
        String[] nameAndGuesses = line.split(":");
        return new Score(nameAndGuesses[0], Integer.parseInt(nameAndGuesses[1]));
    }

    private void store(List<Score> scores) throws IOException {
        // save scores to file
        File file = new File(highscoreFile);
        if (!file.exists() && !file.createNewFile()) {
            throw new IOException("No highscore file");
        }
        PrintWriter writer = new PrintWriter(file);
        String output = scores.stream()
                .map(score -> String.format("%s:%d", score.getPlayer(), score.getNumGuesses()))
                .collect(Collectors.joining("\n"));
        writer.print(output);
        writer.close();
    }

    private void clear() throws IOException {
        // clear scores in file
        File file = new File(highscoreFile);
        if (!file.exists() && !file.createNewFile()) {
            throw new IOException("No highscore file");
        }
        PrintWriter writer = new PrintWriter(file);
        writer.write("");
    }
}
