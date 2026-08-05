package io.github.lianjishu.udp.sendto;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class TasteSendTo {
    public static void main(String[] args) throws IOException {
        // 1.创建DatagramSocket对象(快递公司)
        // 需要同时绑定一个端口
        // 空参: 随机用一个可用的端口
        // 有参: 使用指定端口
        DatagramSocket ds = new DatagramSocket();

        // 2.打包数据啊
        String str = "你好世界🌍";
        byte[] data = str.getBytes();
        // 设置参数
        InetAddress address = InetAddress.getByName("127.0.0.1");
        int port = 10086;
        DatagramPacket dp = new DatagramPacket(data, data.length, address, port);

        // 3.发送走你
        ds.send(dp);

        // 4.释放资源
        ds.close();
    }
}
