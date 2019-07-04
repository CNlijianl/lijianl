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
 * ��QQ�ļ�����С����
 * ʹ��ע��İ�ť����ע��
 * ʹ���û���������е�½
 * ���Լ�ס������Զ���½
 */

public class LoginFrame extends JFrame {

    /**
     * ��½��������ȵ�������
     */
    private JButton loginButton;  //��½��ť
    private JButton cancalButton;  //ȡ����ť
    public static JTextField user;    //��½�û���
    private JLabel username;  //�û�����ǩ
    private JLabel password;  //�����ǩ
    private JPasswordField passwordField; //�û�����
    private JLabel photo;  //��½�����ͷ��
    private JLabel retrievepassword;  //�һ�����
    private JPanel panel; //��½�������
    private MainFrame mainFrame ;



    public LoginFrame() {
        setTitle("������С����");
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

        username = new JLabel("�� �� ��:");
        username.setFont(new Font("����", Font.BOLD, 15));
        username.setBounds(150, 100, 100, 15);
        panel.add(username);

        password = new JLabel("��    ��:");
        password.setFont(new Font("����", Font.BOLD, 15));
        password.setBounds(150, 150, 100, 15);
        panel.add(password);

        user = new JTextField();
        user.setFont(new Font("����", Font.BOLD, 20));
        user.setBounds(250, 95, 140, 25);
        panel.add(user);

        passwordField = new JPasswordField();
        passwordField.setBounds(250, 145, 140, 25);
        panel.add(passwordField);

        loginButton = new JButton("��  ½");
        loginButton.setBounds(150, 200, 100, 30);
        panel.add(loginButton);

        cancalButton = new JButton("ȡ  ��");
        cancalButton.setBounds(295, 200, 100, 30);
        panel.add(cancalButton);

        retrievepassword = new JLabel("�һ�����");
        retrievepassword.setFont(new Font("����", Font.BOLD, 15));
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
                        JOptionPane.showMessageDialog(new LoginFrame(),"�û��������������","֪ͨ",JOptionPane.ERROR_MESSAGE);
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
