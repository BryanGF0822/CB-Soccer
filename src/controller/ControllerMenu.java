package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Game;
import ui.Main;

public class ControllerMenu implements Initializable {

	private static Main main;
	private static Game game;
	private static Stage stageEscoger;

	@FXML
	private Button liga;
	@FXML
	private Button copa;
	@FXML
	private Button records;
	@FXML
	private Button salir;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		main = new Main();
		game = new Game();
		stageEscoger = new Stage();
	}

	public Game getGame() {
		return game;
	}

	public Stage getStage() {
		return stageEscoger;
	}

	public Main getMain() {
		return main;
	}

	public void clickForGame(ActionEvent ae) throws Exception {
		AnchorPane escoger = FXMLLoader.load(getClass().getResource("/application/EscogerEquipos.fxml"));
		Scene scene = new Scene(escoger);
		main.getStage().close();
		stageEscoger.setScene(scene);
		stageEscoger.setTitle("Escoger Equipo");
		stageEscoger.show();
	}

	public void clickForRecords(ActionEvent ae) throws Exception {
		AnchorPane escoger = FXMLLoader.load(getClass().getResource("/application/Records.fxml"));
		Scene scene = new Scene(escoger);
		main.getStage().close();
		stageEscoger.setScene(scene);
		stageEscoger.setTitle("Records");
		stageEscoger.show();
	}

	public void clickForSalir(ActionEvent ae) throws Exception {
		main.getStage().close();
	}

}
