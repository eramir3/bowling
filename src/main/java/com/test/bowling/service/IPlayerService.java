package com.test.bowling.service;

import com.test.bowling.domain.Player;

public interface IPlayerService {

	public Player calculateScore(Player player);
	
	public int calculateStrike(Player player, int i);
	
	public int calculateSpare(Player player, int i);
	
}
