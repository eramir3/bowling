package com.test.bowling.service.impl;

import org.springframework.stereotype.Service;

import com.test.bowling.domain.Player;
import com.test.bowling.service.IScorePrinterService;
import com.test.bowling.utils.BowlingConstants;

@Service
public class ScorePrinterService implements IScorePrinterService{

	public void printScoreTable(Player player) {
		
		printFrameNumbers(player);
		System.out.println();
		System.out.println(player.getName());
		System.out.print("Pinfalls	");
		
		for(int i = 0; i < player.getRolls().length; i++) {
			
			if(player.getRolls()[i] == null)
				continue;
			
			if(player.getRolls()[i].getFrame() < BowlingConstants.LAST_FRAME) {
				printFrames(player, i);
			}
			else {
				printLastFrame(player, i);
			}
		}
		
		System.out.println();
		printScores(player);
	}
	
	public void printFrameNumbers(Player player) {
		if(player.getNumber() == BowlingConstants.PLAYER_ONE) {
			System.out.print("Frame		");
			for(int i = 0; i < BowlingConstants.LAST_FRAME + 1; i++) {
				System.out.print(i + 1 + "		");
			}
		}
	}
	
	public void printScores(Player player) {
		System.out.print("Score		");
		
		for(int i = 0; i < player.getFrames().length; i++) {
			System.out.print(player.getFrames()[i] + "		");
		}
	}
	
	public void printFrames(Player player, int i) {
		
		if(player.getRolls()[i].getPinfalls() == BowlingConstants.MAX_PINFALL_SCORE
				&& i % 2 != 0) {
			System.out.print("/	");
			return;
		}
		
		if(player.getRolls()[i].getPinfalls() == BowlingConstants.MAX_PINFALL_SCORE) {
			System.out.print("	");
			return;
		}
		
		if(player.getRolls()[i].getPinfalls() == BowlingConstants.EMPTY_ROLL) {
			System.out.print("X	");
			return;
		}
		
		if(i != 0 && player.getRolls()[i].getFrame() == player.getRolls()[i - 1].getFrame()) {
			
			if(player.getRolls()[i].getPinfalls() + player.getRolls()[i - 1].getPinfalls() == BowlingConstants.MAX_PINFALL_SCORE) {
				System.out.print("/	");
				return;
			}
		}
			
		System.out.print(player.getRolls()[i].getPinfalls() + "	");
	}
	
	public void printLastFrame(Player player, int i) {
		
		if(i == 20) {
			
			if(player.getRolls()[i].getPinfalls() + player.getRolls()[i - 1].getPinfalls() == BowlingConstants.MAX_PINFALL_SCORE
				&& player.getRolls()[i - 1].getPinfalls() != BowlingConstants.MAX_PINFALL_SCORE
				&& player.getRolls()[i - 2].getPinfalls() + player.getRolls()[i - 1].getPinfalls() != BowlingConstants.MAX_PINFALL_SCORE) {
				System.out.print("/	");
				return;
			}
			
			if(player.getRolls()[i - 2].getPinfalls() == BowlingConstants.MAX_PINFALL_SCORE
					&& player.getRolls()[i - 1].getPinfalls() == BowlingConstants.MIN_PINFALL_SCORE ) {
				System.out.print("/	");
				return;
			}
		}
		
		if(i == 19) {
			
			if(player.getRolls()[i].getPinfalls() + player.getRolls()[i - 1].getPinfalls() == BowlingConstants.MAX_PINFALL_SCORE
				&& player.getRolls()[i - 1].getPinfalls() != BowlingConstants.MAX_PINFALL_SCORE) {
				System.out.print("/	");
				return;
			}
		}
		
		if(player.getRolls()[i].getPinfalls() == BowlingConstants.MAX_PINFALL_SCORE) {
			System.out.print("X	");
			return;
		}
		
		System.out.print(player.getRolls()[i].getPinfalls() + "	");
	}
}
