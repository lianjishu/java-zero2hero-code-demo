package io.github.lianjishu.tcp.encodingissue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {// 输入流
    public static void main(String[] args) throws IOException {
        // TCP协议, 接收数据
        // 1.创建对象ServerSocket
        ServerSocket ss = new ServerSocket(10086);

        // 2.监听客户端的连接
        Socket socket = ss.accept();

        // 3.从连接管道中获取输入流读取数据 | 用转换流 得到字符流!!!
        // InputStream is = socket.getInputStream();
        // InputStreamReader isr = new InputStreamReader(is);
        // 提高效率用BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        char[] buffer = new char[1024];
        int len;
        while ((len = br.read(buffer, 0, buffer.length)) != -1) {
            System.out.print(new String(buffer, 0, len));
        }
        // 释放资源
        socket.close();
        ss.close();
    }
}
