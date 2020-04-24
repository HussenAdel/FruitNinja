package fruit.ninja.game;
import javafx.scene.control.Label;

public class Stopwatch {

    private   int mins = 0, secs = 0, millis = 0;

   public void change(Label StopWatch) {

        if(millis == 1000) {
            secs++;
            millis = 0;
        }
        if(secs == 60) {
            mins++;
            secs = 0;
        }
        StopWatch.setText(": "+(((mins/10) == 0) ? "0" : "") + mins + ":"
                + (((secs/10) == 0) ? "0" : "") + secs + ":"
                + (((millis/10) == 0) ? "00" : (((millis/100) == 0) ? "0" : "")) + millis++);
    }

    public int getSecs() {
        return secs;
    }



}



