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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ControllerEscogerEquipos implements Initializable {

	private static ControllerMenu cm;
	private Stage stageUniforme;
	@FXML
	private Button anterior;
	@FXML
	private Button empezar;
	@FXML
	private Button siguiente;
	@FXML
	private Label equipo;
	@FXML
	private ImageView uniform;
	@FXML
	private Button local;
	@FXML
	private Button visitante;
	@FXML
	private TextField busca;
	@FXML
	private Label encontro;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		cm = new ControllerMenu();
		equipo.setText("Colombia");
		Image image;
		try {
			image = new Image(new FileInputStream("img/Uniformecolombia.png"));
			uniform.setImage(image);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		stageUniforme = new Stage();
	}

	public void clickJugar(ActionEvent ae) throws Exception {
		AnchorPane escoger = FXMLLoader.load(getClass().getResource("/application/ArbolPintado.fxml"));
		Scene scene = new Scene(escoger);
		cm.getStage().setScene(scene);
		cm.getStage().setTitle("Etapas del torneo");
		cm.getStage().show();
	}

	public void clickMenu(ActionEvent ae) throws Exception {
		stageUniforme.close();
		cm.getMain().start(cm.getStage());
	}

	public void clickPrev(ActionEvent ae) throws Exception {

	}

	public void clicSiguiente(ActionEvent ae) throws Exception {

	}

	public void clickLocal(ActionEvent ae) throws Exception {

	}

	public void clickVisitante(ActionEvent ae) throws Exception {

	}

	public void clickUniforme(MouseEvent ae) {

	}

	public void clickEquipo(MouseEvent ae) {

	}

	public void buscarEquipo(ActionEvent ea) throws Exception {

	}
}
