package model;

/**
 * Esta clase abstracta es el padre del cual hereda GameUser para crear nuevos
 * usuarios del juego.
 * 
 * @author guapi
 *
 */
public class Player extends Drawable {

	/**
	 * Este metodoconstructor me permite crear un nuevo usuario de juego un nuevo
	 * Player.
	 * 
	 * @param x   Parametro que contiene las coordenadas en X.
	 * @param y   Parametro que contiene las coordenadas en Y.
	 * @param img Parametro que contiene un archivo de tipo imagen.
	 * @return Retorna un objeto de tipo Player.
	 */
	public Player(int x, int y, String img) {
		super(x, y, img);
	}

}
