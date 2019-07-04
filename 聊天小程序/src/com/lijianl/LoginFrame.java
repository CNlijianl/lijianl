package com.lijianl;

/**
 * @author chinalijianl lijianl_shnu@163.com
 */

import com.db.Dao;
import com.tabbedPanel.updatePanel;
import com.tabbedPanel.userMain;
import sun.applet.Main;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;


/**
 * 仿QQ的简单聊天小程序
 * 使用注册的按钮进行注册
 * 使用用户名密码进行登陆
 * 可以记住密码和自动登陆
 */

public class LoginFrame extends JFrame {

    /**
     * 登陆界面组件等的声明；
     */
    private JButton loginButton;  //登陆按钮
    private JButton cancalButton;  //取消按钮
    public static JTextField user;    //登陆用户名
    private JLabel username;  //用户名标签
    private JLabel password;  //密码标签
    private JPasswordField passwordField; //用户密码
    private JLabel photo;  //登陆界面的头像
    private JLabel retrievepassword;  //找回密码
    private JPanel panel; //登陆界面面板
    private MainFrame mainFrame ;



    public LoginFrame() {
        setTitle("简单聊天小程序");
        int x = Toolkit.getDefaultToolkit().getScreenSize().width / 2;
        int y = Toolkit.getDefaultToolkit().getScreenSize().height / 2;
        setBounds(x - 300, y - 200, 600, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        init();
        addListener();

    }

    private void init() {
        panel = new JPanel();
        this.add(panel);
        panel.setLayout(null);

        username = new JLabel("用 户 名:");
        username.setFont(new Font("楷体", Font.BOLD, 15));
        username.setBounds(150, 100, 100, 15);
        panel.add(username);

        password = new JLabel("密    码:");
        password.setFont(new Font("楷体", Font.BOLD, 15));
        password.setBounds(150, 150, 100, 15);
        panel.add(password);

        user = new JTextField();
        user.setFont(new Font("楷体", Font.BOLD, 20));
        user.setBounds(250, 95, 140, 25);
        panel.add(user);

        passwordField = new JPasswordField();
        passwordField.setBounds(250, 145, 140, 25);
        panel.add(passwordField);

        loginButton = new JButton("登  陆");
        loginButton.setBounds(150, 200, 100, 30);
        panel.add(loginButton);

        cancalButton = new JButton("取  消");
        cancalButton.setBounds(295, 200, 100, 30);
        panel.add(cancalButton);

        retrievepassword = new JLabel("找回密码");
        retrievepassword.setFont(new Font("楷体", Font.BOLD, 15));
        retrievepassword.setForeground(Color.blue);
        retrievepassword.setBounds(320, 240, 80, 12);
        panel.add(retrievepassword);




    }

    private void addListener() {
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String ps = new String(passwordField.getPassword());
                int nm = Integer.parseInt(user.getText());
                Dao dao = new Dao();
                dao.createConnection();

                try {
                    boolean b = dao.selectUser(nm, ps);
                    if (b) {

                        updatePanel.userid = nm;
                        userMain.number = nm;
                        setVisible(false);
                        MainFrame frame = new MainFrame();
                        MainFrame.username.setText(dao.selectUserName(nm));
                        frame.setVisible(true);


                    } else {
                        passwordField.setText("");
                        JOptionPane.showMessageDialog(new LoginFrame(),"用户名或者密码错误","通知",JOptionPane.ERROR_MESSAGE);
                    }
                    dao.closeresultSet();
                    dao.closepreparedStatement();
                    dao.closestatement();
                    dao.closeConn();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

    }

    public static void main(String[] args) {

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Throwable e) {
            e.printStackTrace();
        }
//
//        EventQueue.invokeLater(new Runnable() {
//            @Override
//            public void run() {
//                try {
                    LoginFrame loginFrame = new LoginFrame();
                    loginFrame.setVisible(true);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }
//        });


    }
}
