import ping.PingListener;
import ping.PingListenerSystemOut;
import ping.PingProcess;
import ping.PingProcessManager;

/**
 * Created by arybalko on 18.08.14.
 */
public class ExanplePing {
    public static void main(String[] args) throws InterruptedException {
        new ExanplePing().go();
    }

    public void go() {
        // One ping sinc
        PingProcess pingProcess1 = new PingProcess("ya.ru", 80);
        pingProcess1.run();
        System.out.println("Time = " + (pingProcess1.getTime() / 1000000) + " ms");

        // One ping asinc
        PingProcess pingProcess2 = new PingProcess("vk.com", 80, new PingListenerSystemOut());
        new Thread(pingProcess2).start();

        // More ping asinc
        PingProcessManager pingThreed1 = new PingProcessManager("ya.ru", 80, 1000, 4, new PingListenerSystemOut());
        new Thread(pingThreed1).start();

        // More ping asinc
        PingProcessManager pingThreed2 = new PingProcessManager("example.com", 80, 2000, 4, new MyListener());
        new Thread(pingThreed2).start();
    }

    class MyListener implements PingListener {

        @Override
        public void updata(PingProcess process) {
            String s = process.getHost() + " - " + (process.getTime() / 1000000) + " ms";
            System.out.println(s);
        }
    }
}
