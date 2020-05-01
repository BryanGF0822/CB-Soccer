package model;

public class Tournament {

	private Position firstPosition;
	private Team teamJugador;
	
	public Tournament(Team teamJugador) {
		firstPosition = new Position();
		this.teamJugador = teamJugador;
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
		
}
