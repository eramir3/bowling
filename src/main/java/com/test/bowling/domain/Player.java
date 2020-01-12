package com.test.bowling.domain;

import com.test.bowling.utils.BowlingConstants;

public class Player {

	private String name;
	
	private int number;
	
	private Frame[] frames;
	
	private Roll bonusRoll;
	
	 
	public Player(String name, int number) {
		this.name = name;
		this.number = number;
		this.frames = new Frame[BowlingConstants.TOTAL_FRAMES];
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
	
	public Roll getBonusRoll() {
		return bonusRoll;
	}

	public void setBonusRoll(Roll bonusRoll) {
		this.bonusRoll = bonusRoll;
	}
	
	public Frame[] getFrames() {
		return frames;
	}

	public void setFrames(Frame[] frames2) {
		this.frames = frames2;
	}
}
