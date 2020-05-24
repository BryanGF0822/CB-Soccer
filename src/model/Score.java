package model;

import java.io.Serializable;
import java.util.ArrayList;

public class Score implements Serializable{

	private String name;
	private int score;
	private Score right;
	private Score left;
	
	/**
	 * [Score description]
	 * @param  name  [description]
	 * @param  score [description]
	 * @return       [description]
	 */
	public Score(String name, int score) {
		this.name = name;
		this.score = score;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public Score getRight() {
		return right;
	}
	public void setRight(Score right) {
		this.right = right;
	}
	public Score getLeft() {
		return left;
	}
	public void setLeft(Score left) {
		this.left = left;
	}
	
	/**
	 * [addScore description]
	 * @param e [description]
	 */
	public void addScore(Score e) {
		if (this.getScore() >= e.getScore()) {
			if (left != null) {
				left.addScore(e);
			} else {
				this.setLeft(e);
			}
		}
		if (this.getScore() < e.getScore()) {
			if (right != null) {
				right.addScore(e);
			} else {
				this.setRight(e);
			}
		}
	}
	
	/**
	 * [tenScore description]
	 * @param lista [description]
	 */
	public void tenScore(ArrayList<Score> lista) {
		if (lista.size() < 10) {
			if (right != null) {
				right.tenScore(lista);
			}
			if (lista.size() < 10) {
				lista.add(this);
			}
			if (left != null) {
				left.tenScore(lista);
			}
		}

	}
	
	/**
	 * [toString description]
	 * @return [description]
	 */
	@Override
	public String toString() {
		return  " " + name + ": " + score;
	}
	
}
