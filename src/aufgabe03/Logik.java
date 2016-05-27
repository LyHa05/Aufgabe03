package aufgabe03;

import javafx.collections.ObservableList;
import javafx.scene.control.DatePicker;

import java.time.LocalDate;

/**
 * @author  Chris Thiele, Lydia Pflug
 * @date    24.05.2016
 *
 * Die Klasse 'Logik' repraesentiert die Logik Schicht des Programms.
 */
public class Logik{
    private Controller conObj;
    private ObservableList<Ort> ortListe;

    public Logik(Controller con_obj){
        this.conObj = con_obj;
    }


    public void startHinzufuegen(LocalDate dp,Integer std,Integer min, String name) throws Exception{
        if(!(conObj.getListView().getItems().size() == 0)){
            throw new IllegalArgumentException("Es ist bereits ein Startort vorhanden");
        }

        Ort temp_ort = new Ort(name, std, min, std, min, dp, dp);

        conObj.getListView().getItems().add(temp_ort);
        temp_ort.setIndex(conObj.getListView().getItems().indexOf(temp_ort));
    }

    /** Ist momentan noch so implementiert, dass sie nach dem letzten Element den Ort anfuegt */
    public void zwischenStationHinzufuegen(LocalDate dpAnkunft, LocalDate dpAbfahrt, int stdAnk, int minAnk, int stdAbf,int minAbf, String name) throws Exception{
        /** Wenn hier schon Eingabefehler vom Nutzer vorliegen, werden diese durch die Ortklasse "geworfen" */
        Ort temp_ort = new Ort(name, stdAnk, minAnk, stdAbf, minAbf, dpAnkunft, dpAbfahrt);

        if(conObj.getListView().getItems().size() == 0){
            throw new IllegalArgumentException("Zuerst muss ein Startort eingefuegt werden.");
        }

        if(conObj.getListView().getItems().get((conObj.getListView().getItems().size()-1)).compareTo(temp_ort) == 1){
            throw new IllegalArgumentException("Der Ankunftszeitpunkt darf nicht vor dem letzten Abfahrtszeitpunkt liegen.");
        }

        conObj.getListView().getItems().add(temp_ort);
        temp_ort.setIndex(conObj.getListView().getItems().indexOf(temp_ort));
    }

    /** geht nicht */
    public void setOrtListe(ObservableList<Ort> ortListe){
        this.ortListe = ortListe;
    }
}
