package controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

import exceptions.ExceptionNotTeam;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Team;

public class ControllerEscogerEquipos implements Initializable {

	private static ControllerMenu cm;
	private Stage stageUniforme;
	private boolean selTeam;
	private boolean selUni;

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
		equipo.setText(cm.getGame().getFirstTeam().getName());
		selTeam = false;
		selUni = false;
		Image image;
		try {
			image = new Image(new FileInputStream(cm.getGame().getFirstTeam().getFirstUniform().getImg()));
			uniform.setImage(image);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		stageUniforme = new Stage();
	}

	public void clickJugar(ActionEvent ae) throws Exception {
		if (selTeam && selUni) {
			AnchorPane escoger = FXMLLoader.load(getClass().getResource("/application/ArbolPintado.fxml"));
			Scene scene = new Scene(escoger);
			cm.getStage().setScene(scene);
			cm.getStage().show();
		} else {
			Alert a = new Alert(AlertType.ERROR);
			a.setContentText("no has escogido equipo y/o uniforme");
			a.show();
		}
	}

	public void clickMenu(ActionEvent ae) throws Exception {
		stageUniforme.close();
		cm.getMain().start(cm.getStage());
	}

	public void clickPrev(ActionEvent ae) throws Exception {
		Team actual = cm.getGame().searchTeam(equipo.getText());
		if (actual.getPrev() != null) {
			equipo.setText(actual.getPrev().getName());
		}
		if (actual.getPrev() != null && actual.getPrev().getFirstUniform() != null) {
			Image image = new Image(new FileInputStream(actual.getPrev().getFirstUniform().getImg()));
			uniform.setImage(image);
		}
	}

	public void clicSiguiente(ActionEvent ae) throws Exception {
		Team actual = cm.getGame().searchTeam(equipo.getText());
		if (actual.getSig() != null) {
			equipo.setText(actual.getSig().getName());
		}
		if (actual.getSig() != null && actual.getSig().getFirstUniform() != null) {
			Image image = new Image(new FileInputStream(actual.getSig().getFirstUniform().getImg()));
			uniform.setImage(image);
		}
	}

	public void clickLocal(ActionEvent ae) throws Exception {
		Team actual = cm.getGame().searchTeam(equipo.getText());
		if (actual.getFirstUniform() != null) {
			Image image = new Image(new FileInputStream(actual.getFirstUniform().getImg()));
			uniform.setImage(image);
		}
	}

	public void clickVisitante(ActionEvent ae) throws Exception {
		Team actual = cm.getGame().searchTeam(equipo.getText());
		if (actual.getFirstUniform() != null && actual.getFirstUniform().getNext() != null) {
			Image image = new Image(new FileInputStream(actual.getFirstUniform().getNext().getImg()));
			uniform.setImage(image);
		}
	}

	public void clickUniforme(MouseEvent ae) {
		if (selTeam == true) {
			uniform.setOpacity(0.65);
			local.setVisible(false);
			visitante.setVisible(false);
			selUni = true;
		} else {
			Alert a = new Alert(AlertType.ERROR);
			a.setContentText("no has escogido equipo");
			a.show();
		}
	}

	public void clickEquipo(MouseEvent ae) {
		anterior.setVisible(false);
		siguiente.setVisible(false);
		equipo.setOpacity(0.65);
		selTeam = true;
		cm.getGame().addTeamJugador(cm.getGame().searchTeam(equipo.getText()));
	}

	public void buscarEquipo(ActionEvent ea) throws Exception {
		try {
			encontro.setText(cm.getGame().binarioEquipoNombre(busca.getText()));
			Team actual = cm.getGame().searchTeam(busca.getText());
			equipo.setText(actual.getName());
			Image image = new Image(new FileInputStream(actual.getFirstUniform().getImg()));
			uniform.setImage(image);
		} catch (ExceptionNotTeam e) {
			encontro.setText(e.getMessage());
		}
	}
}
