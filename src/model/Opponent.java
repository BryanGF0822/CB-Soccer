package model;

public class Opponent extends Player{

	private int vectY;
	
	public Opponent(int x, int y, String img) {
		super(x, y, img);
	}

	public int getVectY() {
		return vectY;
	}

	public void setVectY(int vectY) {
		this.vectY = vectY;
	}
	
	public void moverOponente() {
		setY(vectY + getY());
		if (getY()> 350 - 66 || getY() < 0) {
			vectY = -vectY;
		}
	}
	
}
