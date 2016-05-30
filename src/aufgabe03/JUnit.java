package aufgabe03;

import static org.junit.Assert.*;
import java.time.LocalDate;
import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;

/**
 * @author Chris Thiele, Lydia Pflug
 * @date 24.05.2016
 *
 *       Die Klasse testet die Implementierung von Aufgabe03.
 */
public class JUnit {

    public LocalDate o1Ankunft, o1Abfahrt, o2Ankunft, o2Abfahrt;
    public Ort o1, o2, o3;

    @Before
    public void setUp() throws Exception {

        o1Ankunft = LocalDate.of(2000, 1, 1);
        o1Abfahrt = LocalDate.of(2000, 1, 2);
        o2Ankunft = LocalDate.of(2000, 1, 3);
        o2Abfahrt = LocalDate.of(2000, 1, 4);

        this.o1 = new Ort("Hamburg", 12, 12, 8, 22, o1Ankunft, o1Abfahrt, 1);
        this.o2 = new Ort("Hamburg", 12, 12, 8, 22, o1Ankunft, o1Abfahrt, 1);
        this.o3 = new Ort("Frankfurt", 1, 12, 8, 22, o2Ankunft, o2Abfahrt, 0);
    }

    /**
     * Klasse Ort, überschriebene Methode equals
     *
     * @throws Exception
     */
    @Test
    public void testOrtEquals() throws Exception {
        Ort o5 = new Ort("Hamburg", 12, 12, 8, 22, o1Ankunft, o1Abfahrt, 1);
        Ort o6 = new Ort("Hamburg", 12, 12, 8, 22, o1Ankunft, o1Abfahrt, 1);
        Ort o7 = new Ort("Hamburg", 14, 12, 15, 22, o1Ankunft, o1Abfahrt, 1);
        assertEquals(o5, o6);
        assertNotSame(o5, o6);
        assertNotEquals(o5, o7);
    }

    /**
     * Klasse Ort, überschriebene Methode hashCode
     *
     * @throws Exception
     */
    @Test
    public void testOrtHashCode() throws Exception {
        HashSet<Ort> set = new HashSet<Ort>();
        set.add(o1);
        set.add(o2);
        assertEquals(1, set.size());
    }

    /**
     * Klasse Ort: prüfen, ob toString überschrieben worden ist
     *
     * @throws Exception
     */
    @Test
    public void testOrtToString() throws Exception {
        assertFalse(new Ort("Hamburg", 12, 12, 8, 22, o1Ankunft, o1Abfahrt, 1).toString().contains("@"));
    }

    /**
     * Klasse Ort, Methode ueberpruefeUhrzeit
     *
     * @throws Exception
     */
    @Test
    public void testOrtUeberpruefeUhrzeit() throws Exception {
        LocalDate o11Ankunft = LocalDate.of(2000, 2, 1);
        LocalDate o11Abfahrt = LocalDate.of(2000, 2, 2);
        Ort o11 = new Ort("Hamburg", 12, 12, 8, 22, o11Ankunft, o11Abfahrt, 1);
        assertEquals(false,o11.ueberpruefeUhrzeit(12, 61, 25, 22));
    }

    /**
     * Klasse Ort, Methode compareTo
     *
     * @throws Exception
     */
    @Test
    public void testOrtCompareTo() throws Exception {
        LocalDate o8Ankunft = LocalDate.of(2000, 2, 1);
        LocalDate o8Abfahrt = LocalDate.of(2000, 2, 2);
        LocalDate o9Ankunft = LocalDate.of(2000, 2, 2);
        LocalDate o9Abfahrt = LocalDate.of(2000, 2, 3);
        LocalDate o10Ankunft = LocalDate.of(2000, 2, 3);
        LocalDate o10Abfahrt = LocalDate.of(2000, 2, 4);

        Ort o8 = new Ort("Hamburg", 12, 12, 8, 22, o8Ankunft, o8Abfahrt, 1);
        Ort o9 = new Ort("Muenchen", 8, 22, 12, 12, o9Ankunft, o9Abfahrt, 1);
        Ort o10 = new Ort("Berlin", 14, 12, 16, 22, o10Ankunft, o10Abfahrt, -1);

       assertEquals(0, o8.compareTo(o9)); // nicht realistische Abfahrts- und Ankunftszeit
       assertEquals(1, o9.compareTo(o8)); // Ankunftszeit liegt vor Abfahrszeit: Nachfolger.compareTo.Vorfolger
       assertEquals(1, o10.compareTo(o9)); // Ankunftszeit liegt vor Abfahrszeit: Nachfolger.compareTo.Vorfolger
       assertEquals(-1, o9.compareTo(o10)); // Ankunftszeit liegt vor Abfahrszeit
    }


}