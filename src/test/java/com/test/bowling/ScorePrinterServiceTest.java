package com.test.bowling;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.test.bowling.domain.Player;
import com.test.bowling.domain.Roll;
import com.test.bowling.service.impl.ScorePrinterService;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ScorePrinterServiceTest {

	@Autowired
	ScorePrinterService printer;
	
	// Jeff
	Player player1;
		
	// John
	Player player2;
		
	// Carl (Perfect score)
	Player player3;
		
	// Tom (Zero score)
	Player player4;
	
	
//	public void setupScenario1() {
//		
//		player1 = new Player("Jeff", 1);
//		player1.setFrames(new int[10]);
//		player1.getFrames()[0] = 20;
//		player1.getFrames()[1] = 39;
//		player1.getFrames()[2] = 48;
//		player1.getFrames()[3] = 66;
//		player1.getFrames()[4] = 74;
//		player1.getFrames()[5] = 84;
//		player1.getFrames()[6] = 90;
//		player1.getFrames()[7] = 120;
//		player1.getFrames()[8] = 148;
//		player1.getFrames()[9] = 167;
//		
//		Roll[] rolls = new Roll[21];
//		int[] scores = new int[]{10,-1,7,3,9,0,10,-1,0,8,8,2,0,6,10,-1,10,-1,10,8,1};
//		
//		for(int i = 0; i < scores.length; i++) {
//			Roll roll = new Roll();
//			roll.setPinfalls(scores[i]);
//			rolls[i] = roll;
//		}
//		
//		player1.setRolls(rolls);
//	}
//	
//	public void setupScenario2() {
//		
//		player2 = new Player("John", 2);
//		player2.setFrames(new int[10]);
//		player2.getFrames()[0] = 16;
//		player2.getFrames()[1] = 25;
//		player2.getFrames()[2] = 44;
//		player2.getFrames()[3] = 53;
//		player2.getFrames()[4] = 82;
//		player2.getFrames()[5] = 101;
//		player2.getFrames()[6] = 110;
//		player2.getFrames()[7] = 124;
//		player2.getFrames()[8] = 132;
//		player2.getFrames()[9] = 151;
//		
//		Roll[] rolls = new Roll[21];
//		int[] scores = new int[]{3,7,6,3,10,-1,8,1,10,-1,10,-1,9,0,7,3,4,4,10,9,0};
//		
//		for(int i = 0; i < scores.length; i++) {
//			Roll roll = new Roll();
//			roll.setPinfalls(scores[i]);
//			rolls[i] = roll;
//		}
//		
//		player2.setRolls(rolls);
//	}
//	
//	public void setupScenario3() {
//		
//		player3 = new Player("Carl", 1);
//		player3.setFrames(new int[10]);
//		player3.getFrames()[0] = 30;
//		player3.getFrames()[1] = 60;
//		player3.getFrames()[2] = 90;
//		player3.getFrames()[3] = 120;
//		player3.getFrames()[4] = 150;
//		player3.getFrames()[5] = 180;
//		player3.getFrames()[6] = 210;
//		player3.getFrames()[7] = 240;
//		player3.getFrames()[8] = 270;
//		player3.getFrames()[9] = 300;
//		
//		Roll[] rolls = new Roll[21];
//		int[] scores = new int[]{10,-1,10,-1,10,-1,10,-1,10,-1,10,-1,10,-1,10,-1,10,-1,10,10,10};
//		
//		for(int i = 0; i < scores.length; i++) {
//			Roll roll = new Roll();
//			roll.setPinfalls(scores[i]);
//			rolls[i] = roll;
//		}
//		
//		player3.setRolls(rolls);
//	}
//	
//	public void setupScenario4() {
//		
//		player4 = new Player("Tom", 1);
//		player4.setFrames(new int[10]);
//		player4.getFrames()[0] = 0;
//		player4.getFrames()[1] = 0;
//		player4.getFrames()[2] = 0;
//		player4.getFrames()[3] = 0;
//		player4.getFrames()[4] = 0;
//		player4.getFrames()[5] = 0;
//		player4.getFrames()[6] = 0;
//		player4.getFrames()[7] = 0;
//		player4.getFrames()[8] = 0;
//		player4.getFrames()[9] = 0;
//		
//		Roll[] rolls = new Roll[21];
//		int[] scores = new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
//		
//		for(int i = 0; i < scores.length; i++) {
//			Roll roll = new Roll();
//			roll.setPinfalls(scores[i]);
//			rolls[i] = roll;
//		}
//		
//		player4.setRolls(rolls);
//	}
//	
//	//@Test
//	public void printFrameNumbers() {
//		
//		setupScenario1();
//	
//		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
//	      
//		System.setOut(new PrintStream(outContent));
//
//		printer.printFrameNumbers(player1);
//
//	    String expectedOutput  = "Frame		1		2		3		4		5		6		7		8		9		10		";
//
//	    assertEquals(expectedOutput, outContent.toString());
//	}
//	
//	//@Test
//	public void printFramesPlayer1() {
//		
//		setupScenario1();
//		
//		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
//	      
//		System.setOut(new PrintStream(outContent));
//
//		for(int i = 0; i < player1.getRolls().length - 3; i++) {
//			//printer.printFrames(player1, i);
//		}
//
//	    String expectedOutput  = "	X	7	/	9	0		X	0	8	8	/	0	6		X		X	";
//
//	    assertEquals(expectedOutput, outContent.toString());
//	}
//	
//	//@Test
//	public void printScoresPlayer1() {
//		
//		setupScenario1();
//		
//		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
//	      
//		System.setOut(new PrintStream(outContent));
//
//		//printer.printScores(player1);
//
//	    String expectedOutput  = "Score		20		39		48		66		74		84		90		120		148		167		";
//
//	    assertEquals(expectedOutput, outContent.toString());
//	}
//	
//	//@Test
//	public void printFramesPlayer2() {
//		
//		setupScenario2();
//		
//		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
//	      
//		System.setOut(new PrintStream(outContent));
//
//		for(int i = 0; i < player2.getRolls().length - 3; i++) {
//			//printer.printFrames(player2, i);
//		}
//
//	    String expectedOutput  = "3	/	6	3		X	8	1		X		X	9	0	7	/	4	4	";
//
//	    assertEquals(expectedOutput, outContent.toString());
//	}
//	
//	//@Test
//	public void printScoresPlayer2() {
//		
//		setupScenario2();
//		
//		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
//	      
//		System.setOut(new PrintStream(outContent));
//
//		//printer.printScores(player2);
//
//	    String expectedOutput  = "Score		16		25		44		53		82		101		110		124		132		151		";
//
//	    assertEquals(expectedOutput, outContent.toString());
//	}
//	
//	//@Test
//	public void printFramesPlayer3() {
//		
//		setupScenario3();
//		
//		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
//	      
//		System.setOut(new PrintStream(outContent));
//
//		for(int i = 0; i < player3.getRolls().length - 3; i++) {
//			//printer.printFrames(player3, i);
//		}
//
//	    String expectedOutput  = "	X		X		X		X		X		X		X		X		X	";
//
//	    assertEquals(expectedOutput, outContent.toString());
//	}
//	
//	//@Test
//	public void printScoresPlayer3() {
//		
//		setupScenario3();
//		
//		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
//	      
//		System.setOut(new PrintStream(outContent));
//
//		//printer.printScores(player3);
//
//	    String expectedOutput  = "Score		30		60		90		120		150		180		210		240		270		300		";
//
//	    assertEquals(expectedOutput, outContent.toString());
//	}
//	
//	//@Test
//	public void printFramesPlayer4() {
//		
//		setupScenario4();
//		
//		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
//	      
//		System.setOut(new PrintStream(outContent));
//
//		for(int i = 0; i < player4.getRolls().length - 3; i++) {
//			//printer.printFrames(player4, i);
//		}
//
//	    String expectedOutput  = "0	0	0	0	0	0	0	0	0	0	0	0	0	0	0	0	0	0	";
//
//	    assertEquals(expectedOutput, outContent.toString());
//	}
//	
//	//@Test
//	public void printScoresPlayer4() {
//		
//		setupScenario4();
//		
//		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
//	      
//		System.setOut(new PrintStream(outContent));
//
//		//printer.printScores(player4);
//
//	    String expectedOutput  = "Score		0		0		0		0		0		0		0		0		0		0		";
//
//	    assertEquals(expectedOutput, outContent.toString());
//	}
}
