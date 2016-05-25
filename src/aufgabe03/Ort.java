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

    public Ort(LocalDate datum_ankunft, LocalDate datum_abreise, Uhrzeit uhrzeit_ankunft, Uhrzeit uhrzeit_abreise){

    }
}
