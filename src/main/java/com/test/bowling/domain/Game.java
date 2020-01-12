package com.test.bowling.domain;

import java.util.Map.Entry;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.test.bowling.service.IFileHandlerService;
import com.test.bowling.service.IPlayerService;
import com.test.bowling.service.IScorePrinterService;

@Component
public class Game {
	
	private final static Logger LOGGER = Logger.getLogger(Game.class.getName());

	@Autowired
	private IPlayerService playerService;
	
	@Autowired
	private IFileHandlerService fileHandler;
	
	@Autowired
	private IScorePrinterService printer;
	
	
	public void loadGameData() {
		
		try {
			
			fileHandler.loadPlayers("files/bowling_scores.txt");
			
			for(Entry<String, Player> me : fileHandler.getPlayers().entrySet()) {
				
				Player player = me.getValue();
				
				for(int i = 0; i < player.getFrames().length; i++) {
					playerService.calculateScore(player);
				}
				
				printer.printScoreTable(player); 
		    }
		} 
		catch (Exception e) {
			LOGGER.log(Level.SEVERE, e.getMessage());
			e.printStackTrace();
		}
	}
}
