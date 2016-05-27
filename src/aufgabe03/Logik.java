package aufgabe03;

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

    public Logik(Controller con_obj){
        this.conObj = con_obj;
    }

    @SuppressWarnings("unchecked")
    public void startHinzufuegen(DatePicker dp1Start, NumberTextField tf01StdStart, NumberTextField tf02MinStart, LetterTextField tf03OrtStart) throws Exception{
        LocalDate ankunftAbreiseDatum;

        if((conObj.getListView().getItems().size()) != 0){
            throw new IllegalArgumentException("Es ist bereits ein Startort vorhanden, Sie koennen diesen ersetzen,\n" +
                                                "aber nicht direkt austauschen.");
        }

        String ortName = tf03OrtStart.getText();
        /** Kein Try-Catch Block - Exception wird in der Controller Ebene abgefangen */
        Uhrzeit ankunftAbreiseUhrzeit = new Uhrzeit(Integer.parseInt(tf01StdStart.getText()), Integer.parseInt(tf02MinStart.getText()));

        if(dp1Start.getValue() == null){
            throw new IllegalArgumentException("Fehler bei der Datums Eingabe.");
        } else {
            ankunftAbreiseDatum = dp1Start.getValue();
        }

        Ort tempStartOrt = new Ort(ortName, ankunftAbreiseDatum, ankunftAbreiseDatum, ankunftAbreiseUhrzeit, ankunftAbreiseUhrzeit);

        conObj.getListView().getItems().add(tempStartOrt);
    }


    //hier habe ich keine Umbenennung vorgenommen, falls du das alles sowieso loeschst ;-)
    /**
    public void testOrtHinzufuegen(String name, LocalDate d_an, LocalDate d_ab, Uhrzeit u_ab, Uhrzeit u_an, Ort ort_position) throws Exception {

        if(ort_position.datum_abreise.compareTo(d_an) == 1){
            throw new IllegalArgumentException("Das Anreise Datum ist frueher als das Abreise Datum");
        } else if (ort_position.datum_abreise.compareTo(d_an) == 0){
            if(ort_position.uhrzeit_abreise.compareTo(u_an) == 1){
                throw new IllegalArgumentException("Die Anreise Uhrzeit ist fruher als die Abreise Uhrzeit");
            }
        }

        hinzufuegenCollection(ortErstellung(name, d_an, d_ab, u_ab, u_an), ort_position);
    }

    public void testOrtAustauschen(String name, LocalDate d_an, LocalDate d_ab, Uhrzeit u_ab, Uhrzeit u_an, Ort ort_position){

    }

    private Ort ortErstellung(String name, LocalDate d_an, LocalDate d_ab, Uhrzeit u_ab, Uhrzeit u_an){
        return new Ort(name, d_an, d_ab, u_an, u_ab);
    }

    private void hinzufuegenCollection(Ort ort_neu, Ort ort_alt){

    }
     */
}
