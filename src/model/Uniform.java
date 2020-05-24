package model;

public class Uniform {

	private String img;
	private Uniform next;
	private Uniform prev;
	
	/**
	 * [Uniform description]
	 * @param  img [description]
	 * @return     [description]
	 */
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
	/**
	 * [addUniform description]
	 * @param newUniform [description]
	 */
	public void addUniform(Uniform newUniform) {
		if (next == null) {
			next = newUniform;
		} else {
			next.addUniform(newUniform);
		}
	}
	/**
	 * [searchUniform description]
	 * @param  img [description]
	 * @return     [description]
	 */
	public Uniform searchUniform(String img) {
		if (next != null) {
			if (next.getImg().equals(img)) {
				return next;
			} else {
				return next.searchUniform(img);
			}
		} else {
			return null;
		}

	}
}
