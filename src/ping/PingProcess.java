package ping;

import java.net.Socket;

/**
 * Created by arybalko on 18.08.14.
 */
public class PingProcess implements Runnable {
    private String host;
    private int port;
    private long time;
    private PingListener pingListener = new PingListenerDefault();

    public PingProcess(String host, int port) {
        this.host = host;
        this.port = port;
    }

    public PingProcess(String host, int port, PingListener pingListener) {
        this.host = host;
        this.port = port;
        this.pingListener = pingListener;
    }

    @Override
    public void run() {
        time = System.nanoTime();
        try {
            new Socket(host, port).close();
        } catch(Exception e) {
        }
        time = System.nanoTime() - time;
        pingListener.updata(this);
    }

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }

    public long getTime() {
        return time;
    }
}
