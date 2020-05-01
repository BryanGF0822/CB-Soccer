package model;


public class Ball extends Drawable{

	private int vectX;
	private int vectY;
	public Ball(int x, int y, String img) {
		super(x , y, img);
		this.vectX = vectX;
		this.vectY = vectY;
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
		
}
