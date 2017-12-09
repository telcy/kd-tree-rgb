package com.zekcake.kdtree;

import java.awt.*;
import java.util.ArrayList;

public class TreeNode {

    private TreeNode parent = null;
    private Color color;
    private ArrayList<Position> positions = new ArrayList<>();

    private TreeNode left = null;
    private TreeNode right = null;


    TreeNode(Point point) {
        this.color = point.getColor();
        this.positions.add(point.getPosition());
    }

    TreeNode(Point point, TreeNode parent) {
        this.color = point.getColor();
        this.positions.add(point.getPosition());
        this.parent = parent;
    }


    public NearestNeighbour getNearestNeighbour(Color color) {
        return getNearestNeighbour(color, 0);
    }

    public NearestNeighbour getNearestNeighbour(Color color, int dimension) {

        NearestNeighbour bestNeighbour = new NearestNeighbour( this, getDistanceToColor(color));

        double distanceDimension = getDistanceDimension(color, dimension);

        int mod = dimension % 3; // 0 = R, 1 = G, 2 = B

        int colorNode = 0;
        int colorSearch = 0;

        switch(mod) {
            case 0: colorSearch = color.getRed(); colorNode = this.color.getRed(); break;
            case 1: colorSearch = color.getGreen(); colorNode = this.color.getGreen(); break;
            case 2: colorSearch = color.getBlue(); colorNode = this.color.getBlue(); break;
        }

        if(colorSearch > colorNode) {

            if(right != null) {
                NearestNeighbour nnRight = right.getNearestNeighbour(color, mod + 1);
                if(nnRight.getDistance() < bestNeighbour.getDistance()) { bestNeighbour = nnRight; }
                if(nnRight.getDistance() < distanceDimension) return bestNeighbour;
                if(left != null) {
                    NearestNeighbour nnLeft = left.getNearestNeighbour(color, mod + 1);
                    if(nnLeft.getDistance() < bestNeighbour.getDistance()) { bestNeighbour = nnLeft; }
                }
            }

        }else {

            if(left != null) {
                NearestNeighbour nnLeft = left.getNearestNeighbour(color, mod + 1);
                if(nnLeft.getDistance() < bestNeighbour.getDistance()) { bestNeighbour = nnLeft; }
                if(nnLeft.getDistance() < distanceDimension) return bestNeighbour;
                if(right != null) {
                    NearestNeighbour nnRight = right.getNearestNeighbour(color, mod + 1);
                    if(nnRight.getDistance() < bestNeighbour.getDistance()) { bestNeighbour = nnRight; }
                }
            }

        }

        return bestNeighbour;

    }

    public ArrayList<TreeNode> getNodesByColorDistance(Color color, Double distance) {
        return getNodesByColorDistance(color, distance, 0);
    }

    public ArrayList<TreeNode> getNodesByColorDistance(Color color, Double distance, int dimension) {

        ArrayList<TreeNode> nodes = new ArrayList<>();

        if(getDistanceToColor(color) <= distance)
            nodes.add(this);

        double distanceDimension = getDistanceDimension(color, dimension);

        int mod = dimension % 3; // 0 = R, 1 = G, 2 = B

        int colorNode = 0;
        int colorSearch = 0;

        switch(mod) {
            case 0: colorSearch = color.getRed(); colorNode = this.color.getRed(); break;
            case 1: colorSearch = color.getGreen(); colorNode = this.color.getGreen(); break;
            case 2: colorSearch = color.getBlue(); colorNode = this.color.getBlue(); break;
        }


        if(colorSearch > colorNode) {

            if(right != null) {
                nodes.addAll(right.getNodesByColorDistance(color, distance,mod + 1));
            }

            if(distanceDimension < distance && left != null)
                nodes.addAll(left.getNodesByColorDistance(color, distance,mod + 1));

        }else{

            if(left != null) {
                nodes.addAll(left.getNodesByColorDistance(color, distance,mod + 1));
            }

            if(distanceDimension < distance && right != null)
                nodes.addAll(right.getNodesByColorDistance(color, distance,mod + 1));

        }


        return nodes;

    }

    private Double getDistanceDimension(Color color, int dimension) {
        int mod = dimension % 3; // 0 = R, 1 = G, 2 = B
        switch(mod) {
            case 0: return (double) Math.abs(color.getRed() - this.color.getRed());
            case 1: return (double) Math.abs(color.getGreen() - this.color.getGreen());
            case 2: return (double) Math.abs(color.getBlue() - this.color.getBlue());
            default: return Double.POSITIVE_INFINITY;
        }

    }

    private Double getDistanceToColor(Color color) {
        return Math.sqrt(Math.pow(color.getRed() - this.color.getRed(), 2.0) + Math.pow(color.getGreen() - this.color.getGreen(), 2.0) + Math.pow(color.getBlue() - this.color.getBlue(), 2.0));
    }


    public void add(Point point) {
        add(point, 0);
    }

    private void add(Point point, int dimension) {

        if(point.getColor().equals(color)) {
            this.positions.add(point.getPosition());
            return;
        }

        int mod = dimension % 3; // 0 = R, 1 = G, 2 = B

        int colorNode = 0;
        int colorInsert = 0;

        switch(mod) {
            case 0: colorInsert = point.getColor().getRed(); colorNode = color.getRed(); break;
            case 1: colorInsert = point.getColor().getGreen(); colorNode = color.getGreen(); break;
            case 2: colorInsert = point.getColor().getBlue(); colorNode = color.getBlue(); break;
        }

        if(colorInsert > colorNode) {
            if(right == null) { right = new TreeNode(point, this); } else { right.add(point, mod + 1); }
        }else{
            if(left == null) { left = new TreeNode(point, this); } else { left.add(point, mod + 1); }
        }

    }

    public Color getColor() {
        return color;
    }

    public ArrayList<Position> getPositions() {
        return positions;
    }


}
