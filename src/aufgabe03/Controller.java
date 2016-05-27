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
	public Controller(){
		tvTable = new TableView<Ort>();
		reiseItems =FXCollections.observableArrayList();
		tvTable.setItems(reiseItems);
		l_obj = new Logik(this);


		/** Hier wird testweise eine Reise Orte in die Tabelle geschrieben */
		Ort o1, o2, o3, o4;
		LocalDate lo1;
		Uhrzeit uh1;

		try {
			uh1 = new Uhrzeit(12,12);
		} catch (Exception e) {
			e.printStackTrace();
		}

		lo1 = LocalDate.of(Integer.parseInt("2016"), Integer.parseInt("8"), Integer.parseInt("9"));

		o1 = new Ort("Hamburg", lo1, lo1, uh1, uh1); /** Ist initialisiert */
		o2 = new Ort("Berlin", lo1, lo1, uh1, uh1);
		o3 = new Ort("Bremen", lo1, lo1, uh1, uh1);
		o4 = new Ort("Frankfurt", lo1, lo1, uh1, uh1);

		tvTable.getItems().addAll(o1, o2, o3, o4);

		tvNr.setCellFactory(new PropertyValueFactory<Ort, String>());
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

	protected void createTableColum(){
		tvNr = new TableColumn<>("Nr.");
	}

	protected void SetOrtObjekt(int index, Ort ort_obj){

	}

	protected TableView<Ort> getListView(){
		return tvTable;
	}
}