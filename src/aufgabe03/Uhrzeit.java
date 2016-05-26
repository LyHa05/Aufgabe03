package aufgabe03;

/**
 * @author  Chris Thiele, Lydia Pflug
 * @date    24.05.2016
 *
 * Die Klasse 'Uhrzeit' enthaelt eine Anzahl von Minuten und Stunden, ausserdem ist
 * Comparable implementiert, um Uhrzeit vergleichen zu koennen
 */

public class Uhrzeit implements Comparable<Uhrzeit>{
    private int stunden;
    private int minuten;

    public Uhrzeit(int stunden, int minuten){
        if(stunden > -1 && stunden < 25){
            this.setStunden(stunden);
        } else {
            throw new IllegalArgumentException("Stunden muessen 0 < stunden < 24 sein");
        }

        if(minuten > -1 && minuten < 61){
            this.setMinuten(minuten);
        } else {
            throw new IllegalArgumentException("Minuten muessen 0 < stunden < 60 sein");
        }
    }

    public int compareTo(Uhrzeit other){
        // compareTo should return < 0 if this is supposed to be
        // less than other, > 0 if this is supposed to be greater than
        // other and 0 if they are supposed to be equal
        if(this.stunden == other.getStunden() && this.minuten == other.getMinuten()){
            return 0;
        } else if (this.stunden > other.stunden) {
            return 1;
        } else if (this.stunden == other.getStunden() && this.minuten > other.getMinuten()){
            return 1;
        } else if (this.stunden < other.getStunden()){
            return -1;
        } else if (this.stunden == other.getStunden() && this.minuten < other.getMinuten()){
            return -1;
        }

        return 0;
    }

    public int getStunden() {
        return stunden;
    }

    public void setStunden(int stunden) {
        this.stunden = stunden;
    }

    public int getMinuten() {
        return minuten;
    }

    public void setMinuten(int minuten) {
        this.minuten = minuten;
    }
}
