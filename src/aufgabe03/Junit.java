package aufgabe03;

//import static org.junit.Assert.*;
import java.time.LocalDate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * @author  Chris Thiele, Lydia Pflug
 * @date    24.05.2016
 *
 * Die Klasse testet die Implementierung von Aufgabe03.
 */
public class JUnit {
//    @Before
    public void setUp() throws Exception {
        ObservableList<Ort> reiseOrte =FXCollections.observableArrayList();
        Ort o1, o2, o3, o4;
        LocalDate o1Ankunft, o1Abfahrt, o2Ankunft, o2Abfahrt;

        o1Ankunft = LocalDate.of(2000, 1, 1);
        o1Abfahrt = LocalDate.of(2000, 1, 1);
        o2Ankunft = LocalDate.of(2000, 1, 2);
        o2Abfahrt = LocalDate.of(2000, 1, 2);

        o1 = new Ort("Hamburg", 12, 12, 8, 22, o1Ankunft, o1Abfahrt, 1);
        o2 = new Ort("Frankfurt", 1, 12, 8, 22, o2Ankunft, o2Abfahrt, 0);
//        o3 = new Ort("Berlin", 12, 9, 22, 22, d1, d2, 0);
//        o4 = new Ort("Bremen", 13, 22, 8, 22, d1, d2, -1);

        reiseOrte.addAll(o1, o2);
    }


}