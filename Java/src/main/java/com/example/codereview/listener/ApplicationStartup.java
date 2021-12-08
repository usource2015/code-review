package com.example.codereview.listener;

import com.example.codereview.game.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class ApplicationStartup {
    @Autowired
    private Game game;

    @EventListener(ApplicationReadyEvent.class)
    public void runAfterStartup() throws IOException {
        game.start();
    }
}
