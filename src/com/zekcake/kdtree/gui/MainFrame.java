package com.zekcake.kdtree.gui;

import com.zekcake.kdtree.ImageManager;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;


public class MainFrame extends JFrame {

    public MainFrame(ImageManager mgr) {

        JPanel imagesPanel = new JPanel();
        imagesPanel.setLayout(new GridLayout(1,2));

        JPanel imagePanel = new JImagePanel(mgr);
        JPanel imageFilteredPanel = new JImageFilteredPanel(mgr);
        JPanel controlPanel = new JControlPanel(mgr);


        imagesPanel.add(imagePanel);
        imagesPanel.add(imageFilteredPanel);

        //add(controlPanel, BorderLayout.NORTH);
        add(imagesPanel, BorderLayout.CENTER);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(mgr.getImage().getWidth() * 2, mgr.getImage().getHeight()  );
        setVisible(true);



    }





}
