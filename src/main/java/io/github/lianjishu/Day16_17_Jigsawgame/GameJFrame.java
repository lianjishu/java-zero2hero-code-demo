package io.github.lianjishu.Day16_17_Jigsawgame;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class GameJFrame extends JFrame implements KeyListener {
    /*初始化窗口*/
    private void initJFrame() {
        //取消默认的居中放置,这样才会按照X,Y坐标放置
        this.setLayout(null);
        //设置宽高
        this.setSize(602, 680);
        //设置窗口居中位置
        this.setLocationRelativeTo(null);
        //设置关闭时行为 | 结束程序
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置标题
        this.setTitle("拼图游戏单机版 v1.1");
        //设置窗口总是显示在最前面
        this.setAlwaysOnTop(true);
        //给窗口添加键盘⌨️监听
        this.addKeyListener(this);
    }

    /*初始化菜单栏(JMenuBar)对象*/
    private void initJMenuBar() {
        JMenuBar jMenuBar = new JMenuBar();
        //选项: 功能 | 关于我们
        JMenu functionsJMenu = new JMenu();
        functionsJMenu.setText("功能");
        JMenu aboutJMenu = new JMenu("关于我们");
        //选项里面的各个条目
        JMenuItem replayItem = new JMenuItem("重新游戏");
        JMenuItem reLoginItem = new JMenuItem("重新登录");
        JMenuItem exitItem = new JMenuItem("退出游戏");
        JMenuItem  accountItem = new JMenuItem("公众号");
        //每一个条目添加到对应的选项
        functionsJMenu.add(replayItem);
        functionsJMenu.add(reLoginItem);
        functionsJMenu.add(exitItem);
        aboutJMenu.add(accountItem);
        //将选项加入到菜单(Bar)
        jMenuBar.add(functionsJMenu);
        jMenuBar.add(aboutJMenu);
        //将菜单加入到窗口
        this.setJMenuBar(jMenuBar);
    }
    /*初始化图片资源*/
    private void initImage() {
        //读取图片创建ImageIcon对象，存入ArrayList
        ArrayList<ImageIcon> images = new ArrayList<>();
        for(int i=1; i<=16; ++i) {
            images.add(new ImageIcon("image\\animal\\animal3\\"+i+".jpg"));
        }
        //批量创建和布局JLabel容器
        int idx = 0;
        int[] rIdxTable = new Helper().getScrambleArr(16);
        for(var i=0; i<4; ++i) {
            for(var j=0; j<4; ++j) {
                JLabel jLabel = new JLabel(images.get(rIdxTable[idx]));
                var imgWidth = images.getFirst().getIconWidth();
                var imgHeight = images.getFirst().getIconHeight();
                jLabel.setBounds(j*105+74, i*105+104, imgWidth, imgHeight);
                //添加为每一张图片添加边框
                //实现Border接口
//                jLabel.setBorder(new BevelBorder(BevelBorder.RAISED)); //内容向外突出
                jLabel.setBorder(new BevelBorder(BevelBorder.LOWERED));  //内容向内凹陷
                this.add(jLabel);
                idx++;
            }
        }
    }

    /*设置背景图片*/
    private void initBackGround() {
        ImageIcon bg = new ImageIcon("image\\background.png");
        JLabel bgLabel = new JLabel(bg);
        bgLabel.setBounds(30,10, bg.getIconWidth(), bg.getIconHeight());
        this.add(bgLabel);
    }
    /*移动图片*/

    /*窗口构造方法*/
    public GameJFrame() {
        //初始化窗口
        this.initJFrame();
        //初始化菜单栏
        this.initJMenuBar();
        //设置背景图片 | 总是默认在底部放置图片
        this.initBackGround();
        //初始化图片资源
        this.initImage();
        //设置窗口显示
        this.setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {
        //获取按下按键的编号
        var code = e.getKeyCode();
        //对按键做出响应
        if(code == KeyEvent.VK_KP_UP) {

        }
    }
}