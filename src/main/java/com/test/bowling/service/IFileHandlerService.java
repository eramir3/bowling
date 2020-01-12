package com.test.bowling.service;

import java.util.HashMap;

import com.test.bowling.domain.Player;

public interface IFileHandlerService {
	
	public void loadPlayers(String fileName) throws Exception;
		
	public void openFile(String fileName) throws Exception;
    
    public void closeFile();

	public HashMap<String, Player> getPlayers();
}
