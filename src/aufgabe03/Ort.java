package aufgabe03;

import java.time.LocalDate;

/**
 * @author  Chris Thiele, Lydia Pflug
 * @date    24.05.2016
 *
 * Die Klasse 'Ort' repraesentiert einen Reise Ort, welcher eine Ankunftsdatum und eine Ankunftsuhrzeit, sowie
 * ein Abfahrtsdatum und eine Abfahrtsuhrzeit enthaelt.
 */

public class Ort implements Comparable<Ort>{
    String name, uhrzeitAnkunft, uhrzeitAbfahrt;
    int stdAnkunft, minAnkunft, stdAbfahrt, minAbfahrt;
    Integer index;
    LocalDate ankunft, abfahrt;

    public Ort(String name, int stdAnkunft, int minAnkunft, int stdAbfahrt, int minAbfahrt, LocalDate ankunft, LocalDate abfahrt) throws Exception{
        if(!(ueberpruefeUhrzeit(stdAnkunft, minAnkunft, stdAbfahrt, minAbfahrt))){
            throw new IllegalArgumentException("Die Uhrzeit ist unrealistisch!");
        } else if (ankunft.compareTo(abfahrt) == 1){
            throw new IllegalArgumentException("Das Ankunftsdatum darf nicht hinter dem Abfahrtsdatum liegen.");
        } else {
                this.name = name;
                this.stdAbfahrt = stdAbfahrt;
                this.minAbfahrt = minAnkunft;
                this.stdAnkunft = stdAnkunft;
                this.minAnkunft = minAnkunft;
                this.ankunft = ankunft;
                this.abfahrt = abfahrt;
        }

        /** 'Baut' aus den Uhrzeit-Einzel-Teilen zwei Strings fuer die Darstellung in der Tabelle */
        StringBuilder sbAnkunft = new StringBuilder();
        sbAnkunft.append(stdAnkunft);
        sbAnkunft.append(":");
        sbAnkunft.append(minAnkunft);
        uhrzeitAnkunft = sbAnkunft.toString();

        StringBuilder sbAbfahrt = new StringBuilder();
        sbAbfahrt.append(stdAbfahrt);
        sbAbfahrt.append(":");
        sbAbfahrt.append(minAbfahrt);
        uhrzeitAbfahrt = sbAbfahrt.toString();

    }

    public Integer getIndex(){
        return index;
    }

    public void setIndex(Integer index){
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public int getStdAnkunft() {
        return stdAnkunft;
    }

    public int getMinAnkunft() {
        return minAnkunft;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ort ort = (Ort) o;

        if (stdAnkunft != ort.stdAnkunft) return false;
        if (minAnkunft != ort.minAnkunft) return false;
        if (stdAbfahrt != ort.stdAbfahrt) return false;
        if (minAbfahrt != ort.minAbfahrt) return false;
        return name != null ? name.equals(ort.name) : ort.name == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + stdAnkunft;
        result = 31 * result + minAnkunft;
        result = 31 * result + stdAbfahrt;
        result = 31 * result + minAbfahrt;
        return result;
    }

    public int getStdAbfahrt() {

        return stdAbfahrt;
    }

    public int getMinAbfahrt() {
        return minAbfahrt;
    }

    public String getUhrzeitAnkunft(){
       return uhrzeitAnkunft;
    }

    public String getUhrzeitAbfahrt(){
        return uhrzeitAbfahrt;
    }

    public LocalDate getAnkunft() {
        return ankunft;
    }

    public LocalDate getAbfahrt() {
        return abfahrt;
    }

    private boolean ueberpruefeUhrzeit(int stdAnkunft, int minAnkunft, int stdAbfahrt, int minAbfahrt){
        /** Lydia - da ich ja immer ein > und < Problem habe - checkst du die Werte nochmal ab? Danke :-) */
        if(!(stdAnkunft > -1 && stdAnkunft < 24)){
            return false;
        }
        if(!(stdAbfahrt > -1 && stdAbfahrt < 24)){
            return false;
        }
        if(!(minAnkunft > -1 && minAnkunft < 61)){
            return false;
        }
        if(!(minAbfahrt > -1 && minAbfahrt < 61)){
            return false;
        }
        return true;
    }

    public int compareTo(Ort other){
        /** gibt -1 zurueck, wenn this < other - also wenn dieses Objekt zeitlich hinter dem verglichenen liegt
         *  gibt 0 zurueck, wenn this = other - also wenn die Objekte zeitlich identisch sind (auch auf Stunden/Minuten)
         *  gibt 1 zurueck, wenn this > other - also wenn dieses Objekt zeitlich vor dem verglichenen liegt
         *
         *  Ich habs gar nicht erst versucht das short-handed zu machen ... If-Verzweigung des Todes - Bitch
         */

        if(abfahrt.isAfter(other.getAnkunft())){
            return -1;
        }

        if(abfahrt.isEqual(other.getAnkunft())){
            if(stdAbfahrt < other.getStdAnkunft()) return -1;
            if(stdAbfahrt == other.getStdAnkunft()){
                if(minAbfahrt < other.getMinAnkunft()) return -1;
                if(minAbfahrt == other.getMinAnkunft()) return 0;
                if(minAbfahrt > other.getMinAnkunft()) return 1;
            }
            if(stdAbfahrt > other.getStdAnkunft()) return 1;
        }

        if (abfahrt.isBefore(other.getAnkunft())){
            return 1;
        }

        return 0; // Lol Default Return Parameter ..
    }

    public String toString(){
        return "Ort: " + name + " Ankunftsdatum: " + ankunft.toString() + " " + uhrzeitAnkunft + "  Abfahrt " + abfahrt.toString() + " " + uhrzeitAbfahrt;
    }
}
