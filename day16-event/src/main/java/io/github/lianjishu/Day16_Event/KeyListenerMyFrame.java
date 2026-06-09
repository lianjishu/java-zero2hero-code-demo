package io.github.lianjishu.Day16_Event;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyListenerMyFrame extends JFrame implements KeyListener {

    @Override
    public void keyTyped(KeyEvent e) {
        int code = e.getKeyCode();
        System.out.println("获取输入字符的编码: " + code);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("按下时调用");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("松开时调用");
    }

    public KeyListenerMyFrame() {
        this.setLayout(null);
        this.setSize(500, 500);
        this.setTitle("测试按键");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.addKeyListener(this);
    }
}
