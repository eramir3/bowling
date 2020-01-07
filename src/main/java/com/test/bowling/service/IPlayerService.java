package com.test.bowling.service;

import com.test.bowling.domain.Player;

public interface IPlayerService {

	public int[] calculateScore(Player player) throws Exception;
	
	public int calculateStrike(Player player, int i) throws Exception;
	
	public int calculateSpare(Player player, int i) throws Exception;
	
	public int calculateLastFrameScore(Player player, int i, int section) throws Exception;
	
	public void awardScoreToFrame(Player player, int section);
	
	public void validateSecondFramePinfall(Player player, int pinfalls) throws Exception;
	
	public void validateFrameScoreTotalSum(Player player, int section) throws Exception;
}
