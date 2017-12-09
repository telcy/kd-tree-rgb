package com.zekcake.kdtree;

public class NearestNeighbour {

    private TreeNode node;
    private Double distance;

    NearestNeighbour(TreeNode node, Double distance) {
        this.node = node;
        this.distance = distance;
    }

    public TreeNode getNode() {
        return node;
    }

    public Double getDistance() {
        return distance;
    }
}
