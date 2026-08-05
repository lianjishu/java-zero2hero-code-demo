package io.github.lianjishu.tcp.taste;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {// 输入流
    public static void main(String[] args) throws IOException {
        // TCP协议, 接收数据
        // 1.创建对象ServerSocket
        ServerSocket ss = new ServerSocket(10086);

        // 2.监听客户端的连接
        Socket socket = ss.accept();

        // 3.从连接管道中获取输入流读取数据
        InputStream is = socket.getInputStream();
        int b;
        while ((b = is.read()) != -1) {
            System.out.println((char) b);
        }
        // 释放资源
        socket.close();
        ss.close();
    }
}
