package io.github.lianjishu.udp.recvfrom;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.io.IOException;

public class TasteRecvFrom {

    public static void main(String[] args) throws IOException {
        // 1.创建DatagramSocket对象(快递公司)
        // 细节:
        // 在接收的时候,一 定要绑定端口
        // 而且绑定的端口一定要跟发送的端口保持一致
        DatagramSocket ds = new DatagramSocket(10086);

        // 2.接收数据包
        byte[] bytes = new byte[1024];
        DatagramPacket dp = new DatagramPacket(bytes, bytes.length);
        ds.receive(dp);

        // 3.解析数据包
        byte[] data = dp.getData();
        int len = dp.getLength();
        int port = dp.getPort();
        InetAddress address = dp.getAddress();

        System.out.println("接收到的数据: " + new String(data, 0, len));
        System.out.println("接收到的数据是从"
                + address
                + "这台电脑的"
                + port
                + "端口发出的");
    }

}
