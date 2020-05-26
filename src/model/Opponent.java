package model;

/**
 * Es una clase que hereda de Player para crear un oponente para el usuario a la
 * hora de jugar.
 * 
 * @author guapi
 *
 */
public class Opponent extends Player {

	private int vectY;

	/**
	 * Este metodoconstructor me permite crear un nuevo usuario de juego un nuevo
	 * Opponent.
	 * 
	 * @param x   Parametro que contiene las coordenadas en X.
	 * @param y   Parametro que contiene las coordenadas en Y.
	 * @param img Parametro que contiene un archivo de tipo imagen.
	 * @return Retorna un objeto de tipo Opponent.
	 */
	public Opponent(int x, int y, String img) {
		super(x, y, img);
		vectY = ((int) Math.random() * 10) + 10;
	}

	public int getVectY() {
		return vectY;
	}

	public void setVectY(int vectY) {
		this.vectY = vectY;
	}

	/**
	 * Este metodo permite que el oponente se dezplace para evitar una anotacion.
	 */
	public void moverOponente() {
		setY(vectY + getY());
		if (getY() > 350 - 66 || getY() < 0) {
			vectY = -vectY;
		}
	}

}
