package io.github.lianjishu.Day16_17_Jigsawgame;

import javax.swing.*;

public class LoginJFrame extends JFrame{
    //在创建界面时候, 初始化界面的参数, 比如大小,显示等
    public LoginJFrame() {
        //设置宽高
        this.setSize(488, 430);
        //设置窗口居中位置
        this.setLocationRelativeTo(null);
        //设置标题
        this.setTitle("用户登录");
        //设置关闭时行为 | 结束程序
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置窗口显示
        this.setVisible(true);



    }
}