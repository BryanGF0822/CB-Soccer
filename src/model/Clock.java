package model;

public class Clock {

	private int seconds;

	/**
	 * [Clock description]
	 * @return [description]
	 */
	public Clock() {
		seconds = 0;
	}

	public int getSeconds() {
		return seconds;
	}

	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}

	/**
	 * [time description]
	 */
	public void time() {
		setSeconds(getSeconds() + 1);
	}
}
