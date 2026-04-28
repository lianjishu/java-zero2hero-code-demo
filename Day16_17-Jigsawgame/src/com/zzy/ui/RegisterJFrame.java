package com.zzy.ui;

import javax.swing.*;

public class RegisterJFrame extends JFrame{
    public RegisterJFrame() {
        //设置宽高
        this.setSize(488, 500);
        //设置窗口居中位置
        this.setLocationRelativeTo(null);
        //设置标题
        this.setTitle("用户注册");
        //设置关闭时行为 | 结束程序
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置窗口显示
        this.setVisible(true);
    }
}
