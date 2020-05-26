package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import exceptions.ExceptionFinalJuego;
import exceptions.ExceptionNotPlayer;
import exceptions.ExceptionNotTeam;

/**
 * Esta es la clase principal del juego donde se inicializa el esqueleto del
 * juego y tambien es el encargado de portar la mayoria de los metodos de este
 * software , es decir, desde aqui se inicia todo y se hacen lso llamados de la
 * operaciones que el usuario decida realizar.
 * 
 * @author guapi
 *
 */
public class Game {

	private Score firstScore;
	private Tournament tournament;
	private Team firstTeam;
	private ArrayList<Team> listaSorteo;

	/**
	 * Este metodo, el cual es el constructor de la clase Game, es el encargado de
	 * realizar el llamado a tres metodos importante que inicializar los aspectos
	 * principales del juego.
	 * 
	 * @return Su retorno es una instancia del juego, es decir, un partida
	 *         ejecutada.
	 * @throws Exception
	 */
	public Game() {
		start();
		organizarEquipos();
		readScore();
	}

	/**
	 * Este metodo me perminte saber cual es el primer equipo que se encuentra en la
	 * lista enlazadas de equipos que existe en el juego.
	 * 
	 * @return Su retorno siempre seré el primer equipo que se encuentre en la
	 *         lista.
	 */
	public Team getFirstTeam() {
		return firstTeam;
	}

	/**
	 * Este metodo es el que me permite añadir un equipo a la lista de equipos que
	 * se encuentran disponibles en el juego.
	 * 
	 * @param n Este es el parametro de tipo String encargado de guardar el nombre
	 *          del equipo que deseamos agregar.
	 */
	public void addTeam(String n) {
		Team newTeam = new Team(n);
		if (firstTeam == null) {
			firstTeam = newTeam;
		} else {
			firstTeam.addTeam(newTeam);
		}
	}

	/**
	 * Este metodo es el encargado de organizar o ordenar los equipos que estan en
	 * la lista datos por un criterio o varios criterios especificos.
	 */
	public void organizarEquipos() {
		if (firstTeam != null) {
			Team act = firstTeam;
			while (act != null) {
				Team sig = act.getSig();
				Team menor = act;
				while (sig != null) {
					if (sig.getName().compareTo(menor.getName()) <= 0) {
						menor = sig;
					}
					sig = sig.getSig();
				}
				if (act.getPrev() != null) {
					act.getPrev().setSig(menor);
				} else {
					firstTeam = menor;
				}
				if (menor.getSig() != null) {
					menor.getSig().setPrev(act);
				}
				if (act.getSig() != null && menor == act.getSig()) {
					menor.setPrev(act.getPrev());
					act.setSig(menor.getSig());
					menor.setSig(act);
					act.setPrev(menor);

				} else {
					if (!menor.getName().equals(act.getName())) {

						if (menor.getPrev() != null) {
							menor.getPrev().setSig(act);
						}
						if (act.getSig() != null) {
							act.getSig().setPrev(menor);
						}

						Team temp = menor.getSig();

						menor.setSig(act.getSig());
						act.setSig(temp);
						Team temp2 = menor.getPrev();
						menor.setPrev(act.getPrev());
						act.setPrev(temp2);
					}

				}
				act = menor.getSig();
			}

		}
	}

	/**
	 * Este metodo es el encargado de buscar un equipo a traves del nombre y lo que
	 * hace es recorrer la lista hastaencontrar el nombre que coincide con el
	 * parametro asignado.
	 * 
	 * @param name Es el parametro que posee el nombre que se desea buscar.
	 * @return Su retorno es el quipo buscado en caso de que exista o null en caso
	 *         de que no exista.
	 */
	public Team searchTeam(String name) {
		if (firstTeam != null) {
			if (firstTeam.getName().equalsIgnoreCase(name)) {
				return firstTeam;
			} else {
				return firstTeam.searchTeam(name);
			}
		} else {
			return null;
		}
	}

	/**
	 * Este metodo es el encargado de añardir los uniformes pertenecientes a cada
	 * uno de los equipos que existen en el juegos.
	 * 
	 * @param nameTeam Este pareametro contiene el nombre del equipo al cual
	 *                 pertenece el uniforme.
	 * @param img      Este paremetro contiene la imagen con el uniforme que al
	 *                 equipo que lo posee.
	 */
	public void addUniform(String nameTeam, String img) {
		Uniform newUniform = new Uniform(img);
		if (searchTeam(nameTeam) != null) {
			searchTeam(nameTeam).addUniform(newUniform);
		}
	}

