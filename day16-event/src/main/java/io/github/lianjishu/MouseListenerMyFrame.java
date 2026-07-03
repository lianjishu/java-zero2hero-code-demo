package io.github.lianjishu;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class MouseListenerMyFrame extends JFrame {
    private int count = 0;
    public MouseListenerMyFrame() {
        final JButton jButton01 = new JButton("别点我");
        final JButton jButton02 = new JButton("测试滚轮");

        this.setSize(603,680);
        this.setTitle("Frame");
        this.setAlwaysOnTop(true);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(null);

        jButton01.setBounds(0,0,100,50);
        jButton02.setBounds(100,0,100,50);
        jButton02.addMouseWheelListener(new MouseWheelListener() {
            @Override
            public void mouseWheelMoved(MouseWheelEvent e) {
                System.out.println(""+(++count));
            }
        });
        jButton01.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("🖱单击");
            }

            @Override
            public void mousePressed(MouseEvent e) {
                System.out.println("🖱按住");
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                System.out.println("🖱松开");
            }

            @Override
            public void mouseEntered(MouseEvent e) {
                System.out.println("🖱滑入");
            }

            @Override
            public void mouseExited(MouseEvent e) {
                System.out.println("🖱滑出");
            }
        });

        this.add(jButton01);
        this.add(jButton02);
        this.setVisible(true);
    }
}
