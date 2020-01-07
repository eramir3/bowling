package com.test.bowling.domain;

import com.test.bowling.utils.BowlingConstants;

public class Player {

	private String name;
	
	private int number;
	
	private int[] frames;
	
	private Roll[] rolls;
	
	
	public Player(String name, int number) {
		this.name = name;
		this.number = number;
		this.frames = new int[BowlingConstants.TOTAL_FRAMES];
		this.rolls = new Roll[BowlingConstants.MAX_ATTEMPTS_ALLOWED + 1];
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public Roll[] getRolls() {
		return rolls;
	}

	public void setRolls(Roll[] rolls) {
		this.rolls = rolls;
	}

	public int[] getFrames() {
		return frames;
	}

	public void setFrames(int[] frames) {
		this.frames = frames;
	}
}
