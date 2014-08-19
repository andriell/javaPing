package ping;

/**
 * Created by arybalko on 18.08.14.
 */
public class PingProcessManager implements Runnable {
    private String host;
    private int port;
    private int interval = 1000;
    private int count = 4;

    private PingListener pingListener;

    public PingProcessManager(String host, int port, int interval, int count, PingListener pingListener) {
        this.host = host;
        this.port = port;
        this.interval = interval;
        this.count = count;
        this.pingListener = pingListener;
    }

    public void run() {
        for(int i = 0; i < count; i++) {
            new PingProcess(host, port, pingListener).run();
            try {
                Thread.sleep(interval);
            } catch (InterruptedException e) {}
        }
    }
}
