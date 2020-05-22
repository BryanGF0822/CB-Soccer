package threads;

import controller.ControllerCancha;
import model.Ball;
import model.Match;

public class BallonThread extends Thread{
	
	private ControllerCancha cc;
	private Match m;
	
	public BallonThread(ControllerCancha cc,Match m) {
		this.cc = cc;
		this.m = m;
	}
	
	public void run() {
		try {
			while(!m.stopGame()) {
			sleep(100);
			cc.moveBallon();
			m.moverBall();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
