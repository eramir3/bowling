package com.test.bowling.service.impl;

import org.springframework.stereotype.Service;

import com.test.bowling.domain.Player;
import com.test.bowling.service.IPlayerService;
import com.test.bowling.utils.BowlingConstants;

@Service
public class PlayerService implements IPlayerService{

	public int[] calculateScore(Player player) throws Exception {
		
		int section = BowlingConstants.FIRST_FRAME;
		
		for(int i = 0; i < player.getRolls().length; i += 2) {
			
			validateSecondFramePinfall(player, i + 1);
			
			player.getRolls()[i].setFrame(section);
			player.getRolls()[i + 1].setFrame(section);
			
			// Last frame score
			if(section == BowlingConstants.LAST_FRAME) {
				
				if(player.getRolls()[i].getPinfalls() + player.getRolls()[i + 1].getPinfalls() == 10) {
					validateSecondFramePinfall(player, i + 2);
				}
				
				player.getFrames()[section] += calculateLastFrameScore(player, i, section);
				break;
			}
			
			player.getFrames()[section] += player.getRolls()[i].getPinfalls();
			player.getFrames()[section] += player.getRolls()[i + 1].getPinfalls() == BowlingConstants.EMPTY_ROLL ? 0 : player.getRolls()[i + 1].getPinfalls();
			
			validateFrameScoreTotalSum(player, section);
			
			// Strikes
			if(player.getFrames()[section] == BowlingConstants.MAX_PINFALL_SCORE 
					&& player.getRolls()[i].getPinfalls() == BowlingConstants.MAX_PINFALL_SCORE) {
				player.getFrames()[section] += calculateStrike(player, i);
			}
			// Spares
			else if(player.getFrames()[section] == BowlingConstants.MAX_PINFALL_SCORE) {
				player.getFrames()[section] += calculateSpare(player, i);
			}
			
			// Award score to frame
			awardScoreToFrame(player, section);
			
			// Last paired frame
			if(i > 17) 
    			section = BowlingConstants.LAST_FRAME;
    		else
    			section++;
		}
		
		return player.getFrames();
	}
	
	
	public int calculateStrike(Player player, int i) throws Exception {
		
		int pinfalls = 0;
		int aux = 2;
		int j = i + 1;
		
		while(aux > 0) {
			
			if(player.getRolls()[j] == null) {
				throw new Exception("Please enter all frame scores in file for player " + player.getName());
			}
			
			if(player.getRolls()[j].getPinfalls() != -1) {
				pinfalls += player.getRolls()[j].getPinfalls();
				aux--;
			}
			j++;
		}
		
		return pinfalls;
	}
	
	
	public int calculateSpare(Player player, int i) throws Exception {
		
		int pinfalls = 0;
		
		if(player.getRolls()[i + 2] == null) {
			throw new Exception("Please enter all frame scores in file for player " + player.getName());
		}
		
		pinfalls += player.getRolls()[i + 2].getPinfalls();
		
		return pinfalls;
	}
	
	
	public int calculateLastFrameScore(Player player, int i, int section) throws Exception {
		
		int pinfalls = 0;
		
		if(player.getRolls()[i].getPinfalls() + player.getRolls()[i + 1].getPinfalls() > BowlingConstants.MAX_PINFALL_SCORE 
				&& player.getRolls()[i].getPinfalls() != BowlingConstants.MAX_PINFALL_SCORE) {
			throw new Exception("Invalid scores in frame " + (section + 1) + " for player " + player.getName());
		}
		
		if(player.getRolls()[i + 2] != null) {
			
			if(player.getRolls()[i + 1].getPinfalls() + player.getRolls()[i + 2].getPinfalls() > BowlingConstants.MAX_PINFALL_SCORE 
				&& player.getRolls()[i + 1].getPinfalls() != BowlingConstants.MAX_PINFALL_SCORE
				&& player.getRolls()[i].getPinfalls() + player.getRolls()[i + 1].getPinfalls() != BowlingConstants.MAX_PINFALL_SCORE) {
				throw new Exception("Invalid scores in frame " + (section + 1) + " for player " + player.getName());
			}
			
			if(player.getRolls()[i].getPinfalls() + player.getRolls()[i + 1].getPinfalls() < BowlingConstants.MAX_PINFALL_SCORE) {
				throw new Exception("Invalid scores in frame " + (section + 1) + " for player " + player.getName());
			}
			
			if(player.getRolls()[i].getPinfalls() + player.getRolls()[i+1].getPinfalls() >= BowlingConstants.MAX_PINFALL_SCORE) {
				pinfalls += player.getRolls()[i + 2].getPinfalls();
			}
			
			player.getRolls()[i + 2].setFrame(section);
		}
		
		pinfalls += player.getRolls()[i].getPinfalls() + player.getRolls()[i+1].getPinfalls();
		pinfalls += player.getFrames()[section - 1];
		
		return pinfalls;
	}
	
	
	public void awardScoreToFrame(Player player, int section) {
		
		if(section != BowlingConstants.FIRST_FRAME) {
			player.getFrames()[section] += player.getFrames()[section - 1];
		}
	}
	
	
	public void validateSecondFramePinfall(Player player, int pinfalls) throws Exception {
		 
		if(player.getRolls()[pinfalls] == null) {
			throw new Exception("Please enter all frame scores in file for player " + player.getName());
		}
	}
	
	
	public void validateFrameScoreTotalSum(Player player, int section) throws Exception {
		
		if(player.getFrames()[section] > BowlingConstants.MAX_PINFALL_SCORE) {
			throw new Exception("Invalid scores in frame " + (section + 1) + " for player " + player.getName());
		}
	}
}
