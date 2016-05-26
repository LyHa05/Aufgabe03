package aufgabe03;

import java.time.LocalDate;


/**
 * @author  Chris Thiele, Lydia Pflug
 * @date    24.05.2016
 *
 * Die Klasse 'Ort' repraesentiert einen Reise Ort, welcher eine Ankunftsdatum und eine Ankunftsuhrzeit, sowie
 * ein Abfahrtsdatum und eine Abfahrtsuhrzeit enthaelt.
 */

public class Ort {
    Uhrzeit uhrzeit_ankunft, uhrzeit_abreise;
    LocalDate datum_ankunft, datum_abreise;
    String ort_name;

    public Ort(String ort_name, LocalDate datum_ankunft, LocalDate datum_abreise, Uhrzeit uhrzeit_ankunft, Uhrzeit uhrzeit_abreise){
        this.ort_name = ort_name;
        this.datum_ankunft = datum_ankunft;
        this.datum_abreise = datum_abreise;
        this.uhrzeit_ankunft = uhrzeit_ankunft;
        this.uhrzeit_abreise = uhrzeit_abreise;
    }


}
