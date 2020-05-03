package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
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
	
	public ArrayList<Team> hacerListaTeam() {
		ArrayList<Team> lt = new ArrayList<Team>();
		Team sig = firstTeam;
		while (sig != null) {
			lt.add(sig);
			sig = sig.getSig();
		}
		return lt;
	}
	
	public ArrayList<Score> ordenarPorPuntaje() {
		ArrayList<Score> lista = new ArrayList<Score>();
		if (firstScore != null) {
			firstScore.tenScore(lista);
		}
		return lista;
	}
	
	public ArrayList<Score> ordenarPorNombre() {
		ArrayList<Score> e = ordenarPorPuntaje();
		for (int i = 0; i < e.size(); i++) {
			for (int j = i; j > 0 && (e.get(j - 1).getName().compareTo(e.get(j).getName())) > 0; j--) {
				Score tmp = e.get(j);
				e.set(j, e.get(j - 1));
				e.set(j - 1, tmp);
			}
		}
		return e;
	}
	
}
