package test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Game;
import model.Team;

class TeamTest {
	
	private Game game;
	
	public void setup1() {
		game = new Game();
		Team t = new Team("Chilombia");
		game.addTeam(t.getName());
	}
	
	public void setup2() {
		game = new Game();
		Team t = new Team("Nodal");
		game.addTeam(t.getName());
	}
	
	@Test
	void addTeamtest() {
		setup1();
		game.addTeam("Colombia");
		Team actual = game.getFirstTeam();
		while(!actual.getName().equals("Colombia")) {
			actual = actual.getSig();
		}
		assertTrue(actual.getName().equals("Colombia"));
		setup2();
		game.addTeam("Argentina");
		Team actuall = game.getFirstTeam();
		while(!actuall.getName().equals("Argentina")) {
			actuall = actuall.getSig();
		}
		assertTrue(actuall.getName().equals("Argentina"));
	}

	@Test
	void searchTeamTest() {
		setup2();
		Team actual = game.searchTeam("Nodal");
		assertTrue(actual.getName().equals("Nodal"));
		game.addTeam("Peru");
		actual = game.searchTeam("Peru");
		assertTrue(actual.getName().equals("Peru"));
	}
	
}
