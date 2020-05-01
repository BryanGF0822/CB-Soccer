package ui;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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
}
