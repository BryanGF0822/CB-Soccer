package model;

public class Uniform {

	private String img;
	private Uniform next;
	private Uniform prev;
	
	public Uniform(String img) {
		this.img = img;
	}

	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
	}

	public Uniform getNext() {
		return next;
	}

	public void setNext(Uniform next) {
		this.next = next;
	}

	public Uniform getPrev() {
		return prev;
	}

	public void setPrev(Uniform prev) {
		this.prev = prev;
	}
	
	
}
