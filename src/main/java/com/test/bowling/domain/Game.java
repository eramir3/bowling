package com.test.bowling.domain;

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
	
	private Player player1;
	
	private Player player2;

	
	public void loadGameData() {
		
		try {
			
			fileHandler.loadPlayers("files/bowling_scores.txt");
			player1 = fileHandler.getPlayer1();
			player2 = fileHandler.getPlayer2();
			
			if(player1 != null) {
				playerService.calculateScore(player1);
				printer.printScoreTable(player1);
			}
			
			if(player2 != null) {
				playerService.calculateScore(player2);
				printer.printScoreTable(player2);
			}
			System.out.println();
		} 
		catch (Exception e) {
			LOGGER.log(Level.SEVERE, e.getMessage());
			e.printStackTrace();
		}
	}
}
