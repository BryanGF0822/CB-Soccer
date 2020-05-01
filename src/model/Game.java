package model;

import java.util.ArrayList;

public class Game {

	private Score firstScore;
	private Tournament tournament;
	private Team firstTeam;
	private ArrayList<Team> listaSorteo;
	
	public Game() {
		
	}

	public Score getFirstScore() {
		return firstScore;
	}

	public void setFirstScore(Score firstScore) {
		this.firstScore = firstScore;
	}

	public Tournament getTournament() {
		return tournament;
	}

	public void setTournament(Tournament tournament) {
		this.tournament = tournament;
	}

	public Team getFirstTeam() {
		return firstTeam;
	}

	public void setFirstTeam(Team firstTeam) {
		this.firstTeam = firstTeam;
	}

	public ArrayList<Team> getListaSorteo() {
		return listaSorteo;
	}

	public void setListaSorteo(ArrayList<Team> listaSorteo) {
		this.listaSorteo = listaSorteo;
	}
	
}
