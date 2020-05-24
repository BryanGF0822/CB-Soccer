package model;

public class Drawable {

	private int x;
	private int y;
	private String img;

	/**
	 * [Drawable description]
	 * @param  x   [description]
	 * @param  y   [description]
	 * @param  img [description]
	 * @return     [description]
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
