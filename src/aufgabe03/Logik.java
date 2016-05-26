package aufgabe03;

import javafx.collections.ObservableList;

import java.time.LocalDate;

/**
 * @author  Chris Thiele, Lydia Pflug
 * @date    24.05.2016
 *
 * Die Klasse 'Logik' repraesentiert die Logik Schicht des Programms.
 */
public class Logik{
    ObservableList ob_list;

    public Logik(ObservableList list) {
        this.ob_list = list;
    }

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
}
