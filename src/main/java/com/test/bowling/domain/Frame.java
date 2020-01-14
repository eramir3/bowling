package com.test.bowling.domain;

public class Frame {
	
	private int number;

	private Roll[] rolls;
	
	private int score;
	
	private boolean isAvailable;
	

	public Frame(int number, int rolls) {
		super();
		this.number = number;
		this.rolls = new Roll[rolls];
		this.isAvailable = true;
	}
	
	public Roll[] getRolls() {
		return rolls;
	}

	public void setRolls(Roll[] rolls) {
		this.rolls = rolls;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public boolean isAvailable() {
		return isAvailable;
	}

	public void setAvailable(boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
}
