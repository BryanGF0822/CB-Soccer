package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Clock;
import model.Match;

class ClockTest {

	private Match match;
	
	public void setup1() {
		match = new Match(null, null, null, null);
	}
	
	@Test
	void clockTest() {
		setup1();
		Clock clo = new Clock();
		clo.setSeconds(0);
		clo.time();
		assertTrue(clo.getSeconds() == 1);
		clo.setSeconds(5);
		clo.time();
		assertTrue(clo.getSeconds() == 6);
		clo.setSeconds(-8);
		clo.time();
		assertTrue(clo.getSeconds() == -7);
	}

}
