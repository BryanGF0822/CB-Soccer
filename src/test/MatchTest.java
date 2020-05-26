package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Position;
import model.Team;

class MatchTest {

	private Position pos;
	
	public void setup1() {
		pos = new Position();
		Team t1 = new Team("Colombia");
		pos.setTeamGanador(t1);
	}
	
	@Test
	void ganadorPartido() {
		setup1();
		Team t2 = new Team("China");
		pos.setTeamGanador(t2);
		assertTrue(pos.getTeamGanador() == t2);
		Team t3 = new Team("Cuba");
		pos.setTeamGanador(t3);
		assertTrue(pos.getTeamGanador() == t3);
	}

}
