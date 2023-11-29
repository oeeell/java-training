import java.text.SimpleDateFormat;
import java.util.Date;

public class Stopwatch {
    private static boolean running = false;
    private static long startTime;
    private static long stopTime;

    public static void start() {
        if (!running) {
            running = true;
            startTime = System.currentTimeMillis();
            new Thread(() -> {
                while (running) {
                    System.out.println(getElapsedTime());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }

    public static void stop() {
        if (running) {
            running = false;
            stopTime = System.currentTimeMillis();
        }
    }

    public static String getElapsedTime() {
        long elapsed;
        if (running) {
            elapsed = System.currentTimeMillis() - startTime;
        } else {
            elapsed = stopTime - startTime;
        }
        return new SimpleDateFormat("hh:mm:ss").format(new Date(elapsed));
    }

    public static void main(String[] args) {
        start();
    }
}
