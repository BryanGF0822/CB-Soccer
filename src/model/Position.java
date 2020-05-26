package model;

public class Position {

	public final static int octavos = 100;
	public final static int cuartos = 200;
	public final static int semis = 300;
	public final static int finalj = 400;
	public final static String foctavos = "Octavos";
	public final static String fcuartos = "Cuartos de final";
	public final static String fsemis = "Semi final";
	public final static String ffinalj = "Final";

	private String name;
	private Team team1;
	private Team team2;
	private Team teamGanador;
	private Position father;
	private Position right;
	private Position left;
	private Match match;
	private String fase;

	/**
	 * [Position description]
	 * @param  team1 [description]
	 * @param  team2 [description]
	 * @return       [description]
	 */
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

	/**
	 * [setTeamGanador description]
	 * @param teamGanador [description]
	 */
	public void setTeamGanador(Team teamGanador) {
		this.teamGanador = teamGanador;
		if (getFather() != null) {
			if (getFather().getTeam1() == null) {
				getFather().setTeam1(teamGanador);
			} else {
				getFather().setTeam2(teamGanador);
			}
		}
	}

	/**
	 * [addPosition description]
	 * @param  team1 [description]
	 * @param  team2 [description]
	 * @return       [description]
	 */
	public boolean addPosition(Team team1, Team team2) {
		boolean add = false;
		if (left == null && right == null) {
			if (this.team1 == null && this.team2 == null) {
				setTeam1(team1);
				setTeam2(team2);
				add = true;
			}
		} else {
			if (left.addPosition(team1, team2)) {
				add = true;
			} else {
				add = right.addPosition(team1, team2);
			}
		}
		return add;
	}
	/**
	 * [resultadoPartidos description]
	 * @return [description]
	 */
	public Team resultadoPartidos() {
		Team ganador = null;
		int numGanador = (int) (Math.random() * 2) + 1;
		if (numGanador == 1) {
			ganador = team1;
		} else {
			ganador = team2;
		}
		return ganador;
	}
	/**
	 * [posSig description]
	 * @return [description]
	 */
	public Position posSig() {
		Position ret = null;
		if (left == null && right == null) {
			if (teamGanador == null) {
				ret = this;
			}
		} else {
			if (left.getTeamGanador() != null && right.getTeamGanador() != null && teamGanador == null) {
				ret = this;

			} else {
				ret = left.posSig();
				if (ret == null) {
					ret = right.posSig();
				}
			}
		}
		return ret;
	}
	
	/**
	 * [getScore description]
	 * @param  teamJugador [description]
	 * @return             [description]
	 */
	public int getScore(Team teamJugador) {
		int score = 0;
		if (team1.getName().equals(teamJugador.getName()) || team2.getName().equals(teamJugador.getName())) {
			if(fase.equals(foctavos)) {
				score += octavos;
			}else if(fase.equals(fcuartos)) {
				score += cuartos;
			}else if(fase.equals(fsemis)) {
				score += semis;
			}else {
				score += finalj;
			}
		}else {
			if(right != null) {
				score += right.getScore(teamJugador);
			}
			if(left != null) {
				score += left.getScore(teamJugador);
			}
		}
		return score;
	}
}
