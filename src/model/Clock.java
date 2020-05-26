package model;

/**
 * Esta clase es la encargado de generar un objeto de tipo Clock que basicamente
 * me permite llevar un conteo de segundos que se podran manipular dentro del
 * programa para hacer el reloj de cada unos de los partidos del juego.
 * 
 * @author guapi
 *
 */
public class Clock {

	private int seconds;

	/**
	 * Este es el metodo constructor de la clase Clock que inicializa susparametros
	 * en 0 cada vez que se inicia el juego.
	 * 
	 * @return Su retorno es segundos inicializados en 0.
	 */
	public Clock() {
		seconds = 0;
	}

	public int getSeconds() {
		return seconds;
	}

	public void setSeconds(int seconds) {
		this.seconds = seconds;
	}

	/**
	 * Este metodo es el encargado de ir aumentando los segundos de uno en uno para
	 * llevar un conteo del tiempo de cada partido.
	 */
	public void time() {
		setSeconds(getSeconds() + 1);
	}
}
