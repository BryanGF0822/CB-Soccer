package ui;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.Score;

public class ControllerRecords implements Initializable {

	private static ControllerMenu cm;
	private Stage stageRecords;

	@FXML
	private Label b;

	@FXML
	private TextField a;

	@FXML
	private ListView<String> puntaje;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		cm = new ControllerMenu();
		stageRecords = new Stage();

	}

	public void clickMenu(ActionEvent ae) throws Exception {
		stageRecords.close();
		cm.getMain().start(cm.getStage());
	}

	public void ordenarPorNombre(ActionEvent e) {

	}

	public void ordenarPorPuntaje(ActionEvent e) {

	}

	public void buscarJugador(ActionEvent e) {

	}
}
