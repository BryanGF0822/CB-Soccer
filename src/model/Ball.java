package model;

/**
 * Esta clase es la que se encarga de crear el balon que tendrá funcion a la
 * hora iniciar los partidos.
 * 
 * @author guapi
 *
 */
public class Ball extends Drawable {

	private int vectX;
	private int vectY;

	/**
	 * Este es el metodo constructor del balon, el cual tiene unas dimesiones en X,
	 * Y y tiene una imagen que la que podrá visualizarse a la hora de jugar.
	 * 
	 * @param x   Parametro que define las coordenadas en el eje X.
	 * @param y   Parametro que define las coordenadas en el eje Y.
	 * @param img Parametro que porta un archivo de foto que representa el balon.
	 * @return El retorno es un objeto de tipo balon, es este caso, el balon del
	 *         juego.
	 */
	public Ball(int x, int y, String img) {

		super(x, y, img);

		this.vectX = ((int) Math.random() * 10) + 10;
		this.vectY = ((int) Math.random() * 10) + 10;
	}

	public int getVectX() {
		return vectX;
	}

	public void setVectX(int vectX) {
		this.vectX = vectX;
	}

	public int getVectY() {
		return vectY;
	}

	public void setVectY(int vectY) {
		this.vectY = vectY;
	}

	/**
	 * Este metodo es el encargado de los movimientos del balon en los ejes X y Y
	 * que se estará moviendo durante los partidos y los golpes dados por los
	 * jugadores.
	 */
	public void mover() {
		setX(vectX + getX());
		setY(vectY + getY());
		if (getX() > 600 - 90 || getX() < 0) {
			vectX = -vectX;
		}
		if (getY() > 350 - 66 || getY() < 0) {
			vectY = -vectY;
		}

	}

}
