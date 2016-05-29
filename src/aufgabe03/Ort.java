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
    int stdAnkunft, minAnkunft, stdAbfahrt, minAbfahrt, stationFlag;
    Integer index;
    LocalDate ankunft, abfahrt;

    public Ort(String name, int stdAnkunft, int minAnkunft, int stdAbfahrt, int minAbfahrt, LocalDate ankunft, LocalDate abfahrt, int stationFlag) throws Exception{
        if(!(ueberpruefeUhrzeit(stdAnkunft, minAnkunft, stdAbfahrt, minAbfahrt))){
            throw new IllegalArgumentException("Die Uhrzeit ist unrealistisch!");
        } else if (ankunft.compareTo(abfahrt) == 1){
            throw new IllegalArgumentException("Das Ankunftsdatum darf nicht hinter dem Abfahrtsdatum liegen.");
        } else {
                this.name = name;
                this.stdAbfahrt = stdAbfahrt;
                this.minAbfahrt = minAbfahrt;
                this.stdAnkunft = stdAnkunft;
                this.minAnkunft = minAnkunft;
                this.ankunft = ankunft;
                this.abfahrt = abfahrt;
                this.stationFlag = stationFlag;
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
        if (stationFlag != ort.stationFlag) return false;
        if (name != null ? !name.equals(ort.name) : ort.name != null) return false;
        if (uhrzeitAnkunft != null ? !uhrzeitAnkunft.equals(ort.uhrzeitAnkunft) : ort.uhrzeitAnkunft != null)
            return false;
        if (uhrzeitAbfahrt != null ? !uhrzeitAbfahrt.equals(ort.uhrzeitAbfahrt) : ort.uhrzeitAbfahrt != null)
            return false;
        if (index != null ? !index.equals(ort.index) : ort.index != null) return false;
        if (ankunft != null ? !ankunft.equals(ort.ankunft) : ort.ankunft != null) return false;
        return abfahrt != null ? abfahrt.equals(ort.abfahrt) : ort.abfahrt == null;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (uhrzeitAnkunft != null ? uhrzeitAnkunft.hashCode() : 0);
        result = 31 * result + (uhrzeitAbfahrt != null ? uhrzeitAbfahrt.hashCode() : 0);
        result = 31 * result + stdAnkunft;
        result = 31 * result + minAnkunft;
        result = 31 * result + stdAbfahrt;
        result = 31 * result + minAbfahrt;
        result = 31 * result + stationFlag;
        result = 31 * result + (index != null ? index.hashCode() : 0);
        result = 31 * result + (ankunft != null ? ankunft.hashCode() : 0);
        result = 31 * result + (abfahrt != null ? abfahrt.hashCode() : 0);
        return result;
    }

    public int getStationFlag() { return stationFlag; }

    public int getStdAbfahrt() { return stdAbfahrt; }

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

    /** Methode ueberprueft Uhrzeit entsprechend 24 Stunden und 60 Minuten*/
    private boolean ueberpruefeUhrzeit(int stdAnkunft, int minAnkunft, int stdAbfahrt, int minAbfahrt){
        if(!(stdAnkunft > -1 && stdAnkunft < 24)){
            return false;
        }
        if(!(stdAbfahrt > -1 && stdAbfahrt < 24)){
            return false;
        }
        if(!(minAnkunft > -1 && minAnkunft < 60)){
            return false;
        }
        if(!(minAbfahrt > -1 && minAbfahrt < 60)){
            return false;
        }
        return true;
    }

    /**HIER KOMMT IMMER -1 RAUS, DASS MUESSEN WIR MORGEN NOCHMAL IN RUHE DURCHSCHAUEN!!!*/

    /** gibt -1 zurueck, wenn this < other - also wenn dieses Objekt zeitlich hinter dem verglichenen liegt
     *  gibt 0 zurueck, wenn this = other - also wenn die Objekte zeitlich identisch sind (auch auf Stunden/Minuten)
     *  gibt 1 zurueck, wenn this > other - also wenn dieses Objekt zeitlich vor dem verglichenen liegt
     */
    public int compareTo(Ort other){

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

        return 0; // Default Return Parameter
    }

    @Override
    public String toString(){
        return "Ort: " + name + " Ankunftsdatum: " + ankunft.toString() + " " + uhrzeitAnkunft + "  Abfahrt " + abfahrt.toString() + " " + uhrzeitAbfahrt;
    }
}
