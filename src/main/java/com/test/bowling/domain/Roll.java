package com.test.bowling.domain;

public class Roll {

	private int frame;
	
	private int pinfalls;
		
	private boolean isFailed;
	
	
	public Roll() {
		
	}
	
	public Roll(int pinfalls, boolean failed) {
		this.pinfalls = pinfalls;
		this.isFailed = failed;
	}

	public boolean isFailed() {
		return isFailed;
	}

	public void setFailed(boolean isFailed) {
		this.isFailed = isFailed;
	}

	public int getFrame() {
		return frame;
	}

	public void setFrame(int frame) {
		this.frame = frame;
	}

	public int getPinfalls() {
		return pinfalls;
	}

	public void setPinfalls(int pinfalls) {
		this.pinfalls = pinfalls;
	}
}