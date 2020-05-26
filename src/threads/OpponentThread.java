package threads;

import controller.ControllerCancha;
import model.Match;
import model.Opponent;

public class OpponentThread extends Thread {

	private Match m;
	private ControllerCancha cc;

	public OpponentThread(ControllerCancha cc, Match m) {
		this.cc = cc;
		this.m = m;
	}

	public void run() {
		
		while (!m.stopGame()) {
			try {
				sleep(200);
				m.getOpponent().moverOponente();
				cc.moveOpponent();
			} catch (InterruptedException e) {

				e.printStackTrace();
			}

		}
	}
}
