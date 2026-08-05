package io.github.lianjishu.tcpexercise.a;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    private int serverPort;
    private final String serverHost = "127.0.0.1";
    private ServerSocket serverSocket;
    private Socket socket;
    private char[] readChars;
    private final int INIT_CAPACITY = 1024;

    public Server(int serverPort) throws IOException {
        this.serverPort = serverPort;
        this.serverSocket = new ServerSocket(this.serverPort);
        this.socket = serverSocket.accept();
        this.readChars = new char[INIT_CAPACITY];
    }

    private String recvLogic(BufferedReader br) throws IOException {
        // int readLen;
        // String msg = null;
        // while ((readLen = br.read(readChars, 0, readChars.length)) != -1) {
        // msg = new String(readChars, 0, readLen);
        // }
        String line;
        while ((line = br.readLine()) != null) { // 遇到 \n 就返回一行
            System.out.println("[服务端]接收到消息: " + line );
        }
        return line;
    }

    public void doRecv() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        while (true) {
            String msg = recvLogic(br);
            if (msg == null) {
                break;
            }
            System.out.println(msg);
        }
        serverSocket.close();
    }

    public static void main(String[] args) throws IOException {
        Server s = new Server(10086);
        s.doRecv();
    }
}
