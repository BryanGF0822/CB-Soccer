package model;

/**
 * Esta Clase es abstracta y de ella hereda la clase Ball la cualme permite
 * heredarle como padre, los atributos de esta clase para que puedan ser
 * utilizados por las demas clases hijas que hereden de ésta.
 * 
 * @author guapi
 *
 */
public class Drawable {

	private int x;
	private int y;
	private String img;

	/**
	 * Este es metodo constructor de la clase abstracta Drawable.
	 * 
	 * @param x   Este es el parametro que define las coordenadas en el eje X.
	 * @param y   Este es el parametroq ue define las coordenadas en el ejer Y.
	 * @param img Este parametro guarda un archivo de imagen que se desee.
	 * @return El retorno es un objeto de tipo Drawable con todos sus parametros.
	 */
	public Drawable(int x, int y, String img) {
		this.x = x;
		this.y = y;
		this.img = img;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

}
