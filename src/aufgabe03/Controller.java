package aufgabe03;

// Import Custom TextFields

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

import java.time.LocalDate;

public class Controller {
	/** Variable Deklaration
	 *  Die Objekte werden automatisch aus der FXML Datei geparst
	 *  wenn sie den gleichen Namen haben, wie ihre fx:id */
	private Logik lObj;

	/** Die ganzen Variablen Namen muessen angepasst werden .. Konvention und so! */
	@FXML
	private Button 				bt1Start, bt2Zwischen, bt3Ende;

	@FXML
	private DatePicker 			dp1Start, dp2Zwischen1, dp2Zwischen2, dp4Ende;

	@FXML
	private TextField 			tf08EinfuegenOrt;

	@FXML
	private LetterTextField 	tf03OrtStart, tf09OrtZwischen, tf12OrtEnde;

	@FXML
	private NumberTextField 	tf01StdStart, tf02MinStart, tf04StdZwischen_1,
								tf05MinZwischen1, tf06StdZwischen2, tf07MinZwischen2,
								tf10StdEnde, tf11MinEnde;
	@FXML
	private Label 				l1Ueberschrift, l2NettoReise, l3BruttoReise;

	@FXML
	private Pane 				p1Gesamt, p2Reise, p3Start, p4Zwischen, p5Ende, p6Zeit;

	/** Tabellen Struktur erstellen */
	@FXML
	private TableView<Ort> 		tvTable;

	@FXML
	private TableColumn<Ort, String>	tvNr, tvOrt, tvAnkunftsDatum, tvAnkunftsUhrzeit, tvAbreiseDatum, tvAbreiseUhrzeit;

	@FXML
	private ObservableList<Ort> reiseItems;

	/** Konstruktor
	 *  Der Konstruktor erzeugt ein Logik Objekt, welches in einer Instanz
	 *  Variable gespeichert wird und uebergibt this fuer die Referenz aus sich*/
	public Controller() throws Exception {
		tvTable = new TableView<Ort>();
		reiseItems =FXCollections.observableArrayList();
		tvTable.setItems(reiseItems);
		lObj = new Logik(this);

    }

	/** Methoden */
	
	@FXML
	public void buttonStartPressed() {
		try {
			lObj.startHinzufuegen(dp1Start, tf01StdStart, tf02MinStart, tf03OrtStart);
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

	/**protected void createTableColum(){
		tvNr = new TableColumn<>("Nr.");
	}

	protected void SetOrtObjekt(int index, Ort ort_obj){

	} */

	protected TableView<Ort> getListView(){
		return tvTable;
	}
}