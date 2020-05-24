package controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import exceptions.ExceptionNotPlayer;
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
		ObservableList<String> list = FXCollections.observableList(new ArrayList<String>());
		ArrayList<Score> list1 = cm.getGame().ordenarPorNombre();
		for (int i = 0; i < list1.size(); i++) {
			list.add((i+1) + ". " + list1.get(i));
		}
		puntaje.setItems(list);
	}

	public void ordenarPorPuntaje(ActionEvent e) {
		ObservableList<String> list = FXCollections.observableList(new ArrayList<String>());
		ArrayList<Score> list1 = cm.getGame().ordenarPorPuntaje();
		for (int i = 0; i < list1.size(); i++) {
			list.add((i+1) + ". " + list1.get(i));
		}
		puntaje.setItems(list);
	}

	public void buscarJugador(ActionEvent e) {
		try {
			b.setText(cm.getGame().binarioPuntajeNombre(a.getText()));
		} catch (ExceptionNotPlayer e1) {
			b.setText(e1.getMessage());
		}
	}
}
