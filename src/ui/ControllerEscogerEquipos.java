package ui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class ControllerEscogerEquipos implements Initializable {

	private static ControllerMenu cm;
	
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
		
	}

}
