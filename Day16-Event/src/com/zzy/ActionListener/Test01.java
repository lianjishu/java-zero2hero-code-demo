package com.zzy.ActionListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Test01 {
    //初始化窗体
     private void initJFrame(JFrame jFrame) {
        jFrame.setSize(800, 800);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setLayout(null);
    }
    //初始化按钮控件
     private void initJButton(JButton jButton) {
        jButton.setText("Click Me!");
        jButton.setBounds(0,0,100, 50);
        jButton.setBackground(new Color(255,153,204));
        jButton.addActionListener(new ActionListener() {
            private int count = 0;
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.print("\r按钮被电击了" + (++count) + "次！");
            }
        });
    }
    //第一种写法：匿名内部类的使用
      public Test01() {
          JFrame jFrame = new JFrame();
          JButton jButton = new JButton();

          initJFrame(jFrame);
          initJButton(jButton);

          jFrame.add(jButton);
          jFrame.setVisible(true);
    }
}
