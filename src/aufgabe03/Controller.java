package aufgabe03;

// Import Custom TextFields

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class Controller implements Initializable {
	/** Variable Deklaration
	 *  Die Objekte werden automatisch aus der FXML Datei geparst
	 *  wenn sie den gleichen Namen haben, wie ihre fx:id */
	private Logik lObj;


	/** 1 Startort, 0 Zwischenort, -1 Endort*/
	private int stationFlag;

	/** Die ganzen Variablen Namen muessen angepasst werden .. Konvention und so! */
	@FXML
	private DatePicker 			dp1Start, dp2Zwischen1, dp3Zwischen2, dp4Ende;

	@FXML
	private TextField 			tf08EinfuegenOrt;

	@FXML
	private LetterTextField 	tf03OrtStart, tf12OrtEnde;

	@FXML
	private NumberTextField 	tf01StdStart, tf02MinStart, tf04StdZwischen1,
								tf05MinZwischen1, tf06StdZwischen2, tf07MinZwischen2,
								tf10StdEnde, tf11MinEnde, tf09OrtZwischen;
	@FXML
	private Label 				l2NettoReise, l3BruttoReise;

	/** Tabellen Struktur erstellen */
	@FXML private TableView<Ort> tvTable;

	@FXML
	private TableColumn<Ort, String>	tvOrt, tvAnkunftsUhrzeit, tvAbreiseUhrzeit;

	@FXML
	private TableColumn<Ort, LocalDate> tvAnkunftsDatum, tvAbreiseDatum;

	@FXML
	private TableColumn<Ort, Integer> tvNr;

	@FXML
	private ObservableList<Ort> reiseOrte =FXCollections.observableArrayList();

	@Override
	public void initialize(URL location, ResourceBundle resources){
		tvNr.setCellValueFactory(new PropertyValueFactory<Ort, Integer>("index"));
		tvOrt.setCellValueFactory(new PropertyValueFactory<Ort, String>("name"));
		tvAnkunftsDatum.setCellValueFactory(new PropertyValueFactory<Ort, LocalDate>("ankunft"));
		tvAnkunftsUhrzeit.setCellValueFactory(new PropertyValueFactory<Ort, String>("uhrzeitAnkunft"));
		tvAbreiseDatum.setCellValueFactory(new PropertyValueFactory<Ort, LocalDate>("abfahrt"));
		tvAbreiseUhrzeit.setCellValueFactory(new PropertyValueFactory<Ort, String>("uhrzeitAbfahrt"));

		try {
			tvTable.getItems().setAll(reiseOrte);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/** Konstruktor
	 *  Der Konstruktor erzeugt ein Logik Objekt, welches in einer Instanz
	 *  Variable gespeichert wird und uebergibt this fuer die Referenz aus sich*/
	public Controller(){
		lObj = new Logik(this);
    }

	/** Methoden */
	
	@FXML
	public void buttonStartPressed() {
		stationFlag = 1;
		try {
			lObj.startHinzufuegen(dp1Start.getValue(), Integer.parseInt(tf01StdStart.getText()), Integer.parseInt(tf02MinStart.getText()), tf03OrtStart.getText(), 1);
		} catch (Exception e) {
			e.printStackTrace();
			Alert alert = new Alert(Alert.AlertType.WARNING);
			alert.setTitle("Fehler beim Hinzufuegen des Startortes");
			alert.setHeaderText("Beim Hinzufuegen des Startortes ist ein Fehler aufgetreten");
			alert.setContentText(e.getMessage());
			alert.showAndWait();
		}
	}
	
	@FXML
	public void buttonZwischenPressed() {
		stationFlag = 0;
		try {
			/** Memo an mich - die Parameter sind eventuell doch etwas viele */
			lObj.zwischenStationHinzufuegen(dp2Zwischen1.getValue(), dp3Zwischen2.getValue(), Integer.parseInt(tf04StdZwischen1.getText()),
											Integer.parseInt(tf05MinZwischen1.getText()), Integer.parseInt(tf06StdZwischen2.getText()),
											Integer.parseInt(tf07MinZwischen2.getText()), tf09OrtZwischen.getText(), 0);
		} catch (Exception e) {
			e.printStackTrace();
			Alert alert = new Alert(Alert.AlertType.WARNING);
			alert.setTitle("Fehler beim Hinzufuegen des Zwischenortes");
			alert.setHeaderText("Beim hinzufuegen des Zwischenortes ist ein Fehler aufgetreten");
			alert.setContentText(e.getMessage());
			alert.showAndWait();
		}
	}

	@FXML
	public void buttonEndePressed(){
		try {
			lObj.endeHinzufuegen(dp4Ende.getValue(), Integer.parseInt(tf10StdEnde.getText()), Integer.parseInt(tf11MinEnde.getText()), tf12OrtEnde.getText(), -1);
		} catch (Exception e) {
			e.printStackTrace();
			Alert alert = new Alert(Alert.AlertType.WARNING);
			alert.setTitle("Fehler beim Hinzufuegen des Endortes");
			alert.setHeaderText("Beim hinzufuegen des Endortes ist ein Fehler aufgetreten");
			alert.setContentText(e.getMessage());
			alert.showAndWait();
		}
	}

	@FXML
	public void buttonChangeZwischenOrt(){
		try {
			lObj.changeZwischenStation(dp2Zwischen1.getValue(), dp3Zwischen2.getValue(), Integer.parseInt(tf04StdZwischen1.getText()),
					Integer.parseInt(tf05MinZwischen1.getText()), Integer.parseInt(tf06StdZwischen2.getText()),
					Integer.parseInt(tf07MinZwischen2.getText()), tf09OrtZwischen.getText(), 0, Integer.parseInt(tf08EinfuegenOrt.getText()));
		} catch (Exception e) {
			e.printStackTrace();
			Alert alert = new Alert(Alert.AlertType.WARNING);
			alert.setTitle("Fehler beim Aendern eines Zwischenortes");
			alert.setHeaderText("Beim Aendern des Zwischenortes ist ein Fehler aufgetreten");
			alert.setContentText(e.getMessage());
			alert.showAndWait();
		}
	}

	@FXML
	public void buttonReiseErstellenPressed(){
		try {
			lObj.berechnenZeit();
		} catch (Exception e) {
			e.printStackTrace();
			Alert alert = new Alert(Alert.AlertType.WARNING);
			alert.setTitle("Beim Berechnen ist ein Fehler aufgetreten");
			alert.setHeaderText("Ein Fehler ist beim Berechnen der Brutto und Netto Zeit aufgetreten.");
			alert.setContentText(e.getMessage());
			alert.showAndWait();
		}
	}

	protected void updateIndex(){
		for(Ort tempOrt : reiseOrte){
			tempOrt.setIndex(reiseOrte.indexOf(tempOrt));
		}
	}

	protected TableView<Ort> getListView(){
		return tvTable;
	}

	protected Label getNettoLabel(){
		return l2NettoReise;
	}

	protected Label getBruttoLabel(){
		return l3BruttoReise;
	}

	/** Setter-Methode für ReiseOrte (ggf. wieder entfernen)*/
	void setReiseOrte(ObservableList<Ort> reiseOrte) {
		this.reiseOrte = reiseOrte;
	}
}