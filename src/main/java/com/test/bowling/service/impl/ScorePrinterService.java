package com.test.bowling.service.impl;

import org.springframework.stereotype.Service;

import com.test.bowling.domain.Player;
import com.test.bowling.service.IScorePrinterService;
import com.test.bowling.utils.BowlingConstants;

@Service
public class ScorePrinterService implements IScorePrinterService{

	public void printScoreTable(Player player) {
		
		printFrameNumbers(player);
		printPlayerName(player);
		printFrames(player);
		printLastFrame(player);
		printScores(player);
	}
	
	public void printFrameNumbers(Player player) {
		
		if(player.getNumber() == BowlingConstants.PLAYER_ONE) {
			System.out.print("Frame		");
			for(int i = 0; i < BowlingConstants.LAST_FRAME + 1; i++) {
				System.out.print(i + 1 + "		");
			}
		}
		System.out.println();
	}
	
	public void printPlayerName(Player player) {
		System.out.println(player.getName());
	}
	
	public void printFrames(Player player) {
		
		System.out.print("Pinfalls	");
		
		for(int i = 0; i < player.getFrames().length - 1; i++) {
			
			int playerScoreRoll1 = player.getFrames()[i].getRoll1().getPinfalls();
			int playerScoreRoll2 = player.getFrames()[i].getRoll2().getPinfalls();
			
			if(playerScoreRoll1 == BowlingConstants.MAX_PINFALL_SCORE) {
				System.out.print("	X	");
				
			}
			else if(playerScoreRoll1 + playerScoreRoll2 == BowlingConstants.MAX_PINFALL_SCORE) {
				
				System.out.print(playerScoreRoll1 + "	");
				System.out.print(" /	");
			}
			else {
				
				if(player.getFrames()[i].getRoll1().isFailed()) {
					System.out.print("F	");
				}
				else {
					System.out.print(playerScoreRoll1 + "	");
				}
				
				if(player.getFrames()[i].getRoll2().isFailed()) {
					System.out.print("F	");
				}
				else {
					System.out.print(playerScoreRoll2 + "	");
				}
			}
		}
	}
	
	public void printLastFrame(Player player) {
		
		int playerScoreRoll1 = player.getFrames()[BowlingConstants.LAST_FRAME].getRoll1().getPinfalls();
		int playerScoreRoll2 = player.getFrames()[BowlingConstants.LAST_FRAME].getRoll2().getPinfalls();
		int playerBonusRoll = player.getBonusRoll() != null ? player.getBonusRoll().getPinfalls() : BowlingConstants.EMPTY_ROLL;
		
		// Roll 1
		if(playerScoreRoll1 == BowlingConstants.MAX_PINFALL_SCORE) {
			System.out.print("X	");
		}
		else {
			if(player.getFrames()[BowlingConstants.LAST_FRAME].getRoll1().isFailed()) {
				System.out.print("F	");
			}
			else {
				System.out.print(playerScoreRoll1 + "	");
			}
		}
		
		// Roll 2
		if(playerScoreRoll2 == BowlingConstants.MAX_PINFALL_SCORE) {
			System.out.print("X	");
		}
		else {
			
			if(playerScoreRoll1 + playerScoreRoll2 == BowlingConstants.MAX_PINFALL_SCORE && playerScoreRoll1 != BowlingConstants.MAX_PINFALL_SCORE) {
				System.out.print("/	");
			}
			if(player.getFrames()[BowlingConstants.LAST_FRAME].getRoll2().isFailed()) {
				System.out.print("F	");
			}
			else {
				System.out.print(playerScoreRoll2 + "	");
			}
		}
		
		// Bonus roll
		if(playerBonusRoll == BowlingConstants.MAX_PINFALL_SCORE) {
			System.out.print("X	");
		}
		else if(playerBonusRoll != BowlingConstants.EMPTY_ROLL) {
			
			if(playerScoreRoll2 + playerBonusRoll == BowlingConstants.MAX_PINFALL_SCORE && playerScoreRoll2 != BowlingConstants.MAX_PINFALL_SCORE) {
				System.out.print("/	");
			}
			else if(player.getBonusRoll().isFailed()) {
				System.out.print("F	");
			}
			else {
				System.out.print(playerBonusRoll + "	");
			}
		}
		
		System.out.println();
	}
	
	public void printScores(Player player) {
		
		System.out.print("Score		");
		
		for(int i = 0; i < player.getFrames().length; i++) {
			System.out.print(player.getFrames()[i].getScore() + "		");
		}
	}
}
