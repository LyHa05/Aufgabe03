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
    private final ObjectProperty<Uhrzeit> uhrzeit_ankunft, uhrzeit_abreise;
    private final ObjectProperty<LocalDate> datum_ankunft, datum_abreise;
    private final StringProperty ort_name;

    public Ort(String ort_name, LocalDate datum_ankunft, LocalDate datum_abreise, Uhrzeit uhrzeit_ankunft, Uhrzeit uhrzeit_abreise){
        this.ort_name = new SimpleStringProperty(ort_name);
        this.uhrzeit_ankunft = new ObjectProperty<Uhrzeit>() {

    }


    public ObjectProperty<Ort> OrtProperty(){
        return Ort;
    }
}
