package aufgabe03;

import javafx.collections.ObservableList;

import java.time.LocalDate;
import java.util.Iterator;

/**
 * @author  Chris Thiele, Lydia Pflug
 * @date    24.05.2016
 * Test Git mit IntelliJ
 * Die Klasse 'Logik' repraesentiert die Logik Schicht des Programms.
 */
public class Logik{
    private Controller conObj;
    private boolean startUndEnde = false;

    public Logik(Controller con_obj){
        this.conObj = con_obj;
    }


    /** Die Methode "startHinzufuegen" fuegt einen Startpunkt in die Liste ein, sofern noch keiner in der Liste ist */
    public void startHinzufuegen(LocalDate dp,Integer std,Integer min, String name, int stationFlag) throws Exception{
        if(!(conObj.getListView().getItems().size() == 0)){
            throw new IllegalArgumentException("Es ist bereits ein Startort vorhanden");
        }

        Ort temp_ort = new Ort(name, std, min, std, min, dp, dp, stationFlag);

        conObj.getListView().getItems().add(temp_ort);
        temp_ort.setIndex(conObj.getListView().getItems().indexOf(temp_ort));
    }

    /**Die Methode "zwischenStationHinzufuegen fuegt nacht ueberpruefung, ob die Daten korrekt sind und
     * chronologisch Sinn ergeben eine Zwischenstation in die Liste ein.
     *
     * Ist momentan noch so implementiert, dass sie nach dem letzten Element den Ort anfuegt */
    public void zwischenStationHinzufuegen(LocalDate dpAnkunft, LocalDate dpAbfahrt, int stdAnk, int minAnk, int stdAbf,int minAbf, String name, int stationFlag) throws Exception{
        Ort temp_ort = new Ort(name, stdAnk, minAnk, stdAbf, minAbf, dpAnkunft, dpAbfahrt, stationFlag);

        if(conObj.getListView().getItems().size() == 0){
            throw new IllegalArgumentException("Zuerst muss ein Startort eingefuegt werden.");
        }

        if(conObj.getListView().getItems().get((conObj.getListView().getItems().size()-1)).compareTo(temp_ort) == -1){
            throw new IllegalArgumentException("Der Ankunftszeitpunkt darf nicht vor dem letzten Abfahrtszeitpunkt liegen.");
        }

        conObj.getListView().getItems().add(temp_ort);
        temp_ort.setIndex(conObj.getListView().getItems().indexOf(temp_ort));
    }

    /** Die Methode "endeHinzufuegen" ueberprueft, ob bereits ein Endort in der Liste ist, ist dies nicht der Fall
     *  wird ueberprueft, ob das letzte Abfahrtsdatum spaeter ist, als das Anreisedatum am Endzeitpunkt, ist auch
     *  dies nicht der Fall, wird der Endort zur Liste hinzugefuegt und die Boolean "startUndEnde" auf true gesetzt
     * */
    public void endeHinzufuegen(LocalDate dp,Integer std,Integer min, String name,int stationFlag) throws Exception{
        if(startUndEnde){
            throw new IllegalArgumentException("Es ist bereits ein Endort hinzugefuegt");
        }

        Ort temp_ort = new Ort(name, std, min, std, min, dp, dp, stationFlag);

        if(conObj.getListView().getItems().get((conObj.getListView().getItems().size()-1)).compareTo(temp_ort) == -1){
            throw new IllegalArgumentException("Der Ankunftszeitpunkt darf nicht vor dem letzten Abfahrtszeitpunkt liegen.");
        }

        conObj.getListView().getItems().add(temp_ort);
        startUndEnde = true;
        temp_ort.setIndex(conObj.getListView().getItems().indexOf(temp_ort));
    }

    public void berechnenZeit() throws Exception{
        int bruttoGesamtZeit;

        if(!startUndEnde){
            throw new IllegalArgumentException("Es fehlt noch ein Start oder Endort");
        }

        Iterator<Ort> iteratorListe = conObj.getListView().getItems().iterator();

        //
        while(iteratorListe.hasNext()){

        }
    }

    private void setLabel(double minutenBrutto, double minutenNetto){
        double stundenBrutto, stundenNetto, tageBrutto, tageNetto;

        /** Berechnen Minuten auf Stunden */
        stundenBrutto = (minutenBrutto/60);
        stundenNetto = (minutenNetto/60);

        /** Berechnen Stunden auf Tage */
        tageBrutto = (stundenBrutto/24);
        tageNetto = (stundenNetto/24);

        /** StringBuilder erstellt die darzustellenden Strings */
        StringBuilder strBrutto = new StringBuilder();
        strBrutto.append("Tage: ");
        strBrutto.append(tageBrutto);
        strBrutto.append(" | Stunden: ");
        strBrutto.append(stundenBrutto);
        strBrutto.append(" | Minuten: ");
        strBrutto.append(minutenBrutto);

        StringBuilder strNetto = new StringBuilder();
        strNetto.append("Tage: ");
        strNetto.append(tageNetto);
        strNetto.append(" | Stunden: ");
        strNetto.append(stundenNetto);
        strNetto.append(" | Minuten: ");
        strNetto.append(minutenNetto);

        conObj.getBruttoLabel().setText(strBrutto.toString());
        conObj.getNettoLabel().setText(strNetto.toString());
    }

    /** geht nicht :(
    public void setOrtListe(ObservableList<Ort> ortListe){
        this.ortListe = ortListe;
    }*/
}
