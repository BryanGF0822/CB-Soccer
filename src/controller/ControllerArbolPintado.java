package controller;

import java.net.URL;
import java.util.ResourceBundle;

import exceptions.ExceptionFinalJuego;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import model.Position;

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
		try {

			if (cm.getGame().nextMatch()) {
				dibujarArbol();
			} else {
				Parent escoger = FXMLLoader.load(getClass().getResource("/application/Cancha.fxml"));
				Scene scene = new Scene(escoger);
				cm.getStage().setScene(scene);
				cm.getStage().show();
			}
		} catch (ExceptionFinalJuego e) {
			changeScreen();
		}
	}

	public void dibujarArbol() {
		gc.clearRect(0, 0, arbolPintado.getWidth(), arbolPintado.getHeight());
		pintarNodo(20, 0, cm.getGame().getPosition(), (int) arbolPintado.getWidth());
	}

	public void pintarNodo(int h, int w, Position pos, int dim) {
		gc.fillText(pos.getFase(), w + (dim / 2), h);
		gc.fillText(pos.getTeam1() + "", w + (dim / 2), h + 20);
		gc.fillText(pos.getTeam2() + "", w + (dim / 2), h + 40);
		if (pos.getLeft() != null && pos.getRight() != null) {
			pintarNodo(h + 60, w, pos.getLeft(), dim / 2);
			pintarNodo(h + 60, w + dim / 2, pos.getRight(), dim / 2);

		}
	}
	
	public void changeScreen() throws Exception {
		Parent escoger = FXMLLoader.load(getClass().getResource("/application/FinDelJuego.fxml"));
		Scene scene = new Scene(escoger);
		cm.getStage().setScene(scene);
		cm.getStage().show();
	}
}
