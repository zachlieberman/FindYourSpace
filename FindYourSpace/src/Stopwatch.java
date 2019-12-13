import java.util.Timer;
import java.util.TimerTask;

public class Stopwatch {
static int interval;
static Timer timer;

public static void main(String[] args) {
    int delay = 1000;
    int period = 1000;
    timer = new Timer();
    interval = 60*15;
    timer.scheduleAtFixedRate(new TimerTask() {

        public void run() {
        	int tot = setInterval();
        	int min=tot/60;
        	int sec=tot%60;
        	//System.out.println(setInterval());
            System.out.println(min+":"+sec);

        }
    }, delay, period);
}

private static final int setInterval() {
    if (interval == 1)
        timer.cancel();
    return --interval;
}
}