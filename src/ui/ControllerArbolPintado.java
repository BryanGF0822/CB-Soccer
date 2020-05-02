package ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class ControllerArbolPintado implements Initializable {

	private ControllerMenu cm;
	private GraphicsContext gc;
	@FXML
	private Canvas arbolPintado;
	@FXML
	private Button jugar;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		cm = new ControllerMenu();
		gc = arbolPintado.getGraphicsContext2D();
		dibujarArbol();
	}

	public void clickJugar(ActionEvent ae) throws Exception {
		AnchorPane escoger = FXMLLoader.load(getClass().getResource("/application/Cancha.fxml"));
		Scene scene = new Scene(escoger);
		cm.getStage().setScene(scene);
		cm.getStage().setTitle("Campo de juego");
		cm.getStage().show();
	}

	public void dibujarArbol() {
		gc.fillText("Arbol de etapas del toreno", 150, 200);
	}

}
