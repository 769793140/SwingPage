package com.ui;

import javax.swing.*;
import javax.swing.plaf.ColorUIResource;
import javax.swing.plaf.InsetsUIResource;
import java.awt.*;

public class MyTAbbedPane extends JTabbedPane {
    private static final long serialVersionUID = -6039997512110305471L;
    private double scaleRatio = 0.3;
    public MyTAbbedPane() {
        // super();
        new JTabbedPane();
        //设置边框
        UIManager.put("TabbedPane.contentBorderInsets", new InsetsUIResource(2, 2,
                2, 2));
        //设置边框颜色
        UIManager.put("TabbedPane.contentAreaColor", new ColorUIResource(
                new Color(192, 192,
                        192)));
        this.updateUI();
        this.setBackground(Color.white);
    }
}
