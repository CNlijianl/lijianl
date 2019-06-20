package com.frame;

import javax.swing.*;

import java.awt.Toolkit;

import com.allpanel.*;

public class SparBuoy extends JDialog {
    JTabbedPane tp = new JTabbedPane();

    public SparBuoy() {
        this.setTitle("号码走势图");
        setResizable(false);

        setIconImage(Toolkit.getDefaultToolkit().getImage(SparBuoy.class.getResource("/imgs/log.png")));
        tp.addTab("第一位", new Apanel());
        tp.addTab("第二位", new Bpanel());
        tp.addTab("第三位", new Cpanel());
        tp.addTab("第四位", new Dpanel());
        tp.addTab("第五位", new Epanel());
        tp.addTab("第六位", new Fpanel());
        tp.addTab("第七位", new Gpanel());

        this.getContentPane().add(tp);
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setBounds(450, 100, 563, 593);

    }

}
