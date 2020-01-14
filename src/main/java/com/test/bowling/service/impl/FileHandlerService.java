package com.test.bowling.service.impl;

import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

import org.springframework.stereotype.Service;

import com.test.bowling.domain.Frame;
import com.test.bowling.domain.Player;
import com.test.bowling.domain.Roll;
import com.test.bowling.service.IFileHandlerService;
import com.test.bowling.utils.BowlingConstants;

@Service
public class FileHandlerService implements IFileHandlerService {
	
	private Scanner scanner;
	
	private HashMap<String, Player> players;
	
	
	public void loadPlayers(String filename) throws Exception {
		
		players = new HashMap<String, Player>();
		int playerNumber = 0;
		
		openFile(filename);
		
		while(scanner.hasNext()) {
			
			String name = scanner.next();
			String pinfallsData = scanner.next();
			int pinfalls = 0 ;
			boolean failed = false;
			
			Player player = players.containsKey(name) ? players.get(name) : null;
			
			if(player == null) {
				
				player = new Player(name, ++playerNumber);
				for(int i = 0; i < player.getFrames().length; i++) {
					
					Frame frame = null;
					
					if(i == BowlingConstants.LAST_FRAME) {
						 frame = new Frame(i, BowlingConstants.ROLLS_PER_FRAME + 1);
					}
					else {
						 frame = new Frame(i, BowlingConstants.ROLLS_PER_FRAME);
					}
					
					player.getFrames()[i] = frame;
				}
				
				players.put(name, player);
			}
			
			if(!pinfallsData.equals("F")) {
    			try {
    				pinfalls = Integer.parseInt(pinfallsData);
    		    } 
    			catch (NumberFormatException nfe) {
    		        throw new NumberFormatException("Invalid pinfall score on file for player " + player.getName());
    		    }
    		}
			else {
				failed = true;
			}
			
			if(pinfalls < BowlingConstants.MIN_PINFALL_SCORE || pinfalls > BowlingConstants.MAX_PINFALL_SCORE) {
    			throw new Exception("Invalid pinfall score " + pinfalls + " on file" );
    		}
			
			// Bonus roll
			if(player.getFrames()[BowlingConstants.LAST_FRAME].getRolls()[BowlingConstants.ROLL_2] != null) {
				
				
				if(player.getFrames()[BowlingConstants.LAST_FRAME].getRolls()[BowlingConstants.BONUS_ROLL] != null) {
					throw new Exception("File has more rolls than allowed for player " + player.getName());
				}
				
							
				if(player.getFrames()[BowlingConstants.LAST_FRAME].getRolls()[BowlingConstants.ROLL_1].getPinfalls() 
						+ player.getFrames()[BowlingConstants.LAST_FRAME].getRolls()[BowlingConstants.ROLL_2].getPinfalls() < BowlingConstants.MAX_PINFALL_SCORE) {
					throw new Exception("No bonus roll allowed for player " + player.getName());
				}
							
				Roll bonusRoll = new Roll(pinfalls, failed);
				player.getFrames()[BowlingConstants.LAST_FRAME].getRolls()[BowlingConstants.BONUS_ROLL] = bonusRoll;
				continue;
			}
			
			for(int i = 0; i < player.getFrames().length; i++) {
				
				if(!player.getFrames()[i].isAvailable())
					continue;
				
				if(player.getFrames()[i].getRolls()[BowlingConstants.ROLL_1] == null) {
					
					Roll roll1 = new Roll(pinfalls, failed);
					player.getFrames()[i].getRolls()[BowlingConstants.ROLL_1] = roll1;
					
					if(pinfalls == BowlingConstants.MAX_PINFALL_SCORE && player.getFrames()[i].getNumber() < BowlingConstants.LAST_FRAME) {
						Roll roll2 = new Roll(BowlingConstants.EMPTY_ROLL, false);
						player.getFrames()[i].getRolls()[BowlingConstants.ROLL_2] = roll2;
						player.getFrames()[i].setAvailable(false);
					}
				}
				else {
					Roll roll = new Roll(pinfalls, failed);
					player.getFrames()[i].getRolls()[BowlingConstants.ROLL_2] = roll;
					player.getFrames()[i].setAvailable(false);
				}	
				
				break;
			}
		}
		
		closeFile();
	}
	
	public HashMap<String, Player> getPlayers() {
		return players;
	}

	public void setPlayers(HashMap<String, Player> players) {
		this.players = players;
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
    
}
