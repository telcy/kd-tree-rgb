package com.zekcake.kdtree.gui;

import com.zekcake.kdtree.ImageManager;

import javax.swing.*;
import java.awt.*;

public class JImagePanel extends JPanel {

    ImageManager mgr = null;

    JImagePanel(ImageManager mgr) {
        this.mgr = mgr;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(mgr.getImage(), 0, 0, null);
    }

}
