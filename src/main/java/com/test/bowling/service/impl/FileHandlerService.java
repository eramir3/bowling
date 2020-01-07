package com.test.bowling.service.impl;

import java.io.File;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import com.test.bowling.domain.Player;
import com.test.bowling.domain.Roll;
import com.test.bowling.service.IFileHandlerService;
import com.test.bowling.utils.BowlingConstants;

@Service
public class FileHandlerService implements IFileHandlerService {
	
	private Scanner scanner;
	
	private Player player1;
	
	private Player player2;
	
	
	public void loadPlayers(String filename) throws Exception {
		
		openFile(filename);
		
		while(scanner.hasNext()) {
			
			String name = scanner.next();
    		scanner.next();
    		
    		if(player1 == null)
    			player1 = new Player(name, 1);
    		
    		if(player1 != null && !player1.getName().equals(name))
    			player2 = new Player(name, 2);
    		
    		if(player1 != null && player2 != null)
    			break;
		}
		
		closeFile();
		
		if(player1 != null)
			loadPlayerScores(player1, filename);
		
		if(player2 != null)
			loadPlayerScores(player2, filename);
	}
	
	public void loadPlayerScores(Player player, String fileName) throws Exception {
		
		openFile(fileName);
		
		int attempt = 0;
		
    	while(scanner.hasNext()) {
    		
    		// name of player
    		String name = scanner.next();
    		
    		// pinfalls
    		String pinfallsData = scanner.next();
    		
    		if(!name.equals(player.getName()))
    			continue;
    		
    		if(attempt > BowlingConstants.MAX_ATTEMPTS_ALLOWED) {
    			throw new Exception("File has more rolls than allowed for player " + player.getName());
    		}
    		
    		int pinfalls = 0;
    		
    		if(!pinfallsData.equals("F")) {
    			try {
    				pinfalls = Integer.parseInt(pinfallsData);
    		    } 
    			catch (NumberFormatException nfe) {
    		        throw new NumberFormatException("Invalid pinfall score on file for player " + player.getName());
    		    }
    		}
    		
    		if(pinfalls < BowlingConstants.MIN_PINFALL_SCORE || pinfalls > BowlingConstants.MAX_PINFALL_SCORE) {
    			throw new Exception("Invalid pinfall score " + pinfalls + " on file" );
    		}
    		
    		Roll roll = new Roll();
    		roll.setPinfalls(pinfalls);
			
    		player.getRolls()[attempt] = roll;
    		
    		if(pinfalls == BowlingConstants.MAX_PINFALL_SCORE 
    				&& attempt < 17 && attempt % 2 == 0) {
    			
    			Roll roll2 = new Roll();
        		roll2.setPinfalls(BowlingConstants.EMPTY_ROLL);
    			player.getRolls()[++attempt] = roll2;
    		}
    		
    		attempt++;
    	}
		
    	if(attempt < BowlingConstants.MIN_ATTEMPTS_ALLOWED) {
			throw new Exception("Please enter all frame scores to calculate final score of player " + player.getName());
		}
    	
    	closeFile();
	}
	
	public void openFile(String fileName) throws Exception {
				
		try {
        	scanner = new Scanner(new File(fileName));
        }
        catch(Exception e) {
        	throw new Exception("Could not find file");
        }
	}
    
    public void closeFile() {
    	scanner.close();
    }
    
    public Player getPlayer1() {
		return player1;
	}

	public Player getPlayer2() {
		return player2;
	}

}
