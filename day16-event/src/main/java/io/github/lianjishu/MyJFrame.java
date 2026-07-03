package io.github.lianjishu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class MyJFrame extends JFrame implements ActionListener {
    JButton jButton01 = new JButton();
    JButton jButton02 = new JButton();
    @Override
    public void actionPerformed(ActionEvent e) {
        Object event_src = e.getSource();
        if(event_src == jButton01) {
            jButton01.setSize(jButton01.getWidth()+10, jButton01.getHeight()+10);
        }
        else if(event_src == jButton02) {
            jButton02.setLocation(new Random().nextInt(800), new Random().nextInt(800));
        }
    }
    public MyJFrame() {
        this.setSize(800,800);
        this.setLayout(null);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jButton01.setText("别点我");
        jButton01.setBounds(0,0,100,50);
        jButton01.setBackground(new Color(255,153,204));
        jButton01.addActionListener(this);

        jButton02.setText("也别点我");
        jButton02.setBounds(200,100,100,50);
        jButton02.setBackground(new Color(255,153,204));
        jButton02.addActionListener(this);

        this.add(jButton01);
        this.add(jButton02);
        this.setVisible(true);
    }

}
