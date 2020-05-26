package model;

/**
 * Esta clase es la encargada los uniformes de cada equipo.
 * 
 * @author guapi
 *
 */
public class Uniform {

	private String img;
	private Uniform next;
	private Uniform prev;

	/**
	 * Metodo constructor de los uniformes que tiene como parametro una imagen de
	 * cada uniforme.
	 * 
	 * @param img Parametro que contiene un archivo de tipo imagen que contiene el
	 *            uniforme
	 * @return Retorna un objeto de tipo Uniform.
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
	 * Este metodo me permite añadir un uniforme a la lista que existe de uniformes.
	 * 
	 * @param newUniform Parametro que contiene una instancia de tipo uniforme, la
	 *                   cual es la que se va a añadir a la lista.
	 */
	public void addUniform(Uniform newUniform) {
		if (next == null) {
			next = newUniform;
		} else {
			next.addUniform(newUniform);
		}
	}

	/**
	 * Este metodo se encarga de buscar un uniforme especifico dentro de la lista de
	 * uniformes que existe dentro del juego
	 * 
	 * 
	 * @param img Parametro que contiene la imagen del uniforme que se busca.
	 * @return Retorna el uniforme buscado en caso de que exista o null en caso de
	 *         que no exista.
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
