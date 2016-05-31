package aufgabe03;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

/**
 * @author  Chris Thiele, Lydia Pflug
 * @date    24.05.2016
 *
 * Die Klasse 'Controller' erstellt die Objekte der fxml-Datei und definiert die Methoden fuer das Ausfuehren der Buttons.
 */

public class Controller implements Initializable {
	/** Variable Deklaration
	 *  Die Objekte werden automatisch aus der FXML Datei geparst
	 *  wenn sie den gleichen Namen haben, wie ihre fx:id */
	private Logik lObj;

	@FXML
	private DatePicker 			dp1Start, dp2Zwischen1, dp3Zwischen2, dp4Ende;

	@FXML
	private TextField 			tf08EinfuegenOrt;

	@FXML
	private LetterTextField 	tf03OrtStart, tf12OrtEnde, tf09OrtZwischen;

	@FXML
	private NumberTextField 	tf01StdStart, tf02MinStart, tf04StdZwischen1,
								tf05MinZwischen1, tf06StdZwischen2, tf07MinZwischen2,
								tf10StdEnde, tf11MinEnde;
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

	 /**  Der Konstruktor erzeugt ein Logik Objekt, welches in einer Instanz
	 *  Variable gespeichert wird und uebergibt this fuer die Referenz aus sich*/
	public Controller(){
		lObj = new Logik(this);
    }

	/**Methode generiert Startort, stationFlag wird mit 1 fuer Start uebergeben.*/
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

	/**Methode generiert Zwischenort, stationFlag wird mit 0 fuer Zwischenort uebergeben.*/
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

	/**Methode generiert Endort, stationFlag wird mit -1 fuer Endort uebergeben.*/
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

	/**Methode generiert Zwischenort und tauscht ihn gegen anderen Zwischenort aus, stationFlag wird mit 0 fuer Zwischenort uebergeben.*/
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

	/**Methode generiert Zwischenort und setzt ihn vor Station ein, stationFlag wird mit 0 fuer Zwischenort uebergeben.*/
	@FXML
	public void buttonZwischenStationDavorEinfuegen(){
		try {
			lObj.zwischenStationDavorEinfuegen(dp2Zwischen1.getValue(), dp3Zwischen2.getValue(), Integer.parseInt(tf04StdZwischen1.getText()),
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

	/**Methode generiert Zwischenort und setzt ihn nach Station ein, stationFlag wird mit 0 fuer Zwischenort uebergeben.*/
	@FXML
	public void buttonZwischenStationDanachEinfuegen(){
		try {
			lObj.zwischenStationDanachEinfuegen(dp2Zwischen1.getValue(), dp3Zwischen2.getValue(), Integer.parseInt(tf04StdZwischen1.getText()),
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

	/** Methode löst nach Zusammenstellung der Orte die Zeitberechnung aus.*/
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

	/** Methode setzt Index der TableView nach Veränderung der Zwischenorte neu.*/
	protected void updateIndex(){
		for(Ort tempOrt : tvTable.getItems()){
			tempOrt.setIndex(tvTable.getItems().indexOf(tempOrt));
		}
	}

	/* Getter-Methode*/
	protected TableView<Ort> getListView(){
		return tvTable;
	}

	/* Getter-Methode*/
	protected Label getNettoLabel(){
		return l2NettoReise;
	}

	/* Getter-Methode*/
	protected Label getBruttoLabel(){
		return l3BruttoReise;
	}

	/* Getter-Methode*/
	public Logik getlObj() {
		return lObj;
	}
}