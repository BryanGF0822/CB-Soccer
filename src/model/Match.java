package model;

public class Match {

	private Clock clock;
	private Ball ball;
	private Opponent opponent;
	private GameUser gameUser;
	private int golesTeam1;
	private int golesTeam2;
	private Team team1;
	private Team team2;
	private Position pos;
	
	public Match(Clock clock, Ball ball, Opponent opponent, GameUser gameUser) {
		this.clock = clock;
		this.ball = ball;
		this.opponent = opponent;
		this.gameUser = gameUser;
		golesTeam1 = 0;
		golesTeam2 = 0;
	}

	public Clock getClock() {
		return clock;
	}

	public void setClock(Clock clock) {
		this.clock = clock;
	}

	public Ball getBall() {
		return ball;
	}

	public void setBall(Ball ball) {
		this.ball = ball;
	}

	public Opponent getOpponent() {
		return opponent;
	}

	public void setOpponent(Opponent opponent) {
		this.opponent = opponent;
	}

	public GameUser getGameUser() {
		return gameUser;
	}

	public void setGameUser(GameUser gameUser) {
		this.gameUser = gameUser;
	}

	public int getGolesTeam1() {
		return golesTeam1;
	}

	public void setGolesTeam1(int golesTeam1) {
		this.golesTeam1 = golesTeam1;
	}

	public int getGolesTeam2() {
		return golesTeam2;
	}

	public void setGolesTeam2(int golesTeam2) {
		this.golesTeam2 = golesTeam2;
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

	public Position getPos() {
		return pos;
	}

	public void setPos(Position pos) {
		this.pos = pos;
	}
	
}
