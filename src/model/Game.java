package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import Exceptions.ExceptionFinalJuego;
import Exceptions.ExceptionNotPlayer;
import Exceptions.ExceptionNotTeam;

public class Game {

	private Score firstScore;
	private Tournament tournament;
	private Team firstTeam;
	private ArrayList<Team> listaSorteo;

	public Game() {
		start();
		organizarEquipos();
		readScore();
	}

	public Team getFirstTeam() {
		return firstTeam;
	}

	public void addTeam(String n) {
		Team newTeam = new Team(n);
		if (firstTeam == null) {
			firstTeam = newTeam;
		} else {
			firstTeam.addTeam(newTeam);
		}
	}

	public void organizarEquipos() {
		if (firstTeam != null) {
			Team act = firstTeam;
			while (act != null) {
				Team sig = act.getSig();
				Team menor = act;
				while (sig != null) {
					if (sig.getName().compareTo(menor.getName()) <= 0) {
						menor = sig;
					}
					sig = sig.getSig();
				}
				if (act.getPrev() != null) {
					act.getPrev().setSig(menor);
				} else {
					firstTeam = menor;
				}
				if (menor.getSig() != null) {
					menor.getSig().setPrev(act);
				}
				if (act.getSig() != null && menor == act.getSig()) {
					menor.setPrev(act.getPrev());
					act.setSig(menor.getSig());
					menor.setSig(act);
					act.setPrev(menor);

				} else {
					if (!menor.getName().equals(act.getName())) {

						if (menor.getPrev() != null) {
							menor.getPrev().setSig(act);
						}
						if (act.getSig() != null) {
							act.getSig().setPrev(menor);
						}

						Team temp = menor.getSig();

						menor.setSig(act.getSig());
						act.setSig(temp);
						Team temp2 = menor.getPrev();
						menor.setPrev(act.getPrev());
						act.setPrev(temp2);
					}

				}
				act = menor.getSig();
			}

		}
	}

	public Team searchTeam(String name) {
		if (firstTeam != null) {
			if (firstTeam.getName().equalsIgnoreCase(name)) {
				return firstTeam;
			} else {
				return firstTeam.searchTeam(name);
			}
		} else {
			return null;
		}
	}

	public void addUniform(String nameTeam, String img) {
		Uniform newUniform = new Uniform(img);
		if (searchTeam(nameTeam) != null) {
			searchTeam(nameTeam).addUniform(newUniform);
		}
	}

	public Uniform searchUniform(String nameTeam, String img) {
		if (searchTeam(nameTeam) != null) {
			return searchTeam(nameTeam).searchUniform(img);
		} else
			return null;
	}

	public void start() {
		loadTeams();
	}

	public void loadTeams() {
		File a = new File("./data/Teams.txt");
		try {
			FileReader fr = new FileReader(a);
			BufferedReader br = new BufferedReader(fr);
			br.readLine();
			String cadena = br.readLine();
			while (!cadena.equals("#Uniforms")) {
				addTeam(cadena);
				cadena = br.readLine();
			}
			cadena = br.readLine();
			while (cadena != null && !cadena.isEmpty()) {
				String[] cadena1 = cadena.split(";");
				addUniform(cadena1[0], cadena1[1]);
				cadena = br.readLine();
			}
			br.close();
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

		}
	}

	public void serializableScores() {
		try {
			FileOutputStream fs = new FileOutputStream(".\\data\\Scores.txt");
			ObjectOutputStream os = new ObjectOutputStream(fs);
			os.writeObject(firstScore);
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void readScore() {
		try {
			File f = new File(".\\data\\Scores.txt");
			if (f.exists()) {
				FileInputStream fis = new FileInputStream(f);
				ObjectInputStream ois = new ObjectInputStream(fis);
				firstScore = (Score) ois.readObject();
				ois.close();
				fis.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
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

	public ArrayList<Team> getListaSorteo() {
		return listaSorteo;
	}

	public void addPosition(Team team1, Team team2) {
		tournament.addPosition(team1, team2);
	}

	public void makeTournament() {
		ArrayList<Integer> selected = new ArrayList<Integer>();
		int max = listaSorteo.size();
		int counter = 0;
		while (counter < 8) {
			int team1 = (int) (Math.random() * max);
			int team2 = (int) (Math.random() * max);
			while (selected.contains(team1)) {
				team1 = (int) (Math.random() * max);
			}
			while (team1 == team2 || selected.contains(team2)) {
				team2 = (int) (Math.random() * max);
			}
			addPosition(listaSorteo.get(team1), listaSorteo.get(team2));
			selected.add(team1);
			selected.add(team2);
			counter++;
		}
	}

	public void addScore(String n, int e) {
		Score pri = new Score(n, e);
		if (firstScore == null) {
			firstScore = pri;
		} else {
			firstScore.addScore(pri);
		}
		serializableScores();
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

	public ArrayList<Team> pasar() {
		ArrayList<Team> e = new ArrayList<Team>();
		Team actual = firstTeam;
		while (actual != null) {
			e.add(actual);
			actual = actual.getSig();
		}
		return e;
	}

	public String binarioEquipoNombre(String a) throws ExceptionNotTeam {
		ArrayList<Team> e = pasar();
		String msg = "";
		boolean encontrado = false;
		int inicio = 0;
		int fin = e.size() - 1;
		while (inicio <= fin && !encontrado) {
			int medio = (inicio + fin) / 2;
			if (e.get(medio).getName().equalsIgnoreCase(a)) {
				encontrado = true;
				msg = e.get(medio).toString();
			} else if (e.get(medio).getName().compareToIgnoreCase(a) > 0) {
				fin = medio - 1;
			} else if (e.get(medio).getName().compareToIgnoreCase(a) < 0) {
				inicio = medio + 1;
			}
		}
		if (!encontrado) {
			throw new ExceptionNotTeam();
		}

		return msg;
	}

	public void addTeamJugador(Team team) {
		tournament = new Tournament(team);
		listaSorteo = hacerListaTeam();
		makeTournament();
	}

	public Position getPosition() {
		return tournament.getFirstPosition();
	}

	public Match getMatch() {
		return tournament.getMatch();
	}

	public String binarioPuntajeNombre(String a) throws ExceptionNotPlayer {
		ArrayList<Score> e = ordenarPorNombre();
		String msg = "";
		boolean encontrado = false;
		int inicio = 0;
		int fin = e.size() - 1;
		while (inicio <= fin && !encontrado) {
			int medio = (inicio + fin) / 2;
			if (e.get(medio).getName().equals(a)) {
				encontrado = true;
				msg = e.get(medio).toString();
			} else if (e.get(medio).getName().compareTo(a) > 0) {
				fin = medio - 1;
			} else if (e.get(medio).getName().compareTo(a) < 0) {
				inicio = medio + 1;
			}
		}
		if (!encontrado) {
			throw new ExceptionNotPlayer();
		}

		return msg;
	}

	public boolean nextMatch() throws ExceptionFinalJuego {
		return tournament.nextMatch();
	}

	public int getScore() {
		return tournament.getScore();
	}
}
