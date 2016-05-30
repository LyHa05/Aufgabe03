package aufgabe03;

import static org.junit.Assert.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.lang.reflect.Method;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * @author Chris Thiele, Lydia Pflug
 * @date 24.05.2016
 *
 *       Die Klasse testet die Implementierung von Aufgabe03.
 */
public class JUnit {

    public LocalDate o1Ankunft, o1Abfahrt, o2Ankunft, o2Abfahrt;
    public ObservableList<Ort> reiseOrte = FXCollections.observableArrayList();
    public Controller conObj = new Controller();
    //public Logik logObj = new Logik(conObj);
    public Ort o1, o2, o3, o4;

    @Before
    public void setUp() throws Exception {

        o1Ankunft = LocalDate.of(2000, 1, 1);
        o1Abfahrt = LocalDate.of(2000, 1, 2);
        o2Ankunft = LocalDate.of(2000, 1, 3);
        o2Abfahrt = LocalDate.of(2000, 1, 4);

        this.o1 = new Ort("Hamburg", 12, 12, 8, 22, o1Ankunft, o1Abfahrt, 1);
        this.o2 = new Ort("Hamburg", 12, 12, 8, 22, o1Ankunft, o1Abfahrt, 1);
        this.o3 = new Ort("Frankfurt", 1, 12, 8, 22, o2Ankunft, o2Abfahrt, 0);
        // o3 = new Ort("Berlin", 12, 9, 22, 22, d1, d2, 0);
        // o4 = new Ort("Bremen", 13, 22, 8, 22, d1, d2, -1);

        reiseOrte.addAll(o1, o2, o3);
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
        LocalDate o8Ankunft = LocalDate.of(2000, 1, 1);
        LocalDate o8Abfahrt = LocalDate.of(2000, 1, 2);
        Ort o8 = new Ort("Hamburg", 12, 12, 8, 22, o8Ankunft, o8Abfahrt, 1);

        Method m = Ort.class.getDeclaredMethod("ueberpruefeUhrzeit");
        m.setAccessible(true);
        Assert.assertEquals(false, m.invoke(12, 61, 25, 22));
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
        Ort o8 = new Ort("Hamburg", 12, 12, 8, 22, o8Ankunft, o8Abfahrt, 1);
        Ort o9 = new Ort("Hamburg", 12, 12, 8, 22, o8Ankunft, o8Abfahrt, 1);
        //assertSame(-1, o8.compareTo(o1));
        assertEquals(0, o8.compareTo(o8));
        //assertEquals(1,o1.compareTo(o8));


    }

    /**
     * Klasse Logik, Methode startHinzufuegen
     *
     * @throws Exception
     */
    @Test // (expected = IllegalArgumentException.class)
    public void testStartOrtErstellen() throws Exception {
        Ort o5 = new Ort("", 12, 12, 8, 22, this.o1Ankunft, this.o1Abfahrt, 1);
        reiseOrte.addAll(o5);
        conObj.setReiseOrte(reiseOrte);
        conObj.getlObj().startHinzufuegen(o1Abfahrt, 12, 12, "Hamburg", 1);
        assertEquals(o5, conObj.getListView().getItems());

    }

}