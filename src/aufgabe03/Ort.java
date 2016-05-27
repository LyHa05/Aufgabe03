package aufgabe03;

import javafx.beans.InvalidationListener;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

import java.time.LocalDate;


/**
 * @author  Chris Thiele, Lydia Pflug
 * @date    24.05.2016
 *
 * Die Klasse 'Ort' repraesentiert einen Reise Ort, welcher eine Ankunftsdatum und eine Ankunftsuhrzeit, sowie
 * ein Abfahrtsdatum und eine Abfahrtsuhrzeit enthaelt.
 */

public class Ort {
    private final ObjectProperty<Uhrzeit> uhrzeitAnkunft, uhrzeitAbreise;
    private final ObjectProperty<LocalDate> datumAnkunft, datumAbreise;
    private final StringProperty ortName;

    public Ort(String ort_name, LocalDate datum_ankunft, LocalDate datumAbreise, Uhrzeit uhrzeitAnkunft, Uhrzeit uhrzeitAbreise){
        this.ortName = new SimpleStringProperty(ortName);
        this.uhrzeitAnkunft = new ObjectProperty<Uhrzeit>() {

    }

// müsste das hier nicht return this oder so heißen? du willst doch eigentlich das Objekt zurückgeben und nicht die Klasse
    public ObjectProperty<Ort> OrtProperty(){
        return Ort;
    }
}
