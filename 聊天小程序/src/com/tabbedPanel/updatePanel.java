package com.tabbedPanel;

import com.db.Dao;
import com.lijianl.LoginFrame;
import sun.rmi.runtime.Log;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class updatePanel extends JPanel {
    private JLabel userLabel;
    private JLabel sexLabel;
    private JLabel passwordLabel;
    private JTextField user;
    private JTextField password;
    private JRadioButton radioButtonBoy;
    private JRadioButton radioButtonGril;
    private ButtonGroup buttonGroup;
    private JButton update;
    private JButton clearn;
    public static int userid;

    public updatePanel(){

        setLayout(null);
        userLabel = new JLabel("用 户 名：");
        userLabel.setFont(new Font("楷体",Font.BOLD,15));
        userLabel.setBounds(10,50,100,15);
        add(userLabel);

        user = new JTextField();
        user.setFont(new Font("楷体",Font.BOLD,15));
        user.setBounds(120,45,150,20);
        add(user);

        passwordLabel = new JLabel("密    码:");
        passwordLabel.setFont(new Font("楷体",Font.BOLD,15));
        passwordLabel.setBounds(10,120,100,15);
        add(passwordLabel);

        password = new JTextField();
        password.setFont(new Font("楷体",Font.BOLD,15));
        password.setBounds(120,115,150,20);
        add(password);

        sexLabel = new JLabel("性    别:");
        sexLabel.setFont(new Font("楷体",Font.BOLD,15));
        sexLabel.setBounds(10,190,100,15);
        add(sexLabel);

        radioButtonBoy = new JRadioButton("男");
        radioButtonBoy.setFont(new Font("楷体",Font.BOLD,15));
        radioButtonBoy.setBounds(120,190,70,15);
        add(radioButtonBoy);

        radioButtonGril = new JRadioButton("女");
        radioButtonGril.setFont(new Font("楷体",Font.BOLD,15));
        radioButtonGril.setBounds(220,190,70,15);
        add(radioButtonGril);

        buttonGroup = new ButtonGroup();
        buttonGroup.add(radioButtonBoy);
        buttonGroup.add(radioButtonGril);

        update = new JButton("修   改");
        update.setBounds(30,250,100,30);
        add(update);

        clearn = new JButton("清   除");
        clearn.setBounds(220,250,100,30);
        add(clearn);


        addActionListener();

    }
    private void addActionListener(){
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Dao dao = new Dao();
                dao.createConnection();
                String str;
                if(radioButtonBoy.isSelected()){
                    str = radioButtonBoy.getText();
                }else {
                    str = radioButtonGril.getText();
                }
                dao.updateMessage(userid,user.getText(),password.getText(),str);
                dao.closestatement();
                dao.closeConn();
            }
        });

    }
}
