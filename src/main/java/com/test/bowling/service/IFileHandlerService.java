package com.test.bowling.service;

import com.test.bowling.domain.Player;

public interface IFileHandlerService {
	
	public void loadPlayers(String fileName) throws Exception;
	
	public void loadPlayerScores(Player player, String fileName) throws Exception;
	
	public void openFile(String fileName) throws Exception;
    
    public void closeFile();
    
    public Player getPlayer1();

	public Player getPlayer2();
}
