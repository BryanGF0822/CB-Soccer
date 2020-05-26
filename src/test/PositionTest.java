package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Position;
import model.Team;
import model.Tournament;

class PositionTest {

	private Tournament tour;

	public void setup1() {
		tour = new Tournament(null);
	}

	@Test
	void addPositionTest() {
		setup1();
		Position po = tour.getFirstPosition();
		assertTrue(po.getName() == null);
		Team t1 = new Team("Colombia");
		Team t2 = new Team("Chile");
		tour.getFirstPosition().addPosition(t1, t2);
		assertTrue(tour.getFirstPosition() != null);
	}

}
