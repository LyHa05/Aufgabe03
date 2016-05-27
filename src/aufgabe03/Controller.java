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
	private TableColumn<Ort, String>	tvOrt, tvAnkunftsUhrzeit, tvAbreiseUhrzeit;

	@FXML
	private TableColumn<Ort, LocalDate> tvAnkunftsDatum, tvAbreiseDatum;

	@FXML
	private TableColumn<Ort, Integer> tvNr;

	@FXML
	private ObservableList<Ort> reiseOrte;

	/** Konstruktor
	 *  Der Konstruktor erzeugt ein Logik Objekt, welches in einer Instanz
	 *  Variable gespeichert wird und uebergibt this fuer die Referenz aus sich*/
	public Controller() throws Exception {
		lObj = new Logik(this);
		tvTable = new TableView<Ort>();
		//reiseOrte =FXCollections.observableArrayList();

		/** Spalte Nr. (ueber den Index?) */
		tvNr = new TableColumn<>("Nr.");
		tvNr.setCellValueFactory(new PropertyValueFactory<>("dummy"));

		/** Spalte Ort Name */
		tvOrt = new TableColumn<>("Ort");
		tvOrt.setCellValueFactory(new PropertyValueFactory<>("name"));

		/** Spalte Ankunfts Datum */
		tvAnkunftsDatum = new TableColumn<>("Ankunft");
		tvAnkunftsDatum.setCellValueFactory(new PropertyValueFactory<>("ankunft"));

		/** Spalte Ankunfts Uhrzeit */
		tvAnkunftsUhrzeit = new TableColumn<>("Uhrzeit");
		tvAnkunftsUhrzeit.setCellValueFactory(new PropertyValueFactory<>("uhrzeitAnkunft"));

		/** Spalte Abfahrts Datum */
		tvAbreiseDatum = new TableColumn<>("Abfahrt");
		tvAbreiseDatum.setCellValueFactory(new PropertyValueFactory<>("abfahrt"));

		/** Spalte Abfahrts Uhrzeit */
		tvAbreiseUhrzeit = new TableColumn<>("Uhrzeit");
		tvAbreiseUhrzeit.setCellValueFactory(new PropertyValueFactory<>("uhrzeitAbfahrt"));

		//tvTable.getColumns().addAll(tvNr, tvOrt, tvAnkunftsDatum, tvAnkunftsUhrzeit, tvAbreiseDatum, tvAbreiseUhrzeit);
		tvTable.setItems(getSomeItems());
    }

	/** TestMethode zur Erstellung von einigen Ort Objekten und zur Anzeige in der Tabelle! */
	public ObservableList<Ort> getSomeItems() throws Exception{
		reiseOrte =FXCollections.observableArrayList();
		Ort o1, o2, o3, o4;
		LocalDate d1, d2;

		d1 = LocalDate.of(2012, 5, 12);
		d2 = LocalDate.of(2013, 5, 12);

			o1 = new Ort("Hamburg", 12, 12, 8, 22, d1, d2);
			o2 = new Ort("Frankfurt", 1, 12, 8, 22, d1, d2);
			o3 = new Ort("Berlin", 12, 9, 22, 22, d1, d2);
			o4 = new Ort("Bremen", 13, 22, 8, 22, d1, d2);

		reiseOrte.addAll(o1, o2, o3, o4);
		return reiseOrte;
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