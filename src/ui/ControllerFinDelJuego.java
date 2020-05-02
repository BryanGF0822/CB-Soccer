package ui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ControllerFinDelJuego implements Initializable{

	private Stage stageFin;
	private ControllerMenu cm;
	
	@FXML
	private Button menu;
	@FXML
	private Text puntaje;
	@FXML
	private TextField nombre;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		cm = new ControllerMenu();
		stageFin = new Stage();	
		puntaje.setText("1000000");
	}
	
	public void guardarJuego(ActionEvent ae) throws Exception {
		stageFin.close();
		cm.getMain().start(cm.getStage());
		cm.getMain().getStage().show();
	}
}
