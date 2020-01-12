package com.test.bowling.service;

import com.test.bowling.domain.Player;

public interface IScorePrinterService {

	public void printFrameNumbers();
	
	public void printPlayerData(Player player);
	
}
