package com.lijianl;

import com.tabbedPanel.updatePanel;
import com.tabbedPanel.userMain;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private JPanel panelTop;  //顶部面板
    private JPanel panelCenter; //中心主面板
    private JTabbedPane tabbedPane;  //中心选项卡面板

    public static JLabel username;

    public MainFrame(){
        setTitle("聊天小程序");
        setBounds(1000,100,400,800);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        init();


    }
    public void init(){
        panelTop = new JPanel();
        add(panelTop,BorderLayout.NORTH);

        LoginFrame loginFrame = new LoginFrame();

        username = new JLabel();
        username.setFont(new Font("楷体",Font.BOLD,20));
        panelTop.add(username);

        panelCenter = new JPanel();
        panelCenter.setLayout(new BorderLayout());

        add(panelCenter,BorderLayout.CENTER);

        tabbedPane = new JTabbedPane();
        panelCenter.add(tabbedPane,BorderLayout.CENTER);
        tabbedPane.addTab("好友列表",new userMain());
        tabbedPane.addTab("修改信息",new updatePanel());



    }

    public static void main(String[] args) {
        new MainFrame().setVisible(true);
    }
}
