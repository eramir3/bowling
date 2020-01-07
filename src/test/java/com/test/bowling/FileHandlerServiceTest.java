package com.test.bowling;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.test.bowling.domain.Player;
import com.test.bowling.service.impl.FileHandlerService;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class FileHandlerServiceTest {

	@Autowired
	FileHandlerService fileHandler;
	
	// Jeff
	Player player1;
		
	// John
	Player player2;
		
	// Carl (Perfect score)
	Player player3;
		
	// Tom (Zero score)
	Player player4;
	
	private void setupScenario1() {
		player1 = new Player("Carl", 1);
		player2 = new Player("John", 2);
	}
	
	//@Test
	public void loadPlayers() {
		
		try {
			fileHandler.loadPlayers("files/bowling_scores.txt");
			player1 = fileHandler.getPlayer1();
			//player2 = fileHandler.getPlayer2();	
		} 
		catch (Exception e) {
			e.printStackTrace();
			fail("Error parsing file");
		}
	}
	
	//@Test
	public void loadPlayerScores() {
		
		setupScenario1();
		
		try {
			fileHandler.loadPlayerScores(player1, "files/bowling_scores.txt");
			//fileHandler.loadPlayerScores(player2, "files/bowling_scores.txt");
		} 
		catch (Exception e) {
			e.printStackTrace();
			fail("Error parsing file");
		}
	}
	
	/*
	@Test
	public void loadPlayerPerfectScores() {
		
		setupScenario1();
		
		try {
			fileHandler.loadPlayerScores(player1, "files/unit_tests/bowling_scores_perfect_score.txt");
			fileHandler.loadPlayerScores(player2, "files/unit_tests/bowling_scores_perfect_score.txt");
		} 
		catch (Exception e) {
			e.printStackTrace();
			fail("Error parsing file");
		}
	}
	*/
}
