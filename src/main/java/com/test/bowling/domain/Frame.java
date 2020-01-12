package com.test.bowling.domain;

public class Frame {
	
	private int number;

	private Roll roll1;
	
	private Roll roll2;
	
	private int score;
	
	private boolean isAvailable;
	

	public Frame(int number) {
		super();
		this.number = number;
		this.isAvailable = true;
	}

	public Roll getRoll1() {
		return roll1;
	}

	public void setRoll1(Roll roll1) {
		this.roll1 = roll1;
	}

	public Roll getRoll2() {
		return roll2;
	}

	public void setRoll2(Roll roll2) {
		this.roll2 = roll2;
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
