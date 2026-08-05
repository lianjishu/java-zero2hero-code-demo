package io.github.lianjishu.tcp.taste;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {// 输出流
    public static void main(String[] args) throws UnknownHostException, IOException {
        // TCP协议发送数据

        // 1.创建Socket对象
        // 在创建的时候就会连接服务端 | 如果连不上代码报错
        Socket socket = new Socket("127.0.0.1", 10086);

        // 2.从连接通道中获取输出流
        OutputStream os = socket.getOutputStream();
        // 写出数据(暂时不写中文字符)
        os.write("aaa".getBytes());

        // 3.释放资源
        os.close();
        socket.close();
    }
}
