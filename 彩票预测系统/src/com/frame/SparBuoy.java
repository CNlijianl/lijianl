package com.frame;

import javax.swing.*;

import java.awt.Toolkit;

import com.allpanel.*;

public class SparBuoy extends JDialog {
    JTabbedPane tp = new JTabbedPane();

    public SparBuoy() {
        this.setTitle("��������ͼ");
        setResizable(false);

        setIconImage(Toolkit.getDefaultToolkit().getImage(SparBuoy.class.getResource("/imgs/log.png")));
        tp.addTab("��һλ", new Apanel());
        tp.addTab("�ڶ�λ", new Bpanel());
        tp.addTab("����λ", new Cpanel());
        tp.addTab("����λ", new Dpanel());
        tp.addTab("����λ", new Epanel());
        tp.addTab("����λ", new Fpanel());
        tp.addTab("����λ", new Gpanel());

        this.getContentPane().add(tp);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setBounds(450, 100, 563, 593);

    }

}
