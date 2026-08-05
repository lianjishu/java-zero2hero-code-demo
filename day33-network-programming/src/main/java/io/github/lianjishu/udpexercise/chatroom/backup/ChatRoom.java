package io.github.lianjishu.udpexercise.chatroom;

/**
 * 练习 —— 聊天室（UDP 版）.
 *
 * <h2>需求说明</h2>
 * <ul>
 * <li><b>UDP 发送数据：</b>数据来自于键盘录入，直到输入的数据是 {@code 886}，发送数据结束。</li>
 * <li><b>UDP 接收数据：</b>因为接收端不知道发送端什么时候停止发送，故采用<b>死循环</b>接收。</li>
 * </ul>
 *
 * <h2>实现要点</h2>
 * <ul>
 * <li>使用 {@link java.net.DatagramSocket} 创建 UDP 通信端点；</li>
 * <li>发送端使用 {@link java.io.BufferedReader} 包装
 * {@link java.lang.System#in} 读取键盘录入；</li>
 * <li>接收端通过 {@code while(true)} 死循环反复调用
 * {@link java.net.DatagramSocket#receive(java.net.DatagramPacket)}，
 * 以保证不漏掉任何一条报文。</li>
 * </ul>
 *
 * <h2>结束条件</h2>
 * 
 * <pre>
 * if ("886".equals(line))
 *     break; // 发送端结束条件
 * // 接收端无自然结束条件，由用户手动 Ctrl+C 终止
 * </pre>
 */
public class ChatRoom {

    public ChatRoom() {
    }

    public static void main(String[] args) throws Exception {
       
    }

}
