package com.example.codereview;

import com.example.codereview.game.Game;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.io.IOException;


@Configuration
@SpringBootApplication
public class CodeReviewApplication {
    public static void main(String[] args) {
        SpringApplication.run(CodeReviewApplication.class, args);

    }

}
