package model;

public class Ball extends Drawable {

	private int vectX;
	private int vectY;

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
