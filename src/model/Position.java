package model;

public class Position {

	private String name;
	private Team team1;
	private Team team2;
	private Team teamGanador;
	private Position father;
	private Position right;
	private Position left;
	private Match match;
	private String fase;

	public Position(Team team1, Team team2) {
		this.team1 = team1;
		this.team2 = team2;
	}

	public Position() {
		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Team getTeam1() {
		return team1;
	}

	public void setTeam1(Team team1) {
		this.team1 = team1;
	}

	public Team getTeam2() {
		return team2;
	}

	public void setTeam2(Team team2) {
		this.team2 = team2;
	}

	public Team getTeamGanador() {
		return teamGanador;
	}

	public void setTeamGanador(Team teamGanador) {
		this.teamGanador = teamGanador;
	}

	public Position getFather() {
		return father;
	}

	public void setFather(Position father) {
		this.father = father;
	}

	public Position getRight() {
		return right;
	}

	public void setRight(Position right) {
		this.right = right;
	}

	public Position getLeft() {
		return left;
	}

	public void setLeft(Position left) {
		this.left = left;
	}

	public Match getMatch() {
		return match;
	}

	public void setMatch(Match match) {
		this.match = match;
	}

	public String getFase() {
		return fase;
	}

	public void setFase(String fase) {
		this.fase = fase;
	}
	
	
	
}
