package ui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import model.Match;

public class ControllerCancha implements Initializable {

	private static ControllerMenu cm;
	private Match match;
//	private BallonThread bt;
//	private ClockThread ct;
//	private MarcadorThread mt;
//	private OpponentThread op;
	
	@FXML
	private ImageView jugador;
	@FXML
	private ImageView oponente;
	@FXML
	private ImageView balon;
	@FXML
	private ImageView cancha;
	@FXML
	private Text segundos;
	@FXML
	private Text gt1;
	@FXML
	private Text gt2;
	@FXML
	private Text t1;
	@FXML 
	private Text t2;
	@FXML
	private Button continuar;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}

	
}
