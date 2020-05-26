package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.*;

class BallTest {

	private Ball ball;
	private Match match;
	
	public void setup1() {
		match = new Match(null, null, null, null);
	}
	
	public void setup2() {
		Ball b = new Ball(200, 200, "");
	}
	
	@Test
	void mover() {
		setup1();
		Ball b = new Ball(280,150,"");
		match.setBall(b);
		b.mover();
		int x = b.getVectX();
		int y = b.getVectY();
		assertTrue(x == 10 && y == 10);
		setup2();
		Ball r = new Ball(265,100,"");
		match.setBall(r);
		r.mover();
		int xv = r.getVectX();
		int yv = r.getVectY();
		assertTrue(xv == 10 && yv == 10);

	}

}
