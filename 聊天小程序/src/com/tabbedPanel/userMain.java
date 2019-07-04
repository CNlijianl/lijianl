package com.tabbedPanel;

import com.db.Dao;
import com.lijianl.LoginFrame;


import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;


import java.awt.*;
import java.sql.SQLException;
import java.util.List;

public class userMain extends JPanel {

    private JTree usertree;
    private Dao dao;
    public static int number;


    public userMain() {
        setLayout(new BorderLayout());

        DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode("我的好友");


        dao = new Dao();
        List list = dao.selectfriend(number);
        DefaultMutableTreeNode pyNode[] = new DefaultMutableTreeNode[list.size()];

        for (int i = 0; i < list.size(); i++) {
            try {
                String a = dao.selectUserName((int) list.get(i));

                pyNode[i] = new DefaultMutableTreeNode(a);

                rootNode.add(pyNode[i]);
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        usertree = new JTree(rootNode);
        usertree.setFont(new Font("楷体", Font.PLAIN, 20));
        add(usertree, BorderLayout.CENTER);

    }

    public static void main(String[] args) {
        new userMain();
    }


}
