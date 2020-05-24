package model;

public class Team {

	private String name;
	private Uniform firstUniform;
	private Team sig;
	private Team prev;

	/**
	 * [Team description]
	 * @param  name [description]
	 * @return      [description]
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
	 * [addTeam description]
	 * @param newTeam [description]
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
	 * [searchTeam description]
	 * @param  name2 [description]
	 * @return       [description]
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
	 * [addUniform description]
	 * @param newUniform [description]
	 */
	public void addUniform(Uniform newUniform) {
		if (firstUniform == null) {
			firstUniform = newUniform;
		} else {
			firstUniform.addUniform(newUniform);
		}

	}

	/**
	 * [searchUniform description]
	 * @param  img [description]
	 * @return     [description]
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
	
	/**
	 * [toString description]
	 * @return [description]
	 */
	public String toString() {
		return name;
	}
}
