package aufgabe03;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Controller {
	@FXML
	private Label label1;
	
	@FXML
	public void buttonPressed() {
		label1.setText("Button wurde gedrückt!");
	}
	
	@FXML
	public void buttonPressed2() {
		label1.setText(" ");
	}
}