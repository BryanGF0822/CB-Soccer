package threads;

import controller.ControllerCancha;
import model.Clock;
import model.Match;
import model.Position;

public class ClockThread extends Thread {

	private ControllerCancha cc;
	private Match m;

	public ClockThread(ControllerCancha cc,Match m) {
		this.cc = cc;
		this.m = m;
	}

	public void run() {
		try {
			while (!m.stopGame()) {
				sleep(1000);
				m.getClock().time();
				cc.moveTime();
			}
			m.endGame();
			cc.setVisibility();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
