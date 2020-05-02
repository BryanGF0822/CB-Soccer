package ui;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import model.Match;

public class ControllerCancha implements Initializable {

	private static ControllerMenu cm;

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
		cm = new ControllerMenu();
		t1.setText("Colombia");
		t2.setText("Alemania");
		gt1.setText("0");
		gt2.setText("0");
		segundos.setText("0");
		try {
			Image image = new Image(new FileInputStream(".\\img\\Cancha.png"));
			cancha.setImage(image);
			Image image1 = new Image(new FileInputStream(".\\img\\ColombiaLocal.png"));
			jugador.setImage(image1);
			Image image2 = new Image(new FileInputStream(".\\img\\AlemaniaLocal.png"));
			oponente.setImage(image2);
			Image image3 = new Image(new FileInputStream(".\\img\\Ball.png"));
			balon.setX(175);
			balon.setY(175);
			balon.setImage(image3);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void arbolPintado(ActionEvent ae) throws Exception {
		AnchorPane escoger = FXMLLoader.load(getClass().getResource("/application/FinDelJuego.fxml"));
		Scene scene = new Scene(escoger);
		cm.getStage().setScene(scene);
		cm.getStage().setTitle("Fin del juego");
		cm.getStage().show();
	}
	
}
