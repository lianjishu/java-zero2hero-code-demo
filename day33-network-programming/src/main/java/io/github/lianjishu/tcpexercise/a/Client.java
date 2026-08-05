package io.github.lianjishu.tcpexercise.a;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    private String serverHost;
    private int serverPort;
    private BufferedOutputStream bos;
    private Socket s;

    public Client(String serverHost, int serverPort) throws UnknownHostException, IOException {
        this.serverHost = serverHost;
        this.serverPort = serverPort;
        this.s = new Socket(serverHost, this.serverPort); // 建立TCP连接
        this.bos = new BufferedOutputStream(this.s.getOutputStream()); // 拿到输出流 | 用BufferdOutputStream提高效率
    }

    private void sendLogic(String msg) throws IOException {
        // 写出数据
        bos.write((msg + "\n").getBytes("UTF-8"));
        bos.flush();// 强制刷新!!!
        System.out.println("[客戶端]成功发送消息: " + msg + "\\n");
    }

    public void doSend(String[] msgArray) throws UnknownHostException, IOException {
        // 循环发送消息
        for (var msg : msgArray) {
            sendLogic(msg);
        }
        s.close();
    }

    public static void main(String[] args) throws UnknownHostException, IOException {
        Client c = new Client("127.0.0.1", 10086);
        c.doSend(new String[] {
                "你好!!!",
                "我是渣渣辉!!!",
                "是兄弟就来砍我!!!"
        });
    }
}
