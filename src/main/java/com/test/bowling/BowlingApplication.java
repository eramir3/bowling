package com.test.bowling;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.test.bowling.domain.Game;

@SpringBootApplication
public class BowlingApplication implements CommandLineRunner {
	
	@Autowired
	private Game game;
	
	public static void main(String[] args) throws Exception {
		SpringApplication app = new SpringApplication(BowlingApplication.class);
		app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
	}
	
	@Override
    public void run(String... args) throws Exception {
		game.loadGameData();
    }
}
