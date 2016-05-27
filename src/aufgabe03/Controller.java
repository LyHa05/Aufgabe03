package aufgabe03;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import aufgabe03.Logik
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class Controller {
	/** Variable Deklaration
	 *  Die Objekte werden automatisch aus der FXML Datei geparst
	 *  wenn sie den gleichen Namen haben, wie ihre fx:id */
	private Logik l_obj;

	@FXML
	private Button bt1_start, bt2_zwischen, bt3_ende;

	@FXML
	private DatePicker dp_start, dp2_zwischen_1, dp2_zwischen_2, dp4_ende;

	@FXML
	private TextField 	tf01_std_start, tf02_min_start, tf03_ort_start,
						tf04_std_zwischen_1, tf05_min_zwischen_1, tf06_std_zwischen_2,
						tf07_min_zwischen_2, tf08_einfuegen_ort, tf09_ort_zwischen,
						tf10_std_ende, tf11_min_ende, tf12_ort_ende;

	@FXML
	private Label l1_ueberschrift, l2_netto_reise, l3_brutto_reise;

	@FXML
	private Pane p1_gesamt, p2_reise, p3_start, p4_zwischen, p5_ende, p6_zeit;

	/** Konstruktor
	 *  Der Konstruktor erzeugt ein Logik Objekt, welches in einer Instanz
	 *  Variable gespeichert wird */
	public Controller(){
		l_obj = new Logik();
	}

	/** Methoden */
	
	@FXML
	public void buttonPressed() {
	}
	
	@FXML
	public void buttonPressed2() {
	}
}