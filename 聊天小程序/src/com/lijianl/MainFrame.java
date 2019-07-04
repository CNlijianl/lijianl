package com.lijianl;

import com.tabbedPanel.updatePanel;
import com.tabbedPanel.userMain;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private JPanel panelTop;  //�������
    private JPanel panelCenter; //���������
    private JTabbedPane tabbedPane;  //����ѡ����

    public static JLabel username;

    public MainFrame(){
        setTitle("����С����");
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
        username.setFont(new Font("����",Font.BOLD,20));
        panelTop.add(username);

        panelCenter = new JPanel();
        panelCenter.setLayout(new BorderLayout());

        add(panelCenter,BorderLayout.CENTER);

        tabbedPane = new JTabbedPane();
        panelCenter.add(tabbedPane,BorderLayout.CENTER);
        tabbedPane.addTab("�����б�",new userMain());
        tabbedPane.addTab("�޸���Ϣ",new updatePanel());



    }

    public static void main(String[] args) {
        new MainFrame().setVisible(true);
    }
}
