package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Esta clase es la encargada de gestionar los puntajes (Scores) de cada
 * jugador.
 * 
 * @author guapi
 *
 */
public class Score implements Serializable{

	private String name;
	private int score;
	private Score right;
	private Score left;
	
	/**
	 * Metodoconstructor de la clase Score que esta formado por un nombre de jugador
	 * y el puntaje (score) optenido.
	 * 
	 * @param name  Parametro que contiene el nombre del jugador actual.
	 * @param score Parametroq ue contiene el puntaje (score) del jugador actual.
	 * @return Retorna un objeto de tipo Score.
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
	 * Este metodo me permite añadir un score nuevo cada vez que se termina un
	 * campeonato del juego.
	 * 
	 * @param e Parametro que contiene el puntaje o score del jugador.
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
	 * Metodo que se encarga de almacenar los 10 ultimos puntajes que se han jugado.
	 * 
	 * @param lista Parametro que contiene la lista de scores.
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
	
	
	@Override
	public String toString() {
		return  " " + name + ": " + score;
	}
	
}
