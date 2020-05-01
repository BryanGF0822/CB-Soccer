package model;

public class Team {

	private String name;
	private Uniform firstUniform;
	private Team sig;
	private Team prev;
	
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
	
	
	
}
