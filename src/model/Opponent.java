package model;

public class Opponent extends Player{

	private int vectY;
	
	/**
	 * [Opponent description]
	 * @param  x   [description]
	 * @param  y   [description]
	 * @param  img [description]
	 * @return     [description]
	 */
	public Opponent(int x, int y, String img) {
		super(x, y, img);
	}

	public int getVectY() {
		return vectY;
	}

	public void setVectY(int vectY) {
		this.vectY = vectY;
	}
	
	/**
	 * [moverOponente description]
	 */
	public void moverOponente() {
		setY(vectY + getY());
		if (getY()> 350 - 66 || getY() < 0) {
			vectY = -vectY;
		}
	}
	
}
