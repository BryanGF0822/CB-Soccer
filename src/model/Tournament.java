package model;

import java.io.Serializable;
import java.util.Random;

import exceptions.ExceptionFinalJuego;

/**
 * Esta clase clase es la encargada de gestionar el torneo.
 * 
 * @author guapi
 *
 */
public class Tournament implements Serializable{

	private Position firstPosition;
	private Team teamJugador;
	
	/**
	 * Metodo constructor que se encarga de crear el torneo.
	 * 
	 * @param teamJugador Parametro que contiene el torneo generado por el jugador.
	 * @return Retorna un objeto de tipo model.
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
	 * Metodo que organiza los equipos en el arbol segun los resultados de los
	 * partidos.
	 * 
	 * @param pos   Parametro que contiene la posicion del equipo.
	 * @param nivel Parametro que contiene en nivel en el que va a quedar el equipo
	 *              en el arbol.
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
	 * Este metodo me permite simular los partidos en los cuales el usuario no
	 * participa.
	 * 
	 * @param pos Parametro que contiene la posicion de dicho equipo.
	 */
	public void simularPartido(Position pos) {
		Team ganador = null;
		ganador = pos.resultadoPartidos();
		pos.setTeamGanador(ganador);

	}

	/**
	 * Este metodo saber si el partido es jugable o no, es decir, si va a ser
	 * simulado o va a ser jugado por el usuario.
	 * 
	 * @param position Parametro que contiene la posicion.
	 * @return Retorna un booleano para saber si es jugable o no el partido.
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
	 * Este metodo me permite añadir un partido nuevo.
	 * 
	 * @param pos Parametro que contiene la posicion de ese partido en el arbol.
	 * @return Retorna la posicion.
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
	 * Este metodo me permite obtener el partido que se juega, sin importar si es
	 * simulado o jugado por el usuario
	 * 
	 * @return Retorna el partido.
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
	 * Este metodo me lleva al siguiente partido cada vez que se termina el anterior
	 * pero solo cuando el usuario juega.
	 * 
	 * @return Retorna el siguiente partido en caso de que se deba jugar.
	 * @throws ExceptionFinalJuego Excepcion en caso de que el juego termine avisar
	 *                             al usario.
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
	 * Metodo que me permite conocer el puntaje final del usuarios.
	 * 
	 * @return Retorna un int con el puntaje obtenido.
	 */
	public int getScore() {
		return firstPosition.getScore(teamJugador);
	}
	
}
