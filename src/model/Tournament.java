package model;

import java.io.Serializable;
import java.util.Random;

import exceptions.ExceptionFinalJuego;

public class Tournament implements Serializable{

	private Position firstPosition;
	private Team teamJugador;
	
	/**
	 * [Tournament description]
	 * @param  teamJugador [description]
	 * @return             [description]
	 */
	public Tournament(Team teamJugador) {
		firstPosition = new Position();
		this.teamJugador = teamJugador;
		anhadirHijos(firstPosition, 0);
	}

	public Position getFirstPosition() {
		return firstPosition;
	}

	public void setFirstPosition(Position firstPosition) {
		this.firstPosition = firstPosition;
	}

	public Team getTeamJugador() {
		return teamJugador;
	}

	public void setTeamJugador(Team teamJugador) {
		this.teamJugador = teamJugador;
	}
	
	public void addPosition(Team team1, Team team2) {
		firstPosition.addPosition(team1, team2);
	}
	
	/**
	 * [anhadirHijos description]
	 * @param pos   [description]
	 * @param nivel [description]
	 */
	public void anhadirHijos(Position pos, int nivel) {
		if (nivel < 3) {
			Position prev1 = new Position();
			Position prev2 = new Position();
			if (nivel == 0) {
				pos.setFase(Position.ffinalj);
			} else if (nivel == 1) {
				pos.setFase(Position.fsemis);
			} else if (nivel == 2) {
				pos.setFase(Position.fcuartos);
			}
			pos.setRight(prev1);
			pos.setLeft(prev2);
			prev1.setFather(pos);
			prev2.setFather(pos);
			anhadirHijos(prev1, nivel + 1);
			anhadirHijos(prev2, nivel + 1);
		} else {
			pos.setFase(Position.foctavos);
		}
	}
	
	/**
	 * [simularPartido description]
	 * @param pos [description]
	 */
	public void simularPartido(Position pos) {
		Team ganador = null;
		ganador = pos.resultadoPartidos();
		pos.setTeamGanador(ganador);

	}

	/**
	 * [isJugable description]
	 * @param  position [description]
	 * @return          [description]
	 */
	public boolean isJugable(Position position) {
		boolean ret = false;
		if (position.getTeam1().getName().equals(teamJugador.getName())
				|| position.getTeam2().getName().equals(teamJugador.getName())) {
			ret = true;
		}
		return ret;
	}
	
	/**
	 * [addMatch description]
	 * @param  pos [description]
	 * @return     [description]
	 */
	public Match addMatch(Position pos) {
		Team jugador = null;
		Team oponente = null;
		if (pos.getTeam1().getName().equals(teamJugador.getName())) {
			jugador = pos.getTeam1();
			oponente = pos.getTeam2();
		} else {
			jugador = pos.getTeam2();
			oponente = pos.getTeam1();
		}
		Clock c = new Clock();
		Ball b = new Ball(280, 150, "ball.jpg");
		GameUser gu = new GameUser(50, 0, "img\\"+jugador.getName() + "Local.png");
		Random r = new Random();
		int y = r.nextInt(28)*10;
		Opponent op = new Opponent(480, y,"img\\"+ oponente.getName() + "Local.png");
		Match nuevoM = new Match(c, b, op, gu);
		nuevoM.setTeam1(jugador);
		nuevoM.setTeam2(oponente);
		pos.setMatch(nuevoM);
		return nuevoM;
	}

	/**
	 * [getMatch description]
	 * @return [description]
	 */
	public Match getMatch() {
		Match m = null;
		Position pos = firstPosition.posSig();
		while (pos != null && !isJugable(pos)) {
			simularPartido(pos);
			pos = firstPosition.posSig();
		}
		if (pos != null) {
			m = addMatch(pos);
			m.setPos(pos);
		}
		return m;
	}

	/**
	 * [nextMatch description]
	 * @return [description]
	 * @throws ExceptionFinalJuego [description]
	 */
	public boolean nextMatch() throws ExceptionFinalJuego{
		Position pos = firstPosition.posSig();
		if(pos == null) {
			throw new ExceptionFinalJuego();
		}
		if (!isJugable(pos)) {
			simularPartido(pos);
			return true;
		}
		return false;
	}
	
	/**
	 * [getScore description]
	 * @return [description]
	 */
	public int getScore() {
		return firstPosition.getScore(teamJugador);
	}
	
}
