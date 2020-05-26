package model;

/**
 * Esta clase se encarga de montar todo lo necesario para realizar un partido es
 * decir la cancha, el reloj, los equipos a jugar, entre otros.
 * 
 * @author guapi
 *
 */
public class Match {

	public final static int w = 90;

	private Clock clock;
	private Ball ball;
	private Opponent opponent;
	private GameUser gameUser;
	private int golesTeam1;
	private int golesTeam2;
	private Team team1;
	private Team team2;
	private Position pos;

	/**
	 * Metodo constructor de la clase Match que se encarga de creo un objeto de tipo
	 * Match.
	 * 
	 * @param clock    Relacion con la clase Clock para tomar el tiempo del partido.
	 * @param ball     Relacion con la clase Ball para crear un balon para el juego.
	 * @param opponent Relacion con la clase Opponent que crea el equipo adversario
	 *                 al cual se va a enfrentar el usuario.
	 * @param gameUser Relacion con la clse GameUser que crea el equipo con el cual
	 *                 va a participar el ususario.
	 * @return Retorna un objeto de tipo Match con todas sus instancias para crear
	 *         un partido.
	 */
	public Match(Clock clock, Ball ball, Opponent opponent, GameUser gameUser) {
		super();
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

	/**
	 * Este metodo me permite mover el balon dentro de la cancha.
	 */
	public void moverBall() {
		ball.mover();
		if (ball.getX() > 600 - 90) {
			golesTeam1++;
		}
		if (ball.getX() < 0) {
			golesTeam2++;
		}
		rebote();
	}

	/**
	 * Este metodo permite el revote del balon cuando toca al jugador o haga
	 * contacto con los bordes de la cancha.
	 */
	public void rebote() {
		if (ball.getX() + w >= opponent.getX() && opponent.getY() <= ball.getY()
				&& opponent.getY() + w >= ball.getY()) {
			ball.setVectX(-Math.abs(ball.getVectX()));
		}
		if (ball.getX() <= gameUser.getX() + w && gameUser.getY() <= ball.getY()
				&& gameUser.getY() + w >= ball.getY()) {
			ball.setVectX(Math.abs(ball.getVectX()));
		}
	}

	/**
	 * Este metodo se encarga de mover el jugador del usuarios hacia arriba cuando
	 * el lo desee. (teclas de direccion).
	 */
	public void arriba() {
		if (gameUser.getY() >= 10) {
			gameUser.setY(gameUser.getY() - 10);
		}
	}

	/**
	 * [Este metodo se encarga de mover el jugador del usuarios hacia abajo cuando
	 * el lo desee. (teclas de direccion).
	 */
	public void abajo() {
		if (gameUser.getY() <= 340 - w) {
			gameUser.setY(gameUser.getY() + 10);
		}
	}

	/**
	 * Este metodo se encarga de saber cual es el equipo ganador luego de finalizado
	 * el partido a partir de los goles realizados por cada equipo.
	 * 
	 * @return Retorna el equipo ganador.
	 */
	public Team ganadorPartido() {
		if (golesTeam1 > golesTeam2) {
			return team1;
		} else {
			return team2;
		}
	}

	/**
	 * Este metodo me permite detener completamente el juego cuando se desee salir.
	 * 
	 * @return [Retorna un true para salir del programa.
	 */
	public boolean stopGame() {
		boolean ret = false;
		if (clock.getSeconds() > 90) {
			ret = true;
		}
		return ret;
	}

	public Position getPos() {
		return pos;
	}

	public void setPos(Position pos) {
		this.pos = pos;
	}

	/**
	 * Este metodo se encarga de cambiar el ganador del partido para poder saber que
	 * equipo obtiene la victoria.
	 */
	public void endGame() {
		pos.setTeamGanador(ganadorPartido());

	}

}
