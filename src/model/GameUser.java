package model;

/**
 * Esta clase es la encargada de generar un nuevo usuario del juego.
 * 
 * @author guapi
 *
 */
public class GameUser extends Player {

	private Uniform uniform;

	/**
	 * Este metodoconstructor me permite crear un nuevo usuario de juego.
	 * 
	 * @param x   Parametro que contiene las coordenadas en X.
	 * @param y   Parametro que contiene las coordenadas en Y.
	 * @param img Parametro que contiene un archivo de tipo imagen.
	 * @return Retorna un objeto de tipo GameUser.
	 */
	public GameUser(int x, int y, String img) {
		super(x, y, img);
	}

}
