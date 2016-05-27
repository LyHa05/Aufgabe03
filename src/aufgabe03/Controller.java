package aufgabe03;

// Import Custom TextFields

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.Pane;

public class Controller {
	/** Variable Deklaration
	 *  Die Objekte werden automatisch aus der FXML Datei geparst
	 *  wenn sie den gleichen Namen haben, wie ihre fx:id */
	private Logik l_obj;

	/** Die ganzen Variablen Namen muessen angepasst werden .. Konvention und so! */
	@FXML
	private Button 				bt1_start, bt2_zwischen, bt3_ende;

	@FXML
	private DatePicker 			dp_start, dp2_zwischen_1, dp2_zwischen_2, dp4_ende;

	@FXML
	private TextField 			tf08_einfuegen_ort;

	@FXML
	private LetterTextField 	tf03_ort_start, tf09_ort_zwischen, tf12_ort_ende;

	@FXML
	private NumberTextField 	tf01_std_start, tf02_min_start, tf04_std_zwischen_1,
								tf05_min_zwischen_1, tf06_std_zwischen_2, tf07_min_zwischen_2,
								tf10_std_ende, tf11_min_ende;
	@FXML
	private Label 				l1_ueberschrift, l2_netto_reise, l3_brutto_reise;

	@FXML
	private Pane 				p1_gesamt, p2_reise, p3_start, p4_zwischen, p5_ende, p6_zeit;

	@FXML
	private ListView<Ort> 		lv1_reise;

	private ObservableList<Ort> reiseItems;

	/** Konstruktor
	 *  Der Konstruktor erzeugt ein Logik Objekt, welches in einer Instanz
	 *  Variable gespeichert wird und uebergibt this fuer die Referenz aus sich*/
	public Controller(){
		lv1_reise = new ListView<Ort>();
		reiseItems =FXCollections.observableArrayList();
		lv1_reise.setItems(reiseItems);
		l_obj = new Logik(this);
	}

	/** Methoden */
	
	@FXML
	public void buttonStartPressed() {
		try {
			l_obj.startHinzufuegen(dp_start, tf01_std_start, tf02_min_start, tf03_ort_start);
		} catch (Exception e) {
			e.printStackTrace();
			Alert alert = new Alert(Alert.AlertType.WARNING);
			alert.setTitle("Fehler beim Hinzufuegen des Startortes");
			alert.setHeaderText("Beim hinzufuegen des Startortes ist ein Fehler aufgetreten");
			alert.setContentText(e.getMessage());
			alert.showAndWait();
		}
	}
	
	@FXML
	public void buttonZwischenPressed() {

	}

	@FXML
	public void buttonEndePressed(){

	}

	@FXML
	public void buttonReiseErstellenPressed(){

	}

	protected ObservableList getReiseList(){
		return reiseItems;
	}
}