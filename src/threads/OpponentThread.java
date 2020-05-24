package threads;

import controller.ControllerCancha;
import model.Opponent;

public class OpponentThread extends Thread {

	private Opponent o;
	private ControllerCancha cc;

	public OpponentThread(ControllerCancha cc, Opponent o) {
		this.cc = cc;
		this.o = o;
	}

	public void run() {
		boolean noEnd = true;
		while (noEnd) {
			try {
				sleep(200);
				o.moverOponente();
				cc.moveOpponent();
			} catch (InterruptedException e) {

				e.printStackTrace();
			}

		}
	}
}
