package model;

public class Clock {

	private int seconds;

	public Clock() {
		seconds = 0;
	}

	public int getSeconds() {
		return seconds;
	}

	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}

	public void time() {
		setSeconds(getSeconds() + 1);
	}
}
