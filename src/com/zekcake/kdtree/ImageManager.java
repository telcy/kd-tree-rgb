package com.zekcake.kdtree;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.HashSet;

public class ImageManager {

    BufferedImage image = null;
    TreeNode tree = null;
    Color nearestColor = null;
    HashSet<TreeNode> nodesSet = new HashSet<>();

    public ImageManager() {
        loadImage();
        loadNearestNeighbour();
        loadNodesByColorDistance();
    }

    public TreeNode getTree() {
        return tree;
    }

    public Color getNearestColor() {
        return nearestColor;
    }

    public HashSet<TreeNode> getNodesSet() {
        return nodesSet;
    }

    public BufferedImage getImage() {
        return image;
    }

    private void loadImage() {

        try {
            this.image = ImageIO.read(new File("taxi.jpg"));
            buildTree();
        }catch(Exception e) {
            System.err.println(e);
        }


    }

    public void buildTree() {
        TreeNode tree = new TreeNode(new Point(new Color(image.getRGB(0, 0)), new Position(0,0)));
        for (int x = 0; x < image.getWidth(); x++) {
            for (int y = 0; y < image.getHeight(); y++) {
                if(x==0 && y==0) continue;
                tree.add(new Point(new Color(image.getRGB(x, y)), new Position(x,y)));
            }
        }
        System.out.println("Finished building tree.");
        this.tree = tree;
    }

    private void loadNearestNeighbour() {
        //System.out.println( tree.getNearestNeighbour(new Color(244, 244 , 244)).getNode().getColor() );
        //System.out.println( tree.getNearestNeighbour(new Color(227, 149 , 0)).getNode().getColor() );
        nearestColor = tree.getNearestNeighbour(new Color(215, 142, 3)).getNode().getColor();
        System.out.println(nearestColor);
    }

    private void loadNodesByColorDistance() {
        nodesSet.clear();
        nodesSet.addAll(tree.getNodesByColorDistance(new Color(227, 149 , 0), 80.0));
        nodesSet.addAll(tree.getNodesByColorDistance(new Color(255, 0 , 0), 160.0));
        //nodesByColorDistance.addAll(tree.getNodesByColorDistance(new Color(251, 0 , 0), 180.0));
    }




}
