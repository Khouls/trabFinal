package jogoDaVelha;

import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;

public class FechadorPrograma {
    Timer timer;
    JFrame f;

    public FechadorPrograma(int seconds, JFrame f) {
    	this.f = f;
        timer = new Timer();
        timer.schedule(new FecharPrograma(), seconds*1000);
    }

    class FecharPrograma extends TimerTask {
        public void run() {
            f.dispose();
            timer.cancel(); //Para a thread do timer

        }
    }
}