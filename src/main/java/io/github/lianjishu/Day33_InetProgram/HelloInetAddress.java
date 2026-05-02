import java.net.InetAddress;
import java.net.UnknownHostException;

public class HelloInetAddress {
    //获取...
    public void testGetByName() throws UnknownHostException {
        InetAddress ip = InetAddress.getByName("qtoken.vip");
        System.out.println(ip);
    }

    public static void main(String[] args) {
        HelloInetAddress helloInetAddress = new HelloInetAddress();
        try {
            helloInetAddress.testGetByName();
        } catch (UnknownHostException err) {
            err.printStackTrace();
        }
    }
}
