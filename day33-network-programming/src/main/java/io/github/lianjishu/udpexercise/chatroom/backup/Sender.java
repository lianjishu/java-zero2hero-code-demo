package io.github.lianjishu.udpexercise.chatroom;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
 * Sender
 * 
 * 发送数据：数据来自于键盘录入，直到输入的数据是`886`，发送数据结束。
 */
public class Sender {
    private int sendPort;
    private String sendHost;
    private InetAddress address;
    private Scanner sc;
    private DatagramSocket ds;

    public Sender(String sendHost, int sendPort) throws UnknownHostException, SocketException {
        this.sendPort = sendPort;
        this.address = InetAddress.getByName(this.sendHost);
        this.sc = new Scanner(System.in);
        // 创建DatagramSocket对象
        ds = new DatagramSocket(); // 发送处自身占用的端口 | 空参: 系统自动分配
    }

    public void sendLogic(String text) throws IOException {
        // 数据打包
        byte[] buffer = text.getBytes();
        DatagramPacket dp = new DatagramPacket(buffer, buffer.length, address, sendPort);

        // 执行发送
        ds.send(dp);

        // 释放资源
        // ds.close();
        // System.out.println("资源释放, 发送完毕!!!");
    }

    public String keyBoardController() {
        System.out.println("输入要发送的消息内容: ");
        return this.sc.nextLine();
    }

    public void doSend() throws IOException {
        while (true) {
            String text = keyBoardController();
            if ("886".equals(text)) {
                sendLogic(text);
                return;
            }
            sendLogic(text);
        }
    }

    public int getSendPort() {
        return sendPort;
    }

    public void setSendPort(int sendPort) {
        this.sendPort = sendPort;
    }

    public String getSendHost() {
        return sendHost;
    }

    public void setSendHost(String sendHost) throws UnknownHostException {
        this.sendHost = sendHost;
        this.address = InetAddress.getByName(this.sendHost);
    }

    public InetAddress getAddress() {
        return address;
    }

    public void setAddress(InetAddress address) {
        this.address = address;
    }

    public static void main(String[] args) throws IOException {
        Sender s = new Sender("127.0.0.1", 8081);
        s.doSend();
    }
}
