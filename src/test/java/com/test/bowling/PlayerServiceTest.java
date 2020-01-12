package com.test.bowling;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.test.bowling.domain.Player;
import com.test.bowling.domain.Roll;
import com.test.bowling.service.impl.PlayerService;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PlayerServiceTest {

	@Autowired
	PlayerService playerService;
	
	// Jeff
	Player player1;
	
	// John
	Player player2;
	
	// Carl (Perfect score)
	Player player3;
	
	// Tom (Zero score)
	Player player4;
	
	
	private void setupScenario1() {
		
		player1 = new Player("Jeff", 1);
		
		Roll[] rolls = new Roll[21];
		int[] scores = new int[]{10,-1,7,3,9,0,10,-1,0,8,8,2,0,6,10,-1,10,-1,10,8,1};
		
		for(int i = 0; i < scores.length; i++) {
			Roll roll = new Roll();
			roll.setPinfalls(scores[i]);
			rolls[i] = roll;
		}
		
		//player1.setRolls(rolls);
	}
	
	private void setupScenario2() {
		
		player2 = new Player("John", 2);
		
		Roll[] rolls = new Roll[21];
		int[] scores = new int[]{3,7,6,3,10,-1,8,1,10,-1,10,-1,9,0,7,3,4,4,10,9,0};
		
		for(int i = 0; i < scores.length; i++) {
			Roll roll = new Roll();
			roll.setPinfalls(scores[i]);
			rolls[i] = roll;
		}
		
		//player2.setRolls(rolls);
	}
	
	private void setupScenario3() {
		
		player3 = new Player("Carl", 1);
		
		Roll[] rolls = new Roll[21];
		int[] scores = new int[]{10,-1,10,-1,10,-1,10,-1,10,-1,10,-1,10,-1,10,-1,10,-1,10,10,10};
		
		for(int i = 0; i < scores.length; i++) {
			Roll roll = new Roll();
			roll.setPinfalls(scores[i]);
			rolls[i] = roll;
		}
		
		//player3.setRolls(rolls);
	}
	
	private void setupScenario4() {
		
		player4 = new Player("Tom", 1);
		
		Roll[] rolls = new Roll[21];
		int[] scores = new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
		
		for(int i = 0; i < scores.length; i++) {
			Roll roll = new Roll();
			roll.setPinfalls(scores[i]);
			rolls[i] = roll;
		}
		
		//player4.setRolls(rolls);
	}
	
	//@Test
	public void calculateStrikesPlayer1() {
		
		setupScenario1();
		
		int strike1 = 0;
		int strike2 = 0;
		int strike3 = 0;
		int strike4 = 0;
		
		try {
			strike1 = playerService.calculateStrike(player1, 0);
			strike2 = playerService.calculateStrike(player1, 6);
			strike3 = playerService.calculateStrike(player1, 14);
			strike4 = playerService.calculateStrike(player1, 16);
		} 
		catch (Exception e) {
			e.printStackTrace();
			fail("Error calculating strikes of player 1");
		}
		
		assertEquals(10, strike1);
		assertEquals(8, strike2);
		assertEquals(20, strike3);
		assertEquals(18, strike4);
	}
	
	//@Test
	public void calculateSparesPlayer1() {
		
		setupScenario1();
		
		int spare1 = 0;
		int spare2 = 0;
		
		try {
			spare1 = playerService.calculateSpare(player1, 2);
			spare2 = playerService.calculateSpare(player1, 10);
		} 
		catch (Exception e) {
			e.printStackTrace();
			fail("Error calculating spares of player 1");
		}
		
		assertEquals(9, spare1);
		assertEquals(0, spare2);
	}
	
	//@Test
	public void calculateLastFrameScorePlayer1() {
		
		setupScenario1();
		
		int score = 0;
		
		try {
			//score = playerService.calculateLastFrameScore(player1, 18, 9);
		} 
		catch (Exception e) {
			e.printStackTrace();
			fail("Error calculating last frame of player 1");
		}
		
		assertEquals(19, score);
	}
	
	//@Test
	public void calculateStrikesPlayer2() {
		
		setupScenario2();
		
		int strike1 = 0;
		int strike2 = 0;
		int strike3 = 0;
		
		try {
			strike1 = playerService.calculateStrike(player2, 4);
			strike2 = playerService.calculateStrike(player2, 8);
			strike3 = playerService.calculateStrike(player2, 10);
		} 
		catch (Exception e) {
			e.printStackTrace();
			fail("Error calculating strikes of player 2");
		}
		
		assertEquals(9, strike1);
		assertEquals(19, strike2);
		assertEquals(9, strike3);
	}
	
	//@Test
	public void calculateSparesPlayer2() {
		
		setupScenario2();
		
		int spare1 = 0;
		int spare2 = 0;
		
		try {
			spare1 = playerService.calculateSpare(player2, 0);
			spare2 = playerService.calculateSpare(player2, 14);
		} 
		catch (Exception e) {
			e.printStackTrace();
			fail("Error calculating spares of player 2");
		}
		
		assertEquals(6, spare1);
		assertEquals(4, spare2);
	}
	
	//@Test
	public void calculateLastFrameScorePlayer2() {
		
		setupScenario2();
		
		int score = 0;
		
		try {
			//score = playerService.calculateLastFrameScore(player2, 18, 9);
		} 
		catch (Exception e) {
			e.printStackTrace();
			fail("Error calculating last frame of player 2");
		}
		
		assertEquals(19, score);
	}
	
	//@Test
	public void calculateStrikesPlayer3() {
		
		setupScenario3();
		
		int strike1 = 0;
		int strike2 = 0;
		int strike3 = 0;
		int strike4 = 0;
		int strike5 = 0;
		int strike6 = 0;
		int strike7 = 0;
		int strike8 = 0;
		int strike9 = 0;
		
		try {
			strike1 = playerService.calculateStrike(player3, 0);
			strike2 = playerService.calculateStrike(player3, 2);
			strike3 = playerService.calculateStrike(player3, 4);
			strike4 = playerService.calculateStrike(player3, 6);
			strike5 = playerService.calculateStrike(player3, 8);
			strike6 = playerService.calculateStrike(player3, 10);
			strike7 = playerService.calculateStrike(player3, 12);
			strike8 = playerService.calculateStrike(player3, 14);
			strike9 = playerService.calculateStrike(player3, 16);
		} 
		catch (Exception e) {
			e.printStackTrace();
			fail("Error calculating strikes of player 3");
		}
		
		assertEquals(20, strike1);
		assertEquals(20, strike2);
		assertEquals(20, strike3);
		assertEquals(20, strike4);
		assertEquals(20, strike5);
		assertEquals(20, strike6);
		assertEquals(20, strike7);
		assertEquals(20, strike8);
		assertEquals(20, strike9);
	}
	
	//@Test
	public void calculateSparesPlayer3() {
		
		setupScenario3();
		
		int spare1 = 0;
		int spare2 = 0;
		int spare3 = 0;
		int spare4 = 0;
		int spare5 = 0;
		int spare6 = 0;
		int spare7 = 0;
		int spare8 = 0;
		
		try {
			spare1 = playerService.calculateSpare(player3, 1);
			spare2 = playerService.calculateSpare(player3, 3);
			spare3 = playerService.calculateSpare(player3, 5);
			spare4 = playerService.calculateSpare(player3, 7);
			spare5 = playerService.calculateSpare(player3, 5);
			spare6 = playerService.calculateSpare(player3, 11);
			spare7 = playerService.calculateSpare(player3, 13);
			spare8 = playerService.calculateSpare(player3, 15);
		
		} 
		catch (Exception e) {
			e.printStackTrace();
			fail("Error calculating spares of player 3");
			
		}
		
		assertEquals(-1, spare1);
		assertEquals(-1, spare2);
		assertEquals(-1, spare3);
		assertEquals(-1, spare4);
		assertEquals(-1, spare5);
		assertEquals(-1, spare6);
		assertEquals(-1, spare7);
		assertEquals(-1, spare8);
	}
	
	//@Test
	public void calculateLastFrameScorePlayer3() {
		
		setupScenario3();
		
		int score = 0;
		
		try {
			//score = playerService.calculateLastFrameScore(player3, 18, 9);
		} 
		catch (Exception e) {
			e.printStackTrace();
			fail("Error calculating last frame of player 3");
		}
		
		assertEquals(30, score);
	}
	
	//@Test
	public void calculateStrikesPlayer4() {
		
		setupScenario4();
		
		int strike1 = 0;
		int strike2 = 0;
		int strike3 = 0;
		int strike4 = 0;
		int strike5 = 0;
		int strike6 = 0;
		int strike7 = 0;
		int strike8 = 0;
		int strike9 = 0;
		
		try {
			strike1 = playerService.calculateStrike(player4, 0);
			strike2 = playerService.calculateStrike(player4, 2);
			strike3 = playerService.calculateStrike(player4, 4);
			strike4 = playerService.calculateStrike(player4, 6);
			strike5 = playerService.calculateStrike(player4, 8);
			strike6 = playerService.calculateStrike(player4, 10);
			strike7 = playerService.calculateStrike(player4, 12);
			strike8 = playerService.calculateStrike(player4, 14);
			strike9 = playerService.calculateStrike(player4, 16);
		} 
		catch (Exception e) {
			e.printStackTrace();
			fail("Error calculating strikes of player 4");
		}
		
		assertEquals(0, strike1);
		assertEquals(0, strike2);
		assertEquals(0, strike3);
		assertEquals(0, strike4);
		assertEquals(0, strike5);
		assertEquals(0, strike6);
		assertEquals(0, strike7);
		assertEquals(0, strike8);
		assertEquals(0, strike9);
	}
	
	//@Test
	public void calculateSparesPlayer4() {
		
		setupScenario4();
		
		int spare1 = 0;
		int spare2 = 0;
		int spare3 = 0;
		int spare4 = 0;
		int spare5 = 0;
		int spare6 = 0;
		int spare7 = 0;
		int spare8 = 0;
		int spare9 = 0;
		
		try {
			spare1 = playerService.calculateSpare(player4, 0);
			spare2 = playerService.calculateSpare(player4, 2);
			spare3 = playerService.calculateSpare(player4, 4);
			spare4 = playerService.calculateSpare(player4, 6);
			spare5 = playerService.calculateSpare(player4, 8);
			spare6 = playerService.calculateSpare(player4, 10);
			spare7 = playerService.calculateSpare(player4, 12);
			spare8 = playerService.calculateSpare(player4, 14);
			spare9 = playerService.calculateSpare(player4, 16);
		} 
		catch (Exception e) {
			e.printStackTrace();
			fail("Error calculating spares of player 4");
		}
		
		assertEquals(0, spare1);
		assertEquals(0, spare2);
		assertEquals(0, spare3);
		assertEquals(0, spare4);
		assertEquals(0, spare5);
		assertEquals(0, spare6);
		assertEquals(0, spare7);
		assertEquals(0, spare8);
		assertEquals(0, spare9);
	}
	
	//@Test
	public void calculateLastFrameScorePlayer4() {
		
		setupScenario4();
		
		int score = 0;
		
		try {
			//score = playerService.calculateLastFrameScore(player4, 18, 9);
		} 
		catch (Exception e) {
			e.printStackTrace();
			fail("Error calculating last frame of player 4");
		}
		
		assertEquals(0, score);
	}
}
