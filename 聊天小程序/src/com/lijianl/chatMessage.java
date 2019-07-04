package com.lijianl;

import javax.swing.*;
import java.awt.*;

public class chatMessage extends JFrame {
    private JPanel chatPanel;
    private JPanel sendPanel;
    private JPanel messagePanel;
    private JPanel leftPanel;
    private JPanel leftPanel1;
    private JPanel leftPanel2;
    private JTextArea chatText;
    private JTextArea sendText;
    private JTextArea messageText;
    private JLabel username;
    private JLabel userid;
    private JLabel usersex;
    private JScrollPane scrollPane;
    private JButton send;
    private JButton close;


    public chatMessage() {
        int x = Toolkit.getDefaultToolkit().getScreenSize().width / 2;
        int y = Toolkit.getDefaultToolkit().getScreenSize().height / 2;
        setBounds(x - 400, y - 300, 800, 600);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Container c = getContentPane();
        c.setLayout(new BorderLayout());
        init();
        c.add(leftPanel, BorderLayout.WEST);
        c.add(messagePanel, BorderLayout.EAST);


    }

    public void init() {
        leftPanel = new JPanel();
        leftPanel.setLayout(new BorderLayout());
        chatPanel = new JPanel();
        chatText = new JTextArea();
        chatText.setColumns(50);
        chatText.setRows(25);
        chatText.setEnabled(false);
        scrollPane = new JScrollPane(chatText);
        chatPanel.add(scrollPane);

        sendText = new JTextArea();
        sendText.setRows(5);
        sendText.setColumns(50);
        sendPanel = new JPanel();
        sendPanel.add(sendText);
        leftPanel.add(chatPanel, BorderLayout.NORTH);
        leftPanel.add(sendPanel, BorderLayout.CENTER);

        messagePanel = new JPanel();
        messagePanel.setLayout(new GridLayout(3, 1));
        username = new JLabel("lijianliang", JLabel.CENTER);

        userid = new JLabel("134131213", JLabel.CENTER);
        usersex = new JLabel("ÄÐ", JLabel.CENTER);
        leftPanel1 = new JPanel();
        leftPanel1.setLayout(new GridLayout(3, 1));
        leftPanel1.add(userid);
        leftPanel1.add(username);
        leftPanel1.add(usersex);

        leftPanel2 = new JPanel();
        messageText = new JTextArea();
        messageText.setRows(15);
        messageText.setColumns(20);
        messageText.setEnabled(false);
        leftPanel2 = new JPanel();
        leftPanel2.add(messageText);

        messagePanel.add(leftPanel1);
        messagePanel.add(leftPanel2);

        close = new JButton("¹Ø  ±Õ");
        leftPanel.add(close,BorderLayout.SOUTH);

        send = new JButton("·¢  ËÍ");
        messagePanel.add(send);


    }

    public static void main(String[] args) {
        new chatMessage().setVisible(true);
    }

}
