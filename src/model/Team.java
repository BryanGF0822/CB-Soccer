package model;

/**
 * Esta clase es la encargado de generar equipos que contengan todos
 * susparametros como un nombre y un uniforme.
 * 
 * @author guapi
 *
 */
public class Team {

	private String name;
	private Uniform firstUniform;
	private Team sig;
	private Team prev;

	/**
	 * Metodo constructor que se encarga de crear un equipo.
	 * 
	 * @param name Parametro que contiene el nombre del equipo.
	 * @return Retorna un objeto de tipoTeam.
	 */
	public Team(String name) {
		this.setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Uniform getFirstUniform() {
		return firstUniform;
	}

	public void setFirstUniform(Uniform firstUniform) {
		this.firstUniform = firstUniform;
	}

	public Team getSig() {
		return sig;
	}

	public void setSig(Team sig) {
		this.sig = sig;
	}

	public Team getPrev() {
		return prev;
	}

	public void setPrev(Team prev) {
		this.prev = prev;
	}

	/**
	 * Este metodo permite añardir un equipo a la lista de equipos que existen en el
	 * juego.
	 * 
	 * @param newTeam El nuevo objeto de tipo Team ques es un nuevo equipo.
	 */
	public void addTeam(Team newTeam) {
		if (sig == null) {
			newTeam.setPrev(this);
			sig = newTeam;
		} else {
			sig.addTeam(newTeam);
		}
	}
	/**
	 * Este metodo permite buscar un equipo dentro de la lista.
	 * 
	 * @param name2 Parametro que contiene el equipo buscado.
	 * @return Retorna el equipo buscado en caso de que exista o null en caso de que
	 *         no exista.
	 */
	public Team searchTeam(String name2) {
		if (sig != null) {
			if (sig.getName().equalsIgnoreCase(name2)) {
				return sig;
			} else {
				return sig.searchTeam(name2);
			}
		} else {
			return null;
		}
	}

	/**
	 * Este metodo permite añadir un unifome a la lista de uniformes existentes.
	 * 
	 * @param newUniform Parametro de tipo Uniform con el uniforme que se desea
	 *                   añadir.
	 */
	public void addUniform(Uniform newUniform) {
		if (firstUniform == null) {
			firstUniform = newUniform;
		} else {
			firstUniform.addUniform(newUniform);
		}

	}

	/**
	 * 
	 * Este metodo me permite buscar un uniforme en la lista.
	 * 
	 * @param img Parametro que contiene la imagen del uniforme.
	 * @return Retorna el uniforme buscado.
	 */
	public Uniform searchUniform(String img) {
		if (firstUniform != null) {
			if (firstUniform.getImg().equals(img)) {
				return firstUniform;
			} else {
				return firstUniform.searchUniform(img);
			}
		} else {
			return null;
		}
	}
	
	
	public String toString() {
		return name;
	}
}
