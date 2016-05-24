package aufgabe03;

/**
 * Created by chris on 24.05.16.
 */
public class Uhrzeit {
    private int stunden;
    private int minuten;

    public Uhrzeit(int stunden, int minuten){
        if(stunden > 0 && stunden < 24){
            this.setStunden(stunden);
        } else {
            throw new IllegalArgumentException("Stunden muessen 0 < stunden < 24 sein");
        }

        if(minuten > 0 && minuten < 60){
            this.setMinuten(minuten);
        } else {
            throw new IllegalArgumentException("Minuten muessen 0 < stunden < 60 sein");
        }
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