	/**
	 * Este metodo me permite buscar un uniform especifico ya que los equipos poseen
	 * dos uniformes (local y visitante)
	 * 
	 * @param nameTeam Este paremetro contiene el nombre del equipo.
	 * @param img      Este parametro contienen un archivo imagen el cual representa
	 *                 al uniforme buscado.
	 * @return Su retorno
	 */
	public Uniform searchUniform(String nameTeam, String img) {
		if (searchTeam(nameTeam) != null) {
			return searchTeam(nameTeam).searchUniform(img);
		} else
			return null;
	}

	/**
	 * Este metodo se encarga de llamar al metodo que carga todos los equipos al
	 * juego cuando este se inicia por primera vez atra ves de archivos planos.
	 */
	public void start() {
		loadTeams();
	}

	/**
	 * Este metodo se encarga de hacer la lectura de los archivos planos para cargar
	 * todos estos planos al sistema del juego y asi poder poder seleccionar un
	 * equipo al la hora de jugar.
	 */
	public void loadTeams() {
		File a = new File("./data/Teams.txt");
		try {
			FileReader fr = new FileReader(a);
			BufferedReader br = new BufferedReader(fr);
			br.readLine();
			String cadena = br.readLine();
			while (!cadena.equals("#Uniforms")) {
				addTeam(cadena);
				cadena = br.readLine();
			}
			cadena = br.readLine();
			while (cadena != null && !cadena.isEmpty()) {
				String[] cadena1 = cadena.split(";");
				addUniform(cadena1[0], cadena1[1]);
				cadena = br.readLine();
			}
			br.close();
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {

		}
	}

	/**
	 * Este metodo me permite serealizar todos los puntajes obtenidos durante una
	 * partida. Esto para que podamos tener persistencia dentro del juego.
	 */
	public void serializableScores() {
		try {
			FileOutputStream fs = new FileOutputStream(".\\data\\Scores.txt");
			ObjectOutputStream os = new ObjectOutputStream(fs);
			os.writeObject(firstScore);
			os.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Este metodos me permite deserealizar los puntajes para cargarlos al sistema y
	 * asi podamos comparar frente a otros jugadores.
	 */
	public void readScore() {
		try {
			File f = new File(".\\data\\Scores.txt");
			if (f.exists()) {
				FileInputStream fis = new FileInputStream(f);
				ObjectInputStream ois = new ObjectInputStream(fis);
				firstScore = (Score) ois.readObject();
				ois.close();
				fis.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Esta es la lista de equipos, un ArrayList donde van a ir almacenados todos
	 * los equipo creados dentro del juego.
	 * 
	 * @return Su retorno es una lista de quipos disponibles para jugar.
	 */
	public ArrayList<Team> hacerListaTeam() {
		ArrayList<Team> lt = new ArrayList<Team>();
		Team sig = firstTeam;
		while (sig != null) {
			lt.add(sig);
			sig = sig.getSig();
		}
		return lt;
	}

	/**
	 * Este metodo me permite obtener la lista de quipos para el juego.
	 * 
	 * @return Su retor es una lista con todos equipo disponibles.
	 */
	public ArrayList<Team> getListaSorteo() {
		return listaSorteo;
	}

	/**
	 * Este metodo me permite añadir las posiciones de los equipos a jugar durante
	 * los partidos.
	 * 
	 * @param team1 Parametro que contiene el primer equipo.
	 * @param team2 Parametro que contiene el segundo equipo.
	 */
	public void addPosition(Team team1, Team team2) {
		tournament.addPosition(team1, team2);
	}

	/**
	 * Este metodo es el encargado de generar el torneo al azar, es decir, las
	 * parejas de equipos que van a competir en el juego.
	 */
	public void makeTournament() {
		ArrayList<Integer> selected = new ArrayList<Integer>();
		int max = listaSorteo.size();
		int counter = 0;
		while (counter < 8) {
			int team1 = (int) (Math.random() * max);
			int team2 = (int) (Math.random() * max);
			while (selected.contains(team1)) {
				team1 = (int) (Math.random() * max);
			}
			while (team1 == team2 || selected.contains(team2)) {
				team2 = (int) (Math.random() * max);
			}
			addPosition(listaSorteo.get(team1), listaSorteo.get(team2));
			selected.add(team1);
			selected.add(team2);
			counter++;
		}
	}

	/**
	 * Este metodo me permite añadir un nuevo puntaje a la lista del los mejores 10,
	 * con su nombre y puntaje obtenido.
	 * 
	 * @param n Parametro que guarda el nombre del ususario o participante.
	 * @param e Parametro que contiene el puntaje obtenido por el usuario.
	 */
	public void addScore(String n, int e) {
		Score pri = new Score(n, e);
		if (firstScore == null) {
			firstScore = pri;
		} else {
			firstScore.addScore(pri);
		}
		serializableScores();
	}

	/**
	 * Este metodo me permite ordenar la lista de Scores por el criterio de puntaje
	 * optenido.
	 * 
	 * @return Lista de Scores ordenado por puntaje.
	 */
	public ArrayList<Score> ordenarPorPuntaje() {
		ArrayList<Score> lista = new ArrayList<Score>();
		if (firstScore != null) {
			firstScore.tenScore(lista);
		}
		return lista;
	}

	/**
	 * Este metodo mepermite ordenar la lista de Scores por el criterio de nombre
	 * del usuario.
	 * 
	 * @return Lista de Scores ordenada por el criterio nombre.
	 */
	public ArrayList<Score> ordenarPorNombre() {
		ArrayList<Score> e = ordenarPorPuntaje();
		for (int i = 0; i < e.size(); i++) {
			for (int j = i; j > 0 && (e.get(j - 1).getName().compareTo(e.get(j).getName())) > 0; j--) {
				Score tmp = e.get(j);
				e.set(j, e.get(j - 1));
				e.set(j - 1, tmp);
			}
		}
		return e;
	}

	/**
	 * Este metodo me permite desplazarme en la lista de equipo a la hora de
	 * seleccionar el equipo con el cual se desea jugar.
	 * 
	 * @return Se retorna el equipo siguiente.
	 */
	public ArrayList<Team> pasar() {
		ArrayList<Team> e = new ArrayList<Team>();
		Team actual = firstTeam;
		while (actual != null) {
			e.add(actual);
			actual = actual.getSig();
		}
		return e;
	}

	/**
	 * Este metodo realiza la busqueda binaria de un equipo especifico por su
	 * nombre.
	 * 
	 * @param a Parametro que contiene el nombre que se desea buscar.
	 * @return Retorna el equipo buscado en caso de que exista.
	 * @throws ExceptionNotTeam Exepcion que se lanza en caso de que el equipo
	 *                          buscado no se encuentre dentro de la lista de
	 *                          equipos.
	 */
	public String binarioEquipoNombre(String a) throws ExceptionNotTeam {
		ArrayList<Team> e = pasar();
		String msg = "";
		boolean encontrado = false;
		int inicio = 0;
		int fin = e.size() - 1;
		while (inicio <= fin && !encontrado) {
			int medio = (inicio + fin) / 2;
			if (e.get(medio).getName().equalsIgnoreCase(a)) {
				encontrado = true;
				msg = e.get(medio).toString();
			} else if (e.get(medio).getName().compareToIgnoreCase(a) > 0) {
				fin = medio - 1;
			} else if (e.get(medio).getName().compareToIgnoreCase(a) < 0) {
				inicio = medio + 1;
			}
		}
		if (!encontrado) {
			throw new ExceptionNotTeam();
		}

		return msg;
	}

	/**
	 * Este metodo me permite asignar un euipo a un jugador, para ser mas
	 * especificos, al jugar que se encuentra jugando en ese momento.
	 * 
	 * @param team Parametro que contiene el equipo que va a ser asignado al
	 *             jugador.
	 */
	public void addTeamJugador(Team team) {
		tournament = new Tournament(team);
		listaSorteo = hacerListaTeam();
		makeTournament();
	}

	public Position getPosition() {
		return tournament.getFirstPosition();
	}

	public Match getMatch() {
		return tournament.getMatch();
	}

	/**
	 * Este metodo me permite hacer una busqueda binaria a traves los puntajes o
	 * Scores que se encuentren en la lista.
	 * 
	 * @param a Parametro que contiene el puntaje a buscar.
	 * @return Retorna el usuario que tiene el puntaje buscado en caso de que
	 *         exista.
	 * @throws ExceptionNotPlayer Excepcion que se lanza en caso de que el usuario
	 *                            buscado a traves del puntaje no exista.
	 */
	public String binarioPuntajeNombre(String a) throws ExceptionNotPlayer {
		ArrayList<Score> e = ordenarPorNombre();
		String msg = "";
		boolean encontrado = false;
		int inicio = 0;
		int fin = e.size() - 1;
		while (inicio <= fin && !encontrado) {
			int medio = (inicio + fin) / 2;
			if (e.get(medio).getName().equals(a)) {
				encontrado = true;
				msg = e.get(medio).toString();
			} else if (e.get(medio).getName().compareTo(a) > 0) {
				fin = medio - 1;
			} else if (e.get(medio).getName().compareTo(a) < 0) {
				inicio = medio + 1;
			}
		}
		if (!encontrado) {
			throw new ExceptionNotPlayer();
		}

		return msg;
	}

	public boolean nextMatch() throws ExceptionFinalJuego {
		return tournament.nextMatch();
	}

	public int getScore() {
		return tournament.getScore();
	}
}
