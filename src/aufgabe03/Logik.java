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
    private Controller con_obj;

    public Logik(Controller con_obj){
        this.con_obj = con_obj;
    }

    @SuppressWarnings("unchecked")
    public void startHinzufuegen(DatePicker dp_start, NumberTextField tf01_std_start, NumberTextField tf02_min_start, LetterTextField tf03_ort_start) throws Exception{
        LocalDate ankunftAbreiseDatum;

        if((con_obj.getListView().getItems().size()) != 0){
            throw new IllegalArgumentException("Es ist bereits ein Startort vorhanden, Sie koennen diesen ersetzen,\n" +
                                                "aber nicht direkt austauschen.");
        }

        String ortName = tf03_ort_start.getText();
        /** Kein Try-Catch Block - Exception wird in der Controller Ebene abgefangen */
        Uhrzeit ankunftAbreiseUhrzeit = new Uhrzeit(Integer.parseInt(tf01_std_start.getText()), Integer.parseInt(tf02_min_start.getText()));

        if(dp_start.getValue() == null){
            throw new IllegalArgumentException("Fehler bei der Datums Eingabe.");
        } else {
            ankunftAbreiseDatum = dp_start.getValue();
        }

        Ort tempStartOrt = new Ort(ortName, ankunftAbreiseDatum, ankunftAbreiseDatum, ankunftAbreiseUhrzeit, ankunftAbreiseUhrzeit);

        con_obj.getListView().getItems().add(tempStartOrt);
    }


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
