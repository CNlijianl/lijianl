package com.allpanel;

import com.allchart.CLineChart;
import com.allchart.DLineChart;
import com.db.ConnMySQL;
import com.frame.BackgroundPanel;
import org.jfree.ui.RefineryUtilities;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;


public class Dpanel extends JPanel {
    public Dpanel(){
        this.setBorder(new EmptyBorder(5,5,5,5));
        setLayout(new BorderLayout());
        BackgroundPanel contentPane = new BackgroundPanel();
        contentPane.setImage(getToolkit().getImage(getClass().getResource("/imgs/a9.png")));
        add(contentPane,BorderLayout.CENTER);
        contentPane.setLayout(null);

        JLabel lb1NewLabel = new JLabel("各个数字在该位所出现的百分比");
        lb1NewLabel.setBounds(175,12,217,18);
        contentPane.add(lb1NewLabel);
        JLabel label = new JLabel("1:");
        label.setBounds(60,91,27,18);
        contentPane.add(label);

        JLabel label_1 = new JLabel("2:");
        label_1.setBounds(60, 136, 27, 18);
        contentPane.add(label_1);

        JLabel label_2 = new JLabel("4:");// “4:”标签
        label_2.setBounds(60, 226, 27, 18);
        contentPane.add(label_2);

        JLabel label_3 = new JLabel("3:");
        label_3.setBounds(60, 181, 27, 18);
        contentPane.add(label_3);

        JLabel label_4 = new JLabel("5:");
        label_4.setBounds(60, 274, 27, 18);
        contentPane.add(label_4);

        JLabel label_5 = new JLabel("6:");
        label_5.setBounds(60, 319, 27, 18);
        contentPane.add(label_5);

        JLabel label_6 = new JLabel("7:");
        label_6.setBounds(60, 364, 27, 18);
        contentPane.add(label_6);

        JLabel label_7 = new JLabel("8:");
        label_7.setBounds(60, 409, 27, 18);
        contentPane.add(label_7);

        JLabel label_8 = new JLabel("9:");
        label_8.setBounds(60, 454, 27, 18);
        contentPane.add(label_8);

        JLabel label_9 = new JLabel("0:");
        label_9.setBounds(60, 44, 27, 29);
        contentPane.add(label_9);

        JProgressBar progressBar_0 = new JProgressBar();
        progressBar_0.setBounds(94, 43, 321, 32);
        progressBar_0.setForeground(new Color(255, 165, 0));
        progressBar_0.setStringPainted(true);
        progressBar_0.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        contentPane.add(progressBar_0);

        JProgressBar progressBar_1 = new JProgressBar();
        progressBar_1.setBounds(94, 85, 321, 32);
        progressBar_1.setForeground(new Color(255, 165, 0));
        progressBar_1.setStringPainted(true);
        progressBar_1.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        contentPane.add(progressBar_1);

        JProgressBar progressBar_2 = new JProgressBar();
        progressBar_2.setBounds(94, 130, 321, 32);
        progressBar_2.setForeground(new Color(255, 165, 0));
        progressBar_2.setStringPainted(true);
        progressBar_2.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        contentPane.add(progressBar_2);

        JProgressBar progressBar_3 = new JProgressBar();
        progressBar_3.setBounds(94, 175, 321, 32);
        progressBar_3.setForeground(new Color(255, 165, 0));
        progressBar_3.setStringPainted(true);
        progressBar_3.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        contentPane.add(progressBar_3);

        JProgressBar progressBar_4 = new JProgressBar();
        progressBar_4.setBounds(94, 220, 321, 32);
        progressBar_4.setForeground(new Color(255, 165, 0));
        progressBar_4.setStringPainted(true);
        progressBar_4.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        contentPane.add(progressBar_4);

        JProgressBar progressBar_5 = new JProgressBar();
        progressBar_5.setBounds(94, 268, 321, 32);
        progressBar_5.setForeground(new Color(255, 165, 0));
        progressBar_5.setStringPainted(true);
        progressBar_5.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        contentPane.add(progressBar_5);

        JProgressBar progressBar_6 = new JProgressBar();
        progressBar_6.setBounds(94, 313, 321, 32);
        progressBar_6.setForeground(new Color(255, 165, 0));
        progressBar_6.setStringPainted(true);
        progressBar_6.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        contentPane.add(progressBar_6);

        JProgressBar progressBar_7 = new JProgressBar();
        progressBar_7.setBounds(94, 358, 321, 32);
        progressBar_7.setForeground(new Color(255, 165, 0));
        progressBar_7.setStringPainted(true);
        progressBar_7.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        contentPane.add(progressBar_7);

        JProgressBar progressBar_8 = new JProgressBar();
        progressBar_8.setBounds(94, 403, 321, 32);
        progressBar_8.setForeground(new Color(255, 165, 0));
        progressBar_8.setStringPainted(true);
        progressBar_8.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        contentPane.add(progressBar_8);

        JProgressBar progressBar_9 = new JProgressBar();
        progressBar_9.setBounds(94, 448, 321, 32);
        progressBar_9.setForeground(new Color(255, 165, 0));
        progressBar_9.setStringPainted(true);
        progressBar_9.setFont(new Font("微软雅黑", Font.PLAIN, 14));
        contentPane.add(progressBar_9);

        JLabel l_0 = new JLabel("");
        l_0.setBounds(439, 49, 104, 18);
        contentPane.add(l_0);

        JLabel l_1 = new JLabel("");
        l_1.setBounds(439, 91, 104, 18);
        contentPane.add(l_1);

        JLabel l_2 = new JLabel("");
        l_2.setBounds(439, 136, 104, 18);
        contentPane.add(l_2);

        JLabel l_3 = new JLabel("");
        l_3.setBounds(439, 181, 104, 18);
        contentPane.add(l_3);

        JLabel l_4 = new JLabel("");
        l_4.setBounds(439, 226, 104, 18);
        contentPane.add(l_4);

        JLabel l_5 = new JLabel("");
        l_5.setBounds(439, 274, 104, 18);
        contentPane.add(l_5);

        JLabel l_6 = new JLabel("");
        l_6.setBounds(439, 319, 104, 18);
        contentPane.add(l_6);

        JLabel l_7 = new JLabel("");
        l_7.setBounds(439, 364, 104, 18);
        contentPane.add(l_7);

        JLabel l_8 = new JLabel("");
        l_8.setBounds(439, 409, 104, 18);
        contentPane.add(l_8);

        JLabel l_9 = new JLabel("");
        l_9.setBounds(439, 454, 104, 18);
        contentPane.add(l_9);

        ConnMySQL con = new ConnMySQL();// 连接MySQL数据库

        String ab = "d";// 第一位开奖号码

        int i0 = con.getABC(ab, 0);// 获得第一位开奖号码0出现的次数
        con.closeConnection();// 关闭数据库连接
        int i1 = con.getABC(ab, 1);// 获得第一位开奖号码1出现的次数
        con.closeConnection();// 关闭数据库连接
        int i2 = con.getABC(ab, 2);// 获得第一位开奖号码2出现的次数
        con.closeConnection();// 关闭数据库连接
        int i3 = con.getABC(ab, 3);// 获得第一位开奖号码3出现的次数
        con.closeConnection();// 关闭数据库连接
        int i4 = con.getABC(ab, 4);// 获得第一位开奖号码4出现的次数
        con.closeConnection();// 关闭数据库连接
        int i5 = con.getABC(ab, 5);// 获得第一位开奖号码5出现的次数
        con.closeConnection();// 关闭数据库连接
        int i6 = con.getABC(ab, 6);// 获得第一位开奖号码6出现的次数
        con.closeConnection();// 关闭数据库连接
        int i7 = con.getABC(ab, 7);// 获得第一位开奖号码7出现的次数
        con.closeConnection();// 关闭数据库连接
        int i8 = con.getABC(ab, 8);// 获得第一位开奖号码8出现的次数
        con.closeConnection();// 关闭数据库连接
        int i9 = con.getABC(ab, 9);// 获得第一位开奖号码9出现的次数
        con.closeConnection();// 关闭数据库连接

        double all = i0 + i1 + i2 + i3 + i4 + i5 + i6 + i7 + i8 + i9;// 获得开奖次数
        // 设置统计开奖号码出现次数标签中的文本内容
        l_0.setText("出现 " + i0 + " 次");
        l_1.setText("出现 " + i1 + " 次");
        l_2.setText("出现 " + i2 + " 次");
        l_3.setText("出现 " + i3 + " 次");
        l_4.setText("出现 " + i4 + " 次");
        l_5.setText("出现 " + i5 + " 次");
        l_6.setText("出现 " + i6 + " 次");
        l_7.setText("出现 " + i7 + " 次");
        l_8.setText("出现 " + i8 + " 次");
        l_9.setText("出现 " + i9 + " 次");

        DecimalFormat df = new DecimalFormat(".###");// 格式化（保留三位有效数字）
        // 设置被格式化的进度字符串的值，并设置进图条当前值
        progressBar_0.setString(df.format(i0 * 100 / all) + "%");
        progressBar_0.setValue(i0);
        progressBar_1.setString(df.format(i1 * 100 / all) + "%");
        progressBar_1.setValue(i1);
        progressBar_2.setString(df.format(i2 * 100 / all) + "%");
        progressBar_2.setValue(i2);
        progressBar_3.setString(df.format(i3 * 100 / all) + "%");
        progressBar_3.setValue(i3);
        progressBar_4.setString(df.format(i4 * 100 / all) + "%");
        progressBar_4.setValue(i4);
        progressBar_5.setString(df.format(i5 * 100 / all) + "%");
        progressBar_5.setValue(i5);
        progressBar_6.setString(df.format(i6 * 100 / all) + "%");
        progressBar_6.setValue(i6);
        progressBar_7.setString(df.format(i7 * 100 / all) + "%");
        progressBar_7.setValue(i7);
        progressBar_8.setString(df.format(i8 * 100 / all) + "%");
        progressBar_8.setValue(i8);
        progressBar_9.setString(df.format(i9 * 100 / all) + "%");
        progressBar_9.setValue(i9);
        JButton button = new JButton();
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                do_button_actionPerformed(e);
            }
        });
        button.setBounds(94,485,321,32);
        button.setText("查看最近10期的第四位开奖号码走势图");
        button.setFont(new Font("楷体",Font.PLAIN,16));
        button.setForeground(new Color(0,102,153));
        contentPane.add(button);

    }

    public void do_button_actionPerformed(ActionEvent e){
        DLineChart chart = new DLineChart(null,"第四位开奖号码走势图");
        chart.pack();
        RefineryUtilities.centerFrameOnScreen(chart);
        chart.setVisible(true);

    }

}
