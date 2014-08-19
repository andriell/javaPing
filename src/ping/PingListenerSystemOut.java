package ping;

/**
 * Created by arybalko on 18.08.14.
 */
public class PingListenerSystemOut implements PingListener {
    @Override
    public void updata(PingProcess process) {
        String s = process.getHost() + ":" + process.getPort() + " " + (process.getTime() / 1000000) + " ms";
        System.out.println(s);
    }
}
