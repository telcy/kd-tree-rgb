package com.zekcake.kdtree.gui;

import com.zekcake.kdtree.ImageManager;

import javax.swing.*;
import java.awt.*;

public class JControlPanel extends JPanel {

    ImageManager mgr = null;

    JControlPanel(ImageManager mgr) {
        this.mgr = mgr;

        add(new JLabel("Color: "));
        add(new JTextField("227", 3));
        add(new JTextField("149", 3));
        add(new JTextField("0", 3));
        add(new JLabel("Distance: "));
        add(new JTextField("10.0", 5));
        add(new JButton("show"));

    }

}
