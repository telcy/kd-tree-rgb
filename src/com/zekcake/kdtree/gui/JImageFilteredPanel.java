package com.zekcake.kdtree.gui;

import com.zekcake.kdtree.ImageManager;
import com.zekcake.kdtree.Position;
import com.zekcake.kdtree.TreeNode;

import javax.swing.*;
import java.awt.*;

public class JImageFilteredPanel extends JPanel {

    ImageManager mgr = null;

    JImageFilteredPanel(ImageManager mgr) {
        this.mgr = mgr;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for(TreeNode node : mgr.getNodesSet() ) {
            for(Position pos : node.getPositions()) {
                g.setColor(node.getColor());
                g.drawRect(pos.getX(), pos.getY(), 1, 1);
            }

        }

    }

}
