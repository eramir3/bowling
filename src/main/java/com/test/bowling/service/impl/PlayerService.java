package com.test.bowling.service.impl;

import org.springframework.stereotype.Service;

import com.test.bowling.domain.Player;
import com.test.bowling.service.IPlayerService;
import com.test.bowling.utils.BowlingConstants;

@Service
public class PlayerService implements IPlayerService{

	
	public Player calculateScore(Player player) {
		
		int total = 0;
		
		for(int i = 0; i < player.getFrames().length; i++) {
			
			int scoreRoll1 = player.getFrames()[i].getRoll1().getPinfalls();
			int scoreRoll2 = player.getFrames()[i].getRoll2().getPinfalls() != BowlingConstants.EMPTY_ROLL ? player.getFrames()[i].getRoll2().getPinfalls() : 0;
			
			total = scoreRoll1 + scoreRoll2;
			
			if(scoreRoll1 == BowlingConstants.MAX_PINFALL_SCORE && i != BowlingConstants.LAST_FRAME) {
				total += calculateStrike(player, i + 1);
			}
			else if(scoreRoll1 + scoreRoll2 == BowlingConstants.MAX_PINFALL_SCORE && i != BowlingConstants.LAST_FRAME) {
				total += calculateSpare(player, i + 1);
			}
			
			if(i != BowlingConstants.FIRST_FRAME) {
				total += player.getFrames()[i - 1].getScore();
			}
			
			if(i == BowlingConstants.LAST_FRAME) {
				total += player.getBonusRoll() != null ? player.getBonusRoll().getPinfalls() : 0;
			}
			
			player.getFrames()[i].setScore(total);
		}
		
		return player;
	}
	
	
	public int calculateStrike(Player player, int frame) {
		
		int aux = 2;
		int total = 0;
		
		while(aux > 0) {
			
			int scoreRoll1 = player.getFrames()[frame].getRoll1().getPinfalls();
			int scoreRoll2 = player.getFrames()[frame].getRoll2().getPinfalls();
			
			if(scoreRoll1 != BowlingConstants.EMPTY_ROLL) {
				total += scoreRoll1;
				aux--;
				
				if(aux == 0)
					break;
			}
			
			if(scoreRoll2 != BowlingConstants.EMPTY_ROLL) {
				total += scoreRoll2;
				aux--;
			}
			
			frame++;
		}
		
		return total;
	}
	
	public int calculateSpare(Player player, int frame) {
		
		return player.getFrames()[frame].getRoll1().getPinfalls();
	}
}
