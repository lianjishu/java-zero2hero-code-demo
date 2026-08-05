package io.github.lianjishu.tcpexercise.a;

import java.io.IOException;

/**
 * 练习
 *
 * TCP通信练习1 --- 多发多收
 *
 * 客户端：多次发送数据
 *
 * 服务器：接收多次接收数据，并打印
 */
public class MultiSendMultiReceive {
    public static void main(String[] args) throws IOException {
        Server s = new Server(10086);
        Client c = new Client("127.0.0.1", 10086);

        s.doRecv();
        c.doSend(new String[] {
            "你好!!!",
            "我是渣渣辉!!!",
            "是兄弟就来砍我!!!"
        });
    }
}
