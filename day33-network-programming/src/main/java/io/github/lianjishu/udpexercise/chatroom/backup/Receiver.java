package io.github.lianjishu.udpexercise.chatroom;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 * Receiver
 * 
 * 接收数据：因为接收端不知道发送端什么时候停止发送，故采用死循环接收。
 */
public class Receiver {
    private int recvPort;
    private InetAddress address;
    private DatagramSocket ds;
    private byte[] buffer;

    public Receiver(int recvPort) throws SocketException, UnknownHostException {
        this.recvPort = recvPort;
        this.address = InetAddress.getByName("127.0.0.1");
        this.ds = new DatagramSocket(recvPort); // 绑定接收端端口 | 注意和发送端发送端口保持一致
        this.buffer = new byte[8192];
    }

    public int getRecvPort() {
        return recvPort;
    }

    public void setRecvPort(int recvPort) throws SocketException {
        this.recvPort = recvPort;
    }

    public String receiveLogic() throws SocketException, IOException {
        DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
        ds.receive(dp);
        return new String(buffer, 0, dp.getLength());
    }

    public void doReceive() throws SocketException, IOException {
        while (true) {
            var recvMessage = receiveLogic();
            if ("886".equals(recvMessage)) {
                ds.close();
                System.out.println("接收端释放资源");
                return;
            }
            System.out.println("接收端: " + recvMessage);
        }
    }

    public static void main(String[] args) throws IOException {
        Receiver r = new Receiver(8081);
        r.doReceive();
    }
}
