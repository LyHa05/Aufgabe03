package aufgabe03;

import java.time.LocalDate;

/**
 * Created by chris on 28.05.16.
 */
public class TestScriptOrtVergleich {
    /** Hier ist jetzt was verandert! */
    public static void main(String[] args) throws Exception{
        Ort o1, o2, o3, o4;
        LocalDate o1Ankunft, o1Abfahrt, o2Ankunft, o2Abfahrt, o3Ankunft, o3Abfahrt, o4Ankunft, o4Abfahrt;

        o1Ankunft = LocalDate.of(2000, 1, 1);
        o1Abfahrt = LocalDate.of(2001, 1, 1);
        o2Ankunft = LocalDate.of(2000, 6, 1);
        o2Abfahrt = LocalDate.of(2012, 12, 12);
        o3Ankunft = LocalDate.of(1993, 5, 23);
        o3Abfahrt = LocalDate.of(1993, 5, 23);
        o4Ankunft = LocalDate.of(1993, 5, 23);
        o4Abfahrt = LocalDate.of(1994, 5, 26);

        o1 = new Ort("Hamburg", 12, 0, 12, 0, o1Ankunft, o1Abfahrt);
        o2 = new Ort("Berlin", 12, 0, 12, 0, o2Ankunft, o2Abfahrt);
        o3 = new Ort("Frankfurt", 13, 0, 14, 0, o3Ankunft, o3Abfahrt);
        o4 = new Ort("Berne", 13, 0, 16, 0, o4Ankunft, o4Abfahrt);

        System.out.println("o1: " + o1.toString());
        System.out.println("o1: " + o2.toString());
        System.out.println("o1: " + o3.toString());
        System.out.println("o1: " + o4.toString());
        System.out.println("----------------------------");
        System.out.println("Vergleiche o1 mit o2, erwartetes Ergebnis: -1, da o1 > o2");
        System.out.println(o1.compareTo(o2));
        System.out.println("Vergleiche o3 mit o4, erwartetes Ergebnis: 1, da o3 > o4");
        System.out.println(o3.compareTo(o4));
        System.out.println("Vergleiche o4 mit o3, erwartetes Ergebnis: -1, da o4 > o3");
        System.out.println(o4.compareTo(o3));
        System.out.println("Vergleiche o1 mit o4, erwartetes Ergebnis: -1, da o1 < o4");
        System.out.println(o1.compareTo(o4));
        System.out.println("Vergleiche o1Abreise mit o4Ankunft, erwartetes Ergebnis: 1, da o1 < o4");
        System.out.println(o1Abfahrt.compareTo(o4Ankunft));
        System.out.println("LocalDate implementiert compareTo echt scheiße.");
    }
}
